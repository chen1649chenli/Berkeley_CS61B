import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestSort {
    @Test
    public static void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int output = Sort.findSmallest(input, 0);
        int expect = 2;
        org.junit.jupiter.api.Assertions.assertEquals(output, expect);

    }

    @Test
    public static void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        Sort.swap(input, 1,2);
        String[] expect = {"i", "an", "have", "egg"};
        org.junit.jupiter.api.Assertions.assertArrayEquals(input, expect);

    }

    @Test
    public static void testSort() {
        String[] input = {"5", "4", "3", "2", "1"};
        Sort.sort(input, 0);
        String[] expect = {"1", "2", "3", "4", "5"};
        org.junit.jupiter.api.Assertions.assertArrayEquals(input, expect);

        String[] input2 = {"i", "love", "an", "egg"};
        String[] expect2 = {"an", "egg", "i", "love"};
        Sort.sort(input2);
        org.junit.jupiter.api.Assertions.assertArrayEquals(input2, expect2);
    }


}
