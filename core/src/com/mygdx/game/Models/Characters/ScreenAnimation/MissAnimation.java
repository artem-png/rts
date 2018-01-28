package com.mygdx.game.Models.Characters.ScreenAnimation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Models.Characters.Classes.AModel;
import com.mygdx.game.Models.Characters.Classes.Orc;
import com.mygdx.game.Models.Characters.Classes.Player;

import java.util.Random;
import java.util.Vector;

/**
 * Created by User on 25.01.2018.
 */

public class MissAnimation implements IScreenAnimation {
    public Vector2 position;
    public AModel model;
    public boolean isAlive = true;
    int timer = 30;
    Random random = new Random();
    int xoffset;
    double a = 0;

    public MissAnimation(AModel model) {
        if (model instanceof Player) {
            xoffset = 10;
        } else if (model instanceof Orc) {
            xoffset = -10;
        }
        this.model = model;
        position = new Vector2(model.getPosition());
    }

    public void render(SpriteBatch batch) {
        a += 0.3;
        AnimationFabric.miss.setColor(Color.RED.r, Color.RED.g, Color.RED.b, 1 - (float) ((30 - timer) * 3) / 100);
        AnimationFabric.miss.draw(batch, "Miss", (float) (position.x + Math.sin(a) * 10 + xoffset), (float) (position.y + 150 + Math.sqrt((double) (240 - timer * 8)) * 2));
    }

    public void act() {
        timer--;
        if (timer <= 0) {
            isAlive = false;
        }
    }

    public void dispose() {
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }
}
