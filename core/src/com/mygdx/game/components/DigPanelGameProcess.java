package com.mygdx.game.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.process.CaveProcess;
import com.mygdx.game.process.TunnelProcess;
import com.mygdx.game.process.GameProcess;

/**
 * Created by User on 14.10.2017.
 */

public class DigPanelGameProcess {
    private Button showButton;
    private boolean isShow = true;
    private Button closeButton;
    private boolean isClose = false;
    private Button digButton;
    private Button caveButton;

    public DigPanelGameProcess() {
        showButton = new Button(Tex.button_1_1, new Vector2(5 * Tex.x, 5 * Tex.y));
        closeButton = new Button(Tex.button_1_2, new Vector2(5 * Tex.x, 5 * Tex.y));
        digButton = new Button(Tex.digButton, new Vector2(110 * Tex.x, 5 * Tex.y));
        caveButton = new Button(Tex.caveButton, new Vector2(215 * Tex.x, 5 * Tex.y));
        digButton.setDelay(5);
        showButton.setDelay(5);
        closeButton.setDelay(5);
        caveButton.setDelay(5);
    }

    public void act(SpriteBatch batch) {
        if (isShow) {
            showButton.act(batch);
        }
        if (isClose) {
            closeButton.act(batch);
            digButton.act(batch);
            caveButton.act(batch);
        }
    }

    public void input() {
        if (isShow) {
            showButton.input();
            if (showButton.isActivated) {
                isShow = false;
                isClose = true;
                closeButton.isActivated = false;
                closeButton.setDelay(15);
            }
        } else if (isClose) {
            closeButton.input();
            caveButton.input();
            digButton.input();
            if (digButton.isActivated) {
                isShow = true;
                isClose = false;
                showButton.isActivated = false;
                showButton.setDelay(15);
                digButton.isActivated = false;
                digButton.setDelay(15);
                GameLayout.addProcess(new TunnelProcess(GameProcess.landMap));
            } else if (caveButton.isActivated) {
                isShow = true;
                isClose = false;
                showButton.isActivated = false;
                showButton.setDelay(15);
                caveButton.isActivated = false;
                caveButton.setDelay(15);
                GameLayout.addProcess(new CaveProcess(GameProcess.landMap));
            } else if (closeButton.isActivated) {
                isShow = true;
                isClose = false;
                showButton.isActivated = false;
                showButton.setDelay(15);
            }
        }
    }
}
