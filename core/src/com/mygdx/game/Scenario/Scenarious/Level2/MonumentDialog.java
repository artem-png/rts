package com.mygdx.game.Scenario.Scenarious.Level2;

import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogScenario;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogSpeech;

/**
 * Created by User on 27.01.2018.
 */

public class MonumentDialog extends DialogScenario {

    public MonumentDialog() {
        this.yOffset = 160;
        this.isTimeLimit = false;
        String say = L.t("Monuments... They aren't activated. Let's see if I can do something");
        this.add(new DialogSpeech(Tex.Samurai_light_stand_1, say, false));
    }
}
