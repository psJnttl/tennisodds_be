package tennisodds.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tennisodds.service.PlayerService;
import tennisodds.service.TennisPlayerDto;

/**
 *
 * @author Pasi
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @RequestMapping(value = "/api/players", method = RequestMethod.GET)
    public List<TennisPlayerDto> listAll() {
        return playerService.listAll();
    }
}
