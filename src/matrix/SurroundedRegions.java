package matrix;

import java.util.*;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region. 
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * After running your function, the board should be: 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * @author Joshua Wei
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
    	if (board == null || board.length == 0 || board[0].length == 0) return;
    	
        // mark all 'O' reachable from edge
    	for (int i = 0; i < board.length; i++) {
        	if (board[i][0] == 'O') mark(board, i, 0);
        	if (board[i][board[0].length - 1] == 'O') mark(board, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; j++) {
        	if (board[0][j] == 'O') mark(board, 0, j);
        	if (board[board.length - 1][j] == 'O') mark(board, board.length - 1, j);
        }
        
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == 'O') board[i][j] = 'X';
        		if (board[i][j] == 'M') board[i][j] = 'O';
        	}
        }
    }
    
    private void mark(char[][] board, int x, int y) {
    	board[x][y] = 'M';
    	
    	Stack<Integer> xStack = new Stack<Integer>();
    	Stack<Integer> yStack = new Stack<Integer>();
    	xStack.push(x);
    	yStack.push(y);
    	
    	while (!xStack.isEmpty()) {
    		int xx = xStack.pop();
    		int yy = yStack.pop();
    		board[xx][yy] = 'M';
    		
    		if (xx > 0 && board[xx - 1][yy] == 'O') {
        		xStack.push(xx - 1);
        		yStack.push(yy);
        	}
        	if (xx < board.length - 1 && board[xx + 1][yy] == 'O') {
        		xStack.push(xx + 1);
        		yStack.push(yy);
        	}
        	if (yy > 0 && board[xx][yy - 1] == 'O') {
        		xStack.push(xx);
        		yStack.push(yy - 1);
        	}
        	if (yy < board[0].length - 1 && board[xx][yy + 1] == 'O') {
        		xStack.push(xx);
        		yStack.push(yy + 1);
        	}
    	}
    }
}
