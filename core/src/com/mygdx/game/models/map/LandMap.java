package com.mygdx.game.models.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.process.GameProcess;

import jdk.nashorn.internal.ir.Block;

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
        float x = xy.x - 60 * Tex.y ;
        float y = xy.y - 60 * Tex.y;
        float w = GameLayout.camera.viewportWidth * GameLayout.camera.zoom + Gdx.graphics.getWidth() / GameLayout.camera.zoom / 2 + 60 * Tex.x;
        float h = GameLayout.camera.viewportHeight * GameLayout.camera.zoom + Gdx.graphics.getHeight() / GameLayout.camera.zoom / 2 + 60 * Tex.x;

        x = x / (30 * Tex.x);
        y = y / (30 * Tex.y);

        w = w / (30 * Tex.x / GameLayout.camera.zoom) + x;
        if (w >= BlockMap.sizeX) {
            w = BlockMap.sizeX - 1;
        }
        h = h / (30 * Tex.x / GameLayout.camera.zoom) + y;
        if (h >= BlockMap.sizeY) {
            h = BlockMap.sizeY - 1;
        }

        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y =0;
        }

       // System.out.println(x + " " + y + " " + w + " " + h);
        for (int i = (int)x; i < (int) w; i ++) {
            for (int j = (int)y; j < (int) h; j ++) {
                bgMap.act(batch, i, j);
            }
        }
        for (int i = (int)x; i < (int) (x + w); i ++) {
            for (int j = (int)y; j < (int) h; j ++) {
                blockMap.act(batch, i, j);
            }
        }

        for (int i = (int)x; i < (int) (x + w); i ++) {
            for (int j = (int)y; j < (int) h; j ++) {
                blockMap.actCave(batch, i, j);
            }
        }
        blockMap.act1(batch);
    }
}
