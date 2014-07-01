package sort;

/**
 * @author Joshua Wei
 */
public class InsertionSort implements Sort {

	@Override
	public int[] sort(int[] a) {
		if (a == null || a.length < 2) return a;
		
		for (int i = 1; i < a.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[j + 1] < a[j]) {
					int swap = a[j];
					a[j] = a[j + 1];
					a[j + 1] = swap;
				} else {
					break;
				}
			}
		}
		
		return a;
	}
}
