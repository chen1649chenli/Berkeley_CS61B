package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class MapVisualTest {
    private static final int STARTX = 30;
    private static final int STARTY = 6;
    private static final int MAXW = 8;
    private static final int MAXH = 8;
    private static final int MAX_OFFSET = 3;
    private static final int Room.Side ENTRY_SIDE = Room.Side.BOTTOM;
    private static final TETile ENTRY_TILE = Tileset.LOCKED_DOOR;
    private static final TETile EXIT_TILE = Tileset.UNLOCKED_DOOR;

    public static final TERenderer ter = new TERenderer();
    public sta
    MapGenerationParameters mgp = MapGenerationParameters.defaultParameters();
    ter.initialize(mgp.width,mgp.height);
    WorldState ws = MapGenerator.generate(mgp);
    ter.renderFrame(ws.terrainGrid());




}
