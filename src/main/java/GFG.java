import java.util.*;

public class GFG {

    public static void subArraySum(int[] arr, int n, int sum) {
        int curSum = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap();

        hashMap.put(0, curSum);
        int index = 0;
        while(index < n) {
            for (; index < n; index++) {
                curSum += arr[index];
                hashMap.put(index + 1, curSum);
                if (curSum >= sum) {
                    end = index;
                    break;
                }
            }
            int start = 0;
            for (start = 0; start <= end; start++) {
                if (curSum - sum == hashMap.get(start)) {
                    System.out.println(String.format("%d %d", start + 1, end + 1));
                    return;
                }
            }
            index++;
        }

        System.out.println("-1");
    }

    public static void  subArraySumEfficient(int[] arr, int n, int sum) {
        int curSum = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap();
        hashMap.put(0, 0);
        int start = 0;
        for (int index = 0; index < n; index++) {
            curSum += arr[index];
            hashMap.put(curSum, index+1);
            if (curSum >= sum) {
                end = index;
                if (hashMap.containsKey(curSum - sum)) {
                    start = hashMap.get(curSum - sum);
                    System.out.println(String.format("%d %d", start + 1, end + 1));
                    return;
                }
            }
        }
        System.out.println("-1");
    }

    public static void subArraySumMoreEfficient(int[] arr, int n, int sum) {
        int curSum = 0;
        int end = 0;
        int start = 0;
        while(end < n) {
            if (curSum <  sum) {
                curSum += arr[end];
                end++;
            } else if (curSum > sum){
                curSum -= arr[start];
                start++;
            }

            if (curSum == sum) {
                System.out.println(String.format("%d %d", start + 1, end));
                return;
            }

            if (start == end) {
                start++;
                end++;
                curSum=0;
            }
        }
        System.out.println("-1");
    }

    public static void subArraySumMoreEfficient1(int[] arr, int n, int sum) {
        int curSum = 0;
        int end = 0;
        int start = 0;
        while(end < n) {
            if (curSum <  sum) {
                curSum += arr[end];
            } else if (curSum > sum){
                curSum -= arr[start];
            }

            if (curSum == sum) {
                System.out.println(String.format("%d %d", start + 1, end + 1));
                return;
            }

            if (curSum <  sum) {
                end++;
            } else if (curSum > sum){
                start++;
            }

            if (start == end) {
                start++;
                end++;
                curSum=0;
            }
        }
        System.out.println("-1");
    }


    public static void main(String[] args) {
        readFromInput();
    }

    public static void readFromInput() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int S = scanner.nextInt();
            int[] array = new int[N];
            int i = 0;
            while(i < N) {
                array[i++] = scanner.nextInt();
            }
            //System.out.println();
            //subArraySum(array, N, S);
            //subArraySumEfficient(array, N, S);
            subArraySumMoreEfficient1(array, N, S);
        }
        scanner.close();
    }
}