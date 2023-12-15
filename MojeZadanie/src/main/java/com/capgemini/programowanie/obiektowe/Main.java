package com.capgemini.programowanie.obiektowe;

public class Main {
    public static void main(String[] args) {
        Clients clients = new ClientsImpl();
        Warehouse warehouse = new WarehouseImpl();

        try {
            // Tworzenie nowego klienta
            String clientId = clients.createNewClient("Jan", "Kowalski");
            System.out.println("Utworzono klienta o ID: " + clientId);

            // Aktywacja konta premium
            clients.activatePremiumAccount(clientId);
            System.out.println("Konto premium aktywowane dla klienta o ID: " + clientId);

            // Logika dalszych operacji...

        } catch (Exception e) {
            System.err.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}
