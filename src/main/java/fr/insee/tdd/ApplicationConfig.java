package fr.insee.tdd;

import fr.insee.tdd.model.PublicationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private PublicationConverter publicationConverter;

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("db/create-db.sql")
            .addScript("db/insert-data.sql")
            .build();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(publicationConverter);
    }
}
