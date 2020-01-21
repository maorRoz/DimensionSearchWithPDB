package com.company;

public class HeatMapDistanceHeuristic implements IHeuristic{
    private HeatMap2D heatMap;

    public HeatMapDistanceHeuristic(HeatMap2D heatMap){
        this.heatMap = heatMap;
    }
    public double calculateHeuristic(Tile currentTile, Tile goalTile){
        return heatMap.getTileDistance(currentTile.X,currentTile.Y);
    }
}
