package com.mygdx.game.Scenario.Scenarious;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Levels.ILevel;

/**
 * Created by User on 26.01.2018.
 */

public abstract class Scenario {
    public ILevel level;
    public boolean isActive = true;
    public boolean isParalel = false;
    public boolean isTimeLimit = false;
    public int time = 0;
    public String name = "default";
    public String disposeOnName = "";
    public boolean isBeforeRenderPlayer = false;

    public void render(SpriteBatch batch) {

    }

    public void act() {
        if (isTimeLimit) {
            time--;
            if (time <= 0) {
                isActive = false;
            }
        }
    }

    public void dispose() {

    }

    public boolean checkDisposeName(String name) {
        return disposeOnName == name;
    }
}
