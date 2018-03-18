package com.mygdx.game.Scenario.Scenarious.Level2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Models.Logic.Monuments;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class ChestOpen extends Scenario {
    protected Monuments monuments;

    public ChestOpen() {
        isParalel = false;
        isTimeLimit = false;
    }

    public void act() {
        super.act();
        if (Gdx.input.justTouched()) {
            Vector3 coords = GameLayout.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (coords.x > 1140 && coords.x < 1140 + 100 && coords.y > 180 && coords.y < 265) {
                isActive = false;
            }
        }
    }
}

