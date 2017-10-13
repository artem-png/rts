package com.mygdx.game.event.eventHelpers;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.MapHelper;

public class Distance {

    public static boolean isReady = false;

    public static int getDistance(Vector2 gnomPosition, Vector2 cellPosition) {
        if (cellPosition.x == gnomPosition.x) {
            if (cellPosition.y - gnomPosition.y == 1) {
                return 0;
            } else if (cellPosition.y - gnomPosition.y == -1) {
                return 0;
            }
        } else if (cellPosition.y == gnomPosition.y) {
            if (cellPosition.x - gnomPosition.x == 1) {
                return 0;
            } else if (cellPosition.x - gnomPosition.x == -1) {
                return 0;
            }
        }
        int[][] map = MapHelper.getAvaliableMapToWalk();
        isReady = false;
        map[(int) gnomPosition.x][(int) gnomPosition.y] = -1;
        map[(int) cellPosition.x][(int) cellPosition.y] = -10;
        map = fillAround(map, (int) gnomPosition.x, (int) gnomPosition.y, 1);
        int a = 1;
        while (!isReady) {
            isReady = true;
            for (int j = 0; j < BlockMap.sizeX; j++) {
                for (int i = 0; i < BlockMap.sizeY; i++) {
                    if (map[j][i] == a) {
                        map = fillAround(map, j, i, a + 1);
                    }
                }
            }
            a++;
        }
        return getCoordMinimum(map, (int) cellPosition.x, (int) cellPosition.y);
    }

    public static int[][] fillAround(int[][] map, int x, int y, int number) {
        int mapsizex = BlockMap.sizeX;
        int mapsizey = BlockMap.sizeY;
        if (x - 1 >= 0) {
            if (map[x - 1][y] > number || map[x - 1][y] == 0) {
                map[x - 1][y] = number;
                isReady = false;
            }
        }
        if (x + 1 < mapsizex) {
            if (map[x + 1][y] > number || map[x + 1][y] == 0) {
                map[x + 1][y] = number;
                isReady = false;
            }
        }
        if (y - 1 >= 0) {
            if (map[x][y - 1] > number || map[x][y - 1] == 0) {
                map[x][y - 1] = number;
                isReady = false;
            }
        }
        if (y + 1 < mapsizey) {
            if (map[x][y + 1] > number || map[x][y + 1] == 0) {
                map[x][y + 1] = number;
                isReady = false;
            }
        }

        return map;
    }

    public static int getCoordMinimum(int[][] map, int x, int y) {
        int mapsizex = BlockMap.sizeX;
        int mapsizey = BlockMap.sizeY;
        //MapHelper.printMap(map);
        int min = 10000;
        if (x - 1 >= 0) {
            if (map[x - 1][y] > 0) {
                if (map[x - 1][y] < min) {
                    min = map[x - 1][y];
                }
            }
        }
        if (x + 1 < mapsizex) {
            if (map[x + 1][y] > 0) {
                if (map[x + 1][y] < min) {
                    min = map[x + 1][y];
                }
            }
        }
        if (y - 1 >= 0) {
            if (map[x][y - 1] > 0) {
                if (map[x][y - 1] < min) {
                    min = map[x][y - 1];
                }
            }
        }
        if (y + 1 < mapsizey) {
            if (map[x][y + 1] > 0) {
                if (map[x][y + 1] < min) {
                    min = map[x][y + 1];
                }
            }
        }

        return min;
    }
}
