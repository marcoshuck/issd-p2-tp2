package ui.components;

import application.Store;

import javax.swing.*;

public class TemperatureDisplay extends JLabel implements ComponentUpdater, ComponentResetter {
    private final Store store;

    public TemperatureDisplay(Store store) {
        super("0.0 ºC", SwingConstants.CENTER);
        this.store = store;
    }

    public void updateTemperature() {
        double temperature = this.store.getTemperature();
        this.setText(temperature + " ºC");
    }

    private void resetTemperature() {
        this.setText("0.0 ºC");
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
