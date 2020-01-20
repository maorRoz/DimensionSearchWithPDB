package com.company;

public class SearchNode {
    private Tile tile;
    private Tile goalTile;

    private int distanceFromStart;

    private IHeuristic heuristic;

    public SearchNode(Tile tile,Tile goalTile, int distanceFromStart, IHeuristic heuristic){
        this.tile = tile;
        this.goalTile = goalTile;
        this.distanceFromStart = distanceFromStart;
        this.heuristic = heuristic;
    }

    public Tile getTile(){
        return tile;
    }

    public Tile[] getNeighbors(){
        return tile.getNeighbors();
    }

    public int getG(){
        return distanceFromStart;
    }

    public double getH(){
        return heuristic.calculateHeuristic(tile, goalTile);
    }

    public double getF(){
        return tile.isOccupied() ? Double.POSITIVE_INFINITY: getG() + getH();
    }
}
