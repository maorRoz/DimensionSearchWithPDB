package com.company;

public class AirGapDistanceHeuristic implements IHeuristic {

    public double getHeuristic(IProblemState problemState){
        MapState state = (MapState) problemState;
        return Math.sqrt(Math.pow(state._currentCol - state._problem._goalCol,2) + Math.pow(state._currentRow - state._problem._goalRow,2));
    }

    @Override
    public void HeuristicName() {
        System.out.println("-----------------------------------");
        System.out.println("AirGapDistanceHeuristic:");
    }


}
