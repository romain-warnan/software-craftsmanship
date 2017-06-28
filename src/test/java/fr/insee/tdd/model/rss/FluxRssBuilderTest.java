package fr.insee.tdd.model.rss;

import fr.insee.tdd.dao.PublicationDao;
import fr.insee.tdd.model.FluxRssBuilder;
import fr.insee.tdd.model.Publication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class FluxRssBuilderTest {

    private Publication publication;

    @Before
    public void before() {
        publication = new Publication();
        publication.setId(1L);
        publication.setTitre("Titre");
        publication.setSousTitre("Sous-titre");
        publication.setDateParution(new Date(1234567L));
    }

    @Test
    public void itemFromPublication() {
        Item item = FluxRssBuilder.from(publication);
        assertEquals(publication.getTitre(), item.getTitle());
        assertEquals(publication.getSousTitre(), item.getDescription());
        assertEquals(publication.getDateParution(), item.getPubDate());
    }

    @Test
    public void fluxRssFromPublications() {
        List<Publication> publications = Arrays.asList(publication, publication);
        FluxRss fluxRss = FluxRssBuilder.from(publications);
        assertEquals(publications.size(), fluxRss.getChannel().getItems().size());
    }
}