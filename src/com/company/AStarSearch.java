package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarSearch {
    public enum SearchState {PENDING, DONE, FAILED}
    private PriorityQueue<SearchNode> openList;

    private class SearchNodeComparator implements Comparator<SearchNode>
    {
        @Override
        public int compare(SearchNode node1, SearchNode node2) {
            if(node1.getF() < node2.getF()) return -1;
            if(node1.getF() > node2.getF()) return 1;
            return 0;
        }
    }

    private ArrayList<SearchNode> closedList;
    private Tile goalTile;
    private IHeuristic heuristic;
    private SearchState searchState;

    public AStarSearch(IHeuristic heuristic,Tile goalTile){
        this.heuristic = heuristic;
        openList = new PriorityQueue<SearchNode>(1,new SearchNodeComparator());
        closedList = new ArrayList<SearchNode>();
        this.goalTile = goalTile;
        searchState = SearchState.PENDING;
    }

    public void initSearch(Tile startTile){
        SearchNode startNode = new SearchNode(startTile,goalTile,0,heuristic);
        openList.add(startNode);
    }

    public void nextStep(){
        if(openList.isEmpty()){
            searchState = SearchState.FAILED;
            return;
        }

        SearchNode currentNode = openList.remove();
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
            SearchNode childNode = new SearchNode(child,goalTile,currentNode.getG()+ 1,heuristic);
            openList.add(childNode);
        }
    }

    public void clearSearch(){
        openList = new PriorityQueue<SearchNode>(1,new SearchNodeComparator());
        closedList = new ArrayList<SearchNode>();
        searchState = SearchState.PENDING;
    }

    public Tile[] getRoute(){
        return closedList.toArray(new Tile[closedList.size()]);
    }

    public SearchState getResult(){
        return searchState;
    }


}
