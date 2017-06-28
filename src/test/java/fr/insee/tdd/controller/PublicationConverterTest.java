package fr.insee.tdd.controller;

import fr.insee.tdd.model.Publication;
import fr.insee.tdd.model.PublicationConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class PublicationConverterTest {

    @Autowired
    private PublicationConverter publicationConverter;

    @Test
    public void convert_not_empty () {
        Publication publication = publicationConverter.convert("1");
        assertNotNull(publication.getId());
    }

    @Test
    public void convert_empty () {
        Publication publication = publicationConverter.convert("-1");
        assertNull(publication.getId());
    }
}
