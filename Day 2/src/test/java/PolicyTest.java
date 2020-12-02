import domain.Policy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PolicyTest {

    @Test
    public void onePositionContainsRightCharReturnsTrue() {
        Policy policy = new Policy(1, 3, 'a');
        assertTrue(policy.isValidPassword("abcde"));
    }

    @Test
    public void noPositionContainsRightCharReturnsFalse() {
        Policy policy = new Policy(1, 3, 'b');
        assertFalse(policy.isValidPassword("cdefg"));
    }

    @Test
    public void bothPositionsContainsRightCarReturnsFalse() {
        Policy policy = new Policy(2, 9, 'c');
        assertFalse(policy.isValidPassword("ccccccccc"));
    }
}
