package com.mygdx.game.Levels.one;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Background.Background;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Levels.ALevel;
import com.mygdx.game.Scenario.Scenarious.Default.BlackScenario;
import com.mygdx.game.Scenario.Scenarious.Default.SetPlayerScenario;
import com.mygdx.game.Scenario.Scenarious.Default.UnBlackScenario;
import com.mygdx.game.Scenario.Scenarious.Default.WaitForPositionScenario;
import com.mygdx.game.Scenario.Scenarious.Level1.EarthShakeScenario;
import com.mygdx.game.Scenario.Scenarious.Level1.KillDialog;
import com.mygdx.game.Scenario.Scenarious.Level1.OrcDialog;
import com.mygdx.game.Scenario.Scenarious.Level1.PauseScenario;
import com.mygdx.game.Scenario.Scenarious.Level1.SetOrcScenario;
import com.mygdx.game.Scenario.Scenarious.Level1.SleepScenario;
import com.mygdx.game.Scenario.Scenarious.Level1.TutorialAtackScenario;
import com.mygdx.game.Scenario.Scenarious.Level1.TutorialDefendScenario;
import com.mygdx.game.Scenario.Scenarious.Level1.WaitForScenario;
import com.mygdx.game.Scenario.Scenarious.Level1.WakeUpDialog;

import java.util.Vector;

/**
 * Created by User on 20.01.2018.
 */

public class Level1 extends ALevel {
    public Level1() {
        initBackground();
        Texture text = new Texture("maps/map1/untitled.png");
        map = new Sprite(text, text.getWidth(), text.getHeight());
        scenarioHandler.addScenario(new UnBlackScenario(100));
        scenarioHandler.addScenario(new SleepScenario());
        scenarioHandler.addScenario(new EarthShakeScenario());
        scenarioHandler.addScenario(new WakeUpDialog());
        scenarioHandler.addScenario(new SetPlayerScenario(200, 50, 50, 150));
        scenarioHandler.addScenario(new SetOrcScenario());
        scenarioHandler.addScenario(new PauseScenario(180));
        scenarioHandler.addScenario(new OrcDialog());
        scenarioHandler.addScenario(new PauseScenario(60));
        scenarioHandler.addScenario(new TutorialAtackScenario());
        scenarioHandler.addScenario(new PauseScenario(60));
        scenarioHandler.addScenario(new TutorialDefendScenario());
        scenarioHandler.addScenario(new WaitForScenario());
        scenarioHandler.addScenario(new PauseScenario(90));
        scenarioHandler.addScenario(new KillDialog());
        scenarioHandler.addScenario(new WaitForPositionScenario(1350));
        scenarioHandler.addScenario(new BlackScenario(50));
    }

    private void initBackground() {
        Vector<Sprite> sprites = new Vector<Sprite>();
        sprites.add(Tex.background1_bg);
        background = new Background(sprites);
    }
}
