package ui.components;

public class ComponentUpdate implements ComponentUpdater {
    private final TemperatureDisplay display;
    private final TemperatureSlider slider;

    public ComponentUpdate(TemperatureDisplay display, TemperatureSlider slider) {
        this.display = display;
        this.slider = slider;
    }

    @Override
    public void updateComponent() {
        this.display.updateComponent();
        this.slider.updateComponent();
    }
}
