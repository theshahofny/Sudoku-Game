package com.ssa.ironyard;

import static org.junit.Assert.*;

import org.junit.Test;

public class BTSudokuSolverImplTest {

    String easyGame = "024000135000024600000106000080005009050769040900300050000403000001850290538000410";
    BTSudokuSolverImpl solver = new BTSudokuSolverImpl(easyGame);

    @Test
    public void test() {
	 System.out.println(solver.toString());
	assertFalse(solver.guessValid(54, '1'));
	assertTrue(solver.nextBlank() == 0);
	assertFalse(solver.guessValid(0, '2'));
	assertFalse(solver.guessValid(0, '9'));
    }

}
