package ui.components;

import application.Store;

public class ComponentReset implements ComponentResetter {
    private final PrecinctSelection precinctSelection;
    private final Status status;
    private final TemperatureSlider slider;
    private final TemperatureDisplay display;
    private final Store store;

    public ComponentReset(Store store, PrecinctSelection precinctSelection, Status status, TemperatureSlider slider, TemperatureDisplay display) {
        this.store = store;
        this.precinctSelection = precinctSelection;
        this.status = status;
        this.slider = slider;
        this.display = display;
    }

    @Override
    public void resetComponent() {
        this.store.reset();
        this.precinctSelection.resetComponent();
        this.status.resetComponent();
        this.slider.resetComponent();
        this.display.resetComponent();
    }
}
