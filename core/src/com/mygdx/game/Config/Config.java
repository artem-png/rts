package com.mygdx.game.Config;

/**
 * Created by artem on 10/6/17.
 */

public class Config {
    public static String locale = "ru_RU";

    public Config() {

    }

    public static String t(String text) {
        if (locale.equals("ru_RU")) {
            return text;
        } else {
            return text;
        }
    }
}
