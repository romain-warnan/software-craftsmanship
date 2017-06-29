package fr.insee.tdd;

import fr.insee.tdd.model.Publication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class Tests {

    public static final String TITRE = "Titre";
    public static final String SOUS_TITRE = "Sous-titre";
    public static final Date DATE_PARUTION = new Date(1234567L);

    public static Publication unePublication() {
        Publication publication = new Publication();
        publication.setTitre(TITRE);
        publication.setSousTitre(SOUS_TITRE);
        publication.setDateParution(DATE_PARUTION);
        return publication;
    }

    public static List<Publication> desPublications() {
        return Arrays.asList(unePublication(), unePublication());
    }
}
