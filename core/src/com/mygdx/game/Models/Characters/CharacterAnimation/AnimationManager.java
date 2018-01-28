package com.mygdx.game.Models.Characters.CharacterAnimation;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Models.Characters.Classes.AModel;

/**
 * Created by User on 21.01.2018.
 */

public class AnimationManager {
    public Animation stand;
    public Animation run;
    public Animation atack;
    public Animation defend;
    public Animation unDefend;
    public Animation die;
    public int lastType;

    public AnimationManager() {

    }

    public void act(int type)
    {
        getAnimationByType(type).act();
    }

    public Sprite getFrame(int type)
    {
        if (type != lastType) {
            getAnimationByType(type).refresh();
            lastType = type;
        }
        return getAnimationByType(type).getSprite();
    }

    protected Animation getAnimationByType(int type) {
        if (type == AModel.RUN) {
            return run;
        } else if (type == AModel.DEAD) {
            return die;
        } else {
            return stand;
        }
    }

    public void dispose()
    {
        stand.dispose();
        run.dispose();
    }
}
