package com.mygdx.game.models.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.models.blocks.ABlock;
import com.mygdx.game.models.blocks.GroundBlock;

/**
 * Created by artem on 10/9/17.
 */

public class Map {
    private ABlock[][] blocks;
    public static int sizeX = 100;
    public static int sizeY = 200;

    public Map() {
        blocks = new ABlock[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                GroundBlock groundBlock = new GroundBlock();
                groundBlock.setHp(3);
                groundBlock.setPosition(new Vector2(i * Tex.groundBlock.getWidth(), j * Tex.groundBlock.getHeight()));
                blocks[i][j] = groundBlock;
            }
        }
        blocks[10][10] = null;
        blocks[50][50] = null;
        blocks[25][120] = null;
        blocks[7][70] = null;
    }

    public void act(SpriteBatch batch) {
        float x = (GameLayout.camera.position.x - (800) * GameLayout.camera.zoom) - Tex.groundBlock.getWidth() * 3f;
        float y = (GameLayout.camera.position.y - (450) * GameLayout.camera.zoom) - Tex.groundBlock.getHeight() * 3f;
        float w = GameLayout.camera.viewportWidth * GameLayout.camera.zoom + Tex.groundBlock.getWidth() * 6f;
        float h = GameLayout.camera.viewportHeight * GameLayout.camera.zoom + Tex.groundBlock.getHeight() * 6f;

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (blocks[i][j] == null) {
                    continue;
                }
                Vector2 position = blocks[i][j].getPosition();
                if (position.x > x && position.x < x + w && position.y > y && position.y < y + h) {
                    blocks[i][j].render(batch);
                }
                blocks[i][j].act(batch);
            }
        }
    }
}
