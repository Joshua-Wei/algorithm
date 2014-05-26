package misc;

import java.util.*;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution. 
 * 
 * @author Joshua Wei
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[i].length; j++) {
        		if (board[i][j] != '.') continue;
        		
        		List<Character> options = new ArrayList<Character>();
        		for (char k = '1'; k <= '9'; k++) {
        			if (validate(board, i, j, k)) options.add(k);
        		}
        		
        		if (options.isEmpty()) throw new RuntimeException("no solution");
        		
        		for (int k = 0; k < options.size(); k++) {
        			board[i][j] = options.get(k);
        			try {
        				solveSudoku(board);
        			} catch (RuntimeException e) {
        				board[i][j] = '.';
        				if (k == options.size() - 1) throw e;
        				continue;
        			}
        			return;
        		}
        	}
        }
    }

    private boolean validate(char[][] board, int x, int y, int val) {
    	// validate column
    	for (int i = 0; i < board.length; i++) {
            if (i == x) continue;
            if (board[i][y] == val) return false;
        }
        
    	// validate row
    	for (int j = 0; j < board[x].length; j++) {
            if (j == y) continue;
            if (board[x][j] == val) return false;
        }
        
        // validate box
        for (int i = x - x % 3; i < x - x % 3 + 3; i++) {
            for (int j = y - y % 3; j < y - y % 3 + 3; j++) {
                if (i == x && j == y) continue;
                if (board[i][j] == val) return false;
            }
        }
        
        return true;
    }
}
