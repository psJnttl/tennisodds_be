package tennisodds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tennisodds.domain.TennisPlayer;
import tennisodds.repository.PlayerRepository;

/**
 *
 * @author Pasi
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<TennisPlayerDto> listAll() {
        List<TennisPlayer> playerList = playerRepository.findAll();
        return playerList.stream()
                .map(p -> new TennisPlayerDto(p.getId(), p.getName(), p.getNationality(), p.getAssociation()))
                .collect(Collectors.toList());
    }

    public TennisPlayerDto getOnePlayer(Long id) {
        TennisPlayer player = playerRepository.getOne(id);
        return new TennisPlayerDto(player.getId(), player.getName(), player.getNationality(), player.getAssociation());
    }

    public List<NationDto> listNationalities() {
        List<TennisPlayer> players =  playerRepository.listNationalities();
        return players.stream()
                .map(p -> new NationDto(p.getNationality()))
                .collect(Collectors.toList());
    }
}
