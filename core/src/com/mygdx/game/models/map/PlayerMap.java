package com.mygdx.game.models.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.models.player.APlayer;
import java.util.Vector;

/**
 * Created by artem on 10/10/17.
 */

public class PlayerMap implements IMap {
    private Vector<APlayer> players;

    public PlayerMap() {
        players = new Vector<APlayer>();
    }

    public void act(SpriteBatch batch) {
        Vector3 xy = GameLayout.camera.unproject(new Vector3(0, Gdx.graphics.getHeight(), 0));
        float x = xy.x - Tex.groundBlock.getWidth() * 3f * GameLayout.camera.zoom;
        float y = xy.y - Tex.groundBlock.getHeight() * 3f * GameLayout.camera.zoom;
        float w = GameLayout.camera.viewportWidth * GameLayout.camera.zoom + Tex.groundBlock.getWidth() * 6f * GameLayout.camera.zoom;
        float h = GameLayout.camera.viewportHeight * GameLayout.camera.zoom + Tex.groundBlock.getHeight() * 6f * GameLayout.camera.zoom;


        for (int i = 0; i < players.size(); i++) {
            Vector2 position = players.get(i).getPosition();
            if (position.x > x && position.x < x + w && position.y > y && position.y < y + h) {
                players.get(i).render(batch);
            }
            players.get(i).act(batch);
        }
    }

    @Override
    public void add(Object object) {
        players.add(((APlayer) object));
    }

    @Override
    public void dispose() {

    }

    public Vector<APlayer> getAll() {
        return players;
    }
}
