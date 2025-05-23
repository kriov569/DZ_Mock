package ru.productstar.outcoming.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.productstar.outcoming.model.Client;

import java.util.List;

@Repository
public class ClientRepository {
    private final JdbcTemplate jdbcTemplate;

    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Client client) {
        jdbcTemplate.update("INSERT  INTO client(name) VALUES (?)", client.getName());
    }

    public List<Client> findAll() {
        return jdbcTemplate.query("SELECT * FROM client", (rs, rowNum) -> {
            Client c = new Client();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("name"));
            return c;
        });
    }
}
