package ru.productstar.outcoming;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.productstar.outcoming.service.ClientService;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class Real_HzClientTest {
	@Autowired
	ClientService clientService;

	@Test
	void realTest() {
		clientService.addClient("Real Test");
		assertFalse(clientService.getAllClients().isEmpty());
	}
}
