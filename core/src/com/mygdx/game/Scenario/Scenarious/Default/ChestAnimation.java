package com.mygdx.game.Scenario.Scenarious.Default;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Models.Characters.CharacterAnimation.Animation;
import com.mygdx.game.Models.Logic.Monuments;
import com.mygdx.game.Scenario.Scenarious.Scenario;

import java.util.Vector;

/**
 * Created by User on 27.01.2018.
 */

public class ChestAnimation extends Scenario {
    public BitmapFont font = Tex.generateFont("ui/fonts/font1.ttf", 30, Color.WHITE);
    public Sprite coin = new Sprite(new Texture("ui/HPKE0551.png"));

    Vector2 fontPosition;

    float sinA = 0.4f;
    float sinDelta = 0.08f;

    public ChestAnimation(int x, int y) {
        isParalel = false;
        isTimeLimit = true;
        time = 140;
        fontPosition = new Vector2(x, y);
    }

    public void render(SpriteBatch batch) {
        font.draw(batch, "+9000", fontPosition.x, fontPosition.y);
        Color color = batch.getColor();
        batch.setColor(color.r, color.g, color.a, 1 - ((float)(140 - time) / 140));
        batch.draw(coin, fontPosition.x + 70, fontPosition.y - 20, 20, 20);
        batch.setColor(color);
    }

    public void act() {
        super.act();
        font.setColor(1, 1, 1, 1 - ((float)(140 - time) / 140));
        fontPosition.add(0, 0.5f);
        sinA += sinDelta;
        fontPosition.add((float) Math.sin(sinA) / 2, 0);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.font.dispose();
    }
}

