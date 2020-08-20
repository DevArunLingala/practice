import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
public class LargestNumberFromArray {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while(T-- > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            String[] array = input.readLine().trim().split("\\s+");
            printLargestNumberFromString(array);
        }
        input.close();
    }

    private static void printLargestNumberFromString(String[] array) {
        Arrays.sort(array, (l, r) -> {
            return -1 * (l+r).compareTo(r+l);
        });

        System.out.println(Arrays.stream(array).collect(Collectors.joining()));
    }

    // check later
    private static void printLargestNumberFromStringNotWorking(String[] array) {
        Arrays.sort(array, (l, r) -> {
            int ln = l.length();
            int rn = r.length();
            if (ln == rn) {
                return Integer.compare(Integer.parseInt(l), Integer.parseInt(r));
            }

            int k = 0;
            while (k < Math.min(ln, rn)) {
                if (l.charAt(k) == r.charAt(k)) {
                    k++;
                } else {
                    return (l.charAt(k) - r.charAt(k));
                }
            }

            char lc;
            if (ln == Math.min(ln, rn)) {
                lc = '0';
            } else {
                lc = l.charAt(ln - 1);
            }
            return (lc - r.charAt(0));

        });
        StringBuilder sb = new StringBuilder();
        for(int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]);
        }
        System.out.println(sb.toString());
    }
}
