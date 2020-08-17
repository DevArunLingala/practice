import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
public class ChocolateDistributionProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            String[] strs = input.readLine().trim().split("\\s+");
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(strs[i]);
            }
            int M = Integer.parseInt(input.readLine().trim());
            distributeChocolate(array, M);
        }
        input.close();
    }

    private static void distributeChocolate(int[] array, int m) {
        Arrays.sort(array);
        int start = 0;
        int delimit = start + (m - 1);
        int minSofar = Integer.MAX_VALUE;
        while (start < array.length && delimit < array.length) {
            minSofar = Math.min(minSofar, array[delimit] - array[start]);
            start++;
            delimit++;
        }
        System.out.println(minSofar);
    }
}
