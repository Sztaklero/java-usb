package com.capgemini.programowanie.obiektowe;

import java.time.LocalDate;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientsImpl implements Clients {

    private static final ConcurrentHashMap<String, ClientData> clients = new ConcurrentHashMap<>();
    private static final AtomicInteger clientIdCounter = new AtomicInteger(0);

    @Override
    public String createNewClient(String firstName, String lastName) {
        String clientId = "C" + clientIdCounter.incrementAndGet();
        clients.put(clientId, new ClientData(firstName, lastName, LocalDate.now(), false));
        return clientId;
    }

    @Override
    public String activatePremiumAccount(String clientId) {
        ClientData client = getClient(clientId);
        if (client == null) {
            throw new ClientNotFoundException("Client with ID: " + clientId + " not found.");
        }
        client.setPremium(true);
        return clientId;
    }

    @Override
    public String getClientFullName(String clientId) {
        ClientData client = getClient(clientId);
        if (client == null) {
            throw new ClientNotFoundException("Client with ID: " + clientId + " not found.");
        }
        return client.firstName + " " + client.lastName;
    }

    @Override
    public LocalDate getClientCreationDate(String clientId) {
        ClientData client = getClient(clientId);
        if (client == null) {
            throw new ClientNotFoundException("Client with ID: " + clientId + " not found.");
        }
        return client.creationDate;
    }

    @Override
    public boolean isPremiumClient(String clientId) {
        ClientData client = getClient(clientId);
        return client != null && client.isPremium;
    }

    @Override
    public int getNumberOfClients() {
        return clients.size();
    }

    @Override
    public int getNumberOfPremiumClients() {
        return (int) clients.values().stream().filter(clientData -> clientData.isPremium()).count();
    }

    private ClientData getClient(String clientId) {
        return clients.get(clientId);
    }

    private static class ClientData {
        private String firstName;
        private String lastName;
        private boolean isPremium;
        private LocalDate creationDate;

        public ClientData(String firstName, String lastName, LocalDate creationDate, boolean isPremium) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.creationDate = creationDate;
            this.isPremium = isPremium;
        }

        public void setPremium(boolean isPremium) {
            this.isPremium = isPremium;
        }

        // Metoda zwracająca status premium klienta
        public boolean isPremium() {
            return this.isPremium;
        }

        // Możesz dodać więcej metod, jeśli są potrzebne
    }
}