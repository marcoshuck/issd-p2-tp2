package ui;

import application.Store;
import domain.precinct.Precinct;
import ui.components.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends JFrame {
    private final JPanel mainPanel;
    private final JPanel leftPanel;
    private final JPanel rightPanel;

    private final JPanel temperatureDisplayPanel;
    private final JPanel temperatureGainPanel;
    private final JPanel controlPanel;
    private final Store store;

    private IncrementButton incrementButton;
    private DecrementButton decrementButton;
    private TemperatureDisplay temperatureDisplay;
    private TemperatureSlider temperatureSlider;
    private ComponentUpdate componentUpdate;
    private PrecinctSelection precinctSelection;
    private Status status;
    private ComponentReset componentReset;

    public UI(Store store) {
        super();
        this.store = store;
        this.mainPanel = new JPanel(new GridLayout(1, 2));
        this.leftPanel = new JPanel(new GridLayout(4, 1));
        this.rightPanel = new JPanel(new GridLayout(6, 1));

        this.temperatureDisplayPanel = new JPanel(new GridLayout(1, 2));
        this.temperatureGainPanel = new JPanel(new GridLayout(1, 2));
        this.controlPanel = new JPanel(new GridLayout(1, 2));

        this.initialize();

        this.setupLeftPanel();
        this.setupRightPanel();

        this.setupUi();
    }

    private void setupUi() {
        this.mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

        this.mainPanel.add(this.leftPanel);
        this.mainPanel.add(this.rightPanel);

        this.setContentPane(this.mainPanel);
        this.setBounds(0, 0, 800, 600);
        this.setTitle("Horno eléctrico");
    }

    private void initialize() {
        this.initializeStatus();
        this.initializePrecinctSelection();
    }

    private void setupLeftPanel() {
        this.leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        this.setupTemperatureDisplayPanel();
        this.setupTemperatureSlider();
        this.setupComponentUpdateWrapper();
        this.setupComponentResetWrapper();
        this.setupTemperatureGainPanel();
        this.setupControlPanel();
    }

    private void setupTemperatureDisplayPanel() {
        this.temperatureDisplayPanel.add(new JLabel("Temperatura"));

        this.temperatureDisplay = new TemperatureDisplay(store);
        this.temperatureDisplayPanel.add(this.temperatureDisplay);

        this.leftPanel.add(this.temperatureDisplayPanel);
    }

    private void setupTemperatureSlider() {
        this.temperatureSlider = new TemperatureSlider(store, 75, 200, 100);
        this.leftPanel.add(this.temperatureSlider);
    }

    private void setupComponentUpdateWrapper() {
        this.componentUpdate = new ComponentUpdate(this.temperatureDisplay, this.temperatureSlider);
    }

    private void setupComponentResetWrapper() {
        this.componentReset = new ComponentReset(
                this.store,
                this.precinctSelection,
                this.status,
                this.temperatureSlider,
                this.temperatureDisplay
        );
    }

    private void setupTemperatureGainPanel() {
        this.decrementButton = new DecrementButton(this.store, this.componentUpdate);
        this.temperatureGainPanel.add(this.decrementButton);

        this.incrementButton = new IncrementButton(this.store, this.componentUpdate);
        this.temperatureGainPanel.add(this.incrementButton);
        this.leftPanel.add(this.temperatureGainPanel);
    }

    private void setupControlPanel() {
        this.controlPanel.add(new ResetButton(this.componentReset));
        this.controlPanel.add(new StartButton(this.status));
        this.leftPanel.add(this.controlPanel);
    }

    private void setupRightPanel() {
        this.rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        this.rightPanel.add(new JLabel("Recintos"));
        this.setupPrecinctList();
        this.setupPrecinctSelection();
        this.setupStatus();
    }

    private void initializePrecinctSelection() {
        this.precinctSelection = new PrecinctSelection(store);
    }

    private void setupPrecinctList() {
        ArrayList<Precinct> precincts = this.store.getPrecinctList();
        PrecinctEnabler precinctEnabler;
        for (Precinct p: precincts) {
            precinctEnabler = new PrecinctEnabler(this.store, p.getName(), this.precinctSelection);
            this.rightPanel.add(precinctEnabler);
        }
    }

    private void setupPrecinctSelection() {
        this.rightPanel.add(this.precinctSelection);
    }

    private void initializeStatus() {
        this.status = new Status(this.store);
    }

    private void setupStatus() {
        this.rightPanel.add(this.status);
    }

}
