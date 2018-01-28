package com.mygdx.game.Scenario.Scenarious.Level2;

import com.mygdx.game.Config.Params;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Models.Characters.Classes.Orc;
import com.mygdx.game.Models.Characters.HelpModel.CharacterModel;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class SetOrcScenario extends Scenario {
    public void act() {
        isActive = false;
        GameLayout.level.addEnemy(new Orc(CharacterModel.ORC_HUMMER, 1200, 187, Params.hp5, Params.atackDelay120, Params.damage2, Params.speed2));
    }
}
