import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0
public class RecursivelyRemoveAdjacentDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while (T-- > 0) {
            String str = input.readLine().trim();
            remove(str);
        }
        input.close();
    }

    private static void remove(String str) {
        System.out.println(remove(str, 0));
    }

    private static String remove(String str, int i) {
        if (i < 0 || i == str.length()) {
            return str;
        }
        int end = i;
        while(end < str.length() && str.charAt(end) == str.charAt(i)) {
            end++;
        }
        if (end - i > 1) {
            return remove(str.substring(0, i) + str.substring(end), i - 1);
        }
        return remove(str, i + 1);
    }

    private static String replaceConsecutiveDuplicateLettersWithOneLetter(String str, int i) {

        if (i == str.length()) {
            return str;
        }

        if (str.charAt(i) == str.charAt(i - 1)) {
            return replaceConsecutiveDuplicateLettersWithOneLetter(str.substring(0, i) + str.substring(i + 1), i);
        }
        return replaceConsecutiveDuplicateLettersWithOneLetter(str, i+1);
    }
}
