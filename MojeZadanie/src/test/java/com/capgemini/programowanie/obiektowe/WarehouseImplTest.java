package com.capgemini.programowanie.obiektowe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseImplTest {
    private Warehouse warehouse;
    private Clients clients;
    private String validClientId;

    @BeforeEach
    void setUp() {
        clients = new ClientsImpl();
        warehouse = new WarehouseImpl();
        validClientId = clients.createNewClient("John", "Doe");
    }

    @Test
    void testAddMetalIngot() {
        assertDoesNotThrow(() -> warehouse.addMetalIngot(validClientId, SupportedMetalType.COPPER, 10.0));
    }

    @Test
    void testAddMetalIngotThrowsClientNotFoundException() {
        assertThrows(ClientNotFoundException.class,
                () -> warehouse.addMetalIngot("non-existent-id", SupportedMetalType.COPPER, 10.0));
    }

    @Test
    void testGetTotalVolumeOccupiedByClient() {
        warehouse.addMetalIngot(validClientId, SupportedMetalType.COPPER, 10.0);
        double volume = warehouse.getTotalVolumeOccupiedByClient(validClientId);
        assertTrue(volume > 0, "Volume should be greater than 0");
    }
}
