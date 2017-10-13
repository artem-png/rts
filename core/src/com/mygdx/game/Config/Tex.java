package com.mygdx.game.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by artem on 10/6/17.
 */

public class Tex {
    public static float x = (float) Gdx.graphics.getWidth() / 800;
    public static float y = (float) Gdx.graphics.getHeight() / 450;

    public static Sprite groundBlock;
    public static Sprite normalPlayer;
    public static Sprite digButton;
    public static Sprite marker_tonnel_1;
    public static Sprite marker_tonnel_2;
    public static Sprite marker_tonnel_3;
    public static Sprite dug_tonnel_1;
    public static Sprite acceptButton;
    public static Sprite bg;

    public Tex() {
        if (y > x) {
            x = y;
        }
        if (x > y) {
            y = x;
        }
        groundBlock = generateSprite("blockGround.png", 30 * Tex.x, 30 * Tex.y);
        normalPlayer = generateSprite("normalPlayer.png", 30 * Tex.x, 30 * Tex.y);
        digButton = generateSprite("digButton.png", 90 * Tex.x, 90 * Tex.y);
        acceptButton = generateSprite("accept.png", 90 * Tex.x, 90 * Tex.y);
        marker_tonnel_1 = generateSprite("marker_tonnel_2.png", 30 * Tex.x, 30 * Tex.y);
        marker_tonnel_2 = generateSprite("marker_tonnel_1.png", 30 * Tex.x, 30 * Tex.y);
        marker_tonnel_3 = generateSprite("marker_tonnel_3.png", 30 * Tex.x, 30 * Tex.y);
        dug_tonnel_1 = generateSprite("dug_tonnel_1.png", 30 * Tex.x, 30 * Tex.y);
        bg = generateSprite("bg.png", 1000 * Tex.x, 1000 * Tex.y);

    }

    public Sprite generateSprite(String name, float w, float h) {
        Sprite sprite = new Sprite(new Texture(name));
        sprite.setSize(w, h);
        sprite.setOrigin(w/2, h/2);
        return sprite;
    }
}
