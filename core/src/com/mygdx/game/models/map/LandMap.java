package com.mygdx.game.models.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.models.map.build.BgMap;

/**
 * Created by User on 14.10.2017.
 */

public class LandMap {
    public BlockMap blockMap;
    public BgMap bgMap;

    public LandMap(BlockMap blockMap) {
        this.blockMap = blockMap;
        bgMap = new BgMap();
    }

    public void act(SpriteBatch batch) {
        Vector3 xy = GameLayout.camera.unproject(new Vector3(0, Gdx.graphics.getHeight(), 0));
        float x = xy.x - 30 * Tex.x * 3f * GameLayout.camera.zoom;
        float y = xy.y - 30 * Tex.y * 3f * GameLayout.camera.zoom;
        float w = GameLayout.camera.viewportWidth * GameLayout.camera.zoom + 30 * Tex.x * 6f * GameLayout.camera.zoom;
        float h = GameLayout.camera.viewportHeight * GameLayout.camera.zoom + 30 * Tex.y * 6f * GameLayout.camera.zoom;
        for (int i = 0; i < BlockMap.sizeX; i ++) {
            for (int j = 0; j < BlockMap.sizeY; j ++) {
                bgMap.act(batch, i, j, x, y, w, h);
            }
        }
        for (int i = 0; i < BlockMap.sizeX; i ++) {
            for (int j = 0; j < BlockMap.sizeY; j ++) {
                blockMap.act(batch, i, j, x, y, w, h);
            }
        }
    }
}
