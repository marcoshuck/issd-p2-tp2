package application;

import domain.oven.Oven;
import domain.precinct.Precinct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class StoreTest {
    @Test
    public void TestInitializeNewApplication() {
        Store store = new Store();
        Assertions.assertNotNull(store);
    }

    @Test
    public void TestInitializeApplicationWithOven() {
        Oven oven = new Oven();
        Store store = new Store(oven);
        Assertions.assertNotNull(store);
    }

    @Test
    public void TestIncrementTemperatureBy10() {
        Oven oven = new Oven();
        Store store = new Store(oven);

        Assertions.assertEquals(0.0, store.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), store.getTemperature());

        store.incrementTemperature();

        Assertions.assertEquals(10.0, store.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), store.getTemperature());
    }

    @Test
    public void TestDecrementTemperatureBy10() {
        Oven oven = new Oven();
        Store store = new Store(oven);

        Assertions.assertEquals(0.0, store.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), store.getTemperature());

        store.incrementTemperature();

        Assertions.assertEquals(10.0, store.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), store.getTemperature());

        store.decrementTemperature();

        Assertions.assertEquals(0.0, store.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), store.getTemperature());
    }

    @Test
    public void TestIncrementTemperatureBy10WhenTemperatureIs100() {
        Oven oven = new Oven();
        oven.setTemperature(100.0);
        Store store = new Store(oven);

        Assertions.assertEquals(100.0, store.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), store.getTemperature());

        store.incrementTemperature();

        Assertions.assertEquals(100.0, store.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), store.getTemperature());
    }

    @Test
    public void TestDecrementTemperatureBy10WhenTemperatureIsZero() {
        Oven oven = new Oven();
        Store store = new Store(oven);

        Assertions.assertEquals(0.0, store.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), store.getTemperature());

        store.decrementTemperature();

        Assertions.assertEquals(0.0, store.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), store.getTemperature());
    }

    @Test
    public void TestGetStatusCorrectWhenFirstPrecinctIsSelectedAndTemperatureEqualAndLessThan50() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);
        oven.setTemperature(50);

        Store store = new Store(oven);

        store.turnPrecinctOn("Recinto 1");

        String status = store.getStatus();
        Assertions.assertEquals("Correcto", status);

        oven.setTemperature(40);
        status = store.getStatus();
        Assertions.assertEquals("Correcto", status);
    }

    @Test
    public void TestGetStatusIncorrectWhenFirstPrecinctIsSelectedAndTemperatureIsGreaterThan50() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);
        oven.setTemperature(60);

        Store store = new Store(oven);

        store.turnPrecinctOn("Recinto 1");

        String status = store.getStatus();
        Assertions.assertEquals("Incorrecto", status);
    }

    @Test
    public void TestGetStatusCorrectWhenSecondPrecinctIsSelectedAndTemperatureEqualOrLessThan80() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);
        oven.setTemperature(80);

        Store store = new Store(oven);

        store.turnPrecinctOn("Recinto 2");

        String status = store.getStatus();
        Assertions.assertEquals("Correcto", status);

        oven.setTemperature(45);
        status = store.getStatus();
        Assertions.assertEquals("Correcto", status);
    }

    @Test
    public void TestGetStatusIncorrectWhenSecondPrecinctIsSelectedAndTemperatureGreaterThan80() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);
        oven.setTemperature(81);

        Store store = new Store(oven);

        store.turnPrecinctOn("Recinto 2");

        String status = store.getStatus();
        Assertions.assertEquals("Incorrecto", status);
    }

    @Test
    public void TestGetStatusCorrectWhenThirdPrecinctIsSelectedWithAnyTemperature() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);
        oven.setTemperature(0);

        Store store = new Store(oven);

        store.turnPrecinctOn("Recinto 3");

        String status = store.getStatus();
        Assertions.assertEquals("Correcto", status);

        oven.setTemperature(100);
        status = store.getStatus();
        Assertions.assertEquals("Correcto", status);

        oven.setTemperature(50);
        status = store.getStatus();
        Assertions.assertEquals("Correcto", status);
    }

    @Test
    public void TestGetNullWhenNoPrecinctIsEnabled() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);

        Store store = new Store(oven);

        Precinct precinct = store.getEnabledPrecinct();
        Assertions.assertNull(precinct);
    }

    @Test
    public void TestGetPrecinctWhenCertainPrecinctIsEnabled() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);

        Store store = new Store(oven);

        store.turnPrecinctOn("Recinto 2");

        Precinct precinct = store.getEnabledPrecinct();
        Assertions.assertNotNull(precinct);
        Assertions.assertEquals("Recinto 2", precinct.getName());
    }

    @Test
    public void TestGetPrecinctNameWhenCertainPrecinctIsEnabled() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);

        Store store = new Store(oven);

        store.turnPrecinctOn("Recinto 2");

        String precinctName = store.getEnabledPrecinctName();
        Assertions.assertNotNull(precinctName);
        Assertions.assertEquals("Recinto 2", precinctName);
    }

    @Test
    public void TestGetPrecinctList() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);

        Store store = new Store(oven);

        ArrayList<Precinct> result = store.getPrecinctList();

        Assertions.assertEquals(precincts, result);
    }

    @Test
    public void TestResetValues() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);

        Store store = new Store(oven);

        store.incrementTemperature();
        store.turnPrecinctOn("Recinto 1");

        store.reset();

        for (Precinct p: precincts) {
            Assertions.assertEquals(false, p.isEnabled());
        }

        Assertions.assertEquals(0, store.getTemperature());

    }
}
