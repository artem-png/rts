package com.mygdx.game.models.map.build;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.IMap;
import com.mygdx.game.models.map.MapHelper;

/**
 * Created by artem on 10/11/17.
 */

public class TunnelMap implements IMap {
    int[][] sectors;
    int[][] choosenSectors;
    public TunnelMap() {
        sectors = new int[BlockMap.sizeX][BlockMap.sizeY];
        choosenSectors = new int[BlockMap.sizeX][BlockMap.sizeY];
        init();
    }


    @Override
    public void act(SpriteBatch batch) {
        for (int i = 0; i < BlockMap.sizeX; i ++) {
            for (int j = 0; j < BlockMap.sizeY; j ++) {
                if (sectors[i][j] == 5) {
                    batch.draw(
                            Tex.marker_tonnel_1,
                            i * 30 * Tex.x,
                            j * 30 * Tex.y,
                            Tex.marker_tonnel_1.getWidth(),
                            Tex.marker_tonnel_1.getHeight()
                    );
                }
                if (choosenSectors[i][j] == 5) {
                    batch.draw(
                            Tex.marker_tonnel_1,
                            i * 30 * Tex.x,
                            j * 30 * Tex.y,
                            Tex.marker_tonnel_1.getWidth(),
                            Tex.marker_tonnel_1.getHeight()
                    );
                }
            }
        }
    }

    public void init() {

        int[][] avaliableMap = MapHelper.getAvaliableMapToTunnel();
        for (int i = 1; i<BlockMap.sizeX - 1; i++) {
            for (int j = 1; j< BlockMap.sizeY - 1 ; j ++) {
                if (avaliableMap[i][j] == 0) {
                    if (avaliableMap[i - 1][j] == -5) {
                        sectors[i - 1][j] = 5;
                    }
                }
                if (avaliableMap[i][j] == 0) {
                    if (avaliableMap[i + 1][j] == -5) {
                        sectors[i + 1][j] = 5;
                    }
                }
                if (avaliableMap[i][j] == 0) {
                    if (avaliableMap[i][j - 1] == -5) {
                        sectors[i][j - 1] = 5;
                    }
                }
                if (avaliableMap[i][j] == 0) {
                    if (avaliableMap[i][j + 1] == -5) {
                        sectors[i][j + 1] = 5;
                    }
                }
            }
        }
    }

    @Override
    public void add(Object object) {
        Vector2 vector2 = (Vector2) object;
        if (sectors[(int)vector2.x][(int)vector2.y] == 5) {
            choosenSectors[(int) vector2.x][(int) vector2.y] = 5;
            sectors = new int[BlockMap.sizeX][BlockMap.sizeY];
        } else if ( choosenSectors[(int) vector2.x][(int) vector2.y] == 5) {
            remove(vector2);
        }
    }

    public void remove(Object object) {
        Vector2 vector2 = (Vector2) object;
        if ( choosenSectors[(int) vector2.x][(int) vector2.y] == 5) {
            choosenSectors[(int)vector2.x][(int)vector2.y] = 0;
            sectors = new int[BlockMap.sizeX][BlockMap.sizeY];
        }
    }

    @Override
    public void dispose() {

    }
}
