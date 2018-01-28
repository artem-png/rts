package com.mygdx.game.Scenario.Scenarious.Level1;

import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogScenario;
import com.mygdx.game.Scenario.Scenarious.Dialog.DialogSpeech;

/**
 * Created by User on 27.01.2018.
 */

public class KillDialog extends DialogScenario {

    public KillDialog() {
        this.yOffset = 160;
        this.isTimeLimit = false;
        String say = L.t("Something tells me that what I'm looking for is somewhere near.");
        this.add(new DialogSpeech(Tex.Samurai_light_run_1, say, false));
        say = L.t("Whatever it was, I need to continue the search. Time to hit the road!");
        this.add(new DialogSpeech(Tex.Samurai_light_atack_2, say, false));
    }
}
