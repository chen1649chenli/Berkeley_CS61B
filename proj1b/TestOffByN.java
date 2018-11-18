import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void test1() {
        CharacterComparator cc1 = new OffByN(5);
        assertTrue(cc1.equalChars('a', 'f'));
        assertTrue(cc1.equalChars('f', 'a'));
        assertFalse(cc1.equalChars('f', 'h'));
    }

}
