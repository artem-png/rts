package com.mygdx.game.Models.Characters.CharacterActions;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by User on 25.01.2018.
 */

public class Punch {
    public com.mygdx.game.Models.Characters.Classes.AModel dealer;
    public Rectangle radius;

    public Punch (com.mygdx.game.Models.Characters.Classes.AModel dealer)
    {
        this.dealer = dealer;
        if (dealer.side == 1) {
            radius = new Rectangle(dealer.rectangle.x + dealer.rectangle.width, 0, 30, 200);
        } else {
            radius = new Rectangle(dealer.rectangle.x - 30, 0, 30, 200);
        }
    }
}
