package com.mygdx.game.Levels;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Background.Background;
import com.mygdx.game.Component.AtackComponent;
import com.mygdx.game.Component.HpComponent;
import com.mygdx.game.Component.IComponent;
import com.mygdx.game.Component.MoveComponent;
import com.mygdx.game.Models.Characters.Classes.AEnemy;
import com.mygdx.game.Models.Characters.Classes.AModel;
import com.mygdx.game.Models.Characters.Classes.Player;
import com.mygdx.game.Models.Characters.ScreenAnimation.AnimationFabric;
import com.mygdx.game.Scenario.ScenarioHandler;

import java.util.Vector;

/**
 * Created by User on 21.01.2018.
 */

public abstract class ALevel implements ILevel {
    public Sprite map;
    public Background background;
    public Vector<AEnemy> enemies = new Vector<AEnemy>();
    public Vector<IComponent> controlComponents = new Vector<IComponent>();
    public Vector<IComponent> visualComponents = new Vector<IComponent>();
    public Player player;
    public AnimationFabric animationFabric = new AnimationFabric();
    public ScenarioHandler scenarioHandler = new ScenarioHandler();
    public final int STATUS_ACTIVE = 1;
    public final int STATUS_HOLD = 2;
    int status = STATUS_ACTIVE;

    public void render(SpriteBatch batch) {
        background.render(batch);
        batch.draw(map, 0, 0);
        animationFabric.render(batch);
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

    @Override
    public void act() {
        if (this.status == this.STATUS_ACTIVE) {
            animationFabric.act();
            if (player != null) {
                player.act();
            }
            actEnemies();
            actControlComponents();
            actVisualComponents();
        }
        scenarioHandler.act();
    }

    public void initControlComponents(int size, float x1offset, float x2offset) {
        MoveComponent moveComponent = new MoveComponent(this, size);
        moveComponent.setOffsets(x1offset, x2offset);
        controlComponents.add(moveComponent);
        controlComponents.add(new AtackComponent(this));
    }

    public void initVisualComponents(Player player) {
        HpComponent hpComponent = new HpComponent(this, player);
        visualComponents.add(hpComponent);
    }

    public void actControlComponents() {
        for (int i = 0; i < controlComponents.size(); i++) {
            controlComponents.get(i).input();
        }
    }

    public void renderControlComponents(SpriteBatch batch) {
        for (int i = 0; i < controlComponents.size(); i++) {
            controlComponents.get(i).render(batch);
        }
    }

    public void disposeControlComponents() {
        for (int i = 0; i < controlComponents.size(); i++) {
            controlComponents.get(i).dispose();
        }
        controlComponents = new Vector<IComponent>();
    }

    public void actVisualComponents() {
        for (int i = 0; i < visualComponents.size(); i++) {
            visualComponents.get(i).input();
        }
    }

    public void renderVisualComponents(SpriteBatch batch) {
        for (int i = 0; i < visualComponents.size(); i++) {
            visualComponents.get(i).render(batch);
        }
    }

    public void disposeVisualComponents() {
        for (int i = 0; i < visualComponents.size(); i++) {
            visualComponents.get(i).dispose();
        }
        visualComponents = new Vector<IComponent>();
    }

    public void addEnemy(AEnemy enemy) {
        enemies.add(enemy);
    }

    public Vector<AEnemy> getEnemies() { return this.enemies; }

    public int getAliveEnemiesCount() {
        int count = 0;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).status != AModel.DEAD) {
                count++;
            }
        }
        return count;
    }

    public void actEnemies() {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).act();
        }
    }

    public void renderEnemies(SpriteBatch batch) {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).render(batch);
        }
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public void setPlayer(Player player, int size, float xoffset, float yoffset) {
        this.player = player;
        initControlComponents(size, xoffset, yoffset);
        initVisualComponents(player);
    }

    public void dispose() {
        background.dispose();
        scenarioHandler.dispose();
        background = null;
        for (int i = 0; i < controlComponents.size(); i++) {
            controlComponents.get(i).dispose();
        }
        for (int i = 0; i < visualComponents.size(); i++) {
            visualComponents.get(i).dispose();
        }
        if (player != null) {
            player.dispose();
        }
        map.getTexture().dispose();
        animationFabric.dispose();
    }

    public Player getPlayer() {
        return player;
    }

    public AnimationFabric getAnimationFabric() {
        return this.animationFabric;
    }
}
