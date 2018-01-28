package com.mygdx.game.Models.Characters.Classes;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Models.Characters.CharacterActions.AtackModel;
import com.mygdx.game.Models.Characters.CharacterActions.DefendModel;
import com.mygdx.game.Models.Characters.CharacterAnimation.AnimationManager;
import com.mygdx.game.Models.Characters.HelpModel.CharacterModel;
import com.mygdx.game.Models.Characters.CharacterActions.Punch;
import com.mygdx.game.Models.Characters.ScreenAnimation.DamageAnimation;
import com.mygdx.game.Models.Characters.ScreenAnimation.MissAnimation;

/**
 * Created by User on 21.01.2018.
 */

public abstract class AModel implements IModel {
    public AnimationManager animationManager;
    public int status = STAND;
    public Vector2 speed;
    public Rectangle rectangle;
    public Vector2 position;
    public Vector2 size;
    public int side = 1;
    public int hp;
    public int maxHp;
    public int damage;
    public AModel opponent;
    public AtackModel atackModel;
    public DefendModel defModel;
    public int type;

    public static final int STAND = 1;
    public static final int RUN = 2;
    public static final int ATACK = 3;
    public static final int DEAD = 4;

    public void atack(boolean isNear) {
        if (atackModel != null && !atackModel.isWorking && !defModel.isWorking) {
            atackModel.atack(isNear);
        }
    }

    public void defend()
    {
        if (defModel != null && !atackModel.isWorking) {
            defModel.defend();
        }
    }

    public void unDefend()
    {
        if (defModel != null && defModel.isWorking) {
            defModel.unDefend();
        }
    }

    public void act()
    {
        if (hp <= 0 && this.status != DEAD) {
            this.status  = DEAD;
            this.speed.set(0, 0);
            if (this.opponent != null) {
                this.opponent.opponent = null;
                this.opponent = null;
            }
        }
    }

    public void stopAtack() {}

    public Vector2 getPosition() {
        return position;
    }

    public void initAtackComponent(int delay) {
        this.atackModel = new AtackModel(this.animationManager.atack, delay, this);
    }

    public void initDefComponent() {
        this.defModel = new DefendModel(this.animationManager.defend, this.animationManager.unDefend, this);
    }

    public void initAnimationManager(int heroType) {
        type = heroType;
        CharacterModel model = new CharacterModel(heroType);
        this.animationManager = model.animationManager;
    }

    public void getPunch(Punch punch)
    {
        if (this.rectangle.overlaps(punch.radius) && (defModel == null || !defModel.isDefend || opponent.side == this.side)) {
            this.hp -= punch.dealer.damage;
            GameLayout.level.getAnimationFabric().add(new DamageAnimation(this));
        } else {
            if (this.opponent != null) {
                GameLayout.level.getAnimationFabric().add(new MissAnimation(this.opponent));
            }
        }
    }

    public Sprite getCurrentFrame()
    {
        return this.animationManager.getFrame(status);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void dispose() {
        animationManager.dispose();
    }

    public float getFrameOffset()
    {
      return 0;
    }
}
