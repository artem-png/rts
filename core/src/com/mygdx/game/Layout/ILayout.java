package com.mygdx.game.Layout;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by artem on 10/6/17.
 */

public interface ILayout {
    public void render(SpriteBatch batch);
    public void input();
    public void dispose();
}
