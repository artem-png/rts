package com.mygdx.game.models.blocks;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.models.player.APlayer;

/**
 * Created by artem on 10/9/17.
 */

public abstract class ABlock implements IBlock {
    public Sprite texture;
    public Vector2 position;
    public float hp;
    public boolean hasPass = false;

    public Sprite getTexture() {
        return texture;
    }

    public void setTexture(Sprite texture) {
        this.texture = texture;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getHp() {
        return hp;
    }

    public void addHp(APlayer player) {
        if (player.canAtack()) {
            this.hp -= player.damage;
        }
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public boolean hasPass() {
        return hasPass;
    }
}
