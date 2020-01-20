package com.company;

public class EuclideanDistanceHeuristic implements IHeuristic{
    public double calculateHeuristic(Tile currentTile, Tile goal){
        return Math.sqrt(2*(goal.X - currentTile.X) + 2*(goal.Y - currentTile.Y));
    }
}
