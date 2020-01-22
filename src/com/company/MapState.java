package com.company;

import java.util.ArrayList;
import java.util.List;

public class MapState implements IProblemState {
    Map _problem;
    int _currentRow;
    int _currentCol;
    private IProblemMove _lastMove;


    public MapState(Map problem, int currentRow, int currentCol,IProblemMove lastMove) {
        _problem = problem;
        _currentRow = currentRow;
        _currentCol = currentCol;
        _lastMove = lastMove;

    }

    @Override
    public List<IProblemState> getNeighborStates() {
        List<IProblemState> neighborStates = new ArrayList<IProblemState>();
        List<TileMapMove> legalMoves = getLegalMoves();

        for (TileMapMove move : legalMoves) {
            IProblemState newState = performMove(move);
            if (newState != null)
                neighborStates.add(newState);
        }
        return neighborStates;
    }

    @Override
    public IProblem getProblem() {
        return _problem;
    }

    @Override
    public boolean isGoalState() {
        int size = _problem._size;

                if (this._currentCol !=this._problem._goalCol)
                    return false;
                if(this._currentRow!=this._problem._goalRow)
                    return false;
        return true;
    }

    @Override
    public IProblemMove getStateLastMove() {
        return _lastMove;
    }

    @Override
    public double getStateLastMoveCost() {
        return 1;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj instanceof MapState) {
            MapState otherState = (MapState) obj;
            if (_currentCol == otherState._currentCol  && _currentRow ==otherState._currentRow)
                return true;
        }
        return false;
    }

    public IProblemState performMove(IProblemMove move) {

      //  System.out.println(this.toString());
        if (!(move instanceof TileMapMove))
            return null;

        Map newProblem = _problem;
        int newCurrentRow = _currentRow;
        int newCurrentCol = _currentCol;

        TileMapMove tilePuzzleMove = (TileMapMove) move;

        // Find the moving cell
        if (tilePuzzleMove._move == TileMapMove.MOVE.DOWN)
            newCurrentRow--;
        else if (tilePuzzleMove._move == TileMapMove.MOVE.UP)
            newCurrentRow++;
        else if (tilePuzzleMove._move == TileMapMove.MOVE.RIGHT)
            newCurrentCol--;
        else if (tilePuzzleMove._move == TileMapMove.MOVE.LEFT)
            newCurrentCol++;

        // Validation

        if(_problem._tileMap[newCurrentRow][newCurrentCol]==1) //its a wal
            return null;


        if (notLegitMov(newCurrentRow, newCurrentCol))
            return null;



        // Perform the action

       // _currentRow = newCurrentRow;
       // _currentCol = newCurrentCol;

        // Create new state
        return new MapState(newProblem,  newCurrentRow, newCurrentCol,move);

    }

    private List<TileMapMove> getLegalMoves() {
        int size = _problem._size;

        List<TileMapMove> moveList = new ArrayList<TileMapMove>();

        if (_currentRow != 0)
            moveList.add(new TileMapMove(TileMapMove.MOVE.DOWN));

        if (_currentRow != size - 1)
            moveList.add(new TileMapMove(TileMapMove.MOVE.UP));

        if (_currentCol != 0)
            moveList.add(new TileMapMove(TileMapMove.MOVE.RIGHT));

        if (_currentCol != size - 1)
            moveList.add(new TileMapMove(TileMapMove.MOVE.LEFT));
        return moveList;
    }

    private boolean notLegitMov(int row, int col) {
        if (row < 0 || row >= this._problem._size || col < 0 || col >= this._problem._size)
            if (this._problem._tileMap[row][col] == 1) {
                System.out.println(row+"-"+col);
                return true;
            }
        return false;
    }

    public String toString(){
        return "<"+_currentCol+","+_currentRow+">";
    }
    
    
    
    

}
