package com.mygdx.game.Scenario.Scenarious.Level2;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Scenario.Scenarious.Scenario;

import java.util.Random;

/**
 * Created by User on 26.01.2018.
 */

public class EarthShakeScenario extends Scenario {
    Random random = new Random();
    float a = 0.5f;
    float b = 0.7f;

    int timeToDie = 40;
    boolean isDead = false;

    public EarthShakeScenario(String disposeOn) {
        level = GameLayout.level;
        this.disposeOnName = disposeOn;
        isParalel = true;
        isTimeLimit = false;
    }

    public void act() {
        super.act();
        if (isDead) {
            timeToDie--;
            if (timeToDie < 0) {
                isActive = false;
            }
        }
        a += 0.8f;
        b += 0.8f;
        GameLayout.camera.position.add(new Vector3((float)Math.sin(a), (float)Math.sin(b), 0));
    }

    public boolean checkDisposeName(String name) {
        if (disposeOnName == name) {
            isDead = true;
        }
        return false;
    }

    public void dispose() {

    }
}
