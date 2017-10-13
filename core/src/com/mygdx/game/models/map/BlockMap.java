package com.mygdx.game.models.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.models.blocks.ABlock;
import com.mygdx.game.models.blocks.GroundBlock;

/**
 * Created by artem on 10/9/17.
 */

public class BlockMap implements IMap {
    public ABlock[][] blocks;
    public static int sizeX = 200;
    public static int sizeY = 200;

    float deltaX;
    float deltaY;

    public int[][] avaliableMap;

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
        blocks[9][10] = null;
        blocks[8][10] = null;
        blocks[7][10] = null;
        blocks[10][9] = null;
        blocks[10][8] = null;
        blocks[10][7] = null;
        blocks[10][6] = null;
        blocks[10][5] = null;
        blocks[10][4] = null;
        blocks[10][3] = null;
        blocks[8][9] = null;
        blocks[8][8] = null;
        blocks[8][7] = null;
        blocks[8][6] = null;
        blocks[8][5] = null;
        blocks[8][4] = null;
        blocks[8][3] = null;
        avaliableMap = generateAvaliableMap();

        deltaX = (Gdx.graphics.getWidth() / (2f / (float) Math.sqrt((double) Tex.x)));
        deltaY = (Gdx.graphics.getHeight() / (2f / (float) Math.sqrt((double) Tex.y)));
    }

    public void act(SpriteBatch batch) {
        Vector3 xy = GameLayout.camera.unproject(new Vector3(0, Gdx.graphics.getHeight(), 0));
        float x = xy.x - Tex.groundBlock.getWidth() * 3f * GameLayout.camera.zoom;
        float y = xy.y - Tex.groundBlock.getHeight() * 3f * GameLayout.camera.zoom;
        float w = GameLayout.camera.viewportWidth * GameLayout.camera.zoom + Tex.groundBlock.getWidth() * 6f * GameLayout.camera.zoom;
        float h = GameLayout.camera.viewportHeight * GameLayout.camera.zoom + Tex.groundBlock.getHeight() * 6f * GameLayout.camera.zoom;

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (blocks[i][j] == null) {

                } else if (blocks[i][j].getHp() < 0) {
                    blocks[i][j] = null;

                } else {
                    Vector2 position = blocks[i][j].getPosition();
                    if (position.x > x && position.x < x + w && position.y > y && position.y < y + h) {
                        blocks[i][j].render(batch);
                    }
                    blocks[i][j].act(batch);
                }
            }
        }
    }

    @Override
    public void add(Object object) {

    }

    @Override
    public void dispose() {

    }

    public ABlock getBlock(int x, int y) {
        return this.blocks[x][y];
    }

    public int[][] generateAvaliableMap() {
        int[][] array = new int[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (this.blocks[i][j] == null) {
                    array[i][j] = 0;
                } else if (this.blocks[i][j].hasPass) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = -5;
                }
            }
        }

        return array;
    }

    public int[][] getAvaliableMap() {
        return generateAvaliableMap();
    }
}
