package com.mygdx.game.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Levels.ILevel;
import com.mygdx.game.Levels.one.Level1;
import com.mygdx.game.Levels.two.Level2;

/**
 * Created by artem on 10/6/17.
 */

public class GameLayout implements ILayout {
    public static OrthographicCamera camera;
    public static OrthographicCamera cameraDynamic;
    public static ILevel level;

    public GameLayout() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(1100, 1100 * (h / w));
        camera.position.set(1100/2,  1100 * (h / w)/2 + 50, 0);

        cameraDynamic = new OrthographicCamera(1100, 1100 * (h / w));
        cameraDynamic.position.set(1100/2,  1100 * (h / w)/2 + 50, 0);
        cameraDynamic.update();

        level = new Level1();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
        camera.update();
        level.render(batch);
    }

    @Override
    public void input() {
        level.act();
    }

    @Override
    public void dispose() {
        level.dispose();
    }
}
