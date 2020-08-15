package application;

import domain.oven.Oven;
import domain.precinct.Precinct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ApplicationTest {
    @Test
    public void TestInitializeNewApplication() {
        Application application = new Application();
        Assertions.assertNotNull(application);
    }

    @Test
    public void TestInitializeApplicationWithOven() {
        Oven oven = new Oven();
        Application application = new Application(oven);
        Assertions.assertNotNull(application);
    }

    @Test
    public void TestIncrementTemperatureBy10() {
        Oven oven = new Oven();
        Application application = new Application(oven);

        Assertions.assertEquals(0.0, application.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), application.getTemperature());

        application.incrementTemperature();

        Assertions.assertEquals(10.0, application.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), application.getTemperature());
    }

    @Test
    public void TestDecrementTemperatureBy10() {
        Oven oven = new Oven();
        Application application = new Application(oven);

        Assertions.assertEquals(0.0, application.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), application.getTemperature());

        application.incrementTemperature();

        Assertions.assertEquals(10.0, application.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), application.getTemperature());

        application.decrementTemperature();

        Assertions.assertEquals(0.0, application.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), application.getTemperature());
    }

    @Test
    public void TestIncrementTemperatureBy10WhenTemperatureIs100() {
        Oven oven = new Oven();
        oven.setTemperature(100.0);
        Application application = new Application(oven);

        Assertions.assertEquals(100.0, application.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), application.getTemperature());

        application.incrementTemperature();

        Assertions.assertEquals(100.0, application.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), application.getTemperature());
    }

    @Test
    public void TestDecrementTemperatureBy10WhenTemperatureIsZero() {
        Oven oven = new Oven();
        Application application = new Application(oven);

        Assertions.assertEquals(0.0, application.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), application.getTemperature());

        application.decrementTemperature();

        Assertions.assertEquals(0.0, application.getTemperature());
        Assertions.assertEquals(oven.getTemperature(), application.getTemperature());
    }

    @Test
    public void TestGetStatusCorrectWhenFirstPrecinctIsSelectedAndTemperatureEqualAndLessThan50() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);
        oven.setTemperature(50);

        Application application = new Application(oven);

        application.turnPrecinctOn("Recinto 1");

        String status = application.getStatus();
        Assertions.assertEquals("Correcto", status);

        oven.setTemperature(40);
        status = application.getStatus();
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

        Application application = new Application(oven);

        application.turnPrecinctOn("Recinto 1");

        String status = application.getStatus();
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

        Application application = new Application(oven);

        application.turnPrecinctOn("Recinto 2");

        String status = application.getStatus();
        Assertions.assertEquals("Correcto", status);

        oven.setTemperature(45);
        status = application.getStatus();
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

        Application application = new Application(oven);

        application.turnPrecinctOn("Recinto 2");

        String status = application.getStatus();
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

        Application application = new Application(oven);

        application.turnPrecinctOn("Recinto 3");

        String status = application.getStatus();
        Assertions.assertEquals("Correcto", status);

        oven.setTemperature(100);
        status = application.getStatus();
        Assertions.assertEquals("Correcto", status);

        oven.setTemperature(50);
        status = application.getStatus();
        Assertions.assertEquals("Correcto", status);
    }

    @Test
    public void TestGetNullWhenNoPrecinctIsEnabled() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);

        Application application = new Application(oven);

        Precinct precinct = application.getEnabledPrecinct();
        Assertions.assertNull(precinct);
    }

    @Test
    public void TestGetPrecinctWhenCertainPrecinctIsEnabled() {
        ArrayList<Precinct> precincts = new ArrayList<>();
        precincts.add(new Precinct("Recinto 1", false));
        precincts.add(new Precinct("Recinto 2", false));
        precincts.add(new Precinct("Recinto 3", false));

        Oven oven = new Oven(precincts);

        Application application = new Application(oven);

        application.turnPrecinctOn("Recinto 2");

        Precinct precinct = application.getEnabledPrecinct();
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

        Application application = new Application(oven);

        application.turnPrecinctOn("Recinto 2");

        String precinctName = application.getEnabledPrecinctName();
        Assertions.assertNotNull(precinctName);
        Assertions.assertEquals("Recinto 2", precinctName);
    }
}
