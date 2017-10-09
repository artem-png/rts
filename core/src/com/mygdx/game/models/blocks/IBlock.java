package com.mygdx.game.models.blocks;

import com.mygdx.game.models.IModel;
import com.mygdx.game.models.player.APlayer;

/**
 * Created by artem on 10/9/17.
 */

public interface IBlock extends IModel{
    public void afterDeath(APlayer player);
}
