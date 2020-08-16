package ui.components;

import application.Store;

import javax.swing.*;
import java.awt.*;

public class TemperatureSlider extends JPanel implements ComponentUpdater, ComponentResetter {
    private final int height;
    private final int width;
    private final int max;
    private final Store store;
    private double position;

    public TemperatureSlider(Store store, int height, int width, int max) {
        super(new BorderLayout(10, 10));
        this.store = store;
        this.height = height;
        this.width = width;
        this.max = max;
    }

    @Override
    public void resetComponent() {
        this.position = 0;
    }

    @Override
    public void updateComponent() {
        this.position = this.width / max * this.store.getTemperature();
        this.repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.width, this.height);
        g.setColor(Color.RED);

        int positionX = (int)this.position;
        g.drawLine(positionX, 0, positionX, height);
    }
}
