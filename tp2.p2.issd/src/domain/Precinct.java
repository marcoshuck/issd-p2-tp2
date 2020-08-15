package domain;

public class Precinct {
    private boolean enabled;
    private String name;

    public Precinct(String name, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public Precinct(String name) {
        this.name = name;
        this.enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean state) {
        this.enabled = state;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
