// https://leetcode.com/problems/shortest-palindrome/
public class ShortedPalindrome {
    public String shortestPalindrome(String str) {
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
        int max =0;
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