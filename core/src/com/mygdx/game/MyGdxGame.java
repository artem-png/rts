package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Config.Params;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Layout.LayoutManager;

public class MyGdxGame extends ApplicationAdapter {
    public static SpriteBatch batch;
    public static Tex tex;
    public static Params params;
    public static LayoutManager layoutManager;
    public static BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        tex = new Tex();
        params = new Params();
        layoutManager = new LayoutManager();
        layoutManager.push(new GameLayout());
        font= new BitmapFont();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        layoutManager.render(batch);
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 20, 300);
        batch.setProjectionMatrix(GameLayout.camera.combined);
        batch.end();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
