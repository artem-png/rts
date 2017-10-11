package com.mygdx.game.process;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.build.TunnelMap;

/**
 * Created by artem on 10/11/17.
 */

public class BuildProcess implements IProcess {
    private BlockMap blockMap;
    private TunnelMap tunnelMap;

    public BuildProcess(BlockMap map) {
        this.blockMap = map;
        tunnelMap = new TunnelMap();
    }

    @Override
    public void act(SpriteBatch batch) {
        blockMap.act(batch);
        tunnelMap.act(batch);
    }

    @Override
    public void input() {
        if (Gdx.input.justTouched()) {
            Vector3 ar = GameLayout.camera.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0));
            if (ar.x >= 0 && ar.y >= 0) {
                int x = (int) (ar.x / (30 * Tex.x));
                int y = (int) (ar.y / (30 * Tex.y));
                if (x >= 0 && y >= 0 && x < BlockMap.sizeX && y < BlockMap.sizeY) {
                    tunnelMap.add(new Vector2(x, y));
                }
            }
        }
    }
}
