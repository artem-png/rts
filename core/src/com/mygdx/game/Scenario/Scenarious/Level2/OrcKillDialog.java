package com.mygdx.game.Scenario.Scenarious.Level2;

import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogScenario;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogSpeech;

/**
 * Created by User on 27.01.2018.
 */

public class OrcKillDialog extends DialogScenario {

    public OrcKillDialog() {
        this.yOffset = 160;
        this.isTimeLimit = false;
        String say = L.t("Orc again. What is he doing here?");
        this.add(new DialogSpeech(Tex.Samurai_light_atack_4, say, false));
    }
}
