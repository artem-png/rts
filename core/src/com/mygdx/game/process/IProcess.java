package com.mygdx.game.process;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by artem on 10/11/17.
 */

public interface IProcess {
    public void act(SpriteBatch batch);
    public void input();
}
