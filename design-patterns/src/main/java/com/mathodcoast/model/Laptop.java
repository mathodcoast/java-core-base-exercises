package com.mathodcoast.model;

import java.util.Objects;

public class Laptop {

    private String HDD;
    private String RAM;
    private String CPU;

    private Boolean isGraphicalCardEnabled;
    private Boolean isBluetoothEnabled;

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public String getCPU() {
        return CPU;
    }

    private Laptop(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.CPU = builder.CPU;
        this.isGraphicalCardEnabled = builder.isGraphicalCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public Boolean isGraphicalCardEnabled() {
        return isGraphicalCardEnabled;
    }

    public Boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return HDD.equals(laptop.HDD) &&
                RAM.equals(laptop.RAM) &&
                CPU.equals(laptop.CPU) &&
                Objects.equals(isGraphicalCardEnabled,laptop.isGraphicalCardEnabled) &&
                Objects.equals(isBluetoothEnabled,laptop.isBluetoothEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(HDD,RAM,CPU,isGraphicalCardEnabled,isBluetoothEnabled);
    }

    public static class ComputerBuilder{

        private String HDD;
        private String RAM;
        private String CPU;

        private Boolean isGraphicalCardEnabled;
        private Boolean isBluetoothEnabled;

        public ComputerBuilder(String HDD,String RAM,String CPU) {
            this.HDD = HDD;
            this.RAM = RAM;
            this.CPU = CPU;
        }

        public ComputerBuilder setGraphicalCardEnabled(Boolean graphicalCardEnabled) {
            this.isGraphicalCardEnabled = graphicalCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(Boolean bluetoothEnabled) {
            this.isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Laptop build(){
            return new Laptop(this);
        }
    }
}
