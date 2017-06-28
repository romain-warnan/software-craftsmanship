package fr.insee.tdd.dao;

import fr.insee.tdd.model.Publication;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PublicationRowMapper implements RowMapper<Publication> {

    @Override
    public Publication mapRow(ResultSet rs, int rowNum) throws SQLException {
        Publication publication = new Publication();
        publication.setId(rs.getLong("id"));
        publication.setTitre(rs.getString("titre"));
        publication.setSousTitre(rs.getString("sous_titre"));
        publication.setDateParution(rs.getDate("date_parution"));
        return publication;
    }
}
