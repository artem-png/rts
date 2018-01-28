package com.mygdx.game.Models.Characters.CharacterAnimation;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.Vector;

/**
 * Created by User on 21.01.2018.
 */

public class Animation {
    Vector<Sprite> sprites;
    int settingDelay;
    int currentDelay;
    public int currentFrame = 0;
    public int maxFrame;
    public boolean isLimit = false;
    public boolean isNeed = true;

    public Animation(Vector<Sprite> sprite, int delay)
    {
        currentDelay = delay;
        settingDelay = delay;
        sprites = sprite;
        maxFrame = sprite.size() - 1;
    }

    public void refresh()
    {
        isNeed = true;
        currentDelay = settingDelay;
        currentFrame = 0;
    }

    public void act()
    {
        currentDelay--;
        if (currentDelay <= 0) {
            if (isLimit && currentFrame >= maxFrame) {
                isNeed = false;
            } else {
                currentFrame++;
                if (currentFrame > maxFrame) {
                    if (isLimit) {
                        currentFrame = maxFrame;
                    }
                    currentFrame = 0;
                }
                currentDelay = settingDelay;
            }
        }
    }

    public Sprite getSprite()
    {
        return sprites.get(currentFrame);
    }

    public void dispose()
    {
//        for (int i = 0; i < sprites.size(); i ++) {
//            sprites.get(i).getTexture().dispose();
//        }
    }
}
