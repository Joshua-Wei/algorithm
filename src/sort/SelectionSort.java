package sort;

/**
 * @author Joshua Wei
 */
public class SelectionSort implements Sort {

	@Override
	public int[] sort(int[] a) {
		if (a == null || a.length < 2) return a;
		
		for (int i = 0; i < a.length; i++) {
			int minIdx = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIdx]) minIdx = j;
			}
			int swap = a[i];
			a[i] = a[minIdx];
			a[minIdx] = swap;
		}
		
		return a;
	}
}
