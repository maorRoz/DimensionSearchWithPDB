package com.company;

public class DijkstraSearchNode {
    private Tile tile;
    private int distanceFromStart;

    public DijkstraSearchNode(Tile tile, int distanceFromStart){
        this.tile = tile;
        this.distanceFromStart = distanceFromStart;
    }

    public void changeDistanceFromStart(int distanceFromStart){
        this.distanceFromStart = distanceFromStart;
    }

    public Tile getTile(){
        return tile;
    }

    public Tile[] getNeighbors(GameGrid2D grid){
        return tile.getNeighbors(grid);
    }

    public int getG(){
        return distanceFromStart;
    }

    public int getF(){
        return getG();
    }
}
