package com.mygdx.game.Scenario.Scenarious.Default;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Levels.two.Level2;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class BlackScenario extends Scenario {
    private Sprite texture;
    float alpha = 0;
    int timeSetting;

    public BlackScenario(int time) {
        level = GameLayout.level;
        name = "1_black";
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
        alpha += (float) 1 / timeSetting;
    }

    public void dispose() {
        texture.getTexture().dispose();
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        GameLayout.camera.position.set(1100 / 2, 1100 * (h / w) / 2 + 50, 0);

        GameLayout.level.dispose();
        GameLayout.level = new Level2();
    }
}
