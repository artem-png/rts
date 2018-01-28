package com.mygdx.game.Levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Models.Characters.Classes.AEnemy;
import com.mygdx.game.Models.Characters.Classes.Player;
import com.mygdx.game.Models.Characters.ScreenAnimation.AnimationFabric;

import java.util.Vector;

/**
 * Created by User on 20.01.2018.
 */

public interface ILevel {

    public void render(SpriteBatch batch);
    public void act();
    public void dispose();
    public Player getPlayer();
    public void addEnemy(AEnemy enemy);
    public Vector<AEnemy> getEnemies();
    public int getAliveEnemiesCount();
    public void setPlayer(Player player, int size, float xoffset, float yoffset);
    public void setStatus(int status);
    public AnimationFabric getAnimationFabric();
}
