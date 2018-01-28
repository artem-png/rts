package com.mygdx.game.Scenario.Scenarious.Dialog;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by User on 27.01.2018.
 */

public class DialogSpeech {
    public Sprite hero;
    public String text;
    public boolean revert;

    public DialogSpeech(Sprite hero, String text, boolean revert)
    {
        this.hero = hero;
        this.text = text;
        this.revert = revert;
    }

    public void dispose()
    {
        this.hero.setFlip(false, false);
    }
}
