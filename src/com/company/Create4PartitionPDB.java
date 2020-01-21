package com.company;

import java.util.ArrayList;

public class Create4PartitionPDB implements IPDBPlan {
    public static  ArrayList<Tile> CreatePartition(GameGrid2D gameGrid, int startI,int endI, int startJ, int endJ){
        ArrayList<Tile> partition = new ArrayList<Tile>();
        for(int i=startI;i<endI;i++){
            for(int j=startJ;j<endJ;j++){
                partition.add(gameGrid.getTile(i,j));
            }
        }

        return partition;
    }

    public PDB createPDB(GameGrid2D gameGrid) {
        PDB pdb = new PDB();

        ArrayList<ArrayList<Tile>> partitions = new ArrayList<ArrayList<Tile>>();

        partitions.add(CreatePartition(gameGrid, 0, gameGrid.getGrid().length / 2, 0, gameGrid.getGrid().length / 2));
        partitions.add(CreatePartition(gameGrid, 0, gameGrid.getGrid().length / 2, gameGrid.getGrid().length / 2, gameGrid.getGrid().length));
        partitions.add(CreatePartition(gameGrid, gameGrid.getGrid().length / 2, gameGrid.getGrid().length, 0, gameGrid.getGrid().length / 2));
        partitions.add(CreatePartition(gameGrid, gameGrid.getGrid().length / 2,
                gameGrid.getGrid().length, gameGrid.getGrid().length / 2, gameGrid.getGrid().length));

        DijkstraSearch dijkstraSearch = new DijkstraSearch();

        int currentPivotX = 0;
        int currentPivotY = 0;

        for (ArrayList<Tile> partition : partitions) {
            HeatMap2D heatMap = dijkstraSearch.search(partition.get(0), gameGrid);

            Tile pivot = new Tile();
            pivot.X = currentPivotX;
            pivot.Y = currentPivotY;

            pdb.addPivot(pivot, partition.toArray(new Tile[partition.size()]), heatMap);

            if (currentPivotY == 1) {
                currentPivotY = 0;
                currentPivotX = 1;
            } else {
                currentPivotY++;
            }
        }

        return pdb;
    }
}
