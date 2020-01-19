package com.company;

public class Tile {
    public enum TileState {EMPTY,OCCUPIED}
    private TileState value;
    private Tile[] neighbors;

    public Tile( ){
       this.setState(TileState.EMPTY);
    }

    public Tile(TileState value){
        this.setState(value);
    }

    public void setState(TileState value){
        this.value = value;
    }

    public void setNeighbors(Tile[] neighbors){
        this.neighbors = neighbors;
    }

    public boolean isOccupied(){
        return value == TileState.OCCUPIED;
    }


}
