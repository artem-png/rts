package com.mygdx.game.Component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Levels.ILevel;

/**
 * Created by User on 21.01.2018.
 */

public class MoveComponent extends AComponent {
    public Sprite leftArror;
    public Sprite rightArror;
    public Sprite upArror;
    public ILevel level;
    public int mapWidth;
    public float x1offset = 0;
    public float x2offset = 0;

    public MoveComponent(ILevel level, int mapWidth) {
        this.level = level;
        this.mapWidth = mapWidth;
        leftArror = new Sprite(new Texture("ui/buttons/lineLight22.png"));
        rightArror = new Sprite(new Texture("ui/buttons/lineLight23.png"));
        upArror = new Sprite(new Texture("ui/buttons/lineLight24.png"));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        batch.draw(leftArror, 40, 80, leftArror.getWidth(), leftArror.getHeight());
        batch.draw(rightArror, 190, 80);
        //batch.draw(upArror, 115, 160);
        batch.setProjectionMatrix(GameLayout.camera.combined);

    }

    public void setOffsets(float x1, float x2) {
        x1offset = x1;
        x2offset = x2;
    }

    @Override
    public boolean input() {
        for (int i = 0; i < 2; i ++) {
            if (Gdx.input.isTouched(i)) {
                Vector3 position = GameLayout.cameraDynamic.unproject(new Vector3(Gdx.input.getX(i), Gdx.input.getY(i), 0));
                int a = 0;
                if (position.x > 40 && position.x < 40 + 80 && position.y > 80 && position.y < 80 + 80) {
                    level.getPlayer().moveLeft();
                    a = 1;
                } else if (position.x > 190 && position.x < 190 + 80 && position.y > 80 && position.y < 80 + 80) {
                    level.getPlayer().moveRight();
                    a = 2;
                }

                if (a > 0) {
                    GameLayout.camera.position.x = level.getPlayer().position.x + 50;

                    this.cameraCheck();
                    this.playerCheck();
                    return true;
                }
            }
        }
        level.getPlayer().stopMoving();

        return false;
    }

    public void playerCheck() {
        if (level.getPlayer().position.x < x1offset) {
            level.getPlayer().position.x = x1offset;
        }
        float l = (level.getPlayer().position.x) / Tex.blockWidth;
        if (l >= this.mapWidth - 0.5f - x2offset / Tex.blockWidth) {
            level.getPlayer().position.x = (this.mapWidth - 0.5f) * Tex.blockWidth - x2offset;
        }
    }

    public void cameraCheck() {
        if (GameLayout.camera.position.x < Tex.cameraX / 2) {
            GameLayout.camera.position.x = Tex.cameraX / 2;
        }
        float b = Tex.cameraX / Tex.blockWidth;
        float l = (GameLayout.camera.position.x - Tex.cameraX / 2) / Tex.blockWidth;
        if (b + l >= this.mapWidth - 0.5f) {
            GameLayout.camera.position.x = Tex.cameraX / 2 + (this.mapWidth - 0.5f - b) * Tex.blockWidth;
        }
        GameLayout.camera.position.x = (int) GameLayout.camera.position.x;
    }

    public void dispose() {
        leftArror.getTexture().dispose();
        rightArror.getTexture().dispose();
        upArror.getTexture().dispose();
    }
}
