//https://practice.geeksforgeeks.org/problems/missing-number-in-array/0

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        readFromInput();
    }

    public static void readFromInput() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int sumOfNInts = (N * (N + 1)) / 2;
            int arrayLength = N - 1;
            while(arrayLength-- > 0) {
                sumOfNInts -= scanner.nextInt();
            }

            System.out.println(sumOfNInts);
        }
        scanner.close();
    }
}
