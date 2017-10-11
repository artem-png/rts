package com.mygdx.game.event.events;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.event.eventHelpers.Movement;
import com.mygdx.game.models.map.MapHelper;
import com.mygdx.game.models.player.APlayer;
import com.mygdx.game.process.GameProcess;

import java.util.Vector;

/**
 * Created by artem on 10/10/17.
 */

public class TonnelEvent implements IEvent {
    public Vector<Vector2> cells;
    public Vector2 standCell;
    private boolean isFinish = false;
    public APlayer player;
    Movement movement;

    public TonnelEvent() {
        cells = new Vector<Vector2>();
        movement = new Movement();
    }

    @Override
    public boolean isFinish() {
        return isFinish;
    }

    @Override
    public void setCells(Vector<Vector2> vector2s) {
        cells = vector2s;
    }

    @Override
    public void setStandCell(Vector2 vector2) {
        standCell = vector2;
        movement.isReady = false;
        movement.setStandPosition(vector2);
    }

    @Override
    public void setPlayer(APlayer player) {
        this.player = player;
        player.setEvent(this);
        movement.setPlayer(player);
    }

    @Override
    public APlayer getPlayer() {
        return player;
    }

    @Override
    public void act(SpriteBatch batch) {
        Vector2 playerXY = player.getXYPosition();

        int[][] map = MapHelper.getAvaliableMapToWalk();

        if (cells.size() == 0) {
            isFinish = true;
            return;
        }
        if (player.isMoving()) {
            return;
        }
        if (standCell.x == playerXY.x && standCell.y == playerXY.y) {
            movement.isReady = true;
            if (map[(int) cells.get(0).x][(int) cells.get(0).y] == 0) {
                if (cells.size() > 1) {
                    setStandCell(cells.get(0));
                }
                cells.remove(0);
            } else {
                GameProcess.blockMap.blocks[(int) cells.get(0).x][(int) cells.get(0).y].addHp(player);
            }
        } else {
            if (!player.isMoving) {
                movement.isReady = false;
            }
            movement.act();
        }
    }

    @Override
    public boolean isAbleToWalk() {
        return true;
    }

    @Override
    public void dispose() {
        player.removeEvent();
    }
}
