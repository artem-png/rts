package com.mygdx.game.Scenario.Scenarious.Dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Scenario.Scenarious.Scenario;

import java.util.Vector;

/**
 * Created by User on 27.01.2018.
 */

public abstract class DialogScenario extends Scenario {
    Sprite panel = new Sprite(new Texture("ui/dialog/panel.png"));
    Sprite black = new Sprite(new Texture("level/l1/black.png"));
    ;
    public BitmapFont font = Tex.generateFont("ui/fonts/font1.ttf", 32, Color.BLACK);
    public Vector<DialogSpeech> dialogSpeeches = new Vector<DialogSpeech>();
    public int timerSetting = 5;
    public int timer = 5;
    public int timeToDieSetting = 10;
    public int timeToDie = timeToDieSetting;
    public float dieDelta = GameLayout.cameraDynamic.viewportWidth / timeToDie;
    boolean isHide = false;
    public int yOffset = 0;

    public void add(DialogSpeech dialogSpeech) {
        dialogSpeeches.add(dialogSpeech);
    }

    public void render(SpriteBatch batch) {
        Color color = batch.getColor();
        batch.setColor(color.r, color.g, color.b, 0.5f);
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        batch.draw(black, 0 - dieDelta * (timeToDieSetting - timeToDie), 0, GameLayout.cameraDynamic.viewportWidth, 2000);
        batch.setColor(color.r, color.g, color.b, 1);
        batch.draw(panel, 25 - dieDelta * (timeToDieSetting - timeToDie), 75, 1050, 240 - yOffset);
        if (dialogSpeeches.get(0).revert) {
            dialogSpeeches.get(0).hero.setFlip(true, false);
            batch.draw(dialogSpeeches.get(0).hero, 800 - dieDelta * (timeToDieSetting - timeToDie), 300 - yOffset);
        } else {
            batch.draw(dialogSpeeches.get(0).hero, 50 - dieDelta * (timeToDieSetting - timeToDie), 300 - yOffset);
        }
        font.draw(batch, dialogSpeeches.get(0).text, 50 - dieDelta * (timeToDieSetting - timeToDie), 285 - yOffset, 1000, 270 - yOffset, true);
        batch.setProjectionMatrix(GameLayout.camera.combined);
    }

    public int getSpeechCount() {
        return dialogSpeeches.size();
    }

    public void act() {
        if (!isHide) {
            GameLayout.level.setStatus(2);
        }
        timer--;
        super.act();
        input();
        if (getSpeechCount() == 0 || isHide) {
            timeToDie--;
            this.isParalel = true;
            if (timeToDie < 0) {
                this.isActive = false;
            }
        }
    }

    public void input() {
        if ((Gdx.input.justTouched() && timer <= 0) || this.isHide) {
            timer = timerSetting;
            if (getSpeechCount() == 1 && this.timeToDie > 0) {
                GameLayout.level.setStatus(1);
                isHide = true;
            } else {
                dialogSpeeches.remove(0);
            }
        }
    }

    public void dispose() {
        for (int i = 0; i < dialogSpeeches.size(); i++) {
            dialogSpeeches.get(i).dispose();
        }
        this.panel.getTexture().dispose();
        this.font.dispose();
        black.getTexture().dispose();
    }
}
