package com.mygdx.game.Component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by User on 21.01.2018.
 */

public interface IComponent {
    public void render(SpriteBatch batch);
    public boolean input();
    public void dispose();
}
