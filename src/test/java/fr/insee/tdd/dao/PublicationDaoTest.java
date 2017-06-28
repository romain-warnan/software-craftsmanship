package fr.insee.tdd.dao;

import fr.insee.tdd.model.Publication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class PublicationDaoTest {

    @Autowired
    private PublicationDao publicationDao;

    @Test
    public void find() {
        Optional<Publication> publication = publicationDao.find(1L);
        assertTrue(publication.isPresent());
        publication.ifPresent(p -> assertEquals(1L, p.getId().longValue()));
    }

	@Test
    public void findAll() {
        List<Publication> publications = publicationDao.findAll();
        assertTrue(publications.size() > 0);
	}

    @Test
    public void insert() {
        Publication publication = new Publication();
        publication.setTitre("Titre");
        publication.setSousTitre("Sous-titre");
        publication.setDateParution(new Date(1234567L));
        publicationDao.insert(publication);
    }

    @Test
    public void update() {
        Publication publication = new Publication();
        publication.setId(1L);
        publication.setTitre("Titre");
        publication.setSousTitre("Sous-titre");
        publication.setDateParution(new Date(1234567L));
        publicationDao.update(publication);
    }

    @Test
    public void cinqDernieresPublications() {
        List<Publication> publications = publicationDao.cinqDernieresPublications();
        assertEquals(5, publications.size());
    }
}