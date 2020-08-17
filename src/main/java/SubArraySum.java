import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0#ExpectOP
public class SubArraySum {
    public static void main(String[] args) {
        readFromInput();
    }

    public static void readFromInput() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] array = new int[N];
            int i = 0;
            while(i < N) {
                array[i++] = scanner.nextInt();
            }
            maxSumKadanesIterative(array, N);
        }
        scanner.close();
    }
    public static void maxsumBF(int[] array, int l) {
        Integer max = null;
        int from = 0;
        int to = 0;
        for (int i = 0; i < l; i++) {
            int curSum = array[i];
            if (max == null || (max < curSum)) {
                max = array[i];
                from = i;
                to = i;
            }
            for (int j = i + 1; j < l; j++) {
                curSum += array[j];
                if (max < curSum) {
                    max = curSum;
                    from = i;
                    to = j;
                }
            }
        }
        System.out.println(max);
    }

    public static void maxSumKadanesIterative(int[] array, int l) {
        int localMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            localMax = Math.max(array[i], array[i] + localMax);
            if (max < localMax) {
                max = localMax;
            }
        }
        System.out.println(max);
    }


    public static void maxSumKadanesRecursive(int[] array, int l) {
        Map<Integer, Integer> calculated = new HashMap<>(l);
        int max = Integer.MIN_VALUE;
        for (int i = l -1 ; i >=0; i--) {
            int localMax = localMax(array, i, calculated);
            if(max < localMax) {
                max = localMax;
            }
        }
        System.out.println(max);
    }

    public static int localMax(int[] array, int at, Map<Integer, Integer> calculated) {
        if (calculated.containsKey(at)) {
            return calculated.get(at);
        }
        if (at == 0) {
            calculated.put(at, array[at]);
            return array[at];
        }
        int localMax = Math.max(array[at], array[at] + localMax(array, at - 1, calculated));
        calculated.put(at, localMax);
        return localMax;
    }

    public static void maxsumDP(int[] array, int l) {
        Map<Node, Integer> done = new HashMap();

        int max = Integer.MIN_VALUE;
        int from = 0;
        int to = 0;
        for (int i = 0; i < l; i++) {
            int curSum = maxsumDPSum(array, i, i, done);
            if (max < curSum) {
                max = curSum;
                from = i;
                to = i;
            }
            for (int j = i + 1; j < l; j++) {
                curSum = maxsumDPSum(array, i, j, done);
                if (max < curSum) {
                    max = curSum;
                    from = i;
                    to = j;
                }
            }
        }
        System.out.println(max);
    }

    public static int maxsumDPSum(int[] array, int i, int j, Map<Node, Integer> done) {
        Node node = new Node(i, j);
        if (done.containsKey(node)) {
            return done.get(node);
        }

        if (i == j) {
            node.sum = array[i];
            done.put(node, node.sum);
            return array[i];
        }

        int sum = maxsumDPSum(array, i, i, done) + maxsumDPSum(array, i + 1, j, done);
        node.sum = sum;
        node.sum = array[i];
        done.put(node, node.sum);
        return sum;
    }

    static class Node {
        int i;
        int j;
        int sum;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return i == node.i &&
                j == node.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
