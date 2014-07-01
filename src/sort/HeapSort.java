package sort;

import java.util.*;

/**
 * @author Joshua Wei
 */
public class HeapSort implements Sort {

	@Override
	public int[] sort(int[] a) {
		if (a == null || a.length < 2) return a;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < a.length; i++) minHeap.offer(a[i]);
		for (int i = 0; i < a.length; i++) a[i] = minHeap.poll();
		
		return a;
	}
}
