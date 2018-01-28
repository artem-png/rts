package com.mygdx.game.Scenario.Scenarious.Default;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class UnBlackScenario extends Scenario {
    private Sprite texture;
    float alpha = 1;
    int timeSetting;

    public UnBlackScenario(int time) {
        level = GameLayout.level;
        name = "2_unblack";
        isParalel = true;
        isTimeLimit = true;
        timeSetting = time;
        this.time = time;
        texture = new Sprite(new Texture("level/l1/black.png"));
    }

    public void render(SpriteBatch batch) {
        Color color = batch.getColor();
        batch.setColor(color.r, color.g, color.b, alpha);
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        batch.draw(texture, 0, 0, GameLayout.cameraDynamic.viewportWidth, 1100);
        batch.setProjectionMatrix(GameLayout.camera.combined);
        batch.setColor(color.r, color.g, color.b, 1);
    }

    public void act() {
        super.act();
        alpha -= (float)1/timeSetting;
    }

    public void dispose() {
        texture.getTexture().dispose();
    }
}
