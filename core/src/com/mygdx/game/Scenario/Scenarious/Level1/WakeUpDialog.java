package com.mygdx.game.Scenario.Scenarious.Level1;

import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogScenario;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogSpeech;

/**
 * Created by User on 27.01.2018.
 */

public class WakeUpDialog extends DialogScenario {

    public WakeUpDialog() {
        this.yOffset = 160;
        this.isTimeLimit = false;
        String say = L.t("Uh ... What was that? Earthquake? I need to look around.");
        this.add(new DialogSpeech(Tex.Samurai_light_atack_1, say, false));
    }
}
