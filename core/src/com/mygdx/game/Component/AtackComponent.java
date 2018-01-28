package com.mygdx.game.Component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Levels.ILevel;

/**
 * Created by User on 21.01.2018.
 */

public class AtackComponent extends AComponent {
    public Sprite defend;
    public Sprite atack;
    public ILevel level;

    public AtackComponent(ILevel level) {
        this.level = level;
        atack = new Sprite(new Texture("ui/buttons/atack.png"));
        defend = new Sprite(new Texture("ui/buttons/defend.png"));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        batch.draw(atack, 950, 80);
        batch.draw(defend, 820, 80);
        batch.setProjectionMatrix(GameLayout.camera.combined);

    }

    @Override
    public boolean input() {
        for (int i = 0; i < 2; i++) {
            if (Gdx.input.isTouched(i)) {
                Vector3 position = GameLayout.cameraDynamic.unproject(new Vector3(Gdx.input.getX(i), Gdx.input.getY(i), 0));
                if (position.x > 950 && position.x < 950 + 80 && position.y > 80 && position.y < 80 + 80) {
                    level.getPlayer().atack(true);
                    return true;
                } else if (position.x > 820 && position.x < 820 + 80 && position.y > 80 && position.y < 80 + 80) {
                    level.getPlayer().defend();
                    return true;
                }
            }
        }
        level.getPlayer().unDefend();
        return false;
    }

    public void dispose() {
        atack.getTexture().dispose();
        defend.getTexture().dispose();
    }
}
