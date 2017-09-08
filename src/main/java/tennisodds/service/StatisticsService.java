package tennisodds.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pasi
 */
@Service
public class StatisticsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlayerService playerService;

    public PlayerStatisticsDto getPlayerStats(Long playerId) {
        List<StatsNode> statsList = jdbcTemplate.query("SELECT M.date, M.player1, M.player2 , M.odds1, M.odds2 FROM tennismatch M "
                + "WHERE M.player1=? OR M.player2=? "
                + "ORDER BY M.date DESC", new Object[]{playerId, playerId,},
                (rs, rowNbr) -> statsResultExtractor(rs));
        return playerStatsHandler(statsList, playerId);
    }

    private StatsNode statsResultExtractor(ResultSet rs) throws SQLException {
        return StatsNode.builder()
                .date(rs.getDate("date"))
                .winner(rs.getLong("player1"))
                .loser(rs.getLong("player2"))
                .odds1(rs.getDouble("odds1"))
                .odds2(rs.getDouble("odds2"))
                .build();
    }

    private PlayerStatisticsDto playerStatsHandler(List<StatsNode> statsList, long playerId) { // playerId unboxed for filter
        Date from = null, to = null;
        Optional<Date> fromDate = statsList.stream()
                .map(n -> n.getDate())
                .min((a, b) -> a.compareTo(b));
        if (fromDate.isPresent()) {
            from = fromDate.get();
        } // results should be in descending order, but let's be sure
        Optional<Date> toDate = statsList.stream()
                .map(n -> n.getDate())
                .max((a, b) -> a.compareTo(b));
        if (toDate.isPresent()) {
            to = toDate.get();
        }

        long expectedWins = statsList.stream()
                .filter(n -> n.getWinner() == playerId)
                .filter(n -> n.getOdds1() < n.getOdds2())
                .count();
        long unexpectedWins = statsList.stream()
                .filter(n -> n.getWinner() == playerId)
                .filter(n -> n.getOdds1() > n.getOdds2())
                .count();
        long expectedLosses = statsList.stream()
                .filter(n -> n.getLoser() == playerId)
                .filter(n -> n.getOdds2() > n.getOdds1())
                .count();
        long unexpectedLosses = statsList.stream()
                .filter(n -> n.getLoser() == playerId)
                .filter(n -> n.getOdds2() < n.getOdds1())
                .count();
        TennisPlayerDto player = playerService.getOnePlayer(playerId);

        return PlayerStatisticsDto.builder()
                .name(player.getName())
                .matchesTotal(statsList.size())
                .from(from)
                .to(to)
                .expectedWins(expectedWins)
                .expectedLosses(expectedLosses)
                .unExpectedWins(unexpectedWins)
                .unExpectedLosses(unexpectedLosses)
                .build();
    }

        public PlayerStatisticsDto getPlayerStatsWithDateRange(Long playerId, Date start, Date end) {
        List<StatsNode> statsList = jdbcTemplate.query("SELECT date, player1, player2, odds1, odds2 FROM tennismatch "
                + "WHERE date(date) BETWEEN ? AND ? AND (player1=? OR player2=?) ORDER BY date DESC",
                new Object[]{start, end, playerId, playerId,},
                (rs, rowNbr) -> statsResultExtractor(rs));
        return playerStatsHandler(statsList, playerId);
    }
    
}
