package com.mygdx.game.Scenario.Scenarious.Default;

import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Models.Characters.Classes.Player;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class SetPlayerScenario extends Scenario {
    int playerPosition;
    int size;
    int xoffset;
    int yoffset;
    public SetPlayerScenario(int playerPosition,int size, int xoffset, int yoffset) {
        this.playerPosition = playerPosition;
        this.size = size;
        this.xoffset = xoffset;
        this.yoffset = yoffset;
    }

    public void act() {
        isActive = false;
        GameLayout.level.setPlayer(new Player(playerPosition), size, xoffset, yoffset);
    }
}
