package com.mygdx.game.Models.Characters.ScreenAnimation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by User on 26.01.2018.
 */

public interface IScreenAnimation {
    public void render(SpriteBatch batch);
    public void act();
    public void dispose();
    public boolean isAlive();
}
