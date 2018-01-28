package com.mygdx.game.Background;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Layout.GameLayout;

import java.util.Vector;

public class Background {
    Vector<Sprite> sprites;

    public Background(Vector<Sprite> sprites)
    {
        this.sprites = sprites;
    }

    public void render(SpriteBatch batch)
    {
        for (int i = 0; i < 2; i++) {
                batch.draw(sprites.get(0), 0 + i * sprites.get(0).getWidth(), 0);
        }
    }

    public void dispose()
    {
        for (int i = 0; i < sprites.size(); i++) {
            //sprites.get(i).getTexture().dispose();
        }
    }
}
