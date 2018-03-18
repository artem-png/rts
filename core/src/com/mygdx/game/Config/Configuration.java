package com.mygdx.game.Config;

import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.Models.Characters.Classes.Player;

/**
 * Created by User on 26.01.2018.
 */

public class Configuration {

    public static int playerMaxHp = 12;
    public static int playerAtackDelay = 40;
    public static int playerSpeed = 3;
    public static int playerDamage = 1;
    public static int playerDefAnimationSpeed = 4;
    public static int playerAtackAnimationSpeed = 4;

    public static int levelPlayerMaxHp = 1;
    public static int levelPlayerAtackDelay = 1;
    public static int levelPlayerSpeed = 1;
    public static int levelPlayerDamage = 1;
    public static int levelPlayerDefAnimationSpeed = 1;
    public static int levelPlayerAtackAnimationSpeed = 1;

    public static int levelMaxPlayerMaxHp = 3;
    public static int levelMaxPlayerAtackDelay = 3;
    public static int levelMaxPlayerDamage = 3;
    public static int levelMaxPlayerDefAnimationSpeed = 3;
    public static int levelMaxPlayerAtackAnimationSpeed = 3;

    public static boolean isShowTutorial = false;
    public static int levelPoints = 0;

    public Configuration()
    {

    }

    public static void initConfiguration() {
        Player player = GameLayout.level.getPlayer();
        if (levelMaxPlayerMaxHp == 1) {
            player.maxHp = 13;
            player.hp = 13;
        }
        if (levelMaxPlayerMaxHp == 2) {
            player.maxHp = 17;
            player.hp = 17;
        }
        if (levelMaxPlayerMaxHp == 2) {
            player.maxHp = 21;
            player.hp = 21;
        }

        if (levelPlayerDamage == 1) {
            player.damage = 1;
        }
        if (levelPlayerDamage == 2) {
            player.damage = 2;
        }
        if (levelPlayerDamage == 2) {
            player.damage = 3;
        }

        if (levelPlayerAtackDelay == 1) {
            player.atackModel.delay = 40;
        }
        if (levelPlayerAtackDelay == 2) {
            player.atackModel.delay = 30;
        }
        if (levelPlayerAtackDelay == 3) {
            player.atackModel.delay = 20;
        }

        if (levelPlayerDefAnimationSpeed == 1) {
            player.defModel.animationDefend.settingDelay = 4;
        }
        if (levelPlayerDefAnimationSpeed == 2) {
            player.defModel.animationDefend.settingDelay = 3;
        }
        if (levelPlayerDefAnimationSpeed == 3) {
            player.defModel.animationDefend.settingDelay = 2;
        }

        if (levelPlayerAtackAnimationSpeed == 1) {
            player.atackModel.animation.settingDelay = 4;
        }
        if (levelPlayerAtackAnimationSpeed == 2) {
            player.atackModel.animation.settingDelay = 3;
        }
        if (levelPlayerAtackAnimationSpeed == 3) {
            player.atackModel.animation.settingDelay = 2;
        }
    }
}
