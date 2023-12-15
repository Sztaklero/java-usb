package com.capgemini.programowanie.obiektowe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WarehouseImpl implements Warehouse {
    private final Map<String, Map<SupportedMetalType, Double>> storage;

    public WarehouseImpl() {
        this.storage = new HashMap<>();
    }

    @Override
    public void addMetalIngot(String clientId, SupportedMetalType metalType, double mass) {
        storage.computeIfAbsent(clientId, k -> new HashMap<>()).merge(metalType, mass, Double::sum);
    }

    @Override
    public Map<SupportedMetalType, Double> getMetalTypesToMassStoredByClient(String clientId) {
        return storage.getOrDefault(clientId, new HashMap<>());
    }

    @Override
    public double getTotalVolumeOccupiedByClient(String clientId) {
        return storage.getOrDefault(clientId, new HashMap<>()).entrySet().stream()
                .mapToDouble(entry -> entry.getValue() / entry.getKey().getDensity())
                .sum();
    }
    public List<SupportedMetalType> getStoredMetalTypesByClient(String clientId) {
        return storage.getOrDefault(clientId, new HashMap<>())
                .keySet()
                .stream()
                .collect(Collectors.toList());
    }

}
