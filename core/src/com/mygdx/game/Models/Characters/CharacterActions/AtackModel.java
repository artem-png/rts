package com.mygdx.game.Models.Characters.CharacterActions;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by User on 25.01.2018.
 */

public class AtackModel {
    public com.mygdx.game.Models.Characters.CharacterAnimation.Animation animation;
    public int settingDelay;
    public int delay;
    public com.mygdx.game.Models.Characters.Classes.AModel model;
    public boolean isWorking = false;

    public AtackModel(com.mygdx.game.Models.Characters.CharacterAnimation.Animation animation, int delay, com.mygdx.game.Models.Characters.Classes.AModel model) {
        this.animation = animation;
        this.delay = delay / 2;
        this.settingDelay = delay;
        this.model = model;
    }

    public boolean atack(boolean isNear) {
        if (delay  <= 0) {
            isWorking = true;
            animation.act();
            if (animation.currentFrame == animation.maxFrame) {
                if (isNear) {
                    delay = settingDelay;
                } else {
                    delay = 2;
                }
                isWorking = false;
                animation.refresh();
                if (this.model.opponent != null) {
                    this.model.opponent.getPunch(new Punch(model));
                }
            }

            return true;
        }
        delay--;
        isWorking = false;

        return true;
    }

    public void act(boolean isNear)
    {
        if (!isWorking) {
            delay--;
        } else {
            atack(isNear);
        }
    }

    public Sprite getFrame()
    {
        return animation.getSprite();
    }
}
