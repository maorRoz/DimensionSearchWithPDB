package com.company;

public class Main {

    public static void main(String[] args) {
        GameGrid2D grid = new GameGrid2D(4,4);

        AStarSearch starSearch = new AStarSearch(new EuclideanDistanceHeuristic(), grid.getTile(3,3));

        starSearch.initSearch(grid.getTile(1,1));

        while(starSearch.getResultStatus() != AStarSearch.SearchState.DONE && starSearch.getResultStatus() != AStarSearch.SearchState.FAILED){
            starSearch.nextStep();
        }

        if(starSearch.getResultStatus() == AStarSearch.SearchState.DONE){
            System.out.println("found!");
        }

        DijkstraSearch dijkstraSearch = new DijkstraSearch();
        HeatMap2D heatMap2D = dijkstraSearch.search(grid.getTile(1,1),grid);
    }
}
