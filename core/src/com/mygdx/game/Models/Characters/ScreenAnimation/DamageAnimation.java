package com.mygdx.game.Models.Characters.ScreenAnimation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Models.Characters.Classes.AModel;

import java.util.Vector;

/**
 * Created by User on 25.01.2018.
 */

public class DamageAnimation implements IScreenAnimation {
    public Vector<Sprite> sprites;
    public Vector2 position;
    public AModel model;
    public boolean isAlive = true;
    int timerSetting = 2;
    int timer = 2;
    int frameCurrent = 0;
    int frameMax = 2;

    int frameDistance = 2;

    public DamageAnimation(AModel model) {
        this.model = model;
        sprites = new Vector<Sprite>();
        Sprite currentFrame1 = new Sprite(model.getCurrentFrame());


        sprites.add(currentFrame1);
        position = new Vector2(model.getPosition());
    }

    public void render(SpriteBatch batch) {

        Color color = batch.getColor();
        if (frameCurrent == 0) {
            batch.setColor(Color.RED);
            batch.setShader(com.mygdx.game.Models.Characters.ScreenAnimation.AnimationFabric.shaderProgram);
            if (model.side == 1) {
                sprites.get(0).setFlip(false, false);
                batch.draw(sprites.get(0), position.x - frameDistance - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            } else {
                sprites.get(0).setFlip(true, false);
                batch.draw(sprites.get(0), position.x + frameDistance - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            }
        }
        if (frameCurrent == 1) {
            batch.setColor(Color.ORANGE);
            batch.setShader(com.mygdx.game.Models.Characters.ScreenAnimation.AnimationFabric.shaderProgram);
            if (model.side == 1) {
                sprites.get(0).setFlip(false, false);
                batch.draw(sprites.get(0), position.x - frameDistance * 2 - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            } else {
                sprites.get(0).setFlip(true, false);
                batch.draw(sprites.get(0), position.x + frameDistance * 2 - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            }
            batch.setColor(Color.RED);
            batch.setShader(com.mygdx.game.Models.Characters.ScreenAnimation.AnimationFabric.shaderProgram);
            if (model.side == 1) {
                sprites.get(0).setFlip(false, false);
                batch.draw(sprites.get(0), position.x - frameDistance - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            } else {
                sprites.get(0).setFlip(true, false);
                batch.draw(sprites.get(0), position.x + frameDistance - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            }
        }
        if (frameCurrent == 2) {
            batch.setColor(Color.YELLOW);
            batch.setShader(com.mygdx.game.Models.Characters.ScreenAnimation.AnimationFabric.shaderProgram);
            if (model.side == 1) {
                sprites.get(0).setFlip(false, false);
                batch.draw(sprites.get(0), position.x - frameDistance * 3 - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            } else {
                sprites.get(0).setFlip(true, false);
                batch.draw(sprites.get(0), position.x + frameDistance * 3 - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            }
            batch.setColor(Color.ORANGE);
            batch.setShader(com.mygdx.game.Models.Characters.ScreenAnimation.AnimationFabric.shaderProgram);
            if (model.side == 1) {
                sprites.get(0).setFlip(false, false);
                batch.draw(sprites.get(0), position.x - frameDistance * 2 - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            } else {
                sprites.get(0).setFlip(true, false);
                batch.draw(sprites.get(0), position.x + frameDistance * 2 - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            }
            batch.setColor(Color.RED);
            batch.setShader(com.mygdx.game.Models.Characters.ScreenAnimation.AnimationFabric.shaderProgram);
            if (model.side == 1) {
                sprites.get(0).setFlip(false, false);
                batch.draw(sprites.get(0), position.x - frameDistance - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            } else {
                sprites.get(0).setFlip(true, false);
                batch.draw(sprites.get(0), position.x + frameDistance - model.getFrameOffset(), position.y, sprites.get(0).getWidth(), sprites.get(0).getHeight());
            }
        }

        batch.setColor(color);
        batch.setShader(null);
    }

    public void act() {
        timer--;
        if (timer <= 0) {
            timer = timerSetting;
            frameCurrent++;
            if (frameCurrent > frameMax) {
                isAlive = false;
                frameCurrent--;
            }
        }
    }

    public void dispose() {
        for (int i = frameCurrent; i >= 0; i--) {
            //  sprites.get(i).getTexture().dispose();
        }
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }
}
