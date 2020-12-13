import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FerryTest {

    private Ferry ferry;

    @Before
    public void init() {
        this.ferry = new Ferry();
    }

    @Test
    public void resultFromTestinputIsTwentyFive() {
        ferry.moveByInstructionsFromFile("testinput");
        assertEquals(25, ferry.manhattanDistanceFromStartingPosition());
        ferry.reset();
    }
}
