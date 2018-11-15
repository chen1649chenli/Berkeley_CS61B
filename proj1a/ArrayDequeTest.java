import org.junit.Assert;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void sizeTest (){
        ArrayDeque<String> array1 = new ArrayDeque<>();
        Assert.assertEquals(0, array1.size());
    }
    @Test
    public void addFirstTest(){
        ArrayDeque<String> array1 = new ArrayDeque<>();
        array1.addFirst("1");
        array1.addFirst("2");
        array1.addFirst("3");
        array1.addFirst("4");
        array1.addFirst("5");
        array1.addFirst("6");
        array1.addFirst("7");
        array1.addFirst("8");
        array1.addFirst("9");
        array1.addFirst("10");
        array1.addFirst("11");
        Assert.assertEquals(11, array1.size());
    }

    @Test
    public void addLastTest(){
        ArrayDeque<String> array1 = new ArrayDeque<>();
        array1.addLast("1");
        array1.addLast("2");
        array1.addLast("3");
        array1.addLast("4");
        array1.addLast("5");
        array1.addLast("6");
        array1.addLast("7");
        array1.addLast("8");
        array1.addLast("9");
        array1.addLast("10");
        array1.addLast("11");
        Assert.assertEquals(11, array1.size());
    }

    @Test
    public void addTest(){
        ArrayDeque<String> array1 = new ArrayDeque<>();
        array1.addLast("1");
        array1.addLast("2");
        array1.addFirst("3");
        array1.addFirst("4");
        array1.addFirst("5");
        array1.addFirst("6");
        array1.addFirst("7");
        array1.addFirst("8");
        array1.addFirst("9");
        array1.addFirst("10");
        array1.addFirst("11");
        Assert.assertEquals(11, array1.size());
    }
    @Test
    public void addTest2() {
        ArrayDeque<String> array1 = new ArrayDeque<>();
        array1.addFirst("1");
        array1.addFirst("2");
        array1.addFirst("3");
        array1.addFirst("4");
        array1.addFirst("5");
        array1.addFirst("6");
        array1.addFirst("7");
        array1.addFirst("8");
        array1.addFirst("9");
        array1.removeFirst();
        array1.removeFirst();
        array1.removeFirst();
        array1.removeFirst();
        array1.removeFirst();
        array1.removeFirst();
        array1.removeFirst();
        array1.removeFirst();
        array1.removeFirst();

        Assert.assertEquals(0, array1.size());
    }

    @Test
    public void get() {
        ArrayDeque<Integer> array1 = new ArrayDeque<>();
        array1.addFirst(0);
        array1.removeLast();
        array1.addLast(2);
        array1.addLast(3);
        array1.addLast(4);
        array1.addLast(5);
        array1.addFirst(6);
        array1.addLast(7);
        array1.get(0);
        array1.get(4);
        array1.addLast(10);
        array1.removeFirst();
        array1.removeFirst();
        array1.addLast(13);
        array1.get(3);
        array1.removeLast();
        array1.removeLast();
        int i = array1.removeFirst();

        Assert.assertEquals(3, i);
    }
    @Test
    public void get2() {
        ArrayDeque<Integer> array1 = new ArrayDeque<>();
        array1.addFirst(0);
        array1.addFirst(1);
        array1.addLast(2);
        array1.get(1);
        array1.get(1);
        array1.addLast(5);
        array1.addLast(6);
        array1.addFirst(7);
        array1.get(2);
        array1.addLast(9);
        array1.removeFirst();
        array1.addLast(11);
        array1.get(0);
        array1.removeFirst();
        array1.removeFirst();
        array1.removeLast();
        array1.get(3);
        array1.get(3);
        array1.removeLast();
        array1.removeFirst();
        int i = array1.removeLast();
        Assert.assertEquals(3, i);
    }
}
