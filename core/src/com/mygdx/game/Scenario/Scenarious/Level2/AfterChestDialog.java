package com.mygdx.game.Scenario.Scenarious.Level2;

import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogScenario;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogSpeech;

/**
 * Created by User on 27.01.2018.
 */

public class AfterChestDialog extends DialogScenario {

    public AfterChestDialog() {
        this.yOffset = 160;
        this.isTimeLimit = false;
        this.isParalel = false;
        String say = L.t("Treasure of Almatur! Finally! Lets open it.");
        this.add(new DialogSpeech(Tex.Samurai_light_atack_9, say, false));
    }
}
