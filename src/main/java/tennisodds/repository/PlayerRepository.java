package tennisodds.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import tennisodds.domain.TennisPlayer;

/**
 *
 * @author Pasi
 */
public interface PlayerRepository extends JpaRepository<TennisPlayer, Long>{
    
}
