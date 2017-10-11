package com.mygdx.game.event.eventHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.MapHelper;
import com.mygdx.game.models.player.APlayer;

/**
 * Created by artem on 10/11/17.
 */

public class Movement {
    public APlayer player;
    public Vector2 standPosition;
    public boolean isReady;
    public boolean isVolnaReady = false;

    public Movement() {
    }

    public void setPlayer(APlayer player) {
        this.player = player;
    }

    public void setStandPosition(Vector2 vector2) {
        standPosition = vector2;
        isReady = false;
        isVolnaReady = false;
    }

    public void act() {
        if (!isReady) {
            if (standPosition.x == player.getXYPosition().x) {
                if (standPosition.y - player.getXYPosition().y == 1) {
                    player.goTop();
                    isReady = true;
                } else if (standPosition.y - player.getXYPosition().y == -1) {
                    player.goDown();
                    isReady = true;
                }
            } else if (standPosition.y == player.getXYPosition().y) {
                if (standPosition.x - player.getXYPosition().x == 1) {
                    player.goRight();
                    isReady = true;
                } else if (standPosition.x - player.getXYPosition().x == -1) {
                    player.goLeft();
                    isReady = true;
                }
            }
        }
        if (!isReady) {
            int[][] map = MapHelper.getAvaliableMapToWalk();
            volna(map);
        }
    }

    public void volna(int[][] map) {
        map[(int) player.getXYPosition().x][(int) player.getXYPosition().y] = -1;
        map[(int) standPosition.x][(int) standPosition.y] = -10;
        map = fillAround(map, (int) player.getXYPosition().x, (int) player.getXYPosition().y, 1);
        int a = 1;
        while (!isVolnaReady) {
            isVolnaReady = true;
            for (int j = 0; j < BlockMap.sizeX; j++) {
                for (int i = 0; i < BlockMap.sizeY; i++) {
                    if (map[j][i] == a) {
                        map = fillAround(map, j, i, a + 1);
                    }
                }
            }
            a++;
        }

        Vector2 coords = getCoordMinimum(map, (int) standPosition.x, (int) standPosition.y);
        if (coords.x == player.getXYPosition().x) {
            if (coords.y - player.getXYPosition().y == 1) {
                player.goTop();
                isReady = true;
            } else if (coords.y - player.getXYPosition().y == -1) {
                player.goDown();
                isReady = true;
            }
        } else if (coords.y == player.getXYPosition().y) {
            if (coords.x - player.getXYPosition().x == 1) {
                player.goRight();
                isReady = true;
            } else if (coords.x - player.getXYPosition().x == -1) {
                player.goLeft();
                isReady = true;
            }
        }
        while (!isReady) {
            coords = getCoordMinimum(map, (int) coords.x, (int) coords.y);
            if (coords.x == player.getXYPosition().x) {
                if (coords.y - player.getXYPosition().y == 1) {
                    player.goTop();
                    isReady = true;
                } else if (coords.y - player.getXYPosition().y == -1) {
                    player.goDown();
                    isReady = true;
                }
            } else if (coords.y == player.getXYPosition().y) {
                if (coords.x - player.getXYPosition().x == 1) {
                    player.goRight();
                    isReady = true;
                } else if (coords.x - player.getXYPosition().x == -1) {
                    player.goLeft();
                    isReady = true;
                }
            }
        }
//        System.out.println(coords.x + " " + coords.y);
//        for (int j = 0; j < BlockMap.sizeX; j++) {
//            for (int i = 0; i < BlockMap.sizeY; i++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        Gdx.app.exit();
    }

    public int[][] fillAround(int[][] map, int x, int y, int number) {
        int mapsizex = BlockMap.sizeX;
        int mapsizey = BlockMap.sizeY;
        if (x - 1 >= 0) {
            if (map[x - 1][y] > number || map[x - 1][y] == 0) {
                map[x - 1][y] = number;
                isVolnaReady = false;
            }
        }
        if (x + 1 < mapsizex) {
            if (map[x + 1][y] > number || map[x + 1][y] == 0) {
                map[x + 1][y] = number;
                isVolnaReady = false;
            }
        }
        if (y - 1 >= 0) {
            if (map[x][y - 1] > number || map[x][y - 1] == 0) {
                map[x][y - 1] = number;
                isVolnaReady = false;
            }
        }
        if (y + 1 < mapsizey) {
            if (map[x][y + 1] > number || map[x][y + 1] == 0) {
                map[x][y + 1] = number;
                isVolnaReady = false;
            }
        }
        if ((y + 1 < mapsizey && x + 1 < mapsizex)) {
            if (map[x + 1][y + 1] > number || map[x + 1][y + 1] == 0) {
                map[x + 1][y + 1] = number;
                isVolnaReady = false;
            }
        }
        if ((y - 1 >= 0 && x - 1 >= 0)) {
            if (map[x - 1][y - 1] > number || map[x - 1][y - 1] == 0) {
                map[x - 1][y - 1] = number;
                isVolnaReady = false;
            }
        }
        if ((y - 1 >= 0 && x + 1 < mapsizex)) {
            if (map[x + 1][y - 1] > number || map[x + 1][y - 1] == 0) {
                map[x + 1][y - 1] = number;
                isVolnaReady = false;
            }
        }
        if ((y + 1 < mapsizey && x - 1 >= 0)) {
            if (map[x - 1][y + 1] > number || map[x - 1][y + 1] == 0) {
                map[x - 1][y + 1] = number;
                isVolnaReady = false;
            }
        }

        return map;
    }

    public Vector2 getCoordMinimum(int[][]map, int x, int y) {
        int mapsizex = BlockMap.sizeX;
        int mapsizey = BlockMap.sizeY;
        int min = 10000;
        Vector2 minVector = new Vector2();
        if (x - 1 >= 0) {
            if (map[x - 1][y] > 0) {
                if (map[x - 1][y] < min) {
                    min = map[x - 1][y];
                    minVector.set(x - 1, y);
                }
            }
        }
        if (x + 1 < mapsizex) {
            if (map[x + 1][y] > 0) {
                if (map[x + 1][y] < min) {
                    min = map[x + 1][y];
                    minVector.set(x + 1, y);
                }
            }
        }
        if (y - 1 >= 0) {
            if (map[x][y - 1] > 0) {
                if (map[x][y - 1] < min) {
                    min = map[x][y - 1];
                    minVector.set(x, y - 1);
                }
            }
        }
        if (y + 1 < mapsizey) {
            if (map[x][y + 1] > 0) {
                if (map[x][y + 1] < min) {
                    min = map[x][y + 1];
                    minVector.set(x, y + 1);
                }
            }
        }
        if ((y + 1 < mapsizey && x + 1 < mapsizex)) {
            if (map[x + 1][y + 1] > 0) {
                if (map[x + 1][y + 1] < min) {
                    min = map[x + 1][y + 1];
                    minVector.set(x + 1, y + 1);
                }
            }
        }
        if ((y - 1 >= 0 && x - 1 >= 0)) {
            if (map[x - 1][y - 1] > 0) {
                if (map[x - 1][y - 1] < min) {
                    min = map[x - 1][y - 1];
                    minVector.set(x - 1, y - 1);
                }
            }
        }
        if ((y - 1 >= 0 && x + 1 < mapsizex)) {
            if (map[x + 1][y - 1] > 0) {
                if (map[x + 1][y - 1] < min) {
                    min = map[x + 1][y - 1];
                    minVector.set(x + 1, y - 1);
                }
            }
        }
        if ((y + 1 < mapsizey && x - 1 >= 0)) {
            if (map[x - 1][y + 1] > 0) {
                if (map[x - 1][y + 1] < min) {
                    min = map[x - 1][y + 1];
                    minVector.set(x - 1, y + 1);
                }
            }
        }

        return minVector;
    }
}
