import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://practice.geeksforgeeks.org/problems/reverse-array-in-groups/0
public class ReverseInGroups {
    public static void main(String[] a) throws IOException {
        BufferedReader inout = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(inout.readLine().trim());
        while(T-- > 0) {
            String[] NG = inout.readLine().trim().split("\\s+");
            int N = Integer.parseInt(NG[0]);
            int G = Integer.parseInt(NG[1]);
            String[] array = inout.readLine().trim().split("\\s+");
            int s = 0;
            for(int i = 0; s < N; i++) {
                s = i * G;
                int e =( (i + 1) * G) - 1;
                if (e >= N) {
                    e = N - 1;
                }
                while(s < e) {
                    String t = array[s];
                    array[s] = array[e];
                    array[e] = t;
                    s++;
                    e--;
                }
            }
            System.out.println(Stream.of(array).collect(Collectors.joining(" ")));
        }
        inout.close();
    }
}
