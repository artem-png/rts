package com.mygdx.game.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by artem on 10/6/17.
 */

public class Tex {
    public static float x = (float) Gdx.graphics.getWidth() / 800;
    public static float y = (float) Gdx.graphics.getHeight() / 450;
    public static float cameraX = 1100;
    public static float blockWidth = 32;
    public static float cameraYStandart = 535;

    public static Sprite background1_1;
    public static Sprite background1_2;
    public static Sprite background1_3;
    public static Sprite background1_7;
    public static Sprite background1_8;
    public static Sprite background1_9;
    public static Sprite background1_bg;

    public static Sprite Samurai_light_atack_1;
    public static Sprite Samurai_light_atack_2;
    public static Sprite Samurai_light_atack_3;
    public static Sprite Samurai_light_atack_4;
    public static Sprite Samurai_light_atack_5;
    public static Sprite Samurai_light_atack_6;
    public static Sprite Samurai_light_atack_7;
    public static Sprite Samurai_light_atack_8;
    public static Sprite Samurai_light_atack_9;
    public static Sprite Samurai_light_atack_10;

    public static Sprite Samurai_light_stand_1;
    public static Sprite Samurai_light_stand_2;
    public static Sprite Samurai_light_stand_3;
    public static Sprite Samurai_light_stand_4;
    public static Sprite Samurai_light_stand_5;
    public static Sprite Samurai_light_stand_6;
    public static Sprite Samurai_light_stand_7;
    public static Sprite Samurai_light_stand_8;
    public static Sprite Samurai_light_stand_9;

    public static Sprite Samurai_light_run_1;
    public static Sprite Samurai_light_run_2;
    public static Sprite Samurai_light_run_3;
    public static Sprite Samurai_light_run_4;
    public static Sprite Samurai_light_run_5;
    public static Sprite Samurai_light_run_6;
    public static Sprite Samurai_light_run_7;
    public static Sprite Samurai_light_run_8;
    public static Sprite Samurai_light_run_9;

    public static Sprite Samurai_light_die_1;
    public static Sprite Samurai_light_die_2;
    public static Sprite Samurai_light_die_3;
    public static Sprite Samurai_light_die_4;
    public static Sprite Samurai_light_die_5;
    public static Sprite Samurai_light_die_6;
    public static Sprite Samurai_light_die_7;
    public static Sprite Samurai_light_die_8;
    public static Sprite Samurai_light_die_9;
    public static Sprite Samurai_light_die_10;

    public static Sprite Samurai_light_def_1;
    public static Sprite Samurai_light_def_2;
    public static Sprite Samurai_light_def_3;
    public static Sprite Samurai_light_def_4;
    public static Sprite Samurai_light_def_5;
    public static Sprite Samurai_light_def_6;
    public static Sprite Samurai_light_def_7;
    public static Sprite Samurai_light_def_8;
    public static Sprite Samurai_light_def_9;
    public static Sprite Samurai_light_def_10;

    public static Sprite orc_hummer_stand_1;
    public static Sprite orc_hummer_stand_2;
    public static Sprite orc_hummer_stand_3;
    public static Sprite orc_hummer_stand_4;
    public static Sprite orc_hummer_stand_5;
    public static Sprite orc_hummer_stand_6;
    public static Sprite orc_hummer_stand_7;

    public static Sprite orc_hummer_run_1;
    public static Sprite orc_hummer_run_2;
    public static Sprite orc_hummer_run_3;
    public static Sprite orc_hummer_run_4;
    public static Sprite orc_hummer_run_5;
    public static Sprite orc_hummer_run_6;
    public static Sprite orc_hummer_run_7;

    public static Sprite orc_hummer_atack_1;
    public static Sprite orc_hummer_atack_2;
    public static Sprite orc_hummer_atack_3;
    public static Sprite orc_hummer_atack_4;
    public static Sprite orc_hummer_atack_5;
    public static Sprite orc_hummer_atack_6;
    public static Sprite orc_hummer_atack_7;

    public static Sprite orc_hummer_die_1;
    public static Sprite orc_hummer_die_2;
    public static Sprite orc_hummer_die_3;
    public static Sprite orc_hummer_die_4;
    public static Sprite orc_hummer_die_5;
    public static Sprite orc_hummer_die_6;
    public static Sprite orc_hummer_die_7;

    public Tex() {
        initBackground1();
        initSamuraiLight();
        initOrcHummer();
    }

    public void initBackground1() {
        background1_1 = generateSprite("maps/map1/background/Layer_0010_1.png");
        background1_2 = generateSprite("maps/map1/background/Layer_0009_2.png");
        background1_3 = generateSprite("maps/map1/background/Layer_0002_7.png");
        background1_7 = generateSprite("maps/map1/background/Layer_0008_3.png");
        background1_8 = generateSprite("maps/map1/background/Layer_0003_6.png");
        background1_9 = generateSprite("maps/map1/background/Layer_0000_9.png");
        background1_bg = generateSprite("maps/map1/background/bg.png");
    }

    public void initSamuraiLight() {
        Samurai_light_atack_1 = generateSprite("characters/samuraiLight/atack/0.png", 120, 150);
        Samurai_light_atack_2 = generateSprite("characters/samuraiLight/atack/1.png", 120, 150);
        Samurai_light_atack_3 = generateSprite("characters/samuraiLight/atack/2.png", 120, 150);
        Samurai_light_atack_4 = generateSprite("characters/samuraiLight/atack/3.png", 120, 150);
        Samurai_light_atack_5 = generateSprite("characters/samuraiLight/atack/4.png", 120, 150);
        Samurai_light_atack_6 = generateSprite("characters/samuraiLight/atack/5.png", 120, 150);
        Samurai_light_atack_7 = generateSprite("characters/samuraiLight/atack/6.png", 120, 150);
        Samurai_light_atack_8 = generateSprite("characters/samuraiLight/atack/7.png", 120, 150);
        Samurai_light_atack_9 = generateSprite("characters/samuraiLight/atack/8.png", 120, 150);
        Samurai_light_atack_10 = generateSprite("characters/samuraiLight/atack/9.png", 120, 150);

        Samurai_light_stand_1 = generateSprite("characters/samuraiLight/stand/0.png", 90, 130);
        Samurai_light_stand_2 = generateSprite("characters/samuraiLight/stand/1.png", 90, 130);
        Samurai_light_stand_3 = generateSprite("characters/samuraiLight/stand/2.png", 90, 130);
        Samurai_light_stand_4 = generateSprite("characters/samuraiLight/stand/3.png", 90, 130);
        Samurai_light_stand_5 = generateSprite("characters/samuraiLight/stand/4.png", 90, 130);
        Samurai_light_stand_6 = generateSprite("characters/samuraiLight/stand/5.png", 90, 130);
        Samurai_light_stand_7 = generateSprite("characters/samuraiLight/stand/6.png", 90, 130);
        Samurai_light_stand_8 = generateSprite("characters/samuraiLight/stand/7.png", 90, 130);
        Samurai_light_stand_9 = generateSprite("characters/samuraiLight/stand/8.png", 90, 130);

        Samurai_light_run_1 = generateSprite("characters/samuraiLight/run/0.png", 95, 134);
        Samurai_light_run_2 = generateSprite("characters/samuraiLight/run/1.png", 95, 134);
        Samurai_light_run_3 = generateSprite("characters/samuraiLight/run/2.png", 95, 134);
        Samurai_light_run_4 = generateSprite("characters/samuraiLight/run/4.png", 95, 134);
        Samurai_light_run_5 = generateSprite("characters/samuraiLight/run/5.png", 95, 134);
        Samurai_light_run_6 = generateSprite("characters/samuraiLight/run/6.png", 95, 134);
        Samurai_light_run_7 = generateSprite("characters/samuraiLight/run/7.png", 95, 134);
        Samurai_light_run_8 = generateSprite("characters/samuraiLight/run/8.png", 95, 134);
        Samurai_light_run_9 = generateSprite("characters/samuraiLight/run/9.png", 95, 134);

        Samurai_light_die_1 = generateSprite("characters/samuraiLight/die/0.png", 180, 182);
        Samurai_light_die_2 = generateSprite("characters/samuraiLight/die/1.png", 180, 182);
        Samurai_light_die_3 = generateSprite("characters/samuraiLight/die/2.png", 180, 182);
        Samurai_light_die_4 = generateSprite("characters/samuraiLight/die/3.png", 180, 182);
        Samurai_light_die_5 = generateSprite("characters/samuraiLight/die/4.png", 180, 182);
        Samurai_light_die_6 = generateSprite("characters/samuraiLight/die/5.png", 180, 182);
        Samurai_light_die_7 = generateSprite("characters/samuraiLight/die/6.png", 180, 182);
        Samurai_light_die_8 = generateSprite("characters/samuraiLight/die/7.png", 180, 182);
        Samurai_light_die_9 = generateSprite("characters/samuraiLight/die/8.png", 180, 182);
        Samurai_light_die_10 = generateSprite("characters/samuraiLight/die/9.png", 180, 182);

        Samurai_light_def_1 = generateSprite("characters/samuraiLight/defend/0.png", 105, 128);
        Samurai_light_def_2 = generateSprite("characters/samuraiLight/defend/1.png", 105, 128);
        Samurai_light_def_3 = generateSprite("characters/samuraiLight/defend/2.png", 105, 128);
        Samurai_light_def_4 = generateSprite("characters/samuraiLight/defend/3.png", 105, 128);
        Samurai_light_def_5 = generateSprite("characters/samuraiLight/defend/4.png", 105, 128);
        Samurai_light_def_6 = generateSprite("characters/samuraiLight/defend/5.png", 105, 128);
        Samurai_light_def_7 = generateSprite("characters/samuraiLight/defend/6.png", 105, 128);
        Samurai_light_def_8 = generateSprite("characters/samuraiLight/defend/7.png", 105, 128);
        Samurai_light_def_9 = generateSprite("characters/samuraiLight/defend/8.png", 105, 128);
        Samurai_light_def_10 = generateSprite("characters/samuraiLight/defend/9.png", 105, 128);
    }

    public void initOrcHummer() {
        orc_hummer_run_1 = generateSprite("characters/orcHummer/run/RUN_000.png", 142);
        orc_hummer_run_2 = generateSprite("characters/orcHummer/run/RUN_001.png", 142);
        orc_hummer_run_3 = generateSprite("characters/orcHummer/run/RUN_002.png", 142);
        orc_hummer_run_4 = generateSprite("characters/orcHummer/run/RUN_003.png", 142);
        orc_hummer_run_5 = generateSprite("characters/orcHummer/run/RUN_004.png", 142);
        orc_hummer_run_6 = generateSprite("characters/orcHummer/run/RUN_005.png", 142);
        orc_hummer_run_7 = generateSprite("characters/orcHummer/run/RUN_006.png", 142);

        orc_hummer_stand_1 = generateSprite("characters/orcHummer/stand/IDLE_000.png", 142);
        orc_hummer_stand_2 = generateSprite("characters/orcHummer/stand/IDLE_001.png", 142);
        orc_hummer_stand_3 = generateSprite("characters/orcHummer/stand/IDLE_002.png", 142);
        orc_hummer_stand_4 = generateSprite("characters/orcHummer/stand/IDLE_003.png", 142);
        orc_hummer_stand_5 = generateSprite("characters/orcHummer/stand/IDLE_004.png", 142);
        orc_hummer_stand_6 = generateSprite("characters/orcHummer/stand/IDLE_005.png", 142);
        orc_hummer_stand_7 = generateSprite("characters/orcHummer/stand/IDLE_006.png", 142);

        orc_hummer_atack_1 = generateSprite("characters/orcHummer/atack/ATTAK_000.png", 198);
        orc_hummer_atack_2 = generateSprite("characters/orcHummer/atack/ATTAK_001.png", 198);
        orc_hummer_atack_3 = generateSprite("characters/orcHummer/atack/ATTAK_002.png", 198);
        orc_hummer_atack_4 = generateSprite("characters/orcHummer/atack/ATTAK_003.png", 198);
        orc_hummer_atack_5 = generateSprite("characters/orcHummer/atack/ATTAK_004.png", 198);
        orc_hummer_atack_6 = generateSprite("characters/orcHummer/atack/ATTAK_005.png", 198);
        orc_hummer_atack_7 = generateSprite("characters/orcHummer/atack/ATTAK_006.png", 198);

        orc_hummer_die_1 = generateSprite("characters/orcHummer/die/DIE_000.png", 142);
        orc_hummer_die_2 = generateSprite("characters/orcHummer/die/DIE_001.png", 142);
        orc_hummer_die_3 = generateSprite("characters/orcHummer/die/DIE_002.png", 142);
        orc_hummer_die_4 = generateSprite("characters/orcHummer/die/DIE_003.png", 142);
        orc_hummer_die_5 = generateSprite("characters/orcHummer/die/DIE_004.png", 142);
        orc_hummer_die_6 = generateSprite("characters/orcHummer/die/DIE_005.png", 142);
        orc_hummer_die_7 = generateSprite("characters/orcHummer/die/DIE_006.png", 142);
    }

    public Sprite generateSprite(String name, float w, float h) {
        Sprite sprite = new Sprite(new Texture(name));
        sprite.setSize(w, h);
        sprite.setOrigin(w / 2, h / 2);
        return sprite;
    }

    public Sprite generateSprite(String name) {
        Sprite sprite = new Sprite(new Texture(name));
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        return sprite;
    }

    public Sprite generateSprite(String name, float h) {
        Sprite sprite = new Sprite(new Texture(name));
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setSize(sprite.getWidth() * (h / sprite.getHeight()), h);
        return sprite;
    }

    public static BitmapFont generateFont(String path, int size, Color color) {
        final String FONT_CHARS = "абвгдежзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";

        BitmapFont font1;


        final String FONT_PATH = path;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = FONT_CHARS;
        parameter.size = size;
        parameter.color = color;
        font1 = generator.generateFont(parameter);
        generator.dispose();

        return font1;
    }
}
