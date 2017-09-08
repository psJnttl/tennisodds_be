package tennisodds.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tennisodds.domain.TennisPlayer;

/**
 *
 * @author Pasi
 */
public interface PlayerRepository extends JpaRepository<TennisPlayer, Long> {

    @Query("SELECT T FROM TennisPlayer T GROUP by nationality")
    List<TennisPlayer> listNationalities();
}
