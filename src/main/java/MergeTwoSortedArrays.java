// https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
public class MergeTwoSortedArrays {
    public static void main(String[] args) {

    }

    public static void sort(int[] a,int al, int[] b, int bl) {
        int m = al - 1;
        int n = 0;
        while(m >= 0 && n < bl) {
            if (a[m] > b[n]) {
                int t = a[m];
                a[m] = b[n];
                b[n] = t;
            }
            m--;
            n++;
        }
        quickSort(a, 0, al - 1);
        quickSort(b, 0, bl - 1);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivPos = partition(array, low, high);
            quickSort(array, low, pivPos - 1);
            quickSort(array, pivPos + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int p = low;
        int q = p;
        int j = q;
        for(j = q; j < high; j++) {
            if (array[j] > array[high]) {
                // nothing
            } else {
                swap(array, q, j);
                q++;
            }
        }
        swap(array, q, high);
        return q;
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
