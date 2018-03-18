package com.mygdx.game.Scenario.Scenarious.Level2;

import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Models.Logic.Monuments;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class WaitForMonument extends Scenario {
    protected Monuments monuments;

    public WaitForMonument(Monuments monuments) {
        isParalel = false;
        isTimeLimit = false;
        this.monuments = monuments;
    }

    public void act() {
        super.act();
        if (this.monuments.isFinish) {
            isActive = false;
        }
    }
}

