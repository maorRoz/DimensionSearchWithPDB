package com.company;

public class ManhattanDistanceHeuristic implements  IHeuristic{


    public double getHeuristic(IProblemState problemState){
        MapState state = (MapState) problemState;
        return Math.abs(state._currentCol - state._problem._goalCol) + Math.abs(state._currentRow - state._problem._goalRow);
    }

    @Override
    public void HeuristicName() {
        System.out.println("-----------------------------------");
        System.out.println("ManhattanDistanceHeuristic:");
    }


}
