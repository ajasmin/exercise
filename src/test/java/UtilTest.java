import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class UtilTest {
    /**
     * Tests for functions in the Util class
     *
     * TODO: Add more tests
     */

    @Test
    void emailIsValid() {
        assertTrue(Util.isEmailValid("abc@example.com"));
    }

    // TODO: Make this test pass
    @Test
    void isPalindrome() {
        assertTrue("isPalindrome should return true when passed a palindrome",
                Util.isPalindrome("radar"));
    }
}
