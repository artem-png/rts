package com.mygdx.game.Levels.one.InputListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Levels.InputProccessor;

/**
 * Created by artem on 10/9/17.
 */

public class GameInputProcessor implements InputProccessor {
    OrthographicCamera camera;
    public boolean isEnabled = true;
    float vb = 0;

    public GameInputProcessor(OrthographicCamera camera) {
        this.camera = camera;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        if (!isEnabled) {
            return false;
        }
//        camera.translate(-deltaX * camera.zoom * (float) Math.sqrt((double) Tex.x) * 0.5f, 0);
//        if (camera.position.x < 1100/ 2) {
//            camera.position.x = 1100 / 2;
//        }
//        float a = 1100/ 32;
//        float l = (camera.position.x - 1100 / 2) / 32;
//        if (a + l >= 49.5f) {
//            camera.position.x = 1100 / 2 + (49.5f - a) * 32;
//        }
//        camera.position.x = (int)camera.position.x;
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialFirstPointer, Vector2 initialSecondPointer, Vector2 firstPointer, Vector2 secondPointer) {
        return true;
    }

    private void zoomCamera(Vector3 origin, float scale) {
    }

    @Override
    public void pinchStop() {

    }

    @Override
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}
