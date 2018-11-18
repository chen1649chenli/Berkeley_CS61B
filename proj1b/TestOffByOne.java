import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void equalCharsTest1() {
        Character a1 = 'a';
        Character b1 = 'b';
        assertTrue(offByOne.equalChars(a1, b1));

        Character a2 = 'Y';
        Character b2 = 'X';
        assertTrue(offByOne.equalChars(a2, b2));

        Character a3 = '&';
        Character b3 = '%';
        assertTrue(offByOne.equalChars(a3, b3));

        Character a4 = 'Z';
        Character b4 = 'a';
        assertFalse(offByOne.equalChars(a4, b4));

        Character a5 = ' ';
        Character b5 = '!';
        assertTrue(offByOne.equalChars(a5, b5));

        Character a6 = 'a';
        Character b6 = 'z';
        assertFalse(offByOne.equalChars(a6, b6));

        Character a7 = 'A';
        Character b7 = 'C';
        assertFalse(offByOne.equalChars(a7, b7));

    }
}
