package com.mygdx.game.process;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.event.EventController;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.PlayerMap;
import com.mygdx.game.models.player.NormalPlayer;

/**
 * Created by artem on 10/10/17.
 */

public class GameProcess {
    public static BlockMap blockMap;
    public static PlayerMap playerMap;
    public static EventController eventController;

    public GameProcess() {
        playerMap = new PlayerMap();
        eventController = new EventController();
        playerMap.add(new NormalPlayer(new Vector2(8 * 30 * Tex.x, 8 * 30 * Tex.y), new Vector2(8, 8)));
        playerMap.add(new NormalPlayer(new Vector2(10 * 30 * Tex.x, 10 * 30 * Tex.y), new Vector2(10, 10)));

        blockMap = new BlockMap();
    }

    public void render(SpriteBatch batch) {
        eventController.act(batch);
        blockMap.act(batch);
        playerMap.act(batch);
    }

    public void input() {

    }
}
