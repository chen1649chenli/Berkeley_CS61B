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

        Character a2 = 'y';
        Character b2 = 'x';
        assertTrue(offByOne.equalChars(a2, b2));

        Character a3 = '&';
        Character b3 = '%';
        assertTrue(offByOne.equalChars(a3, b3));
    }
}
