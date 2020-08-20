import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix/0
public class SpirallyTraversingMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine().trim());
        while (t-- > 0) {
            String[] mn = input.readLine().trim().split("\\s+");
            int rows = Integer.parseInt(mn[0]);
            int columns = Integer.parseInt(mn[1]);

            String[] all = input.readLine().trim().split("\\s+");
            String[][] matrix = new String[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = all[i * columns + j];
                }
            }
            spiralPrint(matrix, rows, columns);

        }
        input.close();
    }

    private static void spiralPrint(String[][] matrix, int rows, int columns) {
        int[] leftTop = {0, 0};
        int[] rightBottom = {rows -1, columns - 1};


        String[] op = new String[rows * columns];
        int opI = 0;

        while (inRange(leftTop[0], leftTop[1], rightBottom[0], rightBottom[1], rows, columns)) {
            int i = leftTop[0], j = leftTop[1];
            // traverse right
            while (j <= rightBottom[1]) {
                op[opI++] = matrix[i][j];
                // System.out.print(matrix[i][j] + " ");
                j++;
            }

            // traverse down
            i = leftTop[0] + 1;
            j = rightBottom[1];
            while (i <= rightBottom[0]) {
                op[opI++] = matrix[i][j];
                // System.out.print(matrix[i][j] + " ");
                i++;
            }

            //traverse left
            i = rightBottom[0];
            j = rightBottom[1] - 1;
            while (j >= leftTop[1] && opI < op.length) {
                op[opI++] = matrix[i][j];
                // System.out.print(matrix[i][j] + " ");
                j--;
            }

            // traverse up
            i = rightBottom[0] - 1;
            j = leftTop[1];
            while (i > leftTop[0] && opI < op.length) {
                op[opI++] = matrix[i][j];
                // System.out.print(matrix[i][j] + " ");
                i--;
            }

            leftTop[0]++;
            leftTop[1]++;
            rightBottom[0]--;
            rightBottom[1]--;
        }

        System.out.println(Arrays.stream(op).collect(Collectors.joining(" ")));
    }


    protected static boolean inRange(int i, int j, int r, int c, int rows, int columns) {
        return (i >=0 && i <= r) && (j >= 0 && j <= c);
    }
}
