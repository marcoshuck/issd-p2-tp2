package ui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton implements ActionListener {
    private final ComponentUpdater updater;

    public StartButton(ComponentUpdater updater) {
        super("Calefaccionar");
        this.updater = updater;
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.updater.updateComponent();
    }
}
