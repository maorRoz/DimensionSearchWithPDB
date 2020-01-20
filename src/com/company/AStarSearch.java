package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarSearch {
    public enum SearchState {PENDING, DONE, FAILED}
    private PriorityQueue<AStarSearchNode> openList;

    private class SearchNodeComparator implements Comparator<AStarSearchNode>
    {
        @Override
        public int compare(AStarSearchNode node1, AStarSearchNode node2) {
            if(node1.getF() < node2.getF()) return -1;
            if(node1.getF() > node2.getF()) return 1;
            return 0;
        }
    }

    private ArrayList<AStarSearchNode> closedList;
    private Tile goalTile;
    private IHeuristic heuristic;
    private SearchState searchState;

    public AStarSearch(IHeuristic heuristic,Tile goalTile){
        this.heuristic = heuristic;
        openList = new PriorityQueue<AStarSearchNode>(1,new SearchNodeComparator());
        closedList = new ArrayList<AStarSearchNode>();
        this.goalTile = goalTile;
        searchState = SearchState.PENDING;
    }

    public void initSearch(Tile startTile){
        AStarSearchNode startNode = new AStarSearchNode(startTile,goalTile,0,heuristic);
        openList.add(startNode);
    }

    public void nextStep(){
        if(openList.isEmpty()){
            searchState = SearchState.FAILED;
            return;
        }

        AStarSearchNode currentNode = openList.remove();
        System.out.println("popped X:"+currentNode.getTile().X+" Y: "+currentNode.getTile().Y);
        closedList.add(currentNode);

        if(currentNode.getTile().isOccupied()){
            searchState = SearchState.FAILED;
            return;
        }

        if(currentNode.getTile() == goalTile){
            searchState = SearchState.DONE;
            return;
        }

        Tile[] children = currentNode.getNeighbors();

        for(Tile child: children){
            AStarSearchNode childNode = new AStarSearchNode(child,goalTile,currentNode.getG()+ 1,heuristic);
            openList.add(childNode);
        }
    }

    public void clearSearch(){
        openList = new PriorityQueue<AStarSearchNode>(1,new SearchNodeComparator());
        closedList = new ArrayList<AStarSearchNode>();
        searchState = SearchState.PENDING;
    }

    public Tile[] getRoute(){
        return closedList.toArray(new Tile[closedList.size()]);
    }

    public SearchState getResult(){
        return searchState;
    }


}
