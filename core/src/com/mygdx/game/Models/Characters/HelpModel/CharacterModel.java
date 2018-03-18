package com.mygdx.game.Models.Characters.HelpModel;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Config.Configuration;
import com.mygdx.game.Config.Params;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Models.Characters.CharacterAnimation.Animation;
import com.mygdx.game.Models.Characters.CharacterAnimation.AnimationManager;

import java.util.Vector;

/**
 * Created by User on 21.01.2018.
 */

public class CharacterModel {
    public final static int SAMURAI_LIGHT_HERO = 1;
    public final static int ORC_HUMMER = 2;
    public AnimationManager animationManager;

    public CharacterModel(int heroId)
    {
        animationManager = new AnimationManager();
        if (heroId == CharacterModel.SAMURAI_LIGHT_HERO) {
            Vector<Sprite>  spritesStand = new Vector<Sprite>();
            spritesStand.add(Tex.Samurai_light_stand_1);
            spritesStand.add(Tex.Samurai_light_stand_2);
            spritesStand.add(Tex.Samurai_light_stand_3);
            spritesStand.add(Tex.Samurai_light_stand_4);
            spritesStand.add(Tex.Samurai_light_stand_5);
            spritesStand.add(Tex.Samurai_light_stand_6);
            spritesStand.add(Tex.Samurai_light_stand_7);
            spritesStand.add(Tex.Samurai_light_stand_8);
            spritesStand.add(Tex.Samurai_light_stand_9);
            Animation animationStand = new Animation(spritesStand, 6);
            animationManager.stand = animationStand;

            Vector<Sprite>  spritesRun = new Vector<Sprite>();
            spritesRun.add(Tex.Samurai_light_run_1);
            spritesRun.add(Tex.Samurai_light_run_2);
            spritesRun.add(Tex.Samurai_light_run_3);
            spritesRun.add(Tex.Samurai_light_run_4);
            spritesRun.add(Tex.Samurai_light_run_5);
            spritesRun.add(Tex.Samurai_light_run_6);
            spritesRun.add(Tex.Samurai_light_run_7);
            spritesRun.add(Tex.Samurai_light_run_8);
            spritesRun.add(Tex.Samurai_light_run_9);
            Animation animationRun = new Animation(spritesRun, 4);
            animationManager.run = animationRun;

            Vector<Sprite>  spritesAtack = new Vector<Sprite>();
            spritesAtack.add(Tex.Samurai_light_atack_1);
            spritesAtack.add(Tex.Samurai_light_atack_2);
            spritesAtack.add(Tex.Samurai_light_atack_3);
            spritesAtack.add(Tex.Samurai_light_atack_4);
            spritesAtack.add(Tex.Samurai_light_atack_5);
            spritesAtack.add(Tex.Samurai_light_atack_6);
            spritesAtack.add(Tex.Samurai_light_atack_7);
            spritesAtack.add(Tex.Samurai_light_atack_8);
            spritesAtack.add(Tex.Samurai_light_atack_9);
            spritesAtack.add(Tex.Samurai_light_atack_10);
            Animation animationAtack = new Animation(spritesAtack, Configuration.playerAtackAnimationSpeed);
            animationManager.atack = animationAtack;

            Vector<Sprite>  spritesDie = new Vector<Sprite>();
            spritesDie.add(Tex.Samurai_light_die_1);
            spritesDie.add(Tex.Samurai_light_die_2);
            spritesDie.add(Tex.Samurai_light_die_3);
            spritesDie.add(Tex.Samurai_light_die_4);
            spritesDie.add(Tex.Samurai_light_die_5);
            spritesDie.add(Tex.Samurai_light_die_6);
            spritesDie.add(Tex.Samurai_light_die_7);
            spritesDie.add(Tex.Samurai_light_die_8);
            spritesDie.add(Tex.Samurai_light_die_9);
            spritesDie.add(Tex.Samurai_light_die_10);
            Animation animationDie = new Animation(spritesDie, 3);
            animationDie.isLimit = true;
            animationManager.die = animationDie;

            Vector<Sprite>  spritesDef = new Vector<Sprite>();
            spritesDef.add(Tex.Samurai_light_def_1);
            spritesDef.add(Tex.Samurai_light_def_2);
            spritesDef.add(Tex.Samurai_light_def_3);
            spritesDef.add(Tex.Samurai_light_def_4);
            spritesDef.add(Tex.Samurai_light_def_5);
            Animation animationDef = new Animation(spritesDef, Configuration.playerDefAnimationSpeed);
            animationDef.isLimit = true;
            animationManager.defend = animationDef;

            Vector<Sprite>  spritesUnDef = new Vector<Sprite>();
            spritesUnDef.add(Tex.Samurai_light_def_6);
            spritesUnDef.add(Tex.Samurai_light_def_7);
            spritesUnDef.add(Tex.Samurai_light_def_8);
            spritesUnDef.add(Tex.Samurai_light_def_9);
            spritesUnDef.add(Tex.Samurai_light_def_10);
            Animation animationUnDef = new Animation(spritesUnDef, Configuration.playerDefAnimationSpeed);
            animationUnDef.isLimit = true;
            animationManager.unDefend = animationUnDef;
        } else if (heroId == CharacterModel.ORC_HUMMER) {
            Vector<Sprite>  spritesStand = new Vector<Sprite>();
            spritesStand.add(Tex.orc_hummer_stand_1);
            spritesStand.add(Tex.orc_hummer_stand_2);
            spritesStand.add(Tex.orc_hummer_stand_3);
            spritesStand.add(Tex.orc_hummer_stand_4);
            spritesStand.add(Tex.orc_hummer_stand_5);
            spritesStand.add(Tex.orc_hummer_stand_6);
            spritesStand.add(Tex.orc_hummer_stand_7);
            Animation animationStand = new Animation(spritesStand, 9);
            animationManager.stand = animationStand;

            Vector<Sprite>  spritesRun = new Vector<Sprite>();
            spritesRun.add(Tex.orc_hummer_run_1);
            spritesRun.add(Tex.orc_hummer_run_2);
            spritesRun.add(Tex.orc_hummer_run_3);
            spritesRun.add(Tex.orc_hummer_run_4);
            spritesRun.add(Tex.orc_hummer_run_5);
            spritesRun.add(Tex.orc_hummer_run_6);
            spritesRun.add(Tex.orc_hummer_run_7);
            Animation animationRun = new Animation(spritesRun, 7);
            animationManager.run = animationRun;

            Vector<Sprite>  spritesAtack = new Vector<Sprite>();
            spritesAtack.add(Tex.orc_hummer_atack_1);
            spritesAtack.add(Tex.orc_hummer_atack_2);
            spritesAtack.add(Tex.orc_hummer_atack_3);
            spritesAtack.add(Tex.orc_hummer_atack_4);
            spritesAtack.add(Tex.orc_hummer_atack_5);
            spritesAtack.add(Tex.orc_hummer_atack_6);
            spritesAtack.add(Tex.orc_hummer_atack_7);
            Animation animationAtack = new Animation(spritesAtack, Params.animationAtackSpeed5);
            animationManager.atack = animationAtack;

            Vector<Sprite>  spritesDie = new Vector<Sprite>();
            spritesDie.add(Tex.orc_hummer_die_1);
            spritesDie.add(Tex.orc_hummer_die_2);
            spritesDie.add(Tex.orc_hummer_die_3);
            spritesDie.add(Tex.orc_hummer_die_4);
            spritesDie.add(Tex.orc_hummer_die_5);
            spritesDie.add(Tex.orc_hummer_die_6);
            spritesDie.add(Tex.orc_hummer_die_7);
            Animation animationDie = new Animation(spritesDie, 5);
            animationDie.isLimit = true;
            animationManager.die = animationDie;
        }
    }

}
