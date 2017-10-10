package com.mygdx.game.models.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;

/**
 * Created by artem on 10/10/17.
 */

public class NormalPlayer extends APlayer {

    public NormalPlayer(Vector2 position) {
        texture = Tex.normalPlayer;
        hp = 100;
        this.position = position;
        speed = 1;
    }

    @Override
    public void act(SpriteBatch batch) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(this.texture, position.x, position.y, this.texture.getWidth(), this.texture.getHeight());
    }
}
