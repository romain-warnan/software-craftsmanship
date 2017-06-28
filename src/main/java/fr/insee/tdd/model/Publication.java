package fr.insee.tdd.model;

import com.google.common.base.MoreObjects;

import java.util.Date;
import java.util.Objects;

public class Publication {

    private Long id;
    private String titre;
    private String sousTitre;
    private Date dateParution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSousTitre() {
        return sousTitre;
    }

    public void setSousTitre(String sousTitre) {
        this.sousTitre = sousTitre;
    }

    public Date getDateParution() {
        return dateParution;
    }

    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(Publication.class)
            .add("id", id)
            .add("titre", titre)
            .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Publication) {
            Publication other = (Publication) object;
            return Objects.equals(this.id, other.id);
        }
        return false;
    }
}
