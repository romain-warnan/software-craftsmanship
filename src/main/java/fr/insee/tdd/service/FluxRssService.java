package fr.insee.tdd.service;

import fr.insee.tdd.dao.PublicationDao;
import fr.insee.tdd.model.FluxRssBuilder;
import fr.insee.tdd.model.rss.FluxRss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FluxRssService {

    @Autowired
    private PublicationDao publicationDao;

    public FluxRss fluxRss() {
        return FluxRssBuilder.from(publicationDao.cinqDernieresPublications());
    }
}
