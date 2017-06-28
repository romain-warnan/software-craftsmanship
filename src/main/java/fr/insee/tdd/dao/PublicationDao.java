package fr.insee.tdd.dao;

import com.google.common.collect.ImmutableMap;
import fr.insee.tdd.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class PublicationDao {

    private static final String SQL_FIND = "select * from publications where id = :id";
    private static final String SQL_FIND_ALL = "select * from publications";
    private static final String SQL_INSERT = "insert into publications (id, titre, sous_titre, date_parution) values (next value for seq, :titre, :sousTitre, :dateParution)";
    private static final String SQL_UPDATE = "update publications set titre = :titre, sous_titre = :sousTitre, date_parution = :dateParution where id = :id";

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PublicationRowMapper rowMapper;

    private NamedParameterJdbcTemplate template;

    @PostConstruct
    private void postConstruct() {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    public Optional<Publication> find(Long id) {
        try {
            Publication publication = template.queryForObject(SQL_FIND, ImmutableMap.of("id", id), rowMapper);
            return Optional.of(publication);

        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Publication> findAll() {
        return template.query(SQL_FIND_ALL, rowMapper);
    }

    public void insert(Publication publication) {
        template.update(SQL_INSERT, ImmutableMap.of(
                "titre", publication.getTitre(),
                "sousTitre", publication.getSousTitre(),
                "dateParution", publication.getDateParution()));
    }

    public void update(Publication publication) {
        template.update(SQL_UPDATE, ImmutableMap.of(
                "titre", publication.getTitre(),
                "sousTitre", publication.getSousTitre(),
                "dateParution", publication.getDateParution(),
                "id", publication.getId()
        ));
    }
}
