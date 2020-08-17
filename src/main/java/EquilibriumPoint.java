import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/equilibrium-point/0
public class EquilibriumPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while(T-- > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            String[] strs = input.readLine().trim().split("\\s+");
            int[] array = new int[N];
            int totalSum = 0;
            for (int i=0; i < N; i++) {
                array[i] = Integer.parseInt(strs[i]);
                totalSum += array[i];
            }
            printEquilibriumPointIterativeOptimized(array, totalSum);
        }
        input.close();
    }

    private static void printEquilibriumPointIterativeOptimized(int[] array, int totalSum) {
        int leftSum = 0;
        for(int i = 0; i < array.length; i++) {
            if (i != 0) {
                leftSum += array[i - 1];
            }
            int rightSum = totalSum - array[i] - leftSum;

            if (rightSum == leftSum) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void printEquilibriumPointIterative(int[] array) {
        int[] leftSum = new int[array.length];
        int[] rightSum = new int[array.length];
        leftSum[0] = 0;
        rightSum[array.length - 1] = 0;
        for (int i = 1; i < array.length; i++) {
            leftSum[i] =  array[i - 1] + leftSum[i - 1];
        }

        for (int i = array.length - 2; i >=0 ; i--) {
            rightSum[i] =  array[i + 1] + rightSum[i + 1];
        }

        for (int i = 0; i < array.length; i++) {
            if (leftSum[i] == rightSum[i]) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void printEquilibriumPoint(int[] array) {
        int[] leftSum = new int[array.length];
        int[] rightSum = new int[array.length];
        Arrays.fill(leftSum, -1);
        Arrays.fill(rightSum, -1);
        printEquilibriumPoint(array, leftSum, rightSum);
    }

    private static void printEquilibriumPoint(int[] array, int[] leftSum, int[] rightSum) {

        for(int index = 0; index < array.length; index++) {
            if (leftSum[index] == -1) {
                leftSum(array, index, leftSum);
            }

            if (rightSum[index] ==  -1) {
                rightSum(array, index, rightSum);
            }

            if (leftSum[index] == rightSum[index]) {
                System.out.println(index + 1);
                return;
            }
        }
        System.out.println(-1);
    }

    private static int leftSum(int[] array, int index, int[] leftSum) {
        if (index == 0) {
            return 0;
        }
        if (leftSum[index] == -1) {
            return leftSum[index] = array[index - 1] + leftSum(array, index - 1, leftSum);
        }
        return leftSum[index];
    }

    private static int rightSum(int[] array, int index, int[] rightSum) {
        if (index == array.length - 1) {
            return 0;
        }
        if (rightSum[index] == -1) {
            return rightSum[index] = array[index + 1] + rightSum(array, index + 1, rightSum);
        }
        return rightSum[index];
    }
}
