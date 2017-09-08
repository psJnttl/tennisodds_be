package tennisodds.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Pasi
 */
@Entity
@Table(name = "player")
public class TennisPlayer extends AbstractPersistable<Long> {

    private String name;
    private String nationality;
    private String association;

    public TennisPlayer() {
    }

    public TennisPlayer(String name, String nationality, String association) {
        this.name = name;
        this.nationality = nationality;
        this.association = association;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

}
