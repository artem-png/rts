package com.mygdx.game.Scenario.Scenarious.Default;

import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class WaitForPositionScenario extends Scenario {
    int position;
    public WaitForPositionScenario(int p) {
        position = p;
        isParalel = false;
        isTimeLimit = false;
    }

    public void act() {
        super.act();
        if (GameLayout.level.getPlayer().position.x > position) {
            isActive = false;
        }
    }
}

