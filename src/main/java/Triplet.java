import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//https://practice.geeksforgeeks.org/problems/count-the-triplets/0
public class Triplet {
    public static void findTriplet(Integer[] array, int length) {
        Set<Integer> set = new HashSet<Integer>(Arrays.<Integer>asList(array));
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < length) {
            j = i + 1;
            while (j < length) {
                if (set.contains(array[i] + array[j])) {
                    count++;
                }
                j++;
            }
            i++;
        }

        System.out.println(count > 0 ? count : -1);
    }

    public static void main(String[] args) {
        scanInput1();
    }

    public static void findTripletBasedOnSorting(int[] array, int length) {
        quickSort(array, 0, length - 1);
        int count = 0;
        for (int i = length -1; i >= 0; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (array[i] == array[j] +  array[k]) {
                    count++;
                    j++;
                    k--;
                } else if(array[i] > array[j] +  array[k]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(count > 0 ? count : -1);
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

    public static void scanInput() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            Integer[] array = new Integer[N];
            int i = 0;
            while(i < N) {
                array[i++] = scanner.nextInt();
            }
            findTriplet(array, N);
        }
        scanner.close();
    }

    public static void scanInput1() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] array = new int[N];
            int i = 0;
            while(i < N) {
                array[i++] = (scanner.nextInt());
            }
            findTripletBasedOnSorting(array, N);
        }
        scanner.close();
    }
}
