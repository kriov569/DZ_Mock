package ru.productstar.outcoming;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.productstar.outcoming.model.Client;
import ru.productstar.outcoming.service.ClientService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class DI_HzClientTest {

    @Autowired
    private ClientService clientService;

    @Test
    void testAddAndGet() {
        clientService.addClient("DI Test");
        List<Client> clients = clientService.getAllClients();
        assertFalse(clients.isEmpty());
    }
}
