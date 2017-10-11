package com.mygdx.game.models.map;

import com.mygdx.game.process.GameProcess;

/**
 * Created by artem on 10/11/17.
 */

public class MapHelper {
    public static int[][] getAvaliableMapToWalk() {
        int[][] map = GameProcess.blockMap.getAvaliableMap();
        return  map;
    }

    public static int[][] getAvaliableMapToTunnel() {
        int[][] map = GameProcess.blockMap.getAvaliableMap();
        return  map;
    }

    public static void printMap(int [][] map) {
        for (int i = 0; i<BlockMap.sizeX; i++) {
            for (int j = 0; j < BlockMap.sizeY; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
    }
}
