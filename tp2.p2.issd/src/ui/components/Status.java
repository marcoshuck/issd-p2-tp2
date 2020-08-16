package ui.components;

import application.Store;

import javax.swing.*;
import java.awt.*;

public class Status extends JLabel implements ComponentResetter, ComponentUpdater {
    private final Store store;

    public Status(Store store) {
        super("", SwingConstants.CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.store = store;
    }

    public void updateStatus() {
        this.setText(this.store.getStatus());
    }

    public void resetStatus() {
        this.setText("");
    }

    @Override
    public void resetComponent() {
        this.resetStatus();
    }

    @Override
    public void updateComponent() {
        this.updateStatus();
    }
}
