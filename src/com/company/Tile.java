package com.company;

public class Tile {


    public enum TileState {EMPTY,OCCUPIED}
    private TileState value;
    private Tile[] neighbors;

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

    public void setNeighbors(Tile[] neighbors){
        this.neighbors = neighbors;
    }
    public Tile[] getNeighbors(){
        return neighbors;
    }

    public boolean isOccupied(){
        return value == TileState.OCCUPIED;
    }
    public String getvalue() {
        if(value == TileState.EMPTY )return ".";
        return "x";
    }


}
