package fr.insee.tdd.model;

import fr.insee.tdd.dao.PublicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PublicationConverter implements Converter<String, Publication> {

    @Autowired
    private PublicationDao publicationDao;

    @Override
    public Publication convert(String id) {
        return publicationDao
            .find(Long.valueOf(id))
            .orElse(new Publication());
    }
}
