package sort;

/**
 * @author Joshua Wei
 */
public class MergeSort implements Sort {

	@Override
	public int[] sort(int[] a) {
		if (a == null || a.length < 2) return a;
		int[] tmp = new int[a.length];
		sort(a, 0, a.length - 1, tmp);
		return a;
	}
	
	private void sort(int[] a, int low, int high, int[] tmp) {
		if (low >= high) return;
		int mid = (low + high) / 2;
		sort(a, low, mid, tmp);
		sort(a, mid + 1, high, tmp);
		merge(a, low, mid, high, tmp);
	}
	
	private void merge(int[] a, int low, int mid, int high, int[] tmp) {
		System.arraycopy(a, low, tmp, low, high - low + 1);
		int read1 = low;
		int read2 = mid + 1;
		int write = low;
		while (read1 <= mid && read2 <= high) {
			if (tmp[read1] < tmp[read2]) {
				a[write++] = tmp[read1++];
			} else {
				a[write++] = tmp[read2++];
			}
		}
		while (read1 <= mid) {
			a[write++] = tmp[read1++];
		}
	}
}
