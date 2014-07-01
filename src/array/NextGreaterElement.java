package array;

import java.util.*;

/**
 * Given an array, find the Next Greater Element (NGE) for every element. The Next greater Element for an element x is
 * the first greater element on the right side of x in array. Elements for which no greater element exist, consider next
 * greater element as -1.
 *  
 * @author Joshua Wei
 */
public class NextGreaterElement {
	public int[] nextGreater(int[] a) {
		if (a == null) return null;
		
		int[] result = new int[a.length];
			
		Stack<Integer> stack = new Stack<>();
		for (int i = a.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() < a[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}
			stack.push(a[i]);
		}
		return result;
	}
}
