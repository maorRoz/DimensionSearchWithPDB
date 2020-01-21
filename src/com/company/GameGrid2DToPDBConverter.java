package com.company;

import java.util.ArrayList;

public class GameGrid2DToPDBConverter {
    private PDB pdb;

    public GameGrid2DToPDBConverter(GameGrid2D originalGameGrid, IPDBPlan pdbPlan) {
        pdb = pdbPlan.createPDB(originalGameGrid);
    }

    public PDB getPDB(){
        return pdb;
    }
}
