package string;

/**
 * Given a 2D board and a word, find if the word exists in the grid. 
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board = 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @author Joshua Wei
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int x, int y, String word, int start) {
        if (board[x][y] != word.charAt(start)) return false;
        if (start == word.length() - 1) return true;
        
        boolean ret = false;
        board[x][y] = 0;
        
        if (x > 0) ret = ret || exist(board, x - 1, y, word, start + 1);
        if (x < board.length - 1) ret = ret || exist(board, x + 1, y, word, start + 1);
        if (y > 0) ret = ret || exist(board, x, y - 1, word, start + 1);
        if (y < board[0].length - 1) ret = ret || exist(board, x, y + 1, word, start + 1);
        
        board[x][y] = word.charAt(start);
        return ret;
    }
}
