package com.company;

public class Main {

    public static void main(String[] args) {
        GameGrid2D grid = new GameGrid2D(4,4);

        AStarSearch starSearch = new AStarSearch(new EuclideanDistanceHeuristic(), grid.getTile(3,3));

        starSearch.initSearch(grid.getTile(1,1));

        while(starSearch.getResult() != AStarSearch.SearchState.DONE && starSearch.getResult() != AStarSearch.SearchState.FAILED){
            starSearch.nextStep();
        }

        if(starSearch.getResult() == AStarSearch.SearchState.DONE){
            System.out.println("found!");
        }
    }
}
