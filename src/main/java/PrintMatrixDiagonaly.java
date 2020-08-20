import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://practice.geeksforgeeks.org/problems/print-diagonally/0
public class PrintMatrixDiagonaly {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            String[] str = input.readLine().trim().split("\\s");
            printDiagonaly(str, N);
        }
        input.close();
    }

    private static void printDiagonaly(String[] str, int N) {
        int i = 0;
        int j = 0;
        String[] path = new String[N*N];
        int  k = 0;
        for(int dI = 0; dI < ((2 * N) - 1); dI++) {
            i = 0;
            j = dI;
            if (j >= N) {
                j = N - 1;
                i = dI - (N - 1);
            }
            while ((i >= 0 && i < N) && (j >= 0 && j < N)) {
                path[k] = str[i * N + j];
                k++;
                i++;
                j--;
            }
        }
        System.out.println(String.join(" ", path));
    }
}
