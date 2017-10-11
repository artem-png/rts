package com.mygdx.game.models.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
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
        float x = (GameLayout.camera.position.x - (Gdx.graphics.getWidth() / (1.3f / (float) Math.sqrt((double) Tex.x))) * GameLayout.camera.zoom) - Tex.groundBlock.getWidth();
        float y = (GameLayout.camera.position.y - (Gdx.graphics.getHeight() / (1.3f / (float) Math.sqrt((double) Tex.y))) * GameLayout.camera.zoom) - Tex.groundBlock.getHeight();
        float w = GameLayout.camera.viewportWidth * GameLayout.camera.zoom + Tex.groundBlock.getWidth() * 8f;
        float h = GameLayout.camera.viewportHeight * GameLayout.camera.zoom + Tex.groundBlock.getHeight() * 8f;

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

    public Vector<APlayer> getAll() {
        return players;
    }
}
