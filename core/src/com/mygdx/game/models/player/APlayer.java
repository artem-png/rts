package com.mygdx.game.models.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.IEvent;
import com.mygdx.game.Config.Tex;

/**
 * Created by artem on 10/9/17.
 */

public abstract class APlayer implements IPlayer {
    public Sprite texture;
    public int hp;
    public Vector2 position;
    public float speed;
    public IEvent event;
    public int damage;

    public IEvent getEvent() {
        return event;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
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
        return new Vector2(position.x / 30 * Tex.x, position.y / 30 * Tex.y);
    }
}
