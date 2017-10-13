package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Config.Config;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Layout.LayoutManager;
import com.mygdx.game.Layout.MenuLayout;

import java.util.Locale;

public class MyGdxGame extends ApplicationAdapter {
	public static SpriteBatch batch;
	public static Tex tex;
	public static Config config;
	public static LayoutManager layoutManager;

	@Override
	public void create () {
		batch = new SpriteBatch();
		tex = new Tex();
		config = new Config();
		layoutManager = new LayoutManager();
		layoutManager.push(new GameLayout());
	}

	@Override
	public void render () {
		long start = System.nanoTime();
		//Gdx.gl.glClearColor(30/256f, 30/256f, 30/256f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		layoutManager.render(batch);
		batch.end();
		long finish = System.nanoTime();
		long timeConsumedMillis = (finish - start) / 100000;
		System.out.println("total: " + timeConsumedMillis + " ");
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
