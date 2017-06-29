package fr.insee.tdd.dao;

import fr.insee.tdd.Tests;
import fr.insee.tdd.model.Publication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

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
        Publication publication = Tests.unePublication();
        publicationDao.insert(publication);
    }

    @Test
    public void update() {
        Publication publication = Tests.unePublication();
        publication.setId(1L);
        publicationDao.update(publication);
    }
}