package com.mygdx.game.Scenario.Scenarious.Level1;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Levels.ILevel;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 26.01.2018.
 */

public class SleepScenario extends Scenario {
    BitmapFont zFontSmall;
    BitmapFont zFontMedium;
    BitmapFont zFontBig;
    int timer = 0;
    double ss = 0;
    double ms = 0.3;
    double bs = 0.6;

    public SleepScenario() {
        level = GameLayout.level;
        name = "1_sleep";
        isParalel = false;
        isTimeLimit = true;
        time = 400;

        zFontSmall = Tex.generateFont("ui/fonts/font1.ttf", 16, Color.WHITE);
        zFontMedium = Tex.generateFont("ui/fonts/font1.ttf", 24, Color.WHITE);
        zFontBig = Tex.generateFont("ui/fonts/font1.ttf", 32, Color.WHITE);
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i <= (int) (timer / 100); i++) {
            if (i == 3) {
                break;
            }
            zFontSmall.setColor(1, 1, 1, 1 - ((float)(299 - time + 200 - 100 * i) / 299));
            zFontMedium.setColor(1, 1, 1, 1 - ((float)(299 - time + 200 - 100 * i) / 299));
            zFontBig.setColor(1, 1, 1, 1 - ((float)(299 - time + 200 - 100 * i) / 299));
            zFontSmall.draw(batch, "Z", 380 + (float) (Math.sin(ss) * 20), 280 + timer - 100 * i);
            zFontMedium.draw(batch, "Z", 380 + (float) (Math.sin(ms) * 20), 305 + timer - 100 * i);
            zFontBig.draw(batch, "Z", 380 + (float) (Math.sin(bs) * 20), 330 + timer - 100 * i);
        }
    }

    public void act() {
        ss += 0.1;
        ms += 0.1;
        bs += 0.1;
        timer++;
        super.act();
    }

    public void dispose() {
        zFontBig.dispose();
        zFontMedium.dispose();
        zFontSmall.dispose();
    }
}
