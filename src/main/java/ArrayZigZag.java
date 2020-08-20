import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0
public class ArrayZigZag {
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
            zigZag(array);
        }
        input.close();
    }

    private static void zigZag(int[] array) {
        boolean isLessThanExpectedBwElements = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (isLessThanExpectedBwElements == array[i] < array[i + 1]) {
                // nothing
            } else {
                int t = array[i];
                array[i] = array[i+1];
                array[i+1] = t;
            }
            isLessThanExpectedBwElements = !isLessThanExpectedBwElements;
        }
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")).trim());
    }
}
