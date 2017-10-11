package com.mygdx.game.models.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;

/**
 * Created by artem on 10/10/17.
 */

public class NormalPlayer extends APlayer {

    public NormalPlayer(Vector2 position, Vector2 actualPosition) {
        texture = Tex.normalPlayer;
        hp = 100;
        this.position = position;
        this.actualPosition = actualPosition;
        this.speedConst = 2f;
        this.speedVector = new Vector2(0, 0);
        damage = 2;
    }

    @Override
    public void act(SpriteBatch batch) {
        moving();
        if (currentAtackDelay >= 0) {
            currentAtackDelay--;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(this.texture, position.x, position.y, this.texture.getWidth(), this.texture.getHeight());
    }
}
