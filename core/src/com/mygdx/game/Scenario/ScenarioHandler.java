package com.mygdx.game.Scenario;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Scenario.Scenarious.Scenario;

import java.util.Vector;

/**
 * Created by User on 26.01.2018.
 */

public class ScenarioHandler {
    Vector<Scenario> scenarios = new Vector<Scenario>();

    public ScenarioHandler() {

    }

    public void addScenario(Scenario scenario) {
        scenarios.add(scenario);
    }

    public void act() {
        for (int i = 0; i < scenarios.size(); i++) {
            scenarios.get(i).act();
            if (!scenarios.get(i).isParalel) {
                break;
            }
        }
        Vector<Vector2> deleteIds = new Vector<Vector2>();
        for (int i = scenarios.size() - 1; i >= 0; i--) {
            if (!scenarios.get(i).isActive) {
                deleteIds.add(new Vector2(i, 0));
                for (int j = scenarios.size() - 1; j >= 0; j--) {
                    if (scenarios.get(j).checkDisposeName(scenarios.get(i).name)) {
                        deleteIds.add(new Vector2(j, 0));
                    }
                }
            }
        }
        for (int i = 0; i < deleteIds.size(); i++) {
            scenarios.get((int)deleteIds.get(i).x).dispose();
            scenarios.remove((int)deleteIds.get(i).x);
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < scenarios.size(); i++) {
            scenarios.get(i).render(batch);
            if (!scenarios.get(i).isParalel) {
                break;
            }
        }
    }

    public void dispose() {

    }
}
