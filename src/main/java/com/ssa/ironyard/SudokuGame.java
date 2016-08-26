package com.ssa.ironyard;

public class SudokuGame{
    private final int id;
    private final String difficulty;
    private final int[] game = new int[81];
    private int[] solution = new int[81];
    
    public SudokuGame(int id, String difficulty, String game) {
	if(!(game.matches("\\d+") && game.length() == 81))
		throw new IllegalArgumentException();
	
	this.id = id;
	this.difficulty = difficulty;
	for(int i = 0; i < game.length(); i++)
	    this.game[i] = Integer.parseInt(game.substring(i, 1));
	
	this.solution = new SudokuSolverImpl(this).solve();
    }

    public int getId() {
        return id;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int[] getGame() {
        return game;
    }

    public int[] getSolution() {
        return solution;
    }
    
}