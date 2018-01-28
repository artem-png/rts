package com.mygdx.game.Levels;

import com.badlogic.gdx.input.GestureDetector;

/**
 * Created by User on 21.01.2018.
 */

public interface InputProccessor extends GestureDetector.GestureListener{
    public void setEnabled(boolean isEnabled);
}
