package com.ssa.ironyard;

public class BTSudokuSolverImpl implements SudokuSolver {

    String game;

    @Override
    public String solve() {
	return null;
    }

    public BTSudokuSolverImpl(String game) {
	this.game = game;
    }
    
    

    protected boolean guessValid(int index, char guess){
	for(int i=0; i < 9; i++){
	    if(game.toCharArray()[i + index/9] ==guess)
		return false;
	    if(game.toCharArray()[9*i + index%9] ==guess)
		return false;
	}
	
	int baseRow = boxBase(index/9);
	int baseColumn = boxBase(index%9);
	
	for(int i = baseRow; i < baseRow + 3; i++)
	    for(int j = baseColumn; j < baseColumn + 3; j++)
		if(game.toCharArray()[indexOf(i,j)] == guess)
		    return false;

	return true;
    }

    protected int indexOf(int row, int column) {
	return row * 9 + column;
    }

    private int boxBase(int rowOrColumn) {
	if (rowOrColumn < 3)
	    return 0;
	if (rowOrColumn < 6)
	    return 3;
	return 6;
    }

    @Override
    public String toString() {
	return game.substring(0, 9) + "\n" + 
		game.substring(9,18) +   "\n" +
		game.substring(18,27) +   "\n" +
		game.substring(27,36) +   "\n" +
		game.substring(36,45) +   "\n" +
		game.substring(45,54) +   "\n" +
		game.substring(54,63) +   "\n" +
		game.substring(63,72) +   "\n" +
		game.substring(72,81);
    }
    
    protected boolean gameSolved(){
	if(game.contains("0"))
	    return false;
	return true;
    }
    
    protected int nextBlank(){
	return game.indexOf('0');
    }

}
