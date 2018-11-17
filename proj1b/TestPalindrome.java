import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    /** Test a word of length 0 or 1. */
    @Test
    public void testPalindrome1() {
        String s1 = "a";
        String s2 = "@";
        String s3 = " ";
        String s4 = "";
        assertTrue(palindrome.isPalindrome(s1));
        assertTrue(palindrome.isPalindrome(s2));
        assertTrue(palindrome.isPalindrome(s3));
        assertTrue(palindrome.isPalindrome(s4));
    }

    /** Test a word of alphabets and numbers */
    @Test
    public void testPalindrome2() {
        String s1 = "Li Chen";
        String s2 = "abcde";
        String s3 = "sjdbfjsbd864892jdshfjsdh";
        String s4 = "abcdedcba";
        String s5 = "1a2b3b2a1";
        assertFalse(palindrome.isPalindrome(s1));
        assertFalse(palindrome.isPalindrome(s2));
        assertFalse(palindrome.isPalindrome(s3));
        assertTrue(palindrome.isPalindrome(s4));
        assertTrue(palindrome.isPalindrome(s5));
    }
}
