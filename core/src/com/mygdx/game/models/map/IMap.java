package com.mygdx.game.models.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by artem on 10/10/17.
 */

public interface IMap {
    public void act(SpriteBatch batch);
    public void add(Object object);
    public void dispose();
}
