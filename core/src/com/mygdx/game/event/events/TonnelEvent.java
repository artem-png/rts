package com.mygdx.game.event.events;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.IEvent;
import com.mygdx.game.models.player.APlayer;

import java.util.Vector;

/**
 * Created by artem on 10/10/17.
 */

public class TonnelEvent implements IEvent {
    public Vector<Vector2> cells;
    private boolean isFinish = false;
    public APlayer player;

    public TonnelEvent() {
        cells = new Vector<Vector2>();
    }

    @Override
    public boolean isFinish() {
        return false;
    }

    @Override
    public void setCells(Vector<Vector2> vector2s) {
        cells = vector2s;
    }

    @Override
    public void setCell(Vector2 vector2) {
        cells.add(vector2);
    }

    @Override
    public void setPlayer(APlayer player) {
        this.player = player;
    }

    @Override
    public void act() {
        if (cells.size() == 0) {
            isFinish = true;
            return;
        }

    }
}
