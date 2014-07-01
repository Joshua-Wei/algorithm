package sort;

import java.util.*;

/**
 * @author Joshua Wei
 */
public class Test {

	public void test(Sort s) {
		System.out.println(s.getClass().getName());
		print(s.sort(null));
		print(s.sort(new int[]{}));
		print(s.sort(new int[]{1}));
		print(s.sort(new int[]{1,2}));
		print(s.sort(new int[]{2,1}));
		print(s.sort(new int[]{1,2,3,4,5}));
		print(s.sort(new int[]{1,2,3,5,4}));
		print(s.sort(new int[]{2,1,3,4,5}));
		print(s.sort(new int[]{5,4,3,2,1}));
		print(s.sort(new int[]{3,2,5,1,4}));
		print(s.sort(new int[]{3,2,1,5,5,4,4,1,4}));
		System.out.println();
	}
	
	private void print(int[] a) {
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.test(new SelectionSort());
		t.test(new InsertionSort());
		t.test(new BubbleSort());
		t.test(new MergeSort());
		t.test(new QuickSort());
		t.test(new HeapSort());
	}
}
