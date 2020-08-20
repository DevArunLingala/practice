// https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromeInAString {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while (T-- > 0) {
            String str = input.readLine().trim();
            findPalindrome(str);
        }
        input.close();
    }

    private static void findPalindrome(String str) {
        boolean[][] palindromeMatrix = new boolean[str.length()][str.length()];
        // O(n^2)
        for (int i = 0; i < str.length(); i++) {
            for (int j = i ; j < str.length(); j++) {
                palindromeMatrix[i][j] = str.charAt(i) == str.charAt(j);
            }
        }

        int lastLenght = 0;
        int lastStart = 0;
        int lastEnd = -1;

        int largestStart = 0;
        int largestEnd = -1;
        boolean isPalindromeTillNow = false;
        // traverse the matrix diagonal
        for (int i =0; i < str.length(); i++) {
            if (isPalindromeTillNow) {
                if (palindromeMatrix[i][i]) {
                    lastEnd = i;
                    isPalindromeTillNow = true;
                } else {
                    isPalindromeTillNow = false;
                }
            } else {
                if (palindromeMatrix[i][i]) {
                    if ((largestEnd - largestStart) < (lastEnd - lastStart)) {
                        largestStart = lastStart;
                        largestEnd = lastEnd;
                    }
                    lastStart = i;
                    lastEnd = -1;
                    isPalindromeTillNow = true;
                }
            }
        }

        System.out.println(str.substring(largestStart, largestEnd + 1));
    }

    private static boolean isInRange(int i, int j, int l) {
        return i >= 0 && i < l && j >=0 && j< l;
    }

}
