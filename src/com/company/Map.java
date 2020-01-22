package com.company;

public class Map implements IProblem {


    public enum MOVECOST {STANDARD, INCREASING}

    int[][] _tileMap;    // Problem instance
    int _startRow;
    int _startCol;
    int _goalRow;
    int _goalCol;
//    int _currentRow;
//    int _currentCol;

    int _size;
    IHeuristic _heuristic;        // The problem heuristic

    public Map(int[][] probleMap, int startrow, int startcol, int goalrow, int goalcol, IHeuristic heuristic) {
        heuristic.HeuristicName();


        _tileMap = new int[probleMap.length][probleMap[0].length];

        for (int i = 0; i < probleMap.length; i++) {
            for (int j = 0; j < probleMap[1].length; j++) {
                _tileMap[i][j] = probleMap[i][j];
           //     System.out.print( _tileMap[i][j] );

            }
           // System.out.println();

        }

        _size = _tileMap.length;

        _startRow = startrow;
        _startCol = startcol;

        _goalRow = goalrow;
        _goalCol = goalcol;

//        _currentRow = _startRow;
//        _currentCol = _startCol;

        _heuristic = heuristic;
    }


    @Override
    public IProblemState getProblemState() {
        MapState root = new MapState(this, _startRow, _startCol ,null);
        return root;
    }

    @Override
    public IHeuristic getProblemHeuristic() {
        return _heuristic;
    }


//    @Override
//    public boolean performMove(IProblemMove move) {
//        int tempRow = _currentRow;
//        int tempCol = _currentCol;
//
//        if (move instanceof TileMapMove) {
//            TileMapMove tilemapMove = (TileMapMove) move;
//
//            // Find the moving cell
//            if (tilemapMove._move == TileMapMove.MOVE.UP)
//                tempRow--;
//            else if (tilemapMove._move == TileMapMove.MOVE.DOWN)
//                tempRow++;
//            else if (tilemapMove._move == TileMapMove.MOVE.LEFT)
//                tempCol--;
//            else if (tilemapMove._move == TileMapMove.MOVE.RIGHT)
//                tempCol++;
//
//            // Validation
//            if (outOfBoundaries(tempRow, tempCol))
//                return false;
//
//
//
//            _currentRow = tempRow;
//            _currentCol = tempCol;
//
//            return true;
//        }
//        return false;
//    }

//
//    private boolean outOfBoundaries(int row, int col) {
//        if (row < 0 || row >= _size || col < 0 || col >= _size)
//            if (_tileMap[row][col] == 1)
//                return true;
//        return false;
//    }

}
