package matrix;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *  
 * @author Joshua Wei
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] == '.') continue;
                if (!validate(board, x, y)) return false;
            }
        }
        return true;
    }
    
    private boolean validate(char[][] board, int x, int y) {
        for (int i = x - x % 3; i < x - x % 3 + 3; i++) {
            for (int j = y - y % 3; j < y - y % 3 + 3; j++) {
                if (i == x && j == y) continue;
                if (board[x][y] == board[i][j]) return false;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (i == x) continue;
            if (board[x][y] == board[i][y]) return false;
        }
        
        for (int j = 0; j < 9; j++) {
            if (j == y) continue;
            if (board[x][y] == board[x][j]) return false;
        }
        
        return true;
    }
}
