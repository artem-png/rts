package com.mygdx.game.process;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.components.Button;
import com.mygdx.game.event.EventController;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.PlayerMap;
import com.mygdx.game.models.player.NormalPlayer;

/**
 * Created by artem on 10/10/17.
 */

public class GameProcess implements IProcess{
    public static BlockMap blockMap;
    public static PlayerMap playerMap;
    public static EventController eventController;
    public static SpriteBatch menuBatch;
    private Button digButton;

    public GameProcess() {
        menuBatch = new SpriteBatch();
        playerMap = new PlayerMap();
        eventController = new EventController();

        playerMap.add(new NormalPlayer(new Vector2(8, 9)));
        playerMap.add(new NormalPlayer(new Vector2(8, 3)));
        playerMap.add(new NormalPlayer(new Vector2(8, 4)));
        playerMap.add(new NormalPlayer(new Vector2(8, 5)));
        playerMap.add(new NormalPlayer(new Vector2(8, 6)));
        playerMap.add(new NormalPlayer(new Vector2(8, 7)));
        playerMap.add(new NormalPlayer(new Vector2(10, 6)));
        playerMap.add(new NormalPlayer(new Vector2(10, 10)));
        playerMap.add(new NormalPlayer(new Vector2(9, 10)));
        playerMap.add(new NormalPlayer(new Vector2(8, 10)));
        playerMap.add(new NormalPlayer(new Vector2(7, 10)));

        blockMap = new BlockMap();

        digButton = new Button(Tex.digButton, new Vector2(15 * Tex.x, 15 * Tex.y));
        digButton.setDelay(15);
    }

    public void act(SpriteBatch batch) {
        eventController.act(batch);
        blockMap.act(batch);
        playerMap.act(batch);
        batch.end();
        menuBatch.begin();
        digButton.act(menuBatch);
        menuBatch.end();
        batch.begin();
    }

    public void input() {
        digButton.input();
        if (digButton.isActivated) {
            digButton.isActivated = false;
            GameLayout.addProcess(new BuildProcess(blockMap));
        }
    }

    public void dispose() {
        blockMap.dispose();
        playerMap.dispose();
        eventController.dispose();
    }
}
