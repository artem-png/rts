package com.mygdx.game.Scenario.Scenarious.Level2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class ChestScenario extends Scenario {
    public float speed = 12f;
    Vector2 position = new Vector2(1150, 800);
    int timeoutToPress = 120;

    public Sprite chest = new Sprite(new Texture("level/l2/chest.png"));

    public ChestScenario() {
        isParalel = true;
        isTimeLimit = false;
        isBeforeRenderPlayer = true;
    }

    public void render(SpriteBatch batch) {
        batch.draw(chest, position.x, position.y, 80, 70);
    }

    public void act() {
        super.act();
        position.y -= speed;
        if (position.y < 188) {
            position.y = 188;
        }
    }

    public void dispose()
    {
        this.chest.getTexture().dispose();
    }
}

