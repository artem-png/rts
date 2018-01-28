package com.mygdx.game.Models.Characters.CharacterActions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Models.Characters.CharacterAnimation.Animation;
import com.mygdx.game.Models.Characters.Classes.AModel;

/**
 * Created by User on 25.01.2018.
 */

public class DefendModel {
    public Animation animationDefend;
    public Animation animationUnDefend;
    public AModel model;
    public boolean isWorking = false;
    public boolean isDefend = false;
    public boolean isDefendMif = false;

    public DefendModel(Animation animationDefend, Animation animationUnDefend, AModel model) {
        this.animationDefend = animationDefend;
        this.animationUnDefend = animationUnDefend;
        this.model = model;
    }

    public void unDefend()
    {
        if (isDefend) {
            animationUnDefend.refresh();
        }
        isDefend = false;
        isDefendMif = false;
    }

    public void defend() {
        isWorking = true;
        isDefendMif = true;
    }

    public void act() {
        if (isWorking) {
            if (isDefendMif) {
                animationDefend.act();
                if (!animationDefend.isNeed) {
                    isDefend = true;
                }
            } else {
                animationUnDefend.act();
                if (!animationUnDefend.isNeed) {
                    isWorking = false;
                    animationDefend.refresh();
                    animationUnDefend.refresh();
                }
            }
        }
    }

    public Sprite getFrame() {
        if (isDefendMif) {
            return animationDefend.getSprite();
        } else {
            return animationUnDefend.getSprite();
        }
    }
}
