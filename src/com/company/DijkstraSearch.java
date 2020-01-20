package com.company;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DijkstraSearch {
    private PriorityQueue<DijkstraSearchNode> vertexList;

    private class DijkstraSearchNodeComparator implements Comparator<DijkstraSearchNode>
    {
        @Override
        public int compare(DijkstraSearchNode node1, DijkstraSearchNode node2) {
            if(node1.getF() < node2.getF()) return -1;
            if(node1.getF() > node2.getF()) return 1;
            return 0;
        }
    }

    public DijkstraSearch(){
        vertexList = new PriorityQueue<DijkstraSearchNode>(1,new DijkstraSearchNodeComparator());
    }

    private void updateVertexList(){
        DijkstraSearchNode[] nodes = vertexList.toArray( new DijkstraSearchNode[vertexList.size()]);
        vertexList.clear();
        for(DijkstraSearchNode node: nodes){
            vertexList.add(node);
        }
    }

    public HeatMap2D search(Tile startTile, GameGrid2D gameGrid){
        Tile[][] grid = gameGrid.getGrid();

        HeatMap2D heatMap = new HeatMap2D(grid);

        for(Tile[] tilesRow: grid){
            for(Tile tile: tilesRow){
                DijkstraSearchNode node;
                if(tile == startTile){
                   node = new DijkstraSearchNode(tile, 0);
                } else {
                    node = new DijkstraSearchNode(tile, Integer.MAX_VALUE);
                }
                vertexList.add(node);
            }
        }

        while(!vertexList.isEmpty()){
            DijkstraSearchNode currentNode = vertexList.remove();

            heatMap.setTile(currentNode.getTile().X,currentNode.getTile().Y, currentNode.getG());

            for(Tile neighbor: currentNode.getNeighbors()){
                int newDistance = currentNode.getF() + 1;

                Iterator<DijkstraSearchNode> iterator = vertexList.iterator();

                while(iterator.hasNext()){
                    DijkstraSearchNode node = iterator.next();
                    if(node.getTile() == neighbor){
                        node.changeDistanceFromStart(newDistance);
                    }
                }

                updateVertexList();

            }

        }

        vertexList.clear();
        return heatMap;
    }

}
