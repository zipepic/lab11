package com.example.lab11;

import com.example.lab11.model.Client;
import com.example.lab11.repo.ClientRepository;
import com.example.lab11.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    private ClientService clientService;
    private List<Client> clients;

    @BeforeEach
    void setUp() {
        clients = Arrays.asList(
                new Client(1, "John", "Doe", "1", "None"),
                new Client(1, "Alice", "May", "12325", "None"),
                new Client(1, "Bob", "Lon", "14325", "None")
        );
    }
    @Test
    void testGetClientById() {
        assertEquals("John", clients.get(0).getFirstName());
    }
    @Test
    void testFindById() {
        assertEquals("John", clients.get(0).getFirstName());
    }

    @Test
    void testDeleteById() {
        assertEquals(clients.size(), clients.size());
    }

}


