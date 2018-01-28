package com.mygdx.game.Models.Characters.ScreenAnimation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.mygdx.game.Config.Tex;

import java.util.Vector;

/**
 * Created by User on 25.01.2018.
 */

public class AnimationFabric {
    Vector<IScreenAnimation> animationVector;
    public static ShaderProgram shaderProgram;
    public static BitmapFont miss;

    public AnimationFabric()
    {
        miss = Tex.generateFont("ui/fonts/font1.ttf", 20, Color.RED);
        initShader();
        animationVector = new Vector<IScreenAnimation>();
    }

    public void render(SpriteBatch batch)
    {
        for (int i = 0; i < animationVector.size(); i++) {
            animationVector.get(i).render(batch);
        }
    }

    public void add(IScreenAnimation animation)
    {
        animationVector.add(animation);
    }

    public void act()
    {
        for (int i = animationVector.size() - 1; i >= 0; i--) {
            animationVector.get(i).act();
            if (!animationVector.get(i).isAlive()) {
                animationVector.get(i).dispose();
                animationVector.remove(i);
            }
        }
    }

    public void initShader()
    {
        String vertexShader = "attribute vec4 " + ShaderProgram.POSITION_ATTRIBUTE + ";\n" //
                + "attribute vec4 " + ShaderProgram.COLOR_ATTRIBUTE + ";\n" //
                + "attribute vec2 " + ShaderProgram.TEXCOORD_ATTRIBUTE + "0;\n" //
                + "uniform mat4 u_projTrans;\n" //
                + "varying vec4 v_color;\n" //
                + "varying vec2 v_texCoords;\n" //
                + "\n" //
                + "void main()\n" //
                + "{\n" //
                + "   v_color = " + ShaderProgram.COLOR_ATTRIBUTE + ";\n" //
                + "   v_texCoords = " + ShaderProgram.TEXCOORD_ATTRIBUTE + "0;\n" //
                + "   gl_Position =  u_projTrans * " + ShaderProgram.POSITION_ATTRIBUTE + ";\n" //
                + "}\n";
        String fragmentShader = "#ifdef GL_ES\n" //
                + "#define LOWP lowp\n" //
                + "precision mediump float;\n" //
                + "#else\n" //
                + "#define LOWP \n" //
                + "#endif\n" //
                + "varying LOWP vec4 v_color;\n" //
                + "varying vec2 v_texCoords;\n" //
                + "uniform vec4 u_color;\n" //
                + "uniform sampler2D u_texture;\n" //
                + "void main()\n"//
                + "{\n" //
                + "  gl_FragColor = v_color * texture2D(u_texture, v_texCoords).a;\n" //
                + "}";

        shaderProgram = new ShaderProgram(vertexShader, fragmentShader);
    }

    public void dispose() {

    }
}
