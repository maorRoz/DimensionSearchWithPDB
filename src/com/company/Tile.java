package com.company;

import java.util.ArrayList;

public class Tile {

    public enum TileState {EMPTY,OCCUPIED}
    private TileState value;
    private ArrayList<int[]> neighbors;

    int X;
    int Y;

    public Tile( ){
       this.setState(TileState.EMPTY);
    }

    public Tile(TileState value){
        this.setState(value);
    }

    public void setState(TileState value){
        this.value = value;
    }

    public void setNeighbors(ArrayList<int[]> neighbors){
        this.neighbors = neighbors;
    }
    public Tile[] getNeighbors(GameGrid2D grid){
        ArrayList<Tile> neighborsTiles = new ArrayList<Tile>();
        for(int[] neighbor: neighbors){
            neighborsTiles.add(grid.getTile(neighbor[0],neighbor[1]));
        }

        return neighborsTiles.toArray(new Tile[neighborsTiles.size()]);
    }

    public boolean isOccupied(){
        return value == TileState.OCCUPIED;
    }
    public int getvalue() {
        if(value == TileState.EMPTY )return 0;
        return 1;
    }


}
