import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    private Graph testGraph1;
    private Graph testGraph2;

    @Before
    public void initialize() {
        testGraph1 = Graph.getFromFile("testinput1");
        testGraph2 = Graph.getFromFile("testinput2");
    }

    @Test
    public void solutionToPartOneCorrect() {
        assertEquals(35L, testGraph1.getAmountOneDifferenceAndThreeDifferenceProduct());
        assertEquals(220L, testGraph2.getAmountOneDifferenceAndThreeDifferenceProduct());
    }

    @Test
    public void solutionToPartTwoCorrect() {
        assertEquals(8L, testGraph1.traverse(0));
        assertEquals(19208L, testGraph2.traverse(0));
    }
}
