package com.mygdx.game.Models.Logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Component.LevelComponent;
import com.mygdx.game.Config.Configuration;
import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Layout.LevelLayout;
import com.mygdx.game.MyGdxGame;

/**
 * Created by User on 18.03.2018.
 */

public class LevelAttribute {
    public Vector2 position;
    public int currentLevel;
    public int maxLevel;
    public String name;
    Sprite buttonLong = new Sprite(new Texture("ui/plato/buttonLong_brown_pressed.png"));
    Sprite bar = new Sprite(new Texture("ui/plato/barRed_horizontalMid.png"));
    Sprite check = new Sprite(new Texture("ui/plato/iconCheck_beige.png"));
    Sprite circle = new Sprite(new Texture("ui/plato/buttonRound_brown.png"));
    public BitmapFont font = Tex.generateFont("ui/fonts/font1.ttf", 30, Color.BROWN);

    int barX = 170;
    int baxY = 32;

    public LevelAttribute(Vector2 position, int level, int maxLevel, String name) {
        this.position = position;
        this.currentLevel = level;
        this.maxLevel = maxLevel;
        this.name = name;
    }

    public void render(SpriteBatch batch) {
        batch.draw(this.buttonLong, position.x, position.y, barX, baxY);
        font.draw(batch, this.name, position.x, position.y + 70, barX, 1, true);
        for (int i = 1; i <= currentLevel; i++) {
            batch.draw(bar, position.x + 7 * i + (i - 1) * 47, position.y + 5, 47, 22);
        }
        if (currentLevel < maxLevel && Configuration.levelPoints > 0) {
            batch.draw(circle, position.x + 60, position.y - 80, 50, 50);
            batch.draw(check, position.x + 75, position.y - 65, 20, 20);
        }
    }

    public void input() {
        if (currentLevel < maxLevel && Configuration.levelPoints > 0) {
            for (int i = 0; i < 2; i++) {
                if (Gdx.input.justTouched() && Gdx.input.isTouched(i)) {
                    Vector3 positionClick = GameLayout.cameraDynamic.unproject(new Vector3(Gdx.input.getX(i), Gdx.input.getY(i), 0));
                    if (positionClick.x > position.x + 40 && positionClick.x < position.x + 60 + 70 && positionClick.y > position.y - 100 && positionClick.y < position.y - 80 + 70) {
                        Configuration.levelPoints--;
                        if (this.name.equals(L.t("Damage"))) {
                            Configuration.levelPlayerDamage++;
                        }
                        if (this.name.equals(L.t("Health"))) {
                            Configuration.levelPlayerMaxHp++;
                        }
                        if (this.name.equals(L.t("Attack speed"))) {
                            Configuration.levelPlayerAtackAnimationSpeed++;
                        }
                        if (this.name.equals(L.t("Defend speed"))) {
                            Configuration.levelPlayerDefAnimationSpeed++;
                        }
                        if (this.name.equals(L.t("Attack delay"))) {
                            Configuration.levelPlayerAtackDelay++;
                        }
                        this.currentLevel++;
                        Configuration.initConfiguration();
                        return;
                    }
                }
            }
        }
    }

    public void dispose() {
        bar.getTexture().dispose();
        buttonLong.getTexture().dispose();
        check.getTexture().dispose();
        circle.getTexture().dispose();
        font.dispose();
    }
}
