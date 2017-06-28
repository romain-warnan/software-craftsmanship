package fr.insee.tdd.converter;

import fr.insee.tdd.dao.PublicationDao;
import fr.insee.tdd.model.Publication;
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
