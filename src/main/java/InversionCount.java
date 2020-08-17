import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/inversion-of-array/0/
public class InversionCount {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            String[] strs = input.readLine().trim().split("\\s+");
            int[] array = new int[n];
            int i = 0;
            while (i < n) {
                array[i] = Integer.parseInt(strs[i]);
                i++;
            }
            inversionCount(array, n);
        }
        input.close();
    }

    public static void inversionCount(int[] array, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <n; j++) {
                if (array[i] >  array[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
