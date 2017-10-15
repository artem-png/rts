package com.mygdx.game.models.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.models.blocks.ABlock;
import com.mygdx.game.models.blocks.Cave;
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
        avaliableMap = new int[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (j == 10) continue;
                GroundBlock groundBlock = new GroundBlock();
                groundBlock.setHp(3);
                groundBlock.setPosition(new Vector2(i * 30 * Tex.x, j * 30 * Tex.y));
                blocks[i][j] = groundBlock;
                avaliableMap[i][j] = -5;
            }
        }
        generateAvaliableMap();

        deltaX = (Gdx.graphics.getWidth() / (2f / (float) Math.sqrt((double) Tex.x)));
        deltaY = (Gdx.graphics.getHeight() / (2f / (float) Math.sqrt((double) Tex.y)));
    }

    public void act(SpriteBatch batch, int i, int j, float x, float y, float w, float h) {
        if (blocks[i][j] == null) {

        } else if (blocks[i][j].getHp() < 0) {
            blocks[i][j] = null;
            generateAvaliableMap();
        } else {
            Vector2 position = blocks[i][j].getPosition();
            if (blocks[i][j] instanceof Cave) {

            } else {
                if (position.x > x && position.x < x + w && position.y > y && position.y < y + h) {
                    blocks[i][j].render(batch);
                }
                blocks[i][j].act(batch);
            }
        }
    }

    public void actCave(SpriteBatch batch, int i, int j, float x, float y, float w, float h) {
        if (blocks[i][j] == null) {

        } else if (blocks[i][j].getHp() < 0) {
            blocks[i][j] = null;
            generateAvaliableMap();
        } else {
            Vector2 position = blocks[i][j].getPosition();
            if (blocks[i][j] instanceof Cave) {
                float xc = x - 30 * 12 * Tex.x;
                float yc = y - 30 * 12 * Tex.y;
                float hc = h + 30 * 12 * Tex.x;
                float wc = w + 30 * 12 * Tex.y;
                if (position.x * 30 * Tex.x > xc && position.x * 30 * Tex.x < xc + wc && position.y * 30 * Tex.y > yc && position.y * 30 * Tex.y < yc + hc) {
                    blocks[i][j].render(batch);
                }
                blocks[i][j].act(batch);

            } else {
            }
        }
    }

    @Override
    public void act(SpriteBatch batch) {

    }

    @Override
    public boolean add(Object object) {
        return true;
    }

    @Override
    public void dispose() {

    }

    public ABlock getBlock(int x, int y) {
        if (this.blocks[x][y] == null) {
            return new GroundBlock();
        }
        return this.blocks[x][y];
    }

    public void generateAvaliableMap() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (this.blocks[i][j] == null) {
                    avaliableMap[i][j] = 0;
                } else {
                    avaliableMap[i][j] = -5;
                }
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (this.blocks[i][j] instanceof Cave) {
                    Cave cave = (Cave) this.blocks[i][j];
                    if (cave.type == 1) {
                        avaliableMap[i][j] = 0;
                        avaliableMap[i + 1][j] = 0;
                        avaliableMap[i + 2][j] = 0;
                        avaliableMap[i + 3][j] = 0;
                        avaliableMap[i + 4][j] = 0;

                        avaliableMap[i][j + 1] = -99;
                        avaliableMap[i + 1][j + 1] = -99;
                        avaliableMap[i + 2][j + 1] = -99;
                        avaliableMap[i + 3][j + 1] = -99;
                        avaliableMap[i + 4][j + 1] = -99;

                        avaliableMap[i][j + 2] = -99;
                        avaliableMap[i + 1][j + 2] = -99;
                        avaliableMap[i + 2][j + 2] = -99;
                        avaliableMap[i + 3][j + 2] = -99;
                        avaliableMap[i + 4][j + 2] = -99;

                        avaliableMap[i][j - 1] = -99;
                        avaliableMap[i + 1][j - 1] = -99;
                        avaliableMap[i + 2][j - 1] = -99;
                        avaliableMap[i + 3][j - 1] = -99;
                        avaliableMap[i + 4][j - 1] = -99;
                    }
                }
            }
        }
    }

    public int[][] getAvaliableMap() {
        return avaliableMap;
    }
}
