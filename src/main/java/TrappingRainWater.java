import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
public class TrappingRainWater {
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
            trapWater(array);
        }
        input.close();
    }

    protected static void trapWater(int[] array) {
        int s = 0;
        int e = array.length - 1;
        int[] leftMax = new int[array.length];
        int[] rightMax = new int[array.length];
        // cal left maxes
        int curLeftMax = array[0];
        for (int i = 0; i < array.length; i++) {
            curLeftMax = Math.max(curLeftMax, array[i]);
            leftMax[i] = curLeftMax;
        }

        int curRightMax = array[array.length - 1];
        for (int i = array.length - 1; i >= 0; i--) {
            curRightMax = Math.max(curRightMax, array[i]);
            rightMax[i] = curRightMax;
        }

        int capacity = 0;
        for (int i = 0; i < array.length - 1; i++) {
            capacity += Math.min(leftMax[i], rightMax[i]) - array[i];
        }
        System.out.println(capacity);
    }
}
