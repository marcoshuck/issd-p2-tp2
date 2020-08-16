package ui.components;

import application.Store;

import javax.swing.*;

public class TemperatureDisplay extends JLabel implements ComponentUpdater, ComponentResetter {
    private final Store store;

    public TemperatureDisplay(Store store) {
        super("");
        this.store = store;
    }

    public void updateTemperature() {
        double temperature = this.store.getTemperature();
        this.setText(Double.toString(temperature));
    }

    private void resetTemperature() {
        this.setText("");
    }

    @Override
    public void resetComponent() {
        this.resetTemperature();
    }

    @Override
    public void updateComponent() {
        this.updateTemperature();
    }
}
