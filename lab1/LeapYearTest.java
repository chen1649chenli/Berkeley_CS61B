import static org.junit.Assert.*;
import org.junit.Test;

public class LeapYearTest {
    @Test
    public void testCase1() {
        LeapYear year = new LeapYear();
        assertEquals(true, year.isLeapYear(1996));
    }

    @Test
    public void testCase2() {
        LeapYear year = new LeapYear();
        assertEquals(false, year.isLeapYear(1900));
    }
}
