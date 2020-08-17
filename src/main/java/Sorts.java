import java.util.Arrays;
import java.util.stream.Stream;

public class Sorts {
    public static void main(String[] args) {
        int[] array = {7, 10 ,4, 3, 20, 15};
        quickSort(array, 0, array.length-1);
        // nsertionSortOptimized(array, array.length);
        print(array, "Sort");
     }

     private static void print(int[] array, String algo) {
         StringBuilder stringBuilder = new StringBuilder();
         for (int i : array) {
             stringBuilder.append(i).append(" ");
         }
         System.out.println(algo + " >---> " + stringBuilder.toString());
     }

    public static void selectionSort(int[] array, int l) {
        for (int i = 0; i < l; i++) {
            int minIndex = i;
            int min = array[i];
            for(int j = i; j <= l - 1; j++) {
                if(array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static void insertionSortOptimizedNotWorking(int[] array, int l) {
        for(int i = 1; i < l; i++) {
            int j = 0;
            int toBeInserted = array[i];
            while(j <= i && array[j] < toBeInserted) {
                j++;
            }
            int k = j;
            while(k < i) {
                array[k + 1] = array[k];
                k++;
            }
            array[j] = toBeInserted;
        }
    }

    public static void insertionSortOptimized(int[] array, int l) {
        for(int i = 1; i < l; i++) {
            int j = 0;
            int toBeInserted = array[i];
            while(j <= i && array[j] < toBeInserted) {
                j++;
            }
            int k = i;
            while(k > j) {
                array[k] = array[k - 1];
                k--;
            }
            array[j] = toBeInserted;
        }
    }

    public static void insertionSort(int[] array, int l) {
        for(int i = 1; i < l; i++) {
            for (int j = 0; j <= i; j++) {
                if(array[j] > array[i]) {
                    // move
                    int toBeInserted = array[i];
                    int k = i;
                    while (k > j) {
                        array[k] = array[k - 1];
                        k--;
                    }
                    array[k] = toBeInserted;
                    break;
                }
            }
        }
    }

    public static void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivotPos = partition(array, l, r);
        quickSort(array, l, pivotPos - 1);
        quickSort(array,pivotPos + 1, r);
    }

    private static int partition(int[] array, int l, int r) {
        int p = l;
        int q = p;
        int pivot = array[r];
        for(int j = q; j < r; j++) {
            if (array[j] > pivot) {
                // nothing
            } else {
                swap(array, q, j);
                q++;
            }
        }
        swap(array, q, r);
        return q;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
       int mid = (l + r) / 2;
       mergeSort(array, l, mid);
       mergeSort(array, mid + 1, r);
       merge(array, l, mid, r);
    }

    public static void merge(int[] array, int l, int m, int r) {
        int ln = m - l + 1;
        int rn = r - m;
        int[] left = new int[ln];
        int[] right = new int[rn];

        // copy left and right so that we can manipulate the original array from l -> r
        for (int i = 0; i < ln; i++) {
            left[i] = array[l + i];
        }
        for (int j = 0;  j < rn; j++) {
            right[j] = array[m + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < ln && j < rn) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < ln) {
            array[k] = left[i];
            k++;
            i++;
        }

        while (j < rn) {
            array[k] = right[j];
            k++;
            j++;
        }
    }
}
