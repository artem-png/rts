package com.mygdx.game.Models.Characters.Classes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Models.Characters.CharacterActions.Punch;

/**
 * Created by User on 21.01.2018.
 */

public interface IModel {
    public void render(SpriteBatch batch);
    public void act();
    public Rectangle getRectangle();
    public Vector2 getPosition();
    public Vector2 getSpeed();
    public void atack(boolean isNear);
    public void defend();
    public void unDefend();
    public void getPunch(Punch punch);
    public void stopAtack();
    public int getStatus();
    public void setStatus(int status);
    public void dispose();
}
