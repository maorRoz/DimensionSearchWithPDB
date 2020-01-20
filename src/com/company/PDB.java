package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class PDB {
    private HashMap<Tile, Tile[]> pdbPivotToVertex;
    private HashMap<Tile,HeatMap2D> pdbPivotToHeatMap;

    public PDB(){
        pdbPivotToVertex = new HashMap<Tile, Tile[]>();
        pdbPivotToHeatMap = new HashMap<Tile, HeatMap2D>();
    }

    public void addPivot(Tile pivot, Tile[] group, HeatMap2D heatMap){
        pdbPivotToVertex.put(pivot,group);
        pdbPivotToHeatMap.put(pivot,heatMap);
    }

    public HeatMap2D getHeatMap(Tile tile){
       Set<Tile> pivots =  pdbPivotToVertex.keySet();

       for(Tile pivot: pivots) {
           List<Tile> group = Arrays.asList(pdbPivotToVertex.get(pivot));
           if (group.contains(tile)) {
               return pdbPivotToHeatMap.get(pivot);
           }
       }
       throw new Error();
    }
}
