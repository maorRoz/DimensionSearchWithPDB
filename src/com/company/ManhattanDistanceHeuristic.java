package com.company;

public class ManhattanDistanceHeuristic implements IHeuristic {
    public double calculateHeuristic(Tile currentTile, Tile goal){
        return Math.abs(currentTile.X - goal.X) + Math.abs(currentTile.Y - goal.Y);
    }
}
