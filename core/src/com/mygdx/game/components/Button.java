package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;

/**
 * Created by artem on 10/11/17.
 */

public class Button {
    private Sprite sprite;
    private Vector2 position;
    private int delay = 0;
    public boolean isActivated;

    public Button(Sprite sprite, Vector2 position) {
        this.sprite = sprite;
        this.position = position;
        isActivated = false;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void act(SpriteBatch batch) {
        batch.draw(this.sprite, position.x, position.y, this.sprite.getWidth(), this.sprite.getHeight());
    }

    public boolean input() {
        if (delay > 0) {
            delay--;
            return false;
        }
        if (!Gdx.input.justTouched()) {
            return false;
        }
        float x = Gdx.input.getX();
        float y = Gdx.graphics.getHeight() - Gdx.input.getY();

        if (x > position.x && x < position.x + this.sprite.getWidth() && y > position.y && y < position.y + this.sprite.getHeight()) {
            isActivated = true;
            return true;
        }
        return false;
    }
}
