package com.company;

import java.util.List;

public class HitmapHeuristicPDB implements IHeuristic {
    List<int[][]> hitMap;

    HitmapHeuristicPDB(int[][] map) {
    //    for (int i : pivot_list)
     //       hitMap.add(calcHitmap(map,i.row,i.col));
    }

    public double getHeuristic(IProblemState problemState) {
        int h = 0;
        MapState state = (MapState) problemState;
       // h = hitMap[state._currentCol][state._currentRow];
        return h;
    }


    public int[][] calcHitmap(int[][] domain, int pivotRow, int pivotCol) {

        return null;


    }

    @Override
    public void HeuristicName() {
        System.out.println("-----------------------------------");
        System.out.println("HitmapHeuristic:");
    }
}
