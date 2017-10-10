package com.mygdx.game.event.events;

import com.mygdx.game.models.player.APlayer;

/**
 * Created by artem on 10/10/17.
 */

public interface IEvent {
    public void setPlayer(APlayer player);
    public void act();
}
