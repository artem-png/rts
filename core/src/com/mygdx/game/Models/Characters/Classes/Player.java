package com.mygdx.game.Models.Characters.Classes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Params;
import com.mygdx.game.Models.Characters.HelpModel.CharacterModel;

/**
 * Created by User on 21.01.2018.
 */

public class Player extends AModel {

    public Player(int x) {
        this.maxHp = Params.playerMaxHp;
        this.hp = this.maxHp;
        this.damage = Params.playerDamage;
        initAnimationManager(CharacterModel.SAMURAI_LIGHT_HERO);
        initAtackComponent(Params.playerAtackDelay);
        initDefComponent();
        speed = new Vector2(0, 0);
        position = new Vector2(x, 187);
        size = new Vector2(60, 60);
        rectangle = new Rectangle(position.x + 30, position.y, size.x, size.y);
    }

    public void moveRight() {
        if (status != DEAD) {
            side = 1;
            status = Player.RUN;
            if ((this.opponent != null && this.opponent.side == 2) || atackModel.isWorking || defModel.isWorking) {
                stopMoving();
            } else {
                speed.set(Params.playerSpeed, 0);
            }
        }
    }

    public void moveLeft() {
        if (status != DEAD) {
            side = 2;
            status = Player.RUN;
            if ((this.opponent != null && this.opponent.side == 1) || atackModel.isWorking || defModel.isWorking) {
                stopMoving();
            } else {
                speed.set(-Params.playerSpeed, 0);
            }
        }
    }

    public void stopMoving() {
        if (status != DEAD) {
            speed.set(0, 0);
            status = Player.STAND;
        }
    }

    public void render(SpriteBatch batch) {
        if (atackModel.isWorking && this.status != DEAD) {
            if (side == 2) {
                atackModel.getFrame().setFlip(true, false);
                batch.draw(
                        atackModel.getFrame(),
                        position.x - 9,
                        position.y - 15,
                        atackModel.getFrame().getWidth(),
                        atackModel.getFrame().getHeight()
                );
            } else {
                atackModel.getFrame().setFlip(false, false);
                batch.draw(
                        atackModel.getFrame(),
                        position.x - 22,
                        position.y - 16,
                        atackModel.getFrame().getWidth(),
                        atackModel.getFrame().getHeight()
                );
            }
        } else if (defModel.isWorking && this.status != DEAD) {
            if (side == 2) {
                defModel.getFrame().setFlip(true, false);
                batch.draw(
                        defModel.getFrame(),
                        position.x - 10,
                        position.y,
                        defModel.getFrame().getWidth(),
                        defModel.getFrame().getHeight()
                );
            } else {
                defModel.getFrame().setFlip(false, false);
                batch.draw(
                        defModel.getFrame(),
                        position.x - 10,
                        position.y,
                        defModel.getFrame().getWidth(),
                        defModel.getFrame().getHeight()
                );
            }
        } else {
            if (this.status == DEAD) {
                if (side == 2) {
                    animationManager.getFrame(status).setFlip(true, false);
                    batch.draw(
                            animationManager.getFrame(status),
                            position.x,
                            position.y - 50,
                            animationManager.getFrame(status).getWidth(),
                            animationManager.getFrame(status).getHeight()
                    );
                } else {
                    animationManager.getFrame(status).setFlip(false, false);
                    batch.draw(
                            animationManager.getFrame(status),
                            position.x - 90,
                            position.y - 50,
                            animationManager.getFrame(status).getWidth(),
                            animationManager.getFrame(status).getHeight()
                    );
                }
            } else {
                if (side == 2) {
                    animationManager.getFrame(status).setFlip(true, false);
                } else {
                    animationManager.getFrame(status).setFlip(false, false);
                }
                batch.draw(
                        animationManager.getFrame(status),
                        position.x,
                        position.y,
                        animationManager.getFrame(status).getWidth(),
                        animationManager.getFrame(status).getHeight()
                );
            }
        }
    }

    public void act() {
        super.act();
        position.x += speed.x;
        position.y += speed.y;
        rectangle.set(position.x, position.y, size.x, size.y);
        animationManager.act(status);
        atackModel.act(true);
        defModel.act();
    }
}
