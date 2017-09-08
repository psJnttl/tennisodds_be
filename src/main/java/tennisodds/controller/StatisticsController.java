package tennisodds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tennisodds.service.PlayerStatisticsDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tennisodds.service.StatisticsService;

/**
 *
 * @author Pasi
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StatisticsController {
    
    @Autowired
    private StatisticsService statisticsService;
    
    @RequestMapping(value = "/api/statistics/player/{id}")
    public PlayerStatisticsDto getPlayerStatistics(@PathVariable Long id) {
        return statisticsService.getPlayerStats(id);
    }
}
