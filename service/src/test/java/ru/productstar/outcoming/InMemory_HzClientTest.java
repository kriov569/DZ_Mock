package ru.productstar.outcoming;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.productstar.outcoming.repository.ClientRepository;
import ru.productstar.outcoming.service.ClientService;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertFalse;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = InMemory_HzClientTest.InMemoryConfig.class)
public class InMemory_HzClientTest {

    @Autowired
    private ClientService clientService;

    @Test
    void inMemoryClientTest() {
        clientService.addClient("Test");
        assertFalse(clientService.getAllClients().isEmpty());
    }

    @Configuration
    static class InMemoryConfig {
        @Bean
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder()
                            .setType(EmbeddedDatabaseType.H2)
                            .addScript("schema.sql")
                            .build();
        }

        @Bean
        public JdbcTemplate jdbcTemplate(DataSource dataSource) {
            return new JdbcTemplate(dataSource);
        }

        @Bean
        public ClientRepository clientRepository(JdbcTemplate jdbcTemplate) {
            return new ClientRepository(jdbcTemplate);
        }

        @Bean
        public ClientService clientService(ClientRepository repo) {
            return new ClientService(repo);
        }
    }
}
