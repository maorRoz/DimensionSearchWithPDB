package com.company;

import java.util.ArrayList;

public class GameGrid2D {
    public Tile[][] tiles;

    public GameGrid2D(int numberOfColumns, int numberOfRows) {
        if (numberOfColumns <= 0 || numberOfRows <= 0) {
            throw new Error();
        }


        tiles = new Tile[numberOfRows][numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                tiles[i][j] = new Tile();
                tiles[i][j].X = j;
                tiles[i][j].Y = i;
            }
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                ArrayList<int[]> x = new ArrayList<int[]>();
                if (i > 0) {
                    x.add(new int[]{i-1,j});
                }
                if (i < numberOfRows - 1) {
                    x.add(new int[]{i+1,j});
                }

                if (j > 0) {
                    x.add(new int[]{i,j-1});
                }
                if (j < numberOfColumns - 1) {
                    x.add(new int[]{i,j+1});
                }
                tiles[i][j].setNeighbors(x);
            }
        }
    }

    public int[][] gettheGrid() {
        int[][] x = new int[tiles.length][tiles[0].length];


        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[1].length; j++) {
                x[i][j] = tiles[i][j].getvalue();
            }
        }
        return x;

    }

    public void setTile(int rowNumber, int columnNumber, Tile.TileState tileState) {
        tiles[rowNumber][columnNumber].setState(tileState);
    }

    public Tile getTile(int rowNumber, int columnNumber) {
        return tiles[rowNumber][columnNumber];
    }

    public Tile[][] getGrid() {
        return tiles;
    }


    public void mapPrint() {
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles[1].length; j++) {
                System.out.print(tiles[i][j].getvalue());

            }
            System.out.println();

        }
    }
}
