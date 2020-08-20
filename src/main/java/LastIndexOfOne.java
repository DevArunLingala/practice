import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/last-index-of-1/0
public class LastIndexOfOne {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine().trim());
        while (t-- > 0) {
            String s = input.readLine().trim();
            int n = s.length() - 1;
            while (n >= 0) {
                if (s.charAt(n) == '1') {
                    System.out.println(n);
                    break;
                }
                n--;
            }
            if (n < 0) {
                System.out.println(-1);
            }
        }
        input.close();
    }
}
