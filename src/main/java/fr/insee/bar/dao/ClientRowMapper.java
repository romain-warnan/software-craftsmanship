package fr.insee.bar.dao;

import fr.insee.bar.model.Client;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(rs.getShort("id"));
        client.setNom(rs.getString("nom"));
        client.setEmail(rs.getString("email"));
        client.setDateNaissance(rs.getDate("date_naissance"));
        client.setTitre(Client.Titre.of(rs.getShort("titre")));
        return client;
    }
}
