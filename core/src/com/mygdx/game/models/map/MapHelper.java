package com.mygdx.game.models.map;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.event.events.IEvent;
import com.mygdx.game.event.events.TonnelEvent;
import com.mygdx.game.process.GameProcess;

import java.util.Vector;

/**
 * Created by artem on 10/11/17.
 */

public class MapHelper {
    public static int[][] getAvaliableMapToWalk() {
        int[][] map = GameProcess.blockMap.getAvaliableMap();
        return map;
    }

    public static int[][] getAvaliableMapToTunnel() {
        int[][] map = GameProcess.blockMap.getAvaliableMap();
        return map;
    }

    public static int[][] getAlreadyBuldingCells() {
        int[][] map = new int[BlockMap.sizeX][BlockMap.sizeY];
        Vector<IEvent> all = GameProcess.eventController.getAllEvents();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i) instanceof TonnelEvent) {
                Vector<Vector2> cells = ((TonnelEvent) all.get(i)).cells;
                for (int j = 0; j < cells.size(); j++) {
                    map[(int) cells.get(j).x][(int) cells.get(j).y] = 5;
                }
            }
        }
        return map;
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < BlockMap.sizeX; i++) {
            for (int j = BlockMap.sizeY - 1; j > 0; j--) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();

        }
    }
}
