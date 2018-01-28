package com.mygdx.game.Scenario.Scenarious.Level1;

import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Levels.ALevel;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogScenario;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogSpeech;

/**
 * Created by User on 27.01.2018.
 */

public class OrcDialog extends DialogScenario {

    public OrcDialog() {
        this.yOffset = 160;
        this.isTimeLimit = false;
        String say = L.t("Orcs? Is that really true...");
        this.add(new DialogSpeech(Tex.Samurai_light_atack_9, say, false));
    }
}
