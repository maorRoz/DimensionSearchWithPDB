package com.company;

public class GameGrid3D {
    private Tile[][][] tiles;

    public GameGrid3D(int numberOfLayers,int numberOfRows, int numberOfColumns){
        if(numberOfLayers<= 0 || numberOfColumns <= 0 || numberOfRows <= 0){
            throw new Error();
        }

        tiles = new Tile[numberOfLayers][numberOfRows][numberOfColumns];

        for(int i=0;i<numberOfLayers;i++){
            for (int j=0;j<numberOfRows;j++){
                for(int k=0;k<numberOfColumns;k++){
             //       tiles[i][j][k] = new Tile();
                }
            }
        }
    }

    public void setTile(int numberOfLayers,int rowNumber, int columnNumber, Tile.TileState tileState){
        tiles[numberOfLayers][rowNumber][columnNumber].setState(tileState);
    }
}
