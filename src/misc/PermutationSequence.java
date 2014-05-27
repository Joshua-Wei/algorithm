package misc;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3): 
 * 1."123"
 * 2."132"
 * 3."213"
 * 4."231"
 * 5."312"
 * 6."321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author Joshua Wei
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) return "";
        k -= 1;
        
        int[] available = new int[n];
        for (int i = 0; i < n; i++) {
            available[i] = i + 1;
        }
        
        String ret = "";
        for (int i = 1; i <= n; i++) {
        	int f = factorial(n - i);
        	ret += findKth(available, k / f);
        	k %= f;
        }
        return ret;
    }
    
    private int factorial(int a) {
    	int ret = 1;
    	for (int i = 1; i <= a; i++) {
    		ret *= i;
    	}
    	return ret;
    }
    
    private int findKth(int[] a, int k) {
    	for (int i = 0; i < a.length; i++) {
    		if (a[i] == 0) continue;
    		if (k == 0) {
    			int ret = a[i];
    			a[i] = 0;
    			return ret;
    		}
    		k--;
    	}
    	return -1;
    }
}
