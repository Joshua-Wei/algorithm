package number;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints:
 * 
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the
 * reversed integer might overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * @author Joshua Wei
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x > 0) {
            if (x % 10 != x / div) return false;
            x = x % div / 10;
            div /= 100;
        }
        return true;
    }
}
