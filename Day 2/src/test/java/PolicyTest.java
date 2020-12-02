import domain.Policy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PolicyTest {

    private Policy policy;

    @Before
    public void initialize() {
        policy = new Policy(6, 7, 'w');
    }

    @Test
    public void returnFalseIfPasswordContainsTooMany() {
        assertFalse(policy.isValidPassword("wwhwmzwtwwkwzw"));
    }

    @Test
    public void returnFalseIfPasswordContainsTooLittle() {
        assertFalse(policy.isValidPassword("wwhmzwtwwk"));
    }

    @Test
    public void returnTrueIfPasswordValid() {
        assertTrue(policy.isValidPassword("wwhmzwtwwkw"));
    }
}
