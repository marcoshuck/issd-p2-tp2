package ui.components;

import application.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncrementButton extends JButton implements ActionListener {
    private final Store store;
    private final ComponentUpdater componentUpdater;

    public IncrementButton(Store store, ComponentUpdater componentUpdater) {
        super(">>");
        this.store = store;
        this.componentUpdater = componentUpdater;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.store.incrementTemperature();
        this.componentUpdater.updateComponent();
    }
}
