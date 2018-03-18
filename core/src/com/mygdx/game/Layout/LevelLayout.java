package com.mygdx.game.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Configuration;
import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Params;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Levels.ILevel;
import com.mygdx.game.Levels.two.Level2;
import com.mygdx.game.Models.Logic.LevelAttribute;
import com.mygdx.game.MyGdxGame;

import java.util.Vector;

/**
 * Created by artem on 10/6/17.
 */

public class LevelLayout implements ILayout {
    Sprite plate = new Sprite(new Texture("ui/plato/panel_plat.png"));
    Sprite exitCircle = new Sprite(new Texture("ui/plato/buttonRound_brown.png"));
    Sprite exitCross = new Sprite(new Texture("ui/plato/iconCross_beige.png"));
    public BitmapFont font = Tex.generateFont("ui/fonts/font1.ttf", 40, Color.BROWN);

    Vector<LevelAttribute> vector = new Vector<LevelAttribute>();

    int timeout = 10;

    public LevelLayout() {
        vector.add(new LevelAttribute(new Vector2(50, 320), Configuration.levelPlayerDamage, Configuration.levelMaxPlayerDamage, L.t("Damage")));
        vector.add(new LevelAttribute(new Vector2(250, 320), Configuration.levelPlayerMaxHp, Configuration.levelMaxPlayerMaxHp, L.t("Health")));
        vector.add(new LevelAttribute(new Vector2(460, 320), Configuration.levelPlayerAtackAnimationSpeed, Configuration.levelMaxPlayerAtackAnimationSpeed, L.t("Attack speed")));
        vector.add(new LevelAttribute(new Vector2(670, 320), Configuration.levelPlayerDefAnimationSpeed, Configuration.levelMaxPlayerDefAnimationSpeed, L.t("Defend speed")));
        vector.add(new LevelAttribute(new Vector2(880, 320), Configuration.levelPlayerAtackDelay, Configuration.levelMaxPlayerAtackDelay, L.t("Attack delay")));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        GameLayout.cameraDynamic.update();
        batch.draw(this.plate, 0, 50, GameLayout.cameraDynamic.viewportWidth, GameLayout.cameraDynamic.viewportHeight);
        font.draw(batch, L.t("Available points: " + Configuration.levelPoints), 0, 500, GameLayout.cameraDynamic.viewportWidth, 1, true);
        batch.draw(this.exitCircle, GameLayout.cameraDynamic.viewportWidth - 70, GameLayout.cameraDynamic.viewportHeight - 70 + 50, 60, 60);
        batch.draw(this.exitCross, GameLayout.cameraDynamic.viewportWidth - 52, GameLayout.cameraDynamic.viewportHeight - 51 + 50, 25, 25);
        for (int i = 0; i < vector.size(); i ++) {
            vector.get(i).render(batch);
        }
    }

    @Override
    public void input() {
        timeout--;
        if (timeout >= 0) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (Gdx.input.isTouched(i)) {
                Vector3 position = GameLayout.cameraDynamic.unproject(new Vector3(Gdx.input.getX(i), Gdx.input.getY(i), 0));
                if (position.x > 1030 && position.x < 1030 + 80 && position.y > 521 && position.y < 521 + 80) {
                    MyGdxGame.layoutManager.pop();
                }
            }
        }
        for (int i = 0; i < vector.size(); i ++) {
            vector.get(i).input();
        }
    }

    @Override
    public void dispose() {
        this.exitCircle.getTexture().dispose();
        this.plate.getTexture().dispose();
        this.exitCross.getTexture().dispose();
        for (int i = 0; i < vector.size(); i ++) {
            vector.get(i).dispose();
        }
    }
}
