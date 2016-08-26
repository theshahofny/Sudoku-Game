package com.ssa.ironyard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolverImpl implements SudokuSolver {
    private final SudokuGame s;

    private final int[] sudokuArray;

    private List<ArrayList<Integer>> candidates = new ArrayList<ArrayList<Integer>>();

    public SudokuSolverImpl(SudokuGame s) {
	this.s = s;
	sudokuArray = s.getGame();
	for (int i = 0; i < 81; i++)
	    candidates.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    public String solve() {
	// while (!isSolved()) {
	for (int row = 0; row < 9; row++)
	    for (int column = 0; column < 9; column++)
		removeInvalidCandidatesFromCell(row, column);

	setKnownValuesFromCandidates();
	// }

	return null;
    }

    private int getIndex(int row, int column) {
	return row * 9 + column;
    }

    private List<Integer> getInvalidCandidatesBasedOnRow(int row, int column) {
	List<Integer> candidates = new ArrayList<>();

	if (sudokuArray[getIndex(row, column)] != 0) {
	    candidates.add(sudokuArray[getIndex(row, column)]);
	    return candidates;
	}

	for (int i = 0; i < 9; i++)
	    if (sudokuArray[getIndex(row, i)] != 0)
		candidates.add(sudokuArray[getIndex(row, i)]);

	return candidates;
    }

    private List<Integer> getInvalidCandidatesBasedOnColumn(int row, int column) {
	List<Integer> candidates = new ArrayList<>();

	if (sudokuArray[getIndex(row, column)] != 0) {
	    candidates.add(sudokuArray[getIndex(row, column)]);
	    return candidates;
	}

	for (int i = 0; i < 9; i++)
	    if (sudokuArray[getIndex(i, column)] != 0)
		candidates.add(sudokuArray[getIndex(i, column)]);

	return candidates;

    }

    private List<Integer> getInvalidCandidatesBasedOnBox(int row, int column) {
	return null;

    }

    private void removeInvalidCandidatesFromCell(int row, int column) {
	candidates.removeAll(getInvalidCandidatesBasedOnRow(row, column));
	candidates.removeAll(getInvalidCandidatesBasedOnColumn(row, column));
	// candidates.removeAll(getInvalidCandidatesBasedOnBox(row, column));
    }

    private void setKnownValuesFromCandidates() {	
	for (int i = 0; i < sudokuArray.length; i++)
	    if (candidates.get(i).size() == 1 && sudokuArray[i] == 0)
		sudokuArray[i] = candidates.get(i).get(0);
    }

    private boolean isSolved() {
	for (int val : sudokuArray)
	    if (val == 0)
		return false;
	return true;
    }

    @Override
    public String toString() {
	StringBuilder s = new StringBuilder("");
	for (int i = 0; i < 81; i++) {
	    if (i % 9 == 0)
		s.append("\n");
	    s.append(sudokuArray[i]);
	}

	return s.toString();
    }

}
