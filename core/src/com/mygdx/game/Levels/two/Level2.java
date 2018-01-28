package com.mygdx.game.Levels.two;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Background.Background;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Levels.ALevel;
import com.mygdx.game.Scenario.Scenarious.Default.SetPlayerScenario;
import com.mygdx.game.Scenario.Scenarious.Default.UnBlackScenario;
import com.mygdx.game.Scenario.Scenarious.Default.WaitForPositionScenario;
import com.mygdx.game.Scenario.Scenarious.Level2.MonumentDialog;
import com.mygdx.game.Scenario.Scenarious.Level2.OrcKillDialog;
import com.mygdx.game.Scenario.Scenarious.Level2.PauseScenario;
import com.mygdx.game.Scenario.Scenarious.Level2.SetOrcScenario;
import com.mygdx.game.Scenario.Scenarious.Level2.WaitForScenario;

import java.util.Vector;

/**
 * Created by User on 20.01.2018.
 */

public class Level2 extends ALevel {
    public Level2() {
        initBackground();
        Texture text = new Texture("maps/map2/map.png");
        map = new Sprite(text, text.getWidth(), text.getHeight());
        scenarioHandler.addScenario(new SetPlayerScenario(50, 51, 10, 300));
        scenarioHandler.addScenario(new UnBlackScenario(50));
        scenarioHandler.addScenario(new SetOrcScenario());
        scenarioHandler.addScenario(new WaitForScenario());
        scenarioHandler.addScenario(new PauseScenario(80));
        scenarioHandler.addScenario(new OrcKillDialog());
        scenarioHandler.addScenario(new WaitForPositionScenario(800));
        scenarioHandler.addScenario(new MonumentDialog());
    }

    private void initBackground() {
        Vector<Sprite> sprites = new Vector<Sprite>();
        sprites.add(Tex.background1_bg);
        background = new Background(sprites);
    }
}
