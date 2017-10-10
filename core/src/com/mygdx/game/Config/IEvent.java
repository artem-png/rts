package com.mygdx.game.Config;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.models.player.APlayer;

import java.util.Vector;

/**
 * Created by artem on 10/10/17.
 */

public interface IEvent {
    public boolean isFinish();
    public void setCells(Vector<Vector2> vector2s);
    public void setCell(Vector2 vector2);
    public void setPlayer(APlayer player);
    public void act();
}
