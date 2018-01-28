package com.mygdx.game.Scenario.Scenarious.Level1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Scenario.Scenarious.Scenario;

/**
 * Created by User on 27.01.2018.
 */

public class TutorialDefendScenario extends Scenario {
    Sprite black = new Sprite(new Texture("level/l1/black.png"));
    Sprite defend = new Sprite(new Texture("ui/buttons/defend.png"));
    Sprite pointer = new Sprite(new Texture("level/l1/pointer.png"));
    BitmapFont font = Tex.generateFont("ui/fonts/font1.ttf", 50, Color.WHITE);
    int pointerTimeSetting = 30;
    int pointerTime = pointerTimeSetting;
    int refreshSetting = 60;
    int refresh = refreshSetting;
    Vector2 firstPosition = new Vector2(620, 260);
    Vector2 finalPosition = new Vector2(720, 160);
    Vector2 speed = new Vector2((finalPosition.x - firstPosition.x) / pointerTimeSetting , (finalPosition.y - firstPosition.y) / pointerTimeSetting);
    Vector2 actualPosition = new Vector2(620, 260);
    boolean isPointerPause = false;
    int timerDelay = 30;
    double pointerRotation = 0;

    int holdTime = 0;
    int holdTimeNeed = 20;

    public TutorialDefendScenario() {
        isParalel = false;
        isTimeLimit = false;
        pointer.setRotation(170);
        pointer.setOrigin(pointer.getWidth()/2, pointer.getHeight()/2);
    }

    public void render(SpriteBatch batch) {
        Color color = batch.getColor();
        batch.setColor(color.r, color.g, color.b, 0.5f);
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        batch.draw(black, 0, 0, GameLayout.cameraDynamic.viewportWidth, 2000);
        batch.setColor(color.r, color.g, color.b, 1);
        batch.draw(defend, 820, 80);
        batch.draw(pointer, actualPosition.x, actualPosition.y, pointer.getOriginX(), pointer.getOriginY(), pointer.getWidth(), pointer.getHeight(), pointer.getScaleX(), pointer.getScaleY(), pointer.getRotation());
        font.draw(batch, L.t("Hold to defend"), 520, 400);
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
        if (Gdx.input.isTouched()) {
            Vector3 position = GameLayout.cameraDynamic.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (position.x > 820 && position.x < 820 + 80 && position.y > 80 && position.y < 80 + 80 && timerDelay <= 0) {
                holdTime++;
                if (holdTime > holdTimeNeed) {
                    isActive = false;
                }
            } else {
                holdTime = 0;
            }
        } else {
            holdTime = 0;
        }
    }

    public void dispose() {
        super.dispose();
        GameLayout.level.setStatus(1);
        black.getTexture().dispose();
        defend.getTexture().dispose();
        pointer.getTexture().dispose();
    }
}

