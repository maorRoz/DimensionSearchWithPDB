package com.company;
import java.util.ArrayList;

public class GameGrid2D {
    public Tile[][] tiles;

    public GameGrid2D(int numberOfColumns, int numberOfRows){
        if(numberOfColumns <= 0 || numberOfRows <= 0){
            throw new Error();
        }

        tiles = new Tile[numberOfRows][numberOfColumns];

        for(int i=0;i<numberOfRows;i++){
            for (int j=0;j<numberOfColumns;j++){
                tiles[i][j] = new Tile();
                tiles[i][j].X = j;
                tiles[i][j].Y = i;
            }
        }

        for(int i=0;i<numberOfRows;i++){
            for (int j=0;j<numberOfColumns;j++){
                ArrayList<Tile> x = new ArrayList<Tile>();
                if(i>0){
                    x.add(tiles[i-1][j]);
                }
                if(i < numberOfRows - 1){
                    x.add(tiles[i+1][j]);
                }

                if(j>0){
                    x.add(tiles[i][j-1]);
                }
                if(j < numberOfColumns - 1){
                    x.add(tiles[i][j+1]);
                }
                tiles[i][j].setNeighbors(x.toArray(new Tile[x.size()]));
            }
        }
    }

    public void setTile(int rowNumber, int columnNumber, Tile.TileState tileState){
        tiles[rowNumber][columnNumber].setState(tileState);
    }

    public Tile getTile(int rowNumber, int columnNumber){
        return tiles[rowNumber][columnNumber];
    }

    public Tile[][] getGrid(){
        return tiles;
    }
}
