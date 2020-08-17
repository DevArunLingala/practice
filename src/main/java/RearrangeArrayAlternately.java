// https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RearrangeArrayAlternately {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            String[] a = input.readLine().trim().split("\\s+");
            rearrange(a, n);
        }
        input.close();
    }

    public static void rearrange(String[] a, int n) {
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            String last = a[end];
            int shiftS = end;
            while(shiftS > start) {
                a[shiftS] = a[shiftS - 1];
                shiftS--;
            }
            a[start] = last;
            start += 2;
        }
        StringBuilder result = new StringBuilder();
        for (String str: a) {
            result.append(str).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}
