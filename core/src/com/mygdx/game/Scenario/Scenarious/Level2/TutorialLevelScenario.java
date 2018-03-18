package com.mygdx.game.Scenario.Scenarious.Level2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Component.LevelComponent;
import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class TutorialLevelScenario extends Scenario {
    Sprite black = new Sprite(new Texture("level/l1/black.png"));
    Sprite pointer = new Sprite(new Texture("level/l1/pointer.png"));
    BitmapFont font = Tex.generateFont("ui/fonts/font1.ttf", 50, Color.WHITE);
    int pointerTimeSetting = 40;
    int pointerTime = pointerTimeSetting;
    int refreshSetting = 70;
    int refresh = refreshSetting;
    Vector2 firstPosition = new Vector2(760, 260);
    Vector2 finalPosition = new Vector2(930, 440);
    Vector2 speed = new Vector2((finalPosition.x - firstPosition.x) / pointerTimeSetting , (finalPosition.y - firstPosition.y) / pointerTimeSetting);
    Vector2 actualPosition = new Vector2(760, 260);
    boolean isPointerPause = false;
    int timerDelay = 60;
    double pointerRotation = 0;
    LevelComponent levelComponent;

    public TutorialLevelScenario() {
        levelComponent = new LevelComponent(true);
        isParalel = false;
        isTimeLimit = false;
        pointer.setRotation(260);
        pointer.setOrigin(pointer.getWidth()/2, pointer.getHeight()/2);
    }

    public void render(SpriteBatch batch) {
        Color color = batch.getColor();
        batch.setColor(color.r, color.g, color.b, 0.7f);
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        batch.draw(black, 0, 0, GameLayout.cameraDynamic.viewportWidth, 2000);
        batch.setColor(color.r, color.g, color.b, 1);
        batch.draw(pointer, actualPosition.x, actualPosition.y, pointer.getOriginX(), pointer.getOriginY(), pointer.getWidth(), pointer.getHeight(), pointer.getScaleX(), pointer.getScaleY(), pointer.getRotation());
        font.draw(batch, L.t("Tap to manage your points"), 330, 460);
        levelComponent.render(batch);
        batch.setProjectionMatrix(GameLayout.camera.combined);
    }

    public void act() {
        super.act();
        this.pointerRotation += 0.2f;
        pointer.setRotation(pointer.getRotation() + (float)Math.sin(this.pointerRotation) * 3);
        if (!isPointerPause) {
            pointerTime--;
            actualPosition.add(speed.x, speed.y);
        }
        if (pointerTime < 0) {
            isPointerPause = true;
        }
        if (isPointerPause) {
            refresh--;
            if (refresh < 0) {
                refresh = refreshSetting;
                isPointerPause = false;
                pointerTime = pointerTimeSetting;
                actualPosition = new Vector2(firstPosition);
            }
        }
        if (isActive) {
            GameLayout.level.setStatus(2);
        }
        timerDelay--;
        input();
    }

    public void input() {
        if (levelComponent.input()) {
            this.isActive = false;
        }
    }

    public void dispose() {
        super.dispose();
        GameLayout.level.setStatus(1);
        black.getTexture().dispose();
        pointer.getTexture().dispose();
    }
}

