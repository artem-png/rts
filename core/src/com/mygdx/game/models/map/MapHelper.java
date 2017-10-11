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
}
