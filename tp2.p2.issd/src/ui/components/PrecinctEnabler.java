package ui.components;

import application.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrecinctEnabler extends JButton implements ActionListener {
    private final Store store;
    private final String name;
    private final ComponentUpdater componentUpdater;


    public PrecinctEnabler(Store store, String name, ComponentUpdater componentUpdater) {
        super(name);
        this.store = store;
        this.name = name;
        this.componentUpdater = componentUpdater;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.store.turnPrecinctOn(this.name);
        this.componentUpdater.updateComponent();
    }
}
