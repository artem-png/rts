package com.mygdx.game.Scenario.Scenarious.Level2;

import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogScenario;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogSpeech;

/**
 * Created by User on 27.01.2018.
 */

public class AfterLevelDialog extends DialogScenario {

    public AfterLevelDialog() {
        this.yOffset = 160;
        this.isTimeLimit = false;
        String say = L.t("Now I feel better. Time to go home and spend all my money!");
        this.add(new DialogSpeech(Tex.Samurai_light_stand_1, say, false));
    }
}
