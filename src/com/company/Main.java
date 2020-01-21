package com.company;

public class Main {

    public static void MakeSearch(AStarSearch starSearch, Tile start){
        starSearch.initSearch(start);
        while(starSearch.getResultStatus() != AStarSearch.SearchState.DONE && starSearch.getResultStatus() != AStarSearch.SearchState.FAILED){
            starSearch.nextStep();
        }

        if(starSearch.getResultStatus() == AStarSearch.SearchState.DONE){
            System.out.println("found!");
        }
    }

    public static void TestCase(GameGrid2D grid, Tile goal, Tile start){
        AStarSearch euclideanSearch = new AStarSearch(new EuclideanDistanceHeuristic(), grid.getTile(goal.X,goal.Y));
        AStarSearch manHattenDistanceSearch = new AStarSearch(new ManhattanDistanceHeuristic(), grid.getTile(goal.X,goal.Y));

        GameGrid2DToPDBConverter converter = new GameGrid2DToPDBConverter(grid);
        PDB pdb  = converter.getPDB();

        HeatMap2D heatMapOfGoalPivot = pdb.getHeatMap(goal);

        AStarSearch  pdbHeatMapSearch = new AStarSearch(new HeatMapDistanceHeuristic(heatMapOfGoalPivot),grid.getTile(goal.X,goal.Y));

        MakeSearch(euclideanSearch,start);
        MakeSearch(manHattenDistanceSearch, start);
        MakeSearch(pdbHeatMapSearch,start);
    }

    public static void main(String[] args) {
        GameGrid2D grid = new GameGrid2D(4,4);

        TestCase(grid,grid.getTile(3,3),grid.getTile(1,1));
    }
}
