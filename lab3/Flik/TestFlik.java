import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class TestFlik {
    @Test
    public void test1() {
        int i = 127;
        int j = 127;
        assertTrue(Flik.isSameNumber(i, j));
    }
    @Test
    public void test2() {
        int i = 128;
        int j = 128;
        assertTrue(Flik.isSameNumber(i, j));
    }
}
