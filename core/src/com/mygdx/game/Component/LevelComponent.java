package com.mygdx.game.Component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Configuration;
import com.mygdx.game.Config.Params;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Layout.LayoutManager;
import com.mygdx.game.Layout.LevelLayout;
import com.mygdx.game.Levels.ILevel;
import com.mygdx.game.MyGdxGame;

/**
 * Created by User on 21.01.2018.
 */

public class LevelComponent extends AComponent {
    public ILevel level;
    Sprite star = new Sprite(new Texture("ui/levelbar/star.png"));
    Sprite button = new Sprite(new Texture("ui/levelbar/button.png"));
    Sprite head = new Sprite(new Texture("characters/heads/samuraiLight.png"));
    boolean isAlwaysNeed = false;

    float sinA = 1f;

    public LevelComponent(boolean isAlwaysNeed) {
        this.isAlwaysNeed = isAlwaysNeed;
    }

    @Override
    public void render(SpriteBatch batch) {
        if (isAlwaysNeed || this.isNeed()) {
            batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
            batch.draw(button, 1043, 530, 50, 50);
            batch.draw(head, 1048, 535, 40, 40);
            if (Configuration.levelPoints > 0) {
                batch.draw(star, 1034, 521, 16, 16, 32, 32, star.getScaleX(), star.getScaleY(), star.getRotation());
            }
            batch.setProjectionMatrix(GameLayout.camera.combined);
        }

    }

    public boolean isNeed() {
        return Configuration.isShowTutorial;
    }

    public void act() {
        this.sinA += 0.07;
        this.star.setRotation(this.star.getRotation() + (float) Math.sin(this.sinA) * 2);
    }

    @Override
    public boolean input() {
        this.act();
        if (isAlwaysNeed || this.isNeed()) {
            for (int i = 0; i < 2; i++) {
                if (Gdx.input.justTouched() && Gdx.input.isTouched(i)) {
                    Vector3 position = GameLayout.cameraDynamic.unproject(new Vector3(Gdx.input.getX(i), Gdx.input.getY(i), 0));
                    if (position.x > 1030 && position.x < 1030 + 80 && position.y > 521 && position.y < 521 + 80) {
                        MyGdxGame.layoutManager.push(new LevelLayout());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void dispose() {
        star.getTexture().dispose();
        button.getTexture().dispose();
        head.getTexture().dispose();
    }
}
