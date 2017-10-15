package com.mygdx.game.process;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Config.Tex;
import com.mygdx.game.Layout.GameLayout;
import com.mygdx.game.components.Button;
import com.mygdx.game.event.events.CaveEvent;
import com.mygdx.game.event.events.TonnelEvent;
import com.mygdx.game.models.blocks.Cave;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.LandMap;
import com.mygdx.game.models.map.MapHelper;

import java.util.Vector;

/**
 * Created by artem on 10/11/17.
 */

public class CaveProcess implements IProcess {
    public LandMap landMap;
    private Button accept;
    private Button back;
    private Button cave1active;
    private Button cave1;
    private int cave = 0;
    private Cave caveObject;
    private int[][] avaliableMap;
    int[][] bannedSectors;


    public CaveProcess(LandMap map) {
        landMap = map;
        accept = new Button(Tex.acceptButton, new Vector2(715 * Tex.x, 5 * Tex.y));
        back = new Button(Tex.backButton, new Vector2(5 * Tex.x, 5 * Tex.y));
        cave1 = new Button(Tex.cave3x5Button, new Vector2(115 * Tex.x, 5 * Tex.y));
        cave1active = new Button(Tex.cave3x5Button_active, new Vector2(115 * Tex.x, 5 * Tex.y));
        cave1.setDelay(5);
        accept.setDelay(5);
        GameProcess.blockMap.generateAvaliableMap();
        avaliableMap = MapHelper.getAvaliableMapToTunnel();
        bannedSectors = MapHelper.getAlreadyBuldingCaves();
        int[][] alreadyTunnel = MapHelper.getAlreadyBuldingCells();
        for (int i = 0; i < BlockMap.sizeX; i++) {
            for (int j = BlockMap.sizeY - 1; j > 0; j--) {
                if (alreadyTunnel[i][j] == 5 || bannedSectors[i][j] == 6) {
                    avaliableMap[i][j] = -1;
                }
            }
        }
    }

    @Override
    public void act(SpriteBatch batch) {
        landMap.act(batch);
        if (cave > 0) {
            caveObject.getAvaliableToBuild(avaliableMap);
            caveObject.renderMarker(batch);
        }
        for (int i = 0; i < BlockMap.sizeX; i++) {
            for (int j = BlockMap.sizeY - 1; j > 0; j--) {
                if (avaliableMap[i][j] == -1) {
                    batch.draw(Tex.bannedSector, i * Tex.x * 30, j * 30 * Tex.y, Tex.marker_tonnel_1.getWidth(), Tex.marker_tonnel_1.getHeight());
                }
            }
        }
        batch.end();
        GameProcess.menuBatch.begin();
        if (caveObject != null && caveObject.isAvaliableToBuild) {
            accept.act(GameProcess.menuBatch);
        }
        back.act(GameProcess.menuBatch);
        if (cave == 1) {
            cave1active.act(GameProcess.menuBatch);
        } else {
            cave1.act(GameProcess.menuBatch);
        }

        GameProcess.menuBatch.end();
        batch.begin();
    }

    @Override
    public void input() {
        if (back.input()) {
            accept.isActivated = false;
            GameLayout.removeProcess();;
        }
        if (cave == 1) {
            if (cave1active.input()) {
                cave = 0;
                caveObject = null;
                cave1active.isActivated = false;
                cave1active.setDelay(5);
            }
        } else {
            if (cave1.input()) {
                cave1.isActivated = false;
                cave1.setDelay(5);
                cave = 1;
                caveObject = new Cave(5, 3);
            }
        }
        if (caveObject != null && caveObject.isAvaliableToBuild && accept.input()) {
            accept.isActivated = false;
            if (caveObject.type == 1) {
                caveObject.setPosition(new Vector2(caveObject.markerPosition.x - 2, caveObject.markerPosition.y - 1));
            }
            CaveEvent caveEvent = new CaveEvent(caveObject);
            GameProcess.eventController.addEvent(caveEvent);
            GameLayout.removeProcess();
        }
        if (cave > 0) {
            Vector3 ar = GameLayout.camera.unproject(new Vector3(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0));
            if (ar.x >= 0 && ar.y >= 0) {
                int x = (int) (ar.x / (30 * Tex.x));
                int y = (int) (ar.y / (30 * Tex.y)) + 1;
                if (x >= 0 && y >= 0 && x < BlockMap.sizeX && y < BlockMap.sizeY) {
                    caveObject.setMarkerPosition(new Vector2(x, y));
                }
            }
        }
    }
}
