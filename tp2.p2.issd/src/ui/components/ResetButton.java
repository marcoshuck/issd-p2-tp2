package ui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JButton implements ActionListener {
    private final ComponentResetter reset;

    public ResetButton(ComponentResetter reset) {
        super("Inicializar");
        this.reset = reset;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.reset.resetComponent();
    }
}
