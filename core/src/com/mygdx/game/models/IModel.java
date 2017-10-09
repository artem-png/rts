package com.mygdx.game.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by artem on 10/9/17.
 */

public interface IModel {
    public void act(SpriteBatch batch);
    public void render(SpriteBatch batch);
}
