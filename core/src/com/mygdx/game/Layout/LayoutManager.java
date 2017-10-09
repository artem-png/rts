package com.mygdx.game.Layout;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Vector;

/**
 * Created by artem on 10/6/17.
 */

public class LayoutManager {
    Vector<ILayout> vector = new Vector<ILayout>();

    public void pop() {
        if (vector.size() == 0) {
            return;
        }
        vector.get(vector.size() - 1).dispose();
        vector.remove(vector.size() - 1);
    }

    public void push(ILayout layout) {
        vector.add(layout);
    }

    public void set(ILayout layout) {
        pop();
        push(layout);
    }

    public void render(SpriteBatch batch) {
        vector.get(vector.size() - 1).input();
        vector.get(vector.size() - 1).render(batch);
    }
}
