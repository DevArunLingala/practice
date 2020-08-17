import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
public class KthSmallestElement {
    public static boolean[] IS_DONE = {false};
    public static void main(String[] a) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine().trim());
        while(T-- > 0) {
            IS_DONE[0] = false;
            int N = Integer.parseInt(in.readLine().trim());
            String[] as = in.readLine().trim().split("\\s+");
            int K = Integer.parseInt(in.readLine().trim());
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(as[i]);
            }
            qs(array, 0, N - 1, K, IS_DONE);
            if (!IS_DONE[0]) {
                System.out.println(array[K - 1]);
            }
        }
        in.close();
    }

    public static void qs(int[] array, int low, int high, int k, boolean[] isDone) {
        if (low >= high) {
            return;
        }
        if (isDone[0]) {
            return;
        }
        int pp = partition(array, low, high);
        if (pp == (k - 1)) {
            isDone[0] = true;
            System.out.println(array[pp]);
        }
        qs(array, low, pp - 1, k, isDone);
        qs(array, pp + 1, high, k, isDone);
    }

    public static int partition(int[] array, int low, int high) {
        int p = low;
        int q = p;
        int j = q;
        int pivot = array[high];
        while(j < high) {
            if (array[j] > pivot) {
                //
            } else {
                swap(array, j, q);
                q++;
            }
            j++;
        }
        swap(array, high, q);
        return q;
    }

    private static void swap(int[] array, int j, int i) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
