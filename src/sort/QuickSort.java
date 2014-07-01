package sort;

/**
 * @author Joshua Wei
 */
public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] a) {
		if (a == null || a.length < 2) return a;
		sort(a, 0, a.length - 1);
		return a;
	}
	
	private void sort(int[] a, int low, int high) {
		if (low >= high) return;
		
		int pivot = a[high];
		int i = low;
		int j = high - 1;
		while (i < j) {
			if (a[i] <= pivot) {
				i++;
				continue;
			}
			if (a[j] > pivot) {
				j--;
				continue;
			}
			int swap = a[j];
			a[j] = a[i];
			a[i] = swap;
		}

		a[high] = a[i];
		a[i] = pivot;
		
		sort(a, low, i - 1);
		sort(a, i + 1, high);
	}
}
