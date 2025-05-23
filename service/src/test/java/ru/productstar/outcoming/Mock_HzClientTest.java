package ru.productstar.outcoming;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.productstar.outcoming.model.Client;
import ru.productstar.outcoming.repository.ClientRepository;
import ru.productstar.outcoming.service.ClientService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Mock_HzClientTest {
    @Mock
    ClientRepository repo;

    @InjectMocks
    ClientService service;

    @Test
    void testWithMock() {
        when(repo.findAll()).thenReturn(List.of(new Client()));
        assertFalse(service.getAllClients().isEmpty());
    }
}
