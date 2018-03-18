package com.mygdx.game.Scenario.Scenarious.Level2;

import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogScenario;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogSpeech;

/**
 * Created by User on 27.01.2018.
 */

public class AfterMonumentDialog extends DialogScenario {

    public AfterMonumentDialog() {
        this.yOffset = 160;
        this.isTimeLimit = false;
        this.isParalel = false;
        String say = L.t("What's that noise?");
        name = "chestFallen";
        this.add(new DialogSpeech(Tex.Samurai_light_stand_1, say, false));
    }
}
