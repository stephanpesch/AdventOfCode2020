import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void initialize() {
        plane = Plane.getFromFile("testinput");
    }

    @Test
    public void hasSumOfCountsEleven() {
        assertEquals(6, plane.getSumOfCounts());
    }
}
