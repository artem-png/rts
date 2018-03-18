package com.mygdx.game.Levels.two;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Background.Background;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Levels.ALevel;
import com.mygdx.game.Models.Logic.Monuments;
import com.mygdx.game.Scenario.Scenarious.Default.ParalelBlackScenario;
import com.mygdx.game.Scenario.Scenarious.Default.SetPlayerScenario;
import com.mygdx.game.Scenario.Scenarious.Default.UnBlackScenario;
import com.mygdx.game.Scenario.Scenarious.Default.ChestAnimation;
import com.mygdx.game.Scenario.Scenarious.Default.WaitForPositionScenario;
import com.mygdx.game.Scenario.Scenarious.Level2.AfterChestDialog;
import com.mygdx.game.Scenario.Scenarious.Level2.AfterLevelDialog;
import com.mygdx.game.Scenario.Scenarious.Level2.AfterMonumentDialog;
import com.mygdx.game.Scenario.Scenarious.Level2.ChestOpen;
import com.mygdx.game.Scenario.Scenarious.Level2.ChestScenario;
import com.mygdx.game.Scenario.Scenarious.Level2.EarthShakeScenario;
import com.mygdx.game.Scenario.Scenarious.Level2.LevelAnimation;
import com.mygdx.game.Scenario.Scenarious.Level2.MonumentDialog;
import com.mygdx.game.Scenario.Scenarious.Level2.OrcKillDialog;
import com.mygdx.game.Scenario.Scenarious.Level2.PauseScenario;
import com.mygdx.game.Scenario.Scenarious.Level2.SetOrcScenario;
import com.mygdx.game.Scenario.Scenarious.Level2.TutorialLevelScenario;
import com.mygdx.game.Scenario.Scenarious.Level2.WaitForMonument;
import com.mygdx.game.Scenario.Scenarious.Level2.WaitForScenario;

import java.util.Vector;

/**
 * Created by User on 20.01.2018.
 */

public class Level2 extends ALevel {
    Monuments monuments;

    public Level2() {
        initBackground();
        initLevelMenu();
        Texture text = new Texture("maps/map2/map.png");
        map = new Sprite(text, text.getWidth(), text.getHeight());
        monuments = new Monuments();

        scenarioHandler.addScenario(new UnBlackScenario(50));
        scenarioHandler.addScenario(new SetPlayerScenario(50, 51, 10, 300));
        scenarioHandler.addScenario(new SetOrcScenario());
        scenarioHandler.addScenario(new WaitForScenario());
        scenarioHandler.addScenario(new PauseScenario(40));
        scenarioHandler.addScenario(new OrcKillDialog());
        scenarioHandler.addScenario(new WaitForPositionScenario(700));
        scenarioHandler.addScenario(new MonumentDialog());
        scenarioHandler.addScenario(new WaitForMonument(monuments));
        scenarioHandler.addScenario(new EarthShakeScenario("chestFallen"));
        scenarioHandler.addScenario(new PauseScenario(120));
        scenarioHandler.addScenario(new AfterMonumentDialog());
        scenarioHandler.addScenario(new ChestScenario());
        scenarioHandler.addScenario(new PauseScenario(80));
        scenarioHandler.addScenario(new AfterChestDialog());
        scenarioHandler.addScenario(new ChestOpen());
        scenarioHandler.addScenario(new ChestAnimation(1140, 295));
        scenarioHandler.addScenario(new ParalelBlackScenario(0.7f, "level_animation"));
        scenarioHandler.addScenario(new LevelAnimation());
        scenarioHandler.addScenario(new TutorialLevelScenario());
        scenarioHandler.addScenario(new AfterLevelDialog());
    }

    public void render(SpriteBatch batch) {
        background.render(batch);
        batch.draw(map, 0, 0);
        animationFabric.render(batch);
        scenarioHandler.renderBefore(batch);
        monuments.render(batch);
        renderEnemies(batch);
        if (player != null) {
            player.render(batch);
        }
        scenarioHandler.render(batch);
        if (this.status == this.STATUS_ACTIVE) {
            renderControlComponents(batch);
            renderVisualComponents(batch);
        }
    }

    public void act() {
        super.act();
        monuments.act();
    }

    private void initBackground() {
        Vector<Sprite> sprites = new Vector<Sprite>();
        sprites.add(Tex.background1_bg);
        background = new Background(sprites);
    }

    public void dispose() {
        super.dispose();
        monuments.dispose();
    }
}
