package com.ssa.ironyard;

public class SudokuSolverImpl implements SudokuSolver
{
    private final SudokuGame s;
    
    private final int[] sudokuArray;

    public int[] solve() {
	// TODO Auto-generated method stub
	return null;
    }

    public SudokuSolverImpl(SudokuGame s) {
	this.s = s;
	sudokuArray = s.getGame();
    }
    
    private int getIndex(int row, int column){
	return row*9+column;
    }

}
