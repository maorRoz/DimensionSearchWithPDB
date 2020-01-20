package com.company;

import java.util.ArrayList;

public class GameGrid2DToPDBConverter {
    private GameGrid2D gameGrid;
    private PDB pdb;

    public static  ArrayList<Tile> CreatePartition(GameGrid2D gameGrid, int startI,int endI, int startJ, int endJ){
        ArrayList<Tile> partition = new ArrayList<Tile>();
        for(int i=startI;i<endI;i++){
            for(int j=startJ;j<endJ;j++){
                partition.add(gameGrid.getTile(i,j));
            }
        }

        return partition;
    }

    public GameGrid2DToPDBConverter(GameGrid2D originalGameGrid){
        pdb = new PDB();
        gameGrid = new GameGrid2D(2,2);

        ArrayList<ArrayList<Tile>> partitions = new ArrayList<ArrayList<Tile>>();

        partitions.add(CreatePartition(originalGameGrid, 0,originalGameGrid.getGrid().length/2,0,originalGameGrid.getGrid().length/2));
        partitions.add(CreatePartition(originalGameGrid, 0,originalGameGrid.getGrid().length/2,originalGameGrid.getGrid().length/2,originalGameGrid.getGrid().length));
        partitions.add(CreatePartition(originalGameGrid, originalGameGrid.getGrid().length/2,originalGameGrid.getGrid().length,0,originalGameGrid.getGrid().length/2));
        partitions.add(CreatePartition(originalGameGrid, originalGameGrid.getGrid().length/2,
                originalGameGrid.getGrid().length,originalGameGrid.getGrid().length/2,originalGameGrid.getGrid().length));

        DijkstraSearch dijkstraSearch = new DijkstraSearch();

        int currentPivotX = 0;
        int currentPivotY = 0;

        for(ArrayList<Tile> partition: partitions){
            HeatMap2D heatMap = dijkstraSearch.search(partition.get(0),originalGameGrid);

            gameGrid.setTile(currentPivotX,currentPivotY,Tile.TileState.EMPTY);

            pdb.addPivot(gameGrid.getTile(currentPivotX,currentPivotY),partition.toArray(new Tile[partition.size()]),heatMap);

            if(currentPivotY == 1){
                currentPivotY = 0;
                currentPivotX = 1;
            } else {
                currentPivotY++;
            }
        }

        gameGrid.getTile(0,0).setNeighbors(new Tile[]{gameGrid.getTile(0,1),gameGrid.getTile(1,0)});
        gameGrid.getTile(0,1).setNeighbors(new Tile[]{gameGrid.getTile(0,0),gameGrid.getTile(1,1)});
        gameGrid.getTile(1,0).setNeighbors(new Tile[]{gameGrid.getTile(1,1),gameGrid.getTile(0,0)});
        gameGrid.getTile(1,1).setNeighbors(new Tile[]{gameGrid.getTile(1,0),gameGrid.getTile(0,1)});
    }
}
