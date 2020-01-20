package com.company;

public class HeatMap2D {
    private int[][] tiles;

    HeatMap2D(Tile[][] grid){
        tiles = new int[grid.length][grid[0].length];
    }

    public int[][] getMap(){
        return tiles;
    }

    public void setTile(int numberOfRow, int numberOfColumn, int value){
        tiles[numberOfRow][numberOfColumn] = value;
    }
}
