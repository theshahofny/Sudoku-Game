package com.ssa.ironyard;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuGameTest {
    
    SudokuGame s = new SudokuGame(1, "easy", "024678135019024600000106000080005009050769040900300050000403000001850290538000410");

    @Test
    public void testToStringIsReadable() {
	SudokuSolver sSolver = new SudokuSolverImpl(s);
	System.out.println(sSolver);
	sSolver.solve();
	sSolver.solve();
	System.out.println(sSolver);
    }

}
