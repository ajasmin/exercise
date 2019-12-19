import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class UtilTest {
    /**
     * Tests for functions in the Util class
     *
     * TODO: Add more tests
     */

    @Test
    void testEmailIsValid() {
        assertTrue(Util.isEmailValid("abc@example.com"));
    }
}
