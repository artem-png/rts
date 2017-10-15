package com.mygdx.game.models.blocks;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.models.IModel;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.player.APlayer;

/**
 * Created by User on 15.10.2017.
 */

public class Cave extends ABlock {
    Sprite sprite;
    Sprite spriteMarker;
    Sprite spriteMarker2;
    public Vector2 markerPosition;
    public boolean isAvaliableToBuild = false;
    public int type;

    public Cave(int x, int y) {
        this.hp = 100;
        type = Cave.getTypeBySize(x, y);
        if (type == 1) {
            sprite = Tex.cave3x5;
            spriteMarker = Tex.marker_cave_3x5_1;
            spriteMarker2 = Tex.marker_cave_3x5_2;
        }
    }
    @Override
    public void act(SpriteBatch batch) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, position.x * 30 * Tex.x, position.y * 30 * Tex.y, sprite.getWidth(), sprite.getHeight());
    }

    public void renderMarker(SpriteBatch batch) {
        if (type == 1) {
            if (isAvaliableToBuild) {
                batch.draw(spriteMarker, (markerPosition.x - 2) * 30 * Tex.x, (markerPosition.y - 1) * 30 * Tex.y, spriteMarker.getWidth(), spriteMarker.getHeight());
            } else {
                batch.draw(spriteMarker2, (markerPosition.x - 2) * 30 * Tex.x, (markerPosition.y - 1) * 30 * Tex.y, spriteMarker.getWidth(), spriteMarker.getHeight());
            }
        }
    }

    public void setMarkerPosition(Vector2 xy) {
        this.markerPosition = xy;
    }

    public boolean getAvaliableToBuild(int[][] map) {
        if (markerPosition == null) {
            isAvaliableToBuild = false;
            return false;
        }

        if (type == 1) {
            for (int i = ((int) (markerPosition.x - 2)); i <= ((int) (markerPosition.x + 2)); i++) {
                for (int j = ((int) (markerPosition.y - 1)); j <= ((int) (markerPosition.y + 1)); j++) {
                    if (i < 0 || j < 0 || i >= BlockMap.sizeX || j >= BlockMap.sizeY){
                        isAvaliableToBuild = false;
                        return false;
                    }
                    if (j == ((int) (markerPosition.y - 1))) {
                        if (map[i][j] != 0 || j < 1 || map[i][j - 1] == 0 || map[i][j - 1] == -1) {
                            isAvaliableToBuild = false;
                            return false;
                        }
                    } else {
                        if (map[i][j] == 0 || map[i][j] == -99 || map[i][j] == -1) {
                            isAvaliableToBuild = false;
                            return false;
                        }
                    }
                }
            }
        }
        isAvaliableToBuild = true;
        return true;
    }

    public static int getTypeBySize(int x, int y)
    {
        if (x == 5 && y == 3) {
            return 1;
        }

        return 0;
    }

    @Override
    public void afterDeath(APlayer player) {

    }
}
