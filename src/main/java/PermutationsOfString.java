import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
public class PermutationsOfString {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while (T-- > 0) {
            String str = input.readLine().trim();
            permutateString(str);
            System.out.println();
        }
        input.close();
    }

    private static void permutateString(String str) {
        Set<String> set = new HashSet<>();
        permutateString(str, 0, str.length() - 1, set);
        System.out.println(String.join(" ", set));
    }

    private static void permutateString(String string, int l, int r, Set<String> set) {
        if (l == r) {
            set.add(string);
            return;
        }

        for (int i = l; i <=r; i++) {
            string = swap(string, l, i);
            permutateString(string, l+1, r, set);
            string = swap(string, i, l);
        }
    }

    private static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
