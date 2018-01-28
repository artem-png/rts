package com.mygdx.game.Scenario.Scenarious.Level1;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Scenario.Scenarious.Scenario;

import java.util.Random;

/**
 * Created by User on 26.01.2018.
 */

public class EarthShakeScenario extends Scenario {
    Vector3 originPosition;
    double a = 0;
    double b = 0.5;
    float delta = 0.75f;
    float xm = 3;
    float ym = 4;
    int ab = 0;
    Random random = new Random();

    public EarthShakeScenario() {
        originPosition = new Vector3(GameLayout.camera.position);
        level = GameLayout.level;
        name = "1_noise";
        isParalel = false;
        isTimeLimit = true;
        time = 300;
    }

    public void render(SpriteBatch batch) {

    }

    public void act() {
        super.act();
        if ((time < 300 && time >= 240) || (time < 180 && time >= 120) || (time <= 70 && time > 0)) {
            if (ab % 2 == 1) {
                xm -= 0.07;
                ym -= 0.07;
                if (xm < 0) {
                    xm = 0;
                }
                if (ym < 0) {
                    ym = 0;
                }
            }
            a += 0.85f;
            b += 0.85f;
            ab++;
            GameLayout.camera.position.add((float) Math.sin(a) * xm, (float) Math.sin(b) * ym, 0);
        } else {
            xm = 3;
            ym = 4;
            delta = 0.75f;
            GameLayout.camera.position.set(originPosition);
        }
    }

    public void dispose() {

    }
}
