import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/unsorted-array/0
public class ElementWithLeftSideSmallerAndRightSideGreater  {
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
            findTheElement(array);
        }
        input.close();
    }

    private static void findTheElement(int[] array) {
        // calculate local maxima of each left element
        // calculate local minima of each  right element
        int[] rightMin = new int[array.length];
        int[] leftMax = new int[array.length];
        int maxTillLastEle = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            leftMax[i] = Math.max(maxTillLastEle, array[i]);
            maxTillLastEle = leftMax[i];
        }

        int minTillLastEle = Integer.MAX_VALUE;
        for(int i = array.length -1; i >=0; i--) {
            rightMin[i] = Math.min(minTillLastEle, array[i]);
            minTillLastEle = rightMin[i];
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (leftMax[i - 1] <= array[i] && array[i] <= rightMin[i + 1]) {
                System.out.println(array[i]);
                return;
            }
        }
        System.out.println(-1);
        return;
    }
}
