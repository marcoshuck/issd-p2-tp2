package ui.components;

import application.Store;

import javax.swing.*;
import java.awt.*;

public class PrecinctSelection extends JLabel implements ComponentUpdater, ComponentResetter {
    private final Store store;

    public PrecinctSelection(Store store) {
        super("", SwingConstants.CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.store = store;
    }

    private void updateSelection() {
        String text = this.store.getEnabledPrecinctName();
        if(text == null) {
            this.setText("");
            return;
        }
        this.setText(text);
    }

    private void resetSelection() {
        this.setText("");
    }

    @Override
    public void updateComponent() {
        this.updateSelection();
    }

    @Override
    public void resetComponent() {
        this.resetSelection();
    }
}
