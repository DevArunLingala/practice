import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
public class StockBuyAndSell {
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
            findMaxProfitDays(array);
        }
        input.close();
    }
    private static void findMaxProfitDays(int[] array) {
        int[] min = new int[array.length];
        int[] max = new int[array.length];

        for (int i = 0; i < array.length;) {
            int raisingWindowStart = i;
            int curI = raisingWindowStart;
            int nextI = curI + 1;
            while (curI < array.length && array[curI] < array[nextI]) {

                int prevI = curI == raisingWindowStart ? curI : curI - 1;

                min[raisingWindowStart] = Math.min(min[prevI], array[curI]);
                max[raisingWindowStart] = Math.max(max[prevI], array[curI]);
                curI++;
                nextI++;
            }
        }

        System.out.println();

    }

    private static void findMaxProfitDays1(int[] array) {
        int[] min = new int[array.length];
        int[] max = new int[array.length];

        for (int i = 0; i < array.length;) {
            int raisingWindowStart = i;
            min[raisingWindowStart] = Integer.MAX_VALUE;
            max[raisingWindowStart] = Integer.MIN_VALUE;
            int j = raisingWindowStart;
            while (j < array.length -1) {
                int lastIndex = (j == raisingWindowStart) ? j : j - 1;
                min[j] = Math.min(array[j], min[lastIndex]);
                max[j] = Math.max(array[j], max[lastIndex]);
                if (array[j] > array[++j]) {
                    break;
                }
            }
            int maxProfitIntheWindow = Integer.MIN_VALUE;
            for (int k = raisingWindowStart; k < j; k++) {
                maxProfitIntheWindow = Math.max(maxProfitIntheWindow, max[k] - min[k]);
            }
            if (maxProfitIntheWindow != 0) {
                System.out.println(String.format("(%d %d) -> %d", raisingWindowStart, j,maxProfitIntheWindow));
            }
            i = j;
            if (i == array.length -1) {
                break;
            }
        }

    }
}
