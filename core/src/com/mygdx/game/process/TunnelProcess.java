package com.mygdx.game.process;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Layout.input.GameInputProcessor;
import com.mygdx.game.components.Button;
import com.mygdx.game.event.events.TonnelEvent;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.LandMap;
import com.mygdx.game.models.map.build.TunnelMap;

import java.util.Vector;

/**
 * Created by artem on 10/11/17.
 */

public class TunnelProcess implements IProcess {
    public LandMap landMap;
    private TunnelMap tunnelMap;
    private Button accept;
    private Button backButton;
    private boolean isPressed = false;

    public TunnelProcess(LandMap map) {
        tunnelMap = new TunnelMap();
        landMap = map;
        accept = new Button(Tex.acceptButton, new Vector2(715 * Tex.x, 5 * Tex.y));
        backButton = new Button(Tex.backButton, new Vector2(5 * Tex.x, 5 * Tex.y));
        accept.setDelay(5);
        backButton.setDelay(5);
    }

    @Override
    public void act(SpriteBatch batch) {
        landMap.act(batch);
        tunnelMap.act(batch);
        batch.end();
        GameProcess.menuBatch.begin();
        accept.act(GameProcess.menuBatch);
        backButton.act(GameProcess.menuBatch);
        GameProcess.menuBatch.end();
        batch.begin();
    }

    @Override
    public void input() {
        if (Gdx.input.isTouched()) {
            Vector3 ar = GameLayout.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (ar.x >= 0 && ar.y >= 0) {
                int x = (int) (ar.x / (30 * Tex.x));
                int y = (int) (ar.y / (30 * Tex.y));
                if (x >= 0 && y >= 0 && x < BlockMap.sizeX && y < BlockMap.sizeY) {
                    if (tunnelMap.add(new Vector2(x, y))) {
                        isPressed = true;
                        GameInputProcessor.isNeed = false;
                    } else if (!isPressed) {
                        GameInputProcessor.isNeed = true;
                    }
                }
            }
        } else {
            isPressed = false;
        }
        if (backButton.input()) {
            GameInputProcessor.isNeed = true;
            backButton.isActivated = false;
            GameLayout.removeProcess();
        }
        if (accept.input()) {
            GameInputProcessor.isNeed = true;
            accept.isActivated = false;
            Vector<Vector2> vector2s = tunnelMap.generateDataForEvent();
            if (vector2s != null) {
                GameInputProcessor.isNeed = true;
                TonnelEvent tonnelEvent = new TonnelEvent();
                tonnelEvent.setCells(tunnelMap.generateDataForEvent());
                tonnelEvent.setStandCells(tunnelMap.getStandCells());
                GameProcess.eventController.addEvent(tonnelEvent);
            }
            GameLayout.removeProcess();
        }
    }
}
