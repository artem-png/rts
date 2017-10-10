package com.mygdx.game.models.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.models.blocks.ABlock;
import com.mygdx.game.models.blocks.GroundBlock;

/**
 * Created by artem on 10/9/17.
 */

public class BlockMap implements IMap {
    private ABlock[][] blocks;
    public static int sizeX = 30;
    public static int sizeY = 30;

    public BlockMap() {
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
        blocks[11][10] = null;
        blocks[12][10] = null;
        blocks[13][10] = null;
    }

    public void act(SpriteBatch batch) {
        float x = (GameLayout.camera.position.x - (Gdx.graphics.getWidth() / (1.3f / (float) Math.sqrt((double) Tex.x))) * GameLayout.camera.zoom) - Tex.groundBlock.getWidth();
        float y = (GameLayout.camera.position.y - (Gdx.graphics.getHeight() / (1.3f / (float) Math.sqrt((double) Tex.y))) * GameLayout.camera.zoom) - Tex.groundBlock.getHeight();
        float w = GameLayout.camera.viewportWidth * GameLayout.camera.zoom + Tex.groundBlock.getWidth() * 8f;
        float h = GameLayout.camera.viewportHeight * GameLayout.camera.zoom + Tex.groundBlock.getHeight() * 8f;

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

    @Override
    public void add(Object object) {

    }

    public ABlock getBlock(int x, int y) {
        return this.blocks[x][y];
    }

    public int[][] getAvaliableMap() {
        int[][] array = new int[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (this.blocks[sizeX][sizeY] == null) {
                    array[sizeX][sizeY] = 0;
                } else if (this.blocks[sizeX][sizeY].hasPass) {
                    array[sizeX][sizeY] = 0;
                } else {
                    array[sizeX][sizeY] = 1;
                }
            }
        }

        return array;
    }
}
