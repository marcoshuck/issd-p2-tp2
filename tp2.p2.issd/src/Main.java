import application.Store;
import domain.oven.Oven;
import domain.precinct.Precinct;
import ui.UI;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayList<Precinct> precincts = new ArrayList<>();
                    precincts.add(new Precinct("Recinto 1"));
                    precincts.add(new Precinct("Recinto 2"));
                    precincts.add(new Precinct("Recinto 3"));
                    Oven oven = new Oven(precincts);
                    Store store = new Store(oven);
                    UI ui = new UI(store);
                    ui.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
