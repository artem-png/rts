package com.mygdx.game.models.blocks;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.models.player.APlayer;

/**
 * Created by artem on 10/9/17.
 */

public class GroundBlock extends ABlock {

    public GroundBlock() {
        texture = Tex.groundBlock;
    }
    @Override
    public void act(SpriteBatch batch) {
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void afterDeath(APlayer player) {

    }
}
