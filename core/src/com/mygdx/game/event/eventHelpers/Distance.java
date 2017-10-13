package com.mygdx.game.event.eventHelpers;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.models.map.BlockMap;
import com.mygdx.game.models.map.MapHelper;
import com.mygdx.game.process.GameProcess;

import java.util.Vector;

public class Distance {

    public static boolean isReady = false;
    private static Vector<Vector2> vector2s;
    private static Vector<Vector2> vector2sHelp;


    public static int getDistance(Vector2 gnomPosition, Vector2 cellPosition) {
        vector2s = new Vector<Vector2>();
        vector2sHelp = new Vector<Vector2>();
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
        GameProcess.blockMap.generateAvaliableMap();
        int[][] map = MapHelper.getAvaliableMapToWalk();
        isReady = false;
        map[(int) gnomPosition.x][(int) gnomPosition.y] = -1;
        map[(int) cellPosition.x][(int) cellPosition.y] = -10;
        map = fillAround(map, (int) gnomPosition.x, (int) gnomPosition.y, 1);
        vector2s.addAll(vector2sHelp);
        vector2sHelp.clear();
        int a = 1;
        while (vector2s.size() > 0) {
            for (int i = 0; i < vector2s.size(); i++) {
                if (map[(int) vector2s.get(i).x][(int) vector2s.get(i).y] == a) {
                    map = fillAround(map, (int) vector2s.get(i).x, (int) vector2s.get(i).y, a + 1);
                }
            }
            vector2s.clear();
            vector2s.addAll(vector2sHelp);
            vector2sHelp.clear();
            a++;
        }
        return getCoordMinimum(map, (int) cellPosition.x, (int) cellPosition.y);
    }

    public static int[][] fillAround(int[][] map, int x, int y, int number) {
        int mapsizex = BlockMap.sizeX;
        int mapsizey = BlockMap.sizeY;
        if (x - 1 >= 0) {
            if (map[x - 1][y] > number || map[x - 1][y] == 0) {
                vector2sHelp.add(new Vector2(x - 1, y));
                map[x - 1][y] = number;
                isReady = false;
            }
        }
        if (x + 1 < mapsizex) {
            if (map[x + 1][y] > number || map[x + 1][y] == 0) {
                vector2sHelp.add(new Vector2(x + 1, y));
                map[x + 1][y] = number;
                isReady = false;
            }
        }
        if (y - 1 >= 0) {
            if (map[x][y - 1] > number || map[x][y - 1] == 0) {
                vector2sHelp.add(new Vector2(x, y - 1));
                map[x][y - 1] = number;
                isReady = false;
            }
        }
        if (y + 1 < mapsizey) {
            if (map[x][y + 1] > number || map[x][y + 1] == 0) {
                vector2sHelp.add(new Vector2(x, y + 1));
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
