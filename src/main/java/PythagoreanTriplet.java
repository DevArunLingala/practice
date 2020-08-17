import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/pythagorean-triplet/0
public class PythagoreanTriplet {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            String[] strs = input.readLine().trim().split("\\s+");
            int[] array = new int[N];
            Set<Integer> set = new HashSet<>(N);
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(strs[i]);
                array[i] *= array[i];
                set.add(array[i]);
            }
            checkForPythagoreanTriplet(array, set);
        }
        input.close();
    }

    private static void checkForPythagoreanTriplet(int[] array, Set<Integer> set) {
        // check whether there is a element which is equal to sum of other two
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(set.contains(array[i] + array[j])) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}
