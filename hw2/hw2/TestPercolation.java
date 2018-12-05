package hw2;

import org.junit.Assert;
import org.junit.Test;

public class TestPercolation {
    @Test
    public void testIsOpen() {
        Percolation grid1 = new Percolation(5);
        grid1.open(3,3);
        Assert.assertFalse(grid1.isOpen(2,2));
        Assert.assertFalse(grid1.isOpen(2,0));
        Assert.assertFalse(grid1.isOpen(0,2));
        Assert.assertFalse(grid1.isOpen(2,2));
        Assert.assertTrue(grid1.isOpen(3,3));
    }
    @Test
    public void testIsFull() {
        Percolation grid2 = new Percolation(3);
        grid2.open(0,1);
        grid2.open(1,1);
        grid2.open(1,0);
        Assert.assertFalse(grid2.isFull(1,2));
        Assert.assertFalse(grid2.isFull(0,0));
        Assert.assertTrue(grid2.isFull(1,1));
    }
    @Test
    public void testPercolates() {
        Percolation grid3 = new Percolation(3);
        grid3.open(0,1);
        grid3.open(1,1);
        grid3.open(1,0);
        Assert.assertFalse(grid3.percolates());
        grid3.open(2,0);
        Assert.assertTrue(grid3.percolates());

    }

}
