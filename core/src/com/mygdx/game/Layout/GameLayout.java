package com.mygdx.game.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Layout.input.GameInputProcessor;
import com.mygdx.game.models.map.Map;

/**
 * Created by artem on 10/6/17.
 */

public class GameLayout implements ILayout {
    public static Map map;
    public static OrthographicCamera camera;
    private GameInputProcessor gameInputProcessor;

    public GameLayout() {
        map = new Map();
        camera = new OrthographicCamera(1600, 900);
        camera.position.set(0, 0, 0);
        camera.zoom = 1f;
        camera.update();
        gameInputProcessor = new GameInputProcessor(camera);
        Gdx.input.setInputProcessor(new GestureDetector(gameInputProcessor));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
        camera.update();
        map.act(batch);
    }

    @Override
    public void input() {
        /**
         * FOR DESKTOP
         */
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.zoom += 0.02;
            if (camera.zoom > 1.0) {
                camera.zoom = 1.0f;
            }
            camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, 1600/camera.viewportWidth);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.zoom -= 0.02;
            if (camera.zoom < 0.4f) {
                camera.zoom = 0.4f;
            }
            camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, 1600/camera.viewportWidth);
        }
    }

    @Override
    public void dispose() {
    }
}
