package com.mygdx.game.Scenario.Scenarious.Level1;

import com.mygdx.game.Config.Params;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class PauseScenario extends Scenario {
    public PauseScenario(int time) {
        this.time = time;
        isParalel = false;
        isTimeLimit = true;
    }
}

