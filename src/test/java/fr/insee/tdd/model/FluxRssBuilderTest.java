package fr.insee.tdd.model;

import fr.insee.tdd.Tests;
import fr.insee.tdd.dao.PublicationDao;
import fr.insee.tdd.model.rss.FluxRss;
import fr.insee.tdd.model.rss.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class FluxRssBuilderTest {

    @Test
    public void fluxRssFromPublications() {
        FluxRss fluxRss = FluxRssBuilder.from(Tests.desPublications());
        List<Item> items = fluxRss.getChannel().getItems();
        assertEquals(2, items.size());
        assertEquals("Dernières publications", fluxRss.getChannel().getTitle());
        Item item = items.get(0);
        assertEquals(Tests.TITRE, item.getTitle());
        assertEquals(Tests.SOUS_TITRE, item.getDescription());
        assertEquals(Tests.DATE_PARUTION, item.getPubDate());
    }
}