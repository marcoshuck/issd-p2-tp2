package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Oven {
    private ArrayList<Precinct> precincts;

    public Oven(ArrayList<Precinct> precincts) {
        this.precincts = new ArrayList<>(precincts);
    }

    public Oven(Precinct[] precincts) {
        this.precincts = new ArrayList<>(Arrays.asList(precincts));
    }

    public Oven() {
        this.precincts = new ArrayList<>();
    }

    public Precinct[] getPrecinctsArray() {
        return this.precincts.toArray(new Precinct[0]);
    }

    public ArrayList<Precinct> getPrecinctsArrayList() {
        return this.precincts;
    }
}
