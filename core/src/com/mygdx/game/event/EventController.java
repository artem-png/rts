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
    }

    public void addEvent(IEvent event) {
        freeEvents.add(event);
    }

    public void act(SpriteBatch batch) {
        if (freeEvents.size() > 0) {
            for (int i = 0; i < GameProcess.playerMap.getAll().size(); i++) {
                if (freeEvents.size() > 0 && !GameProcess.playerMap.getAll().get(i).isBusy()) {
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
