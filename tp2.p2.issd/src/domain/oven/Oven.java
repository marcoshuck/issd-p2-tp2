package domain.oven;

import domain.precinct.Precinct;

import java.util.ArrayList;
import java.util.Arrays;

public class Oven {
    private ArrayList<Precinct> precincts;
    private double temperature;

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

    public void appendPrecinct(Precinct precinct) {
        this.precincts.add(precinct);
    }

    public Precinct getPrecinctByName(String name) {
        for (Precinct p : this.precincts) {
            if (p.getName() == name) {
                return p;
            }
        }
        return null;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
