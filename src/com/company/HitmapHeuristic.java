package com.company;

public class HitmapHeuristic implements IHeuristic {
    int[][] hitMap;

    HitmapHeuristic(GameGrid2D grid, Tile startTile) {
        DijkstraSearch dijkstraSearch = new DijkstraSearch();
        HeatMap2D heatMap2D = dijkstraSearch.search(startTile,grid);
        hitMap = heatMap2D.getMap();
    }

    public double getHeuristic(IProblemState problemState) {
        int h = 0;
        MapState state = (MapState) problemState;
        h = hitMap[state._currentCol][state._currentRow];
        return h;
    }

    @Override
    public void HeuristicName() {
        System.out.println("-----------------------------------");
        System.out.println("HitmapHeuristic:");
    }

}
