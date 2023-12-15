package com.capgemini.programowanie.obiektowe;

public enum SupportedMetalType {
    COPPER(8.96), // gęstość w g/cm³
    IRON(7.87),
    GOLD(19.32),
    SILVER(10.49),
    PLATINUM(21.45);

    private final double density; // gęstość w g/cm³

    SupportedMetalType(double density) {
        this.density = density;
    }

    public double getDensity() {
        return density;
    }
}