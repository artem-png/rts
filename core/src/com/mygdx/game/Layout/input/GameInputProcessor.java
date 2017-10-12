package com.mygdx.game.Layout.input;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.models.map.BlockMap;

/**
 * Created by artem on 10/9/17.
 */

public class GameInputProcessor implements GestureDetector.GestureListener {
    OrthographicCamera camera;
    private Vector2 oldInitialFirstPointer = null, oldInitialSecondPointer = null;
    private float oldScale;

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
        camera.translate(-deltaX * camera.zoom * (float)Math.sqrt((double)Tex.x) * 0.5f, deltaY * camera.zoom * (float)Math.sqrt((double)Tex.y) * 0.5f);
        if (camera.position.x < 0) {
            camera.position.x = 0;
        }
        if (camera.position.x > BlockMap.sizeX * 30 * Tex.x) {
            camera.position.x = BlockMap.sizeX * 30 * Tex.x;
        }
        if (camera.position.y < 0) {
            camera.position.y = 0;
        }
        if (camera.position.y > BlockMap.sizeY * 30 * Tex.y) {
            camera.position.y = BlockMap.sizeY * 30 * Tex.x;
        }
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
        if (!(initialFirstPointer.equals(oldInitialFirstPointer) && initialSecondPointer.equals(oldInitialSecondPointer))) {
            oldInitialFirstPointer = initialFirstPointer.cpy();
            oldInitialSecondPointer = initialSecondPointer.cpy();
            oldScale = camera.zoom;
        }
        Vector3 center = new Vector3(
                (firstPointer.x + initialSecondPointer.x) / 2,
                (firstPointer.y + initialSecondPointer.y) / 2,
                0
        );
        zoomCamera(center, oldScale * initialFirstPointer.dst(initialSecondPointer) / firstPointer.dst(secondPointer));
        return true;
    }

    private void zoomCamera(Vector3 origin, float scale) {
        camera.update();
        Vector3 oldUnprojection = camera.unproject(origin.cpy()).cpy();
        camera.zoom = scale;
        camera.zoom = Math.min(2.0f, Math.max(camera.zoom, 0.5f));
        if (camera.zoom > 1.7) {
            camera.zoom = 1.7f;
        }
        if (camera.zoom < 0.4f) {
            camera.zoom = 0.4f;
        }
        camera.update();
        Vector3 newUnprojection = camera.unproject(origin.cpy()).cpy();
        camera.position.add(oldUnprojection.cpy().add(newUnprojection.cpy().scl(-1f)));
    }

    @Override
    public void pinchStop() {

    }
}
