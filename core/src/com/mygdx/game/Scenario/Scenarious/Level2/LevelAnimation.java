package com.mygdx.game.Scenario.Scenarious.Level2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Config.Configuration;
import com.mygdx.game.Config.L;
import com.mygdx.game.Config.Params;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Models.Characters.CharacterAnimation.Animation;
import com.mygdx.game.Scenario.Scenarious.Scenario;

import java.util.Vector;

/**
 * Created by User on 27.01.2018.
 */

public class LevelAnimation extends Scenario {
    protected Animation animation;
    public BitmapFont font = Tex.generateFont("ui/fonts/font1.ttf", 40, Color.WHITE);
    public Sprite coin = new Sprite(new Texture("ui/HPKE0551.png"));
    int textTime = 36;

    int delay = 2;
    int constDelay = 2;

    float fontSize = 1.4f;
    float sinA = 0.4f;

    public LevelAnimation() {
        isParalel = false;
        isTimeLimit = false;
        name = "level_animation";
        Vector<Sprite> vector = new Vector<Sprite>();
        vector.add(new Sprite(new Texture("effects/cloud1/image_part_003.png")));
        vector.add(new Sprite(new Texture("effects/cloud1/image_part_004.png")));
        vector.add(new Sprite(new Texture("effects/cloud1/image_part_005.png")));
        vector.add(new Sprite(new Texture("effects/cloud1/image_part_006.png")));
        vector.add(new Sprite(new Texture("effects/cloud1/image_part_007.png")));
        vector.add(new Sprite(new Texture("effects/cloud1/image_part_008.png")));
        vector.add(new Sprite(new Texture("effects/cloud1/image_part_009.png")));
        vector.add(new Sprite(new Texture("effects/cloud1/image_part_010.png")));
        vector.add(new Sprite(new Texture("effects/cloud1/image_part_011.png")));
        vector.add( new Sprite(new Texture("effects/cloud1/image_part_012.png")));
        vector.add( new Sprite(new Texture("effects/cloud1/image_part_013.png")));
        vector.add( new Sprite(new Texture("effects/cloud1/image_part_014.png")));
        vector.add( new Sprite(new Texture("effects/cloud1/image_part_015.png")));
        vector.add( new Sprite(new Texture("effects/cloud1/image_part_016.png")));
        vector.add( new Sprite(new Texture("effects/cloud1/image_part_017.png")));
        vector.add( new Sprite(new Texture("effects/cloud1/image_part_018.png")));

        this.animation = new Animation(vector, 5);
        this.animation.isLimit = true;
    }

    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        if (textTime <= 0) {
            font.draw(batch, L.t("Level Up!"), 340, 375, 410, 1, true);
        }
        if (animation.isNeed) {
            batch.draw(this.animation.getSprite(), 100, 100, 900, 500);
        }
        batch.setProjectionMatrix(GameLayout.camera.combined);
    }

    public void act() {
        super.act();
        this.animation.act();
        textTime--;
        if (!this.animation.isNeed) {
            if (Gdx.input.justTouched()) {
                Configuration.isShowTutorial = true;
                Configuration.levelPoints += 2;
                GameLayout.level.getPlayer().level++;
                isActive = false;
            }
        }
        delay--;
        if (delay <= 0 && textTime <= 0) {
            delay = constDelay;
            sinA += 0.1;
            fontSize += Math.sin(sinA) / 20;
            font.getData().setScale(fontSize);
        }
        GameLayout.level.setStatus(2);
    }

    @Override
    public void dispose() {
        GameLayout.level.setStatus(1);
        super.dispose();
        this.animation.dispose();
        this.font.dispose();
    }
}

