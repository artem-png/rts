package com.mygdx.game.process;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.DigPanelGameProcess;
import com.mygdx.game.event.EventController;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.LandMap;
import com.mygdx.game.models.map.PlayerMap;
import com.mygdx.game.models.player.NormalPlayer;

/**
 * Created by artem on 10/10/17.
 */

public class GameProcess implements IProcess{
    public static LandMap landMap;
    public static BlockMap blockMap;
    public static PlayerMap playerMap;
    public static EventController eventController;
    public static SpriteBatch menuBatch;
    private DigPanelGameProcess digPanelGameProcess;

    public GameProcess() {
        menuBatch = new SpriteBatch();
        playerMap = new PlayerMap();
        eventController = new EventController();

        playerMap.add(new NormalPlayer(new Vector2(10, 10)));
        playerMap.add(new NormalPlayer(new Vector2(12, 10)));
        playerMap.add(new NormalPlayer(new Vector2(14, 10)));
        playerMap.add(new NormalPlayer(new Vector2(16, 10)));
        playerMap.add(new NormalPlayer(new Vector2(18, 10)));
        playerMap.add(new NormalPlayer(new Vector2(17, 10)));
        playerMap.add(new NormalPlayer(new Vector2(15, 10)));
        playerMap.add(new NormalPlayer(new Vector2(5, 10)));
        playerMap.add(new NormalPlayer(new Vector2(2, 10)));
        playerMap.add(new NormalPlayer(new Vector2(6, 10)));
        playerMap.add(new NormalPlayer(new Vector2(7, 10)));

//        playerMap.add(new NormalPlayer(new Vector2(8, 6)));
//        playerMap.add(new NormalPlayer(new Vector2(8, 7)));
//        playerMap.add(new NormalPlayer(new Vector2(10, 6)));
//        playerMap.add(new NormalPlayer(new Vector2(10, 10)));
//        playerMap.add(new NormalPlayer(new Vector2(9, 10)));
//        playerMap.add(new NormalPlayer(new Vector2(8, 10)));
//        playerMap.add(new NormalPlayer(new Vector2(7, 10)));
//        playerMap.add(new NormalPlayer(new Vector2(8, 9)));
//        playerMap.add(new NormalPlayer(new Vector2(8, 3)));
//        playerMap.add(new NormalPlayer(new Vector2(8, 4)));
//        playerMap.add(new NormalPlayer(new Vector2(8, 5)));
//        playerMap.add(new NormalPlayer(new Vector2(8, 6)));
//        playerMap.add(new NormalPlayer(new Vector2(8, 7)));
//        playerMap.add(new NormalPlayer(new Vector2(10, 6)));
//        playerMap.add(new NormalPlayer(new Vector2(10, 10)));
//        playerMap.add(new NormalPlayer(new Vector2(9, 10)));
//        playerMap.add(new NormalPlayer(new Vector2(8, 10)));
//        playerMap.add(new NormalPlayer(new Vector2(7, 10)));

        blockMap = new BlockMap();
        landMap = new LandMap(blockMap);
        digPanelGameProcess = new DigPanelGameProcess();
    }

    public void act(SpriteBatch batch) {
        long start = System.nanoTime();
        eventController.act(batch);
        long finish = System.nanoTime();
        long timeConsumedMillis = (finish - start) / 100000;
        //System.out.println(" event " + timeConsumedMillis);
        start = System.nanoTime();
        landMap.act(batch);
        finish = System.nanoTime();
        timeConsumedMillis = (finish - start) / 100000;
        //System.out.println(" land " + timeConsumedMillis);

        start = System.nanoTime();
        playerMap.act(batch);
        finish = System.nanoTime();
        timeConsumedMillis = (finish - start) / 100000;
        //System.out.println(" playerMap " + timeConsumedMillis);

        batch.end();
        menuBatch.begin();
        digPanelGameProcess.act(menuBatch);
        menuBatch.end();
        batch.begin();
    }

    public void input() {
        digPanelGameProcess.input();
    }

    public void dispose() {
        blockMap.dispose();
        playerMap.dispose();
        eventController.dispose();
    }
}
