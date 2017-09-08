package tennisodds.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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

    private PlayerStatisticsDto playerStatsHandler(List<StatsNode> statsList, Long playerId) {
        return null;
               
    }

}
