package com.mygdx.game.models.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.event.events.IEvent;
import com.mygdx.game.Config.Tex;

/**
 * Created by artem on 10/9/17.
 */

public abstract class APlayer implements IPlayer {
    public Sprite texture;
    public int hp;
    public Vector2 position;
    public Vector2 actualPosition;
    public float speedConst;
    public Vector2 speedVector;
    public IEvent event;
    public int damage;
    public int atackDelay = 60;
    public int currentAtackDelay = atackDelay;
    public boolean isMoving = false;
    public float movingDistantion = 0;

    public boolean canAtack() {
        if (currentAtackDelay <= 0) {
            currentAtackDelay = atackDelay;
            return true;
        }
        return false;
    }

    public void setCurrentAtackDelay(int currentAtackDelay) {
        this.currentAtackDelay = currentAtackDelay;
    }

    public IEvent getEvent() {
        return event;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Sprite getTexture() {
        return texture;
    }

    public void setTexture(Sprite texture) {
        this.texture = texture;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setEvent(IEvent event) {
        this.event = event;
    }

    public void removeEvent() {
        this.event = null;
    }

    public boolean isBusy() {
        return this.event != null;
    }

    public Vector2 getXYPosition() {
        return actualPosition;
    }

    public float getSpeedConst() {
        return speedConst;
    }

    public void setSpeedConst(float speedConst) {
        this.speedConst = speedConst;
    }

    public Vector2 getSpeedVector() {
        return speedVector;
    }

    public void setSpeedVector(Vector2 speedVector) {
        this.speedVector = speedVector;
    }

    public void moving() {
        if (isMoving && (this.getEvent() == null || this.getEvent().isAbleToWalk())) {
            position.add(speedVector);
            if (speedVector.x > 0) {
                movingDistantion -= speedVector.x;
            } else {
                movingDistantion += speedVector.x;
            }
            if (speedVector.y > 0) {
                movingDistantion -= speedVector.y;
            } else {
                movingDistantion += speedVector.y;
            }
            if (movingDistantion <= 0) {
                if (speedVector.x > 0) {
                    actualPosition.add(1, 0);
                } else if (speedVector.x < 0) {
                    actualPosition.add(-1, 0);
                }

                if (speedVector.y > 0) {
                    actualPosition.add(0, 1);
                } else if (speedVector.y < 0) {
                    actualPosition.add(0, -1);
                }
                position.x = actualPosition.x * 30 * Tex.x;
                position.y = actualPosition.y * 30 * Tex.y;
                movingDistantion = 0;
                setMoving(false);
                speedVector.set(0, 0);
            }
        }
    }

    public void goTop() {
        if (!isMoving()) {
            movingDistantion = Tex.groundBlock.getHeight();
            speedVector.add(0, 1f * getSpeedConst() * Tex.y);
            setMoving(true);
        }
    }

    public void goDown() {
        if (!isMoving()) {
            movingDistantion = Tex.groundBlock.getHeight();
            speedVector.add(0, -1f * getSpeedConst() * Tex.y);
            setMoving(true);
        }
    }

    public void goLeft() {
        if (!isMoving()) {
            movingDistantion = Tex.groundBlock.getWidth();
            speedVector.add(-1 * getSpeedConst() * Tex.x, 0);
            setMoving(true);
        }
    }

    public void goRight() {
        if (!isMoving()) {
            movingDistantion = Tex.groundBlock.getWidth();
            speedVector.add(1 * getSpeedConst() * Tex.x, 0);
            setMoving(true);
        }
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }
}
