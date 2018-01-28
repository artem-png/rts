package com.mygdx.game.Scenario.Scenarious.Level2;

import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class WaitForScenario extends Scenario {
    public WaitForScenario() {
        isParalel = false;
        isTimeLimit = false;
    }

    public void act() {
        super.act();
        if (GameLayout.level.getAliveEnemiesCount() == 0) {
            isActive = false;
        }
    }
}

