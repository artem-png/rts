package com.mygdx.game.Models.Logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Layout.GameLayout;

/**
 * Created by User on 30.01.2018.
 */

public class Monuments {
    public boolean isFinish = false;

    public float alpha = 1;
    public float alphaDelta = 0.006f;

    public Sprite sphere1 = new Sprite(new Texture("level/l2/spheres/sphere1.png"));
    Vector2 sphere1Position = new Vector2(750, 400);
    float max1 = 2;
    float settingMax1 = 2;
    boolean isPlus1 = true;
    boolean isActivated1 = false;
    Vector3 sphere1Points = new Vector3(1, 1, 2);

    public Sprite sphere2 = new Sprite(new Texture("level/l2/spheres/sphere1.png"));
    Vector2 sphere2Position = new Vector2(880, 450);
    float max2 = 1.3f;
    float settingMax2 = 2;
    boolean isPlus2 = true;
    boolean isActivated2 = false;
    Vector3 sphere2Points = new Vector3(1, 0, 0);

    public Sprite sphere3 = new Sprite(new Texture("level/l2/spheres/sphere1.png"));
    Vector2 sphere3Position = new Vector2(1010, 380);
    float max3 = 1.7f;
    float settingMax3 = 2;
    boolean isPlus3 = true;
    boolean isActivated3 = false;
    Vector3 sphere3Points = new Vector3(1, 0, 1);

    public Sprite sphere4 = new Sprite(new Texture("level/l2/spheres/sphere1.png"));
    Vector2 sphere4Position = new Vector2(1140, 460);
    float max4 = 0.8f;
    float settingMax4 = 2.1f;
    boolean isPlus4 = true;
    boolean isActivated4 = false;
    Vector3 sphere4Points = new Vector3(0, 0, 2);

    public Sprite sphere5 = new Sprite(new Texture("level/l2/spheres/sphere1.png"));
    Vector2 sphere5Position = new Vector2(1270, 390);
    float max5 = 0.25f;
    float settingMax5 = 1.9f;
    boolean isPlus5 = true;
    boolean isActivated5 = false;
    Vector3 sphere5Points = new Vector3(0, 2, 1);

    public Sprite monument = new Sprite(new Texture("level/l2/monument_not_active.png"));

    Vector2 monument1Pos = new Vector2(846, 224);
    int monument1points = 2;
    boolean monument1Active = true;
    Vector2 monument2Pos = new Vector2(942, 224);
    int monument2points = 3;
    boolean monument2Active = true;
    Vector2 monument3Pos = new Vector2(1038, 224);
    int monument3points = 4;
    boolean monument3Active = true;
    Color myColor = new Color(0x9EFF9EFF);
    Color blendColor;

    public void render(SpriteBatch batch) {
        Color originColor = batch.getColor();
        blendColor = new Color(batch.getColor());
        blendColor.a = alpha;

        if (isActivated1 || isFinish) {
            batch.setColor(myColor);
        }
        batch.draw(sphere1, sphere1Position.x, sphere1Position.y, 30, 30);
        batch.setColor(originColor);

        if (isActivated2) {
            batch.setColor(myColor);
        }
        if (isFinish) {
            batch.setColor(blendColor);
        }
        batch.draw(sphere2, sphere2Position.x, sphere2Position.y, 30, 30);
        batch.setColor(originColor);

        if (isActivated3 || isFinish) {
            batch.setColor(myColor);
        }
        batch.draw(sphere3, sphere3Position.x, sphere3Position.y, 30, 30);
        batch.setColor(originColor);

        if (isActivated4) {
            batch.setColor(myColor);
        }
        if (isFinish) {
            batch.setColor(blendColor);
        }
        batch.draw(sphere4, sphere4Position.x, sphere4Position.y, 30, 30);
        batch.setColor(originColor);

        if (isActivated5 || isFinish) {
            batch.setColor(myColor);
        }
        batch.draw(sphere5, sphere5Position.x, sphere5Position.y, 30, 30);
        batch.setColor(originColor);

        if (monument1Active) {
            batch.draw(monument, monument1Pos.x, monument1Pos.y);
        }
        if (monument2Active) {
            batch.draw(monument, monument2Pos.x, monument2Pos.y);
        }
        if (monument3Active) {
            batch.draw(monument, monument3Pos.x, monument3Pos.y);
        }
    }

    public void act() {
        moveSpheres();
        if (!isFinish) {
            checkPoints();
            input();
        } else {
            alpha -= alphaDelta;
            if (alpha <= 0) {
                alpha = 0;
            }
            myColor.a = alpha;
        }
    }

    protected void checkPoints() {
        Vector3 points = new Vector3(0, 0, 0);
        if (isActivated1) {
            points.add(sphere1Points);
        }
        if (isActivated2) {
            points.add(sphere2Points);
        }
        if (isActivated3) {
            points.add(sphere3Points);
        }
        if (isActivated4) {
            points.add(sphere4Points);
        }
        if (isActivated5) {
            points.add(sphere5Points);
        }
        monument1Active = !(points.x == monument1points);
        monument2Active = !(points.y == monument2points);
        monument3Active = !(points.z == monument3points);

        if (!monument1Active && !monument2Active && !monument3Active) {
            this.isFinish = true;
        }
    }

    protected void moveSpheres() {
        if (isPlus1) {
            sphere1Position.add(0, (float) Math.sqrt(max1) / 5);
        } else {
            sphere1Position.add(0, (float) -Math.sqrt(max1) / 5);
        }
        max1 -= 0.01f;
        if (max1 <= 0) {
            isPlus1 = !isPlus1;
            max1 = settingMax1;
        }

        if (isPlus2) {
            sphere2Position.add(0, (float) Math.sqrt(max2) / 5);
        } else {
            sphere2Position.add(0, (float) -Math.sqrt(max2) / 5);
        }
        max2 -= 0.011f;
        if (max2 <= 0) {
            isPlus2 = !isPlus2;
            max2 = settingMax2;
        }

        if (isPlus3) {
            sphere3Position.add(0, (float) Math.sqrt(max3) / 5);
        } else {
            sphere3Position.add(0, (float) -Math.sqrt(max3) / 5);
        }
        max3 -= 0.012f;
        if (max3 <= 0) {
            isPlus3 = !isPlus3;
            max3 = settingMax3;
        }

        if (isPlus4) {
            sphere4Position.add(0, (float) Math.sqrt(max4) / 5);
        } else {
            sphere4Position.add(0, (float) -Math.sqrt(max4) / 5);
        }
        max4 -= 0.0089f;
        if (max4 <= 0) {
            isPlus4 = !isPlus4;
            max4 = settingMax4;
        }

        if (isPlus5) {
            sphere5Position.add(0, (float) Math.sqrt(max5) / 5);
        } else {
            sphere5Position.add(0, (float) -Math.sqrt(max5) / 5);
        }
        max5 -= 0.0079f;
        if (max5 <= 0) {
            isPlus5 = !isPlus5;
            max5 = settingMax5;
        }
    }

    public void input() {
        if (Gdx.input.justTouched()) {
            Vector3 coords = GameLayout.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (
                    coords.x > sphere1Position.x - 20
                    && coords.x < sphere1Position.x + 70
                    && coords.y > sphere1Position.y - 20
                    && coords.y < (sphere1Position.y + 70)
            ) {
                isActivated1 = !isActivated1;
            }
            if (
                    coords.x > sphere2Position.x - 20
                    && coords.x < sphere2Position.x + 70
                    && coords.y > sphere2Position.y - 20
                    && coords.y < (sphere2Position.y + 70)
            ) {
                isActivated2 = !isActivated2;
            }
            if (
                    coords.x > sphere3Position.x - 20
                    && coords.x < sphere3Position.x + 70
                    && coords.y > sphere3Position.y - 20
                    && coords.y < (sphere3Position.y + 70)
            ) {
                isActivated3 = !isActivated3;
            }
            if (
                    coords.x > sphere4Position.x - 20
                    && coords.x < sphere4Position.x + 70
                    && coords.y > sphere4Position.y - 20
                    && coords.y < (sphere4Position.y + 70)
            ) {
                isActivated4 = !isActivated4;
            }
            if (
                    coords.x > sphere5Position.x - 20
                    && coords.x < sphere5Position.x + 70
                    && coords.y > sphere5Position.y - 20
                    && coords.y < (sphere5Position.y + 70)
            ) {
                isActivated5 = !isActivated5;
            }
        }
    }

    public void dispose() {
        sphere1.getTexture().dispose();
        sphere2.getTexture().dispose();
        sphere3.getTexture().dispose();
        sphere4.getTexture().dispose();
        sphere5.getTexture().dispose();
        monument.getTexture().dispose();
    }
}
