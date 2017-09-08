package tennisodds.service;

import java.util.Objects;

/**
 *
 * @author Pasi
 */
public class TennisPlayerDto {
    private Long id;
    private String name;
    private String nationality;
    private String association;    

    public TennisPlayerDto() {
    }

    public TennisPlayerDto(Long id, String name, String nationality, String association) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.association = association;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.nationality);
        hash = 89 * hash + Objects.hashCode(this.association);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TennisPlayerDto other = (TennisPlayerDto) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.nationality, other.nationality)) {
            return false;
        }
        if (!Objects.equals(this.association, other.association)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TennisPlayerDto{" + "id=" + id + ", name=" + name + ", nationality=" + nationality + ", association=" + association + '}';
    }

    

}
