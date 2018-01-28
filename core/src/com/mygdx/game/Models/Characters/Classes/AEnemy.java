package com.mygdx.game.Models.Characters.Classes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Layout.GameLayout;

/**
 * Created by User on 25.01.2018.
 */

public abstract class AEnemy extends AModel {
    int constandSpeed;

    public void act() {
        super.act();
        if (GameLayout.level.getPlayer() == null) {
            animationManager.act(status);
            return;
        }
        if (this.status != DEAD) {
            atackModel.act(checkPlayerOverlap());
            if (GameLayout.level.getPlayer().status == DEAD) {
                this.status = STAND;
                atackModel.isWorking = false;
            } else if (checkPlayerOverlap() || atackModel.isWorking) {
                if (!atackModel.isWorking) {
                    atackModel.atack(true);
                }
                this.opponent = GameLayout.level.getPlayer();
                GameLayout.level.getPlayer().opponent = this;
                this.status = AModel.ATACK;
                this.speed.set(0, 0);
            } else {
                if (GameLayout.level.getPlayer().opponent == this) {
                    GameLayout.level.getPlayer().opponent = null;
                }
                this.opponent = null;
                this.status = AModel.RUN;
                setSpeedToPlayer();
                position.x += speed.x;
                position.y += speed.y;
                rectangle.setPosition(position.x - animationManager.getFrame(status).getWidth() / 2, position.y);
            }
            setSideToPlayer();
        }
        animationManager.act(status);

    }

    public boolean checkPlayerOverlap()
    {
        if (GameLayout.level.getPlayer() != null) {
            return this.rectangle.overlaps(GameLayout.level.getPlayer().getRectangle());
        }

        return false;
    }

    public void setSideToPlayer()
    {
        if (GameLayout.level.getPlayer() == null) {
            side = 1;
        }
        if (GameLayout.level.getPlayer().getPosition().x > this.position.x - animationManager.getFrame(status).getWidth()/2 ) {
            side = 1;
        } else {
            side = 2;
        }
    }

    public void setSpeedToPlayer()
    {
        if (GameLayout.level.getPlayer() == null) {
            return;
        }
        if (GameLayout.level.getPlayer().getPosition().x > this.position.x) {
            this.speed.set(constandSpeed, 0);
        } else {
            this.speed.set(-constandSpeed, 0);
        }
    }

    public void render(SpriteBatch batch)
    {
         if (atackModel.isWorking && status != DEAD) {
            if (side == 2) {
                atackModel.getFrame().setFlip(true, false);
            } else {
                atackModel.getFrame().setFlip(false, false);
            }
            batch.draw(
                    atackModel.getFrame(),
                    position.x - atackModel.getFrame().getWidth()/2,
                    position.y,
                    atackModel.getFrame().getWidth(),
                    atackModel.getFrame().getHeight()
            );
        } else {
            if (side == 2) {
                animationManager.getFrame(status).setFlip(true, false);
            } else {
                animationManager.getFrame(status).setFlip(false, false);
            }
            batch.draw(
                    animationManager.getFrame(status),
                    position.x - animationManager.getFrame(status).getWidth() / 2,
                    position.y,
                    animationManager.getFrame(status).getWidth(),
                    animationManager.getFrame(status).getHeight()
            );
        }
    }

    public float getFrameOffset()
    {
      return animationManager.getFrame(status).getWidth() / 2;
    }
}
