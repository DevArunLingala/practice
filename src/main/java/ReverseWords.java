import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
public class ReverseWords {
    public static void main(String[] a) throws IOException {
        BufferedReader inout = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(inout.readLine().trim());
        while(T-- > 0) {
            String[] sentence = inout.readLine().trim().split("\\.");
            int i = 0, j = sentence.length-1;
            while(i < j) {
                String t = sentence[i];
                sentence[i] = sentence[j];
                sentence[j] = t;
                i++;j--;
            }
            System.out.println(Arrays.stream(sentence).collect(Collectors.joining(".")));

        }
        inout.close();
    }
}
