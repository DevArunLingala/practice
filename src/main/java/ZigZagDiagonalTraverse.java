import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://leetcode.com/problems/diagonal-traverse/
public class ZigZagDiagonalTraverse {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            String[] str = input.readLine().trim().split("\\s");
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(str[(i * N) + j]);
                }
            }
            System.out.println(Arrays.stream(printDiagonalOrder(matrix)).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        }
        input.close();
    }

    public static int[] printDiagonalOrder(int[][] matrix) {
        int rows = matrix.length;
        int[] path = {};
        if (rows == 0) {
            return path;
        }
        int columns =  matrix[0].length;
        path = new int[rows * columns];

        boolean isUpwardDirection = true;

        int patI = 0;

        int diagonalNumber = (rows + columns) - 1;

        for (int dI = 0; dI < diagonalNumber; dI++) {
            int i, j;
            if (isUpwardDirection) {
                i = dI;
                j = 0;
                if (i >= rows) {
                    i = rows - 1;
                    j = dI - i;
                }
            } else {
                i = 0;
                j = dI;
                if (j >= columns) {
                    j = columns - 1;
                    i = dI- j;
                }
            }

            while ((i >= 0 && i < rows) && (j >= 0 && j < columns)) {
                path[patI] = matrix[i][j];
                patI++;

                if (isUpwardDirection) {
                    i--;
                    j++;
                } else {
                    i++;
                    j--;
                }
            }
            isUpwardDirection = !isUpwardDirection;
        }
        return path;
    }
}

