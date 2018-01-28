package com.mygdx.game.Scenario.Scenarious.Level1;

import com.mygdx.game.Config.Params;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Models.Characters.Classes.Orc;
import com.mygdx.game.Models.Characters.Classes.Player;
import com.mygdx.game.Models.Characters.HelpModel.CharacterModel;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class SetOrcScenario extends Scenario {
    public SetOrcScenario() {

    }

    public void act() {
        isActive = false;
        GameLayout.level.addEnemy(new Orc(CharacterModel.ORC_HUMMER, 1400, 187, Params.hp5, Params.atackDelay150, Params.damage1, Params.speed2));
    }
}
