package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    /**
     * Adds a hexagon to the world.
     * @param world the world to draw on
     * @param p the bottom left coordinate of the hexagon
     * @param s the size of the hexagon
     * @param t the tile to draw
     */
    public static void addHexagon(TETile world[][], Position p, int s, TETile t) {

        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }
        /** hexagon has 2*s rows. this code iterates up
         * from the bottom row, which we call row 0*/
        for (int i = 0; i < 2 * s; i++) {
            int yPos = i + p.y;

            int xPos = hexRowOffSet(s, i) + p.x;

            Position rowStartP = new Position(xPos, yPos);

            int rowWidth = hexRowWidth(s, i);

            addRow(world, rowStartP, rowWidth, t);
        }

    }

    /**
     * Adds a row of the same tile
     * @param world the world to draw on
     * @param p the leftmost position of the row
     * @param width the number of tiles wide to draw
     * @param t the tile to draw
     */
    public static void addRow(TETile[][] world, Position p, int width, TETile t) {
        for (int i = 0; i < width; i++) {
            int xCoord = p.x + i;
            int yCoord = p.y;
            world[xCoord][yCoord] = t;
        }
    }

    /**
     * Computes the width of row i for a size s hexagon.
     * @param width The size of the hex
     * @param ithRow The row number where i = 0 is the bottom row.
     * @return
     */
    public static int hexRowWidth(int width, int ithRow) {
        if (ithRow <= width - 1) {
            return width + 2 * ithRow;
        } else {
            return width + 2 * (2 * width - ithRow - 1) ;
        }
    }

    /**
     * Computes the relative offset of ith row start x-axis position
     * to the lower left point of hexagon.
     * @param width The size of the hex
     * @param ithRow The row number where i = 0 is the bottom row.
     * @return
     */
    public static int hexRowOffSet(int width, int ithRow) {
        if (ithRow <= width - 1) {
            return -1 * ithRow;
        } else {
          return ithRow + 1 - 2 * width;
        }
    }

    @Test
    public void testHexRowWidth() {
        assertEquals(2, hexRowWidth(2,0));
        assertEquals(4, hexRowWidth(2,1));
        assertEquals(4, hexRowWidth(2,2));
        assertEquals(2, hexRowWidth(2,3));
        assertEquals(3, hexRowWidth(3,0));
        assertEquals(5, hexRowWidth(3,1));
        assertEquals(7, hexRowWidth(3,2));
        assertEquals(7, hexRowWidth(3,3));
        assertEquals(5, hexRowWidth(3,4));
        assertEquals(3, hexRowWidth(3,5));
    }

    @Test
    public void testHexRowOffSet() {
        assertEquals(0, hexRowOffSet(2, 0));
        assertEquals(-1, hexRowOffSet(2, 1));
        assertEquals(-1,  hexRowOffSet(2, 2));
        assertEquals(0, hexRowOffSet(2, 3));
        assertEquals(0, hexRowOffSet(3, 0));
        assertEquals(-1, hexRowOffSet(3, 1));
        assertEquals(-2, hexRowOffSet(3, 2));
        assertEquals(-2, hexRowOffSet(3, 3));
        assertEquals(-1, hexRowOffSet(3, 4));
        assertEquals(0, hexRowOffSet(3, 5));


    }
}
