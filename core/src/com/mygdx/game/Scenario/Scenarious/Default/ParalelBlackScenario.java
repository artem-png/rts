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

public class ParalelBlackScenario extends Scenario {
    private Sprite texture;
    float alpha = 0;

    public ParalelBlackScenario(float alpha, String disposeOn) {
        level = GameLayout.level;
        name = "2_black";
        isParalel = true;
        isTimeLimit = false;
        this.alpha = alpha;
        this.disposeOnName = disposeOn;
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
    }

    public void dispose() {
        texture.getTexture().dispose();
    }
}
