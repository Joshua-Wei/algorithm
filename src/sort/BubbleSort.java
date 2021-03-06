package sort;

/**
 * @author Joshua Wei
 */
public class BubbleSort implements Sort {

	@Override
	public int[] sort(int[] a) {
		if (a == null || a.length < 2) return a;
		
		while (true) {
			boolean sorted = true;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i + 1] < a[i]) {
					int swap = a[i];
					a[i] = a[i + 1];
					a[i + 1] = swap;
					sorted = false;
				}
			}
			if (sorted) break;
		}
		
		return a;
	}
}
