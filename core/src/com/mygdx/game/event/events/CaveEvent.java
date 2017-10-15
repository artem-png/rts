package com.mygdx.game.event.events;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.event.eventHelpers.Distance;
import com.mygdx.game.event.eventHelpers.Movement;
import com.mygdx.game.models.blocks.Cave;
import com.mygdx.game.models.map.MapHelper;
import com.mygdx.game.models.player.APlayer;
import com.mygdx.game.process.GameProcess;

import java.util.Vector;

/**
 * Created by User on 15.10.2017.
 */

public class CaveEvent implements IEvent {
    public Cave cave;
    public Vector2 standCell;
    private boolean isFinish = false;
    private boolean isDigged = false;
    public APlayer player;
    Movement movement;

    public CaveEvent(Cave cave) {
        this.cave = cave;
        movement = new Movement();

        if (cave.type == 1) {
            setStandCell(new Vector2(cave.getPosition().x + 2, cave.getPosition().y));
        }
    }

    @Override
    public boolean isFinish() {
        return isFinish;
    }

    @Override
    public void setCells(Vector<Vector2> vector2s) {

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
    public Vector2 getCellForDistance() {
        return standCell;
    }

    @Override
    public void act(SpriteBatch batch) {
        Vector2 playerXY = player.getXYPosition();
        if (isDigged) {
            isFinish = true;
            return;
        }
        if (player.isMoving()) {
            return;
        }

        if (standCell.x == playerXY.x && standCell.y == playerXY.y) {
            movement.isReady = true;
            if (cave.type == 1) {
                GameProcess.blockMap.blocks[(int)cave.position.x][(int)cave.position.y + 1] = null;
                GameProcess.blockMap.blocks[(int)cave.position.x + 1][(int)cave.position.y + 1] = null;
                GameProcess.blockMap.blocks[(int)cave.position.x + 2][(int)cave.position.y + 1] = null;
                GameProcess.blockMap.blocks[(int)cave.position.x + 3][(int)cave.position.y + 1] = null;
                GameProcess.blockMap.blocks[(int)cave.position.x + 4][(int)cave.position.y + 1] = null;

                GameProcess.blockMap.blocks[(int)cave.position.x][(int)cave.position.y + 2] = null;
                GameProcess.blockMap.blocks[(int)cave.position.x + 1][(int)cave.position.y + 2] = null;
                GameProcess.blockMap.blocks[(int)cave.position.x + 2][(int)cave.position.y + 2] = null;
                GameProcess.blockMap.blocks[(int)cave.position.x + 3][(int)cave.position.y + 2] = null;
                GameProcess.blockMap.blocks[(int)cave.position.x + 4][(int)cave.position.y + 2] = null;
            }
            GameProcess.blockMap.blocks[(int)cave.position.x][(int)cave.position.y] = cave;
            isDigged = true;
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
