package byog.lab5;
import javafx.geometry.Pos;
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
    private static final Random RANDOM = new Random();

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

    /**
     * Generates random tile.
     * @return
     */
    private static TETile randomTitle() {
        int tileNum = RANDOM.nextInt(5);
        switch(tileNum) {
            case 0: return Tileset.FLOWER;
            case 1: return Tileset.GRASS;
            case 2: return Tileset.SAND;
            case 3: return Tileset.TREE;
            case 4: return Tileset.MOUNTAIN;
            default: return Tileset.FLOWER;
        }
    }

    /**
     * Generates the width and height of the world.
     * @param s The size of the hex, which is the 1st parameter of main() function
     * @return
     */
    private static int[] worldSize(int s) {
        int worldXAxis = 2 + 2 * s + 3 * (3 * s - 2) ;
        int worldYAxis = 2 * s * 5;
        int[] dim = new int[2];
        dim[0] = worldXAxis;
        dim[1] = worldYAxis;
        return dim;
    }

    /**
     * Generates the coordinates of the 19 hexagons in the world.
     * @param s The size of the hex, which is the 1st parameter of main() function
     * @return
     */
    private static Position[] hexP(int s) {
        Position[] p = new Position[19];
        /** hexagon in first column */
        p[0] = new Position(s,2 * s);
        p[1] = new Position(s,4 * s);
        p[2] = new Position(s,6 * s);
        /** hexagon in second column */
        p[3] = new Position(3 * s - 1,1 * s);
        p[4] = new Position(3 * s - 1,3 * s);
        p[5] = new Position(3 * s - 1,5 * s);
        p[6] = new Position(3 * s - 1,7 * s);
        /** hexagon in third column */
        p[7] = new Position(5 * s - 2,0);
        p[8] = new Position(5 * s - 2,2 * s);
        p[9] = new Position(5 * s - 2,4 * s);
        p[10] = new Position(5 * s - 2,6 * s);
        p[11] = new Position(5 * s - 2,8 * s);
        /** hexagon in fourth column */
        p[12] = new Position(7 * s - 3,1 * s);
        p[13] = new Position(7 * s - 3,3 * s);
        p[14] = new Position(7 * s - 3,5 * s);
        p[15] = new Position(7 * s - 3,7 * s);
        /** hexagon in the fifth column */
        p[16] = new Position(9 * s - 4,2 * s);
        p[17] = new Position(9 * s - 4,4 * s);
        p[18] = new Position(9 * s - 4,6 * s);
        return p;
    }

    public static void main(String[] args) {
        /** Creates the world. */
        int s = Integer.parseInt(args[0]);
        int[] size = worldSize(s);
        int width = size[0];
        int height = size[1];
        TERenderer render = new TERenderer();
        render.initialize(width, height);

        // initialize tiles
        TETile[][] world = new TETile[width][height];
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        /** Generates the position of the 19 hexagons.*/
        Position[] p = hexP(s);

        /** Adds the hexagons */
        for (int i =  0; i < 19; i++) {
            TETile t = randomTitle();
            addHexagon(world,p[i], s, t);
        }

        render.renderFrame(world);
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
