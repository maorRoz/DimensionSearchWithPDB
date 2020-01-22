package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
//		long start = System.currentTimeMillis();
        System.out.println("Start!");


        AStarSearch astar = new AStarSearch();
        GameGrid2D play = MapFileLoader.loadMapFile("/Users/maorr/Downloads/arena.map");

        solveInstances(astar,play.gettheGrid() , new ManhattanDistanceHeuristic());
        solveInstances(astar, play.gettheGrid(), new AirGapDistanceHeuristic());

        solveInstances(astar, play.gettheGrid(), new HitmapHeuristic(play,play.getTile(10,10)));



        System.out.println("");
        System.out.println("Done!");
//		System.out.println("time: "+(System.currentTimeMillis() - start));
    }


    public static void solveInstances(ASearch solvers, int [][] instance, IHeuristic heuristic) {

            long totalTime = 0;

                Map problem = new Map(instance,1,2,1,7, heuristic);

                    long startTime = System.nanoTime();
                    List<IProblemMove> solution = solvers.solve(problem);
                    long finishTime = System.nanoTime();

                  //  if (cost >= 0)        // valid solution
                    {
                        // printSolution(problem, solution);

                        System.out.println("Moves: " + solution.size());
                        System.out.println("Time:  " + (finishTime - startTime) / 1000000.0 + " ms");
                        System.out.println(solution);
                        totalTime += (finishTime - startTime) / 1000000.0;
                    }// else                // invalid solution
                      //  System.out.println("Invalid solution.");

                System.out.println("");

            System.out.println("Total time:  " + totalTime / 60000.0 + " min");
            System.out.println("");

    }




}
