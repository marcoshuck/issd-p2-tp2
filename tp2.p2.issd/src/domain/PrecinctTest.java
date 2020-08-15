package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrecinctTest {
    private Precinct precinct;

    @BeforeEach
    public void SetupEachTest() {
        this.precinct = new Precinct("Recinto", false);
        Assertions.assertNotNull(precinct);
    }

    @Test
    public void TestIfIsPrecinctEnabledAfterCreation() {
        Precinct precinct = new Precinct("Recinto", false);
        Assertions.assertFalse(precinct.isEnabled());
    }

    @Test
    public void TestPrecinctEnabledAfterCreationWithDefaultValue() {
        Precinct precinct = new Precinct("Recinto", true);
        Assertions.assertTrue(precinct.isEnabled());
    }

    @Test
    public void TestSetPrecinctEnabled() {
        Assertions.assertFalse(this.precinct.isEnabled());
        this.precinct.setEnabled(true);
        Assertions.assertTrue(this.precinct.isEnabled());
    }

    @Test
    public void TestGetPrecinctName() {
        Assertions.assertEquals("Recinto", this.precinct.getName());
    }

    @Test
    public void TestSetPrecinctName() {
        this.precinct.setName("RecintoModificado");
        Assertions.assertEquals("RecintoModificado", this.precinct.getName());
    }
}
