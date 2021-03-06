package domain.oven;

import domain.precinct.Precinct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class OvenTest {
    @Test
    public void TestCreateOvenWithNoData() {
        Oven oven = new Oven();
    }

    @Test
    public void TestCreateOvenWithPrecinctsArray() {
        Precinct[] precincts = new Precinct[0];
        Oven oven = new Oven(precincts);
        Assertions.assertNotNull(oven);
    }

    @Test
    public void TestCreateOvenWithPrecinctsArrayList() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        Oven oven = new Oven(precincts);
        Assertions.assertNotNull(oven);
    }


    @Test
    public void TestGetPrecinctsAsArray() {
        Oven oven = new Oven();
        Precinct[] precincts = oven.getPrecinctsArray();
        Assertions.assertNotNull(precincts);
    }

    @Test
    public void TestGetPrecinctsAsArrayList() {
        Oven oven = new Oven();
        ArrayList<Precinct> precincts = oven.getPrecinctsArrayList();
        Assertions.assertNotNull(precincts);
    }

    @Test
    public void TestInitializeOvenAndGetPrecinctsArrayAndAreEqual() {
        Precinct[] precincts = new Precinct[3];
        precincts[0] = new Precinct("Reciento 1");
        precincts[1] = new Precinct("Reciento 2");
        precincts[2] = new Precinct("Reciento 3");
        Oven oven = new Oven(precincts);

        Precinct[] result = oven.getPrecinctsArray();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.length);
        Assertions.assertEquals(precincts[0], result[0]);
        Assertions.assertEquals(precincts[1], result[1]);
        Assertions.assertEquals(precincts[2], result[2]);
    }

    @Test
    public void TestInitializeOvenAndGetPrecinctsArrayListAndAreEqual() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1"));
        precincts.add(new Precinct("Recinto 2"));
        precincts.add(new Precinct("Recinto 3"));

        Oven oven = new Oven(precincts);

        ArrayList<Precinct> result = oven.getPrecinctsArrayList();

        Assertions.assertEquals(precincts, result);
    }

    @Test
    public void TestAppendPrecinctsToOven() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1"));
        precincts.add(new Precinct("Recinto 2"));
        precincts.add(new Precinct("Recinto 3"));

        Oven oven = new Oven(precincts);

        oven.appendPrecinct(new Precinct("Reciento 4"));
    }

    @Test
    public void TestGetOnePrecinctByNameReturnsValue() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1"));
        precincts.add(new Precinct("Recinto 2"));
        precincts.add(new Precinct("Recinto 3"));

        Oven oven = new Oven(precincts);

        Precinct precinct = oven.getPrecinctByName("Recinto 1");
        Assertions.assertNotNull(precinct);
        Assertions.assertEquals("Recinto 1", precinct.getName());
    }

    @Test
    public void TestGetOnePrecinctReturnsNull() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1"));
        precincts.add(new Precinct("Recinto 2"));
        precincts.add(new Precinct("Recinto 3"));

        Oven oven = new Oven(precincts);

        Precinct precinct = oven.getPrecinctByName("Recinto X");
        Assertions.assertNull(precinct);
    }

    @Test
    public void TestGetTemperature() {
        Oven oven = new Oven();
        Assertions.assertEquals(0.0, oven.getTemperature());
    }

    @Test
    public void TestSetTemperature() {
        Oven oven = new Oven();
        double temperature = 50.0;
        oven.setTemperature(temperature);
        Assertions.assertEquals(temperature, oven.getTemperature());
    }
}
