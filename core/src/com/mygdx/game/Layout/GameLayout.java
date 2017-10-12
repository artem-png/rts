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
import com.mygdx.game.process.IProcess;

import java.util.Vector;

/**
 * Created by artem on 10/6/17.
 */

public class GameLayout implements ILayout {
    public static Vector<IProcess> gameProcesses;
    public static OrthographicCamera camera;
    private GameInputProcessor gameInputProcessor;

    public GameLayout() {
        gameProcesses = new Vector<IProcess>();
        gameProcesses.add(new GameProcess());
        camera = new OrthographicCamera(Gdx.graphics.getWidth() * 0.5f * (float) Math.sqrt((double) Tex.x), Gdx.graphics.getHeight() * 0.5f * (float) Math.sqrt((double) Tex.x));
        camera.position.set(500, 500, 0);
        camera.zoom = 1.7f;
        camera.update();
        gameInputProcessor = new GameInputProcessor(camera);
        Gdx.input.setInputProcessor(new GestureDetector(gameInputProcessor));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
        camera.update();
        gameProcesses.lastElement().act(batch);
    }

    @Override
    public void input() {
        gameProcesses.lastElement().input();
        /**
         * FOR DESKTOP
         */
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.zoom += 0.02;
            if (camera.zoom > 1.7f) {
                camera.zoom = 1.7f;
            }
            camera.zoom = MathUtils.clamp(camera.zoom, 0.2f, Gdx.graphics.getWidth() * 0.5f * Tex.x / camera.viewportWidth);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.zoom -= 0.02;
            if (camera.zoom < 0.4f) {
                camera.zoom = 0.4f;
            }
            camera.zoom = MathUtils.clamp(camera.zoom, 0.2f, Gdx.graphics.getWidth() * 0.5f * Tex.x / camera.viewportWidth);
        }
    }

    @Override
    public void dispose() {
    }


    public static void addProcess(IProcess process) {
        gameProcesses.add(process);
    }

    public static void removeProcess() {
        gameProcesses.remove(gameProcesses.size() - 1);
    }
}
