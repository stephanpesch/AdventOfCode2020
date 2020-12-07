import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BagTest {

    @Test
    public void toStringReturnsConcatenatedStrings() {
        Bag bag = new Bag("shiny", "gold");
        assertEquals("shiny gold", bag.toString());
    }

    @Test
    public void equalityIsSymmetric() {
        Bag bag1 = new Bag("shiny", "gold");
        Bag bag2 = new Bag("shiny", "gold");

        assertEquals(bag1, bag2);
        assertEquals(bag1.hashCode(), bag2.hashCode());
    }
}
