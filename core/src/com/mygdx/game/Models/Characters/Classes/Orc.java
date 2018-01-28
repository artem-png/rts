package com.mygdx.game.Models.Characters.Classes;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Params;

/**
 * Created by User on 21.01.2018.
 */

public class Orc extends AEnemy {

    public Orc(int type, int x, int y, int hp, int atackDelay, int damage, int speed)
    {
        constandSpeed = speed;
        initAnimationManager(type);
        initAtackComponent(atackDelay);
        this.speed = new Vector2(0, 0);
        position = new Vector2(x, y);
        size = new Vector2(100, 100);
        status = Orc.RUN;
        rectangle = new Rectangle();
        rectangle.set(position.x - animationManager.getFrame(status).getWidth() / 2, position.y, 140, size.y);
        this.hp = hp;
        this.maxHp = hp;
        this.damage = damage;
    }
}
