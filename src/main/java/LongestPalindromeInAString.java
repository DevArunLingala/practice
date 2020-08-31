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
            System.out.println(new Solution().longestPalindrome(str));
        }
        input.close();
    }
}


class Solution {
    public String longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Boolean[][] palindromeMatrix = new Boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                find(str, i, j, palindromeMatrix);
            }
        }

        int start = -1;
        int max = -1;
        for (int i = 0; i < str.length() ; i++) {
            for (int j = i; j < str.length() ; j++) {
                if(palindromeMatrix[i][j]) {
                    if (max < (j - i) + 1) {
                        start = i;
                        max = (j - i) + 1;
                    }
                }
            }
        }
        return str.substring(start, start + max);
    }

    private boolean find(String str, int i, int j, Boolean[][] palindromeMatrix) {
        if (palindromeMatrix[i][j] != null) {
            return palindromeMatrix[i][j];
        }
        if (i == j) {
            palindromeMatrix[i][j] = true;
            return palindromeMatrix[i][j];
        }

        if (j == i + 1) {
            palindromeMatrix[i][j] = str.charAt(i) == str.charAt(j);
            return palindromeMatrix[i][j];
        }

        // should not cross each other

        palindromeMatrix[i][j] = find(str, i + 1, j - 1, palindromeMatrix) && str.charAt(i) == str.charAt(j);


        return palindromeMatrix[i][j];
    }
}

class SolutionMatrixWasWrong {
    public String longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        boolean[][] palindromeMatrix = new boolean[str.length()][str.length()];
        // O(n^2)
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0 ; j < str.length(); j++) {
                palindromeMatrix[i][j] = str.charAt(i) == str.charAt(j);
                System.out.print((palindromeMatrix[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }

        int maxPlndrm = -1;
        int maxStart = -1;
        int palinStart = -1;
        int palinL = 0;

        for (int dI = 0; dI < (str.length() + str.length()) - 1; dI++) {
            int i = 0;
            int j = dI;

            if (j >= str.length()) {
                j = str.length() - 1;
                i = dI - j;
            }

            while (i >= 0 && i < str.length() && j >=0 && j < str.length()) {
                if (palindromeMatrix[i][j]) {
                    palinL++;
                    maxPlndrm = Math.max(maxPlndrm, palinL);
                } else {
                    palinL = 0;
                }
                i++;
                j--;
            }
            // max plaind at end of each diagonal
            if (maxPlndrm < palinL) {
                maxPlndrm = palinL;
            }
            palinL = 0;
        }
        return str;//.substring(maxStart, maxPlndrm);
    }
}