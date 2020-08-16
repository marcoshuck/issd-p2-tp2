package application;

import domain.oven.Oven;
import domain.precinct.Precinct;

import java.util.ArrayList;

public class Store {
    private final Oven oven;

    public Store(Oven oven) {
        this.oven = oven;
    }

    public Store() {
        this.oven = new Oven();
    }

    public void incrementTemperature() {
        double temperature = this.oven.getTemperature();
        if (temperature >= 100) {
            return;
        }
        this.oven.setTemperature(temperature+10);
    }

    public double getTemperature() {
        return this.oven.getTemperature();
    }

    public void decrementTemperature() {
        double temperature = this.oven.getTemperature();
        if (temperature <= 0) {
            return;
        }
        this.oven.setTemperature(temperature-10);
    }

    public void turnPrecinctOn(String name) {
        Precinct selected = this.oven.getPrecinctByName(name);
        if(selected == null) {
            return;
        }
        Precinct[] precincts = this.oven.getPrecinctsArray();
        for (Precinct precinct:
             precincts) {
            precinct.setEnabled(false);
        }
        selected.setEnabled(true);
    }

    public String getStatus() {
        Precinct precinct = this.getEnabledPrecinct();
        if (precinct == null) {
            return "Incorrecto";
        }
        switch (precinct.getName()) {
            case "Recinto 1":
                return isFirstPrecinctCorrect(precinct) ? "Correcto" : "Incorrecto";
            case "Recinto 2":
                return isSecondPrecinctCorrect(precinct) ? "Correcto" : "Incorrecto";
            case "Recinto 3":
                return isThirdPrecinctCorrect(precinct) ? "Correcto" : "Incorrecto";
        }
        return "Incorrecto";
    }

    private boolean isFirstPrecinctCorrect(Precinct precinct) {
        return precinct.isEnabled() && this.oven.getTemperature() <= 50;
    }

    private boolean isSecondPrecinctCorrect(Precinct precinct) {
        return precinct.isEnabled() && this.oven.getTemperature() <= 80;
    }

    private boolean isThirdPrecinctCorrect(Precinct precinct) {
        return precinct.isEnabled();
    }

    public Precinct getEnabledPrecinct() {
        for (Precinct p : this.oven.getPrecinctsArray()) {
            if(p.isEnabled()) {
                return p;
            }
        }
        return null;
    }

    public String getEnabledPrecinctName() {
        Precinct p = this.getEnabledPrecinct();
        if(p != null) {
            return p.getName();
        }
        return null;
    }

    public ArrayList<Precinct> getPrecinctList() {
        return this.oven.getPrecinctsArrayList();
    }

    public void reset() {
        this.oven.setTemperature(0);
        for (Precinct p: this.oven.getPrecinctsArray()) {
            p.setEnabled(false);
        }
    }
}
