package com.mygdx.game.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.input.GameInputProcessor;
import com.mygdx.game.process.GameProcess;

/**
 * Created by artem on 10/6/17.
 */

public class GameLayout implements ILayout {
    public GameProcess gameProcess;
    public static OrthographicCamera camera;
    private GameInputProcessor gameInputProcessor;

    public GameLayout() {
        gameProcess = new GameProcess();
        camera = new OrthographicCamera(Gdx.graphics.getWidth() * 1.3f * (float)Math.sqrt((double)Tex.x), Gdx.graphics.getHeight() * 1.3f * (float)Math.sqrt((double)Tex.x));
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
        gameProcess.render(batch);
    }

    @Override
    public void input() {
        gameProcess.input();
        /**
         * FOR DESKTOP
         */
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.zoom += 0.02;
            if (camera.zoom > 1.0) {
                camera.zoom = 1.0f;
            }
            camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, Gdx.graphics.getWidth() * 1.3f * Tex.x/camera.viewportWidth);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.zoom -= 0.02;
            if (camera.zoom < 0.4f) {
                camera.zoom = 0.4f;
            }
            camera.zoom = MathUtils.clamp(camera.zoom, 0.1f, Gdx.graphics.getWidth() * 1.3f * Tex.x/camera.viewportWidth);
        }
    }

    @Override
    public void dispose() {
    }
}
