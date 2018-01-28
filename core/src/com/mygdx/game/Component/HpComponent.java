package com.mygdx.game.Component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Levels.ILevel;
import com.mygdx.game.Models.Characters.Classes.AModel;
import com.mygdx.game.Models.Characters.Classes.Player;
import com.mygdx.game.Models.Characters.HelpModel.CharacterModel;

/**
 * Created by User on 21.01.2018.
 */

public class HpComponent extends AComponent {
    public Sprite head;
    public Sprite headOpponent;
    public Sprite platform;
    public Sprite redLine;
    public Sprite healthLeft;
    public Sprite healthMid;
    public Sprite healthRight;
    public ILevel level;
    public Player player;

    public HpComponent(ILevel level, Player player) {
        this.level = level;
        this.player = player;
        head = new Sprite(new Texture("characters/heads/samuraiLight.png"));
        platform = new Sprite(new Texture("ui/healthbar/healthbar.png"));
        redLine = new Sprite(new Texture("ui/healthbar/heart.png"));
        healthLeft = new Sprite(new Texture("ui/healthbar/healthLeft.png"));
        healthMid = new Sprite(new Texture("ui/healthbar/healthMid.png"));
        healthRight = new Sprite(new Texture("ui/healthbar/healthRight.png"));
    }

    public String getOpponentHead() {
        if (player.opponent.type == CharacterModel.SAMURAI_LIGHT_HERO) {
            return "characters/heads/samuraiLight.png";
        } else if (player.opponent.type == CharacterModel.ORC_HUMMER) {
            return "characters/heads/orcHummer.png";
        } else {
            return "";
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(GameLayout.cameraDynamic.combined);
        drawPlayerHealth(batch);
        if (player.opponent != null) {
            if (headOpponent == null) {
                headOpponent = new Sprite(new Texture(getOpponentHead()));
            }
            drawOpponentHealth(batch);
        } else if (headOpponent != null) {
            headOpponent.getTexture().dispose();
            headOpponent = null;
        }
        batch.setProjectionMatrix(GameLayout.camera.combined);

    }

    public void drawPlayerHealth(SpriteBatch batch) {
        float delta = (float) player.maxHp / 10;
        batch.draw(platform, 90, 540 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart));
        batch.draw(head, 45, 525 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart), 60, 60);
        if (player.hp > 0) {
            batch.draw(healthLeft, 106, 551 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart));
        }
        for (int i = 1; i <= 8; i++) {
            if (player.hp > i * delta) {
                batch.draw(healthMid, 114 + 18 * (i - 1), 551 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart));
            }
        }
        if (player.hp == player.maxHp) {
            batch.draw(healthRight, 258, 551 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart));
        }
    }

    public void drawOpponentHealth(SpriteBatch batch) {
        float delta = (float) player.opponent.maxHp / 10;
        batch.draw(platform, 450, 540 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart));
        batch.draw(headOpponent, 405, 525 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart), 60, 58);
        if (player.opponent.hp > 0) {
            batch.draw(healthLeft, 466, 551 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart));
        }
        for (int i = 1; i <= 8; i++) {
            if (player.opponent.hp > i * delta) {
                batch.draw(healthMid, 474 + 18 * (i - 1), 551 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart));
            }
        }
        if (player.opponent.hp == player.opponent.maxHp) {
            batch.draw(healthRight, 618, 551 + (GameLayout.cameraDynamic.viewportHeight - Tex.cameraYStandart));
        }
    }

    @Override
    public boolean input() {

        return false;
    }

    public void dispose() {
        if (headOpponent != null) {
            headOpponent.getTexture().dispose();
        }
        head.getTexture().dispose();
        platform.getTexture().dispose();
        redLine.getTexture().dispose();
        healthLeft.getTexture().dispose();
        healthMid.getTexture().dispose();
        healthRight.getTexture().dispose();
    }
}
