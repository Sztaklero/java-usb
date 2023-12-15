package com.capgemini.programowanie.obiektowe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientsImplTest {
    private Clients clients;

    @BeforeEach
    void setUp() {
        clients = new ClientsImpl();
    }

    @Test
    void testCreateNewClient() {
        String clientId = clients.createNewClient("John", "Doe");
        assertNotNull(clientId, "Client ID should not be null");
    }

    @Test
    void testActivatePremiumAccount() {
        String clientId = clients.createNewClient("Jane", "Doe");
        assertDoesNotThrow(() -> clients.activatePremiumAccount(clientId));
    }

    @Test
    void testActivatePremiumAccountThrowsException() {
        String nonExistentClientId = "non-existent-id";
        assertThrows(ClientNotFoundException.class, () -> clients.activatePremiumAccount(nonExistentClientId));
    }
}
