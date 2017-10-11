package com.mygdx.game.event;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.event.events.IEvent;
import com.mygdx.game.event.events.TonnelEvent;
import com.mygdx.game.process.GameProcess;

import java.util.Vector;

/**
 * Created by artem on 10/10/17.
 */

public class EventController {
    private Vector<IEvent> freeEvents;
    private Vector<IEvent> playerEvents;

    public EventController() {
        freeEvents = new Vector<IEvent>();
        playerEvents = new Vector<IEvent>();

        TonnelEvent event = new TonnelEvent();
        event.setStandCell(new Vector2(10, 5));
        Vector<Vector2> vector2s = new Vector<Vector2>();
        vector2s.add(new Vector2(9, 5));
        vector2s.add(new Vector2(9, 4));
        vector2s.add(new Vector2(8, 4));
        event.setCells(vector2s);
        this.addEvent(event);

        event = new TonnelEvent();
        event.setStandCell(new Vector2(10, 10));
        vector2s = new Vector<Vector2>();
        vector2s.add(new Vector2(10, 11));
        vector2s.add(new Vector2(10, 12));
        vector2s.add(new Vector2(10, 13));
        vector2s.add(new Vector2(10, 14));
        event.setCells(vector2s);
        this.addEvent(event);

        event = new TonnelEvent();
        event.setStandCell(new Vector2(9, 10));
        vector2s = new Vector<Vector2>();
        vector2s.add(new Vector2(8, 10));
        vector2s.add(new Vector2(7, 10));
        vector2s.add(new Vector2(6, 10));
        event.setCells(vector2s);
        this.addEvent(event);

        event = new TonnelEvent();
        event.setStandCell(new Vector2(8, 8));
        vector2s = new Vector<Vector2>();
        vector2s.add(new Vector2(8, 7));
        vector2s.add(new Vector2(8, 6));
        vector2s.add(new Vector2(9, 6));
        vector2s.add(new Vector2(9, 7));
        event.setCells(vector2s);
        this.addEvent(event);
    }

    public void addEvent(IEvent event) {
        freeEvents.add(event);
    }

    public void act(SpriteBatch batch) {
        if (freeEvents.size() > 0) {
            for (int i = 0; i < GameProcess.playerMap.getAll().size(); i++) {
                if (!GameProcess.playerMap.getAll().get(i).isBusy()) {
                    freeEvents.get(0).setPlayer(GameProcess.playerMap.getAll().get(i));
                    playerEvents.add(freeEvents.get(0));
                    freeEvents.remove(0);
                }
            }
        }
        for (int i = playerEvents.size() - 1; i >= 0; i--) {
            playerEvents.get(i).act(batch);
            if (playerEvents.get(i).isFinish()) {
                playerEvents.get(i).dispose();
                playerEvents.remove(i);
            }
        }
    }

    public void dispose() {

    }
}
