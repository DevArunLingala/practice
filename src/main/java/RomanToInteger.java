import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
// https://practice.geeksforgeeks.org/problems/roman-number-to-integer/0
public class RomanToInteger {
    public static void main(String[] a) throws IOException {
        BufferedReader inout = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(inout.readLine().trim());
        while(T-- > 0) {
            System.out.println(convert(inout.readLine().trim()));
        }
        inout.close();
    }
    public static int convert(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int l = roman.length();
        int ans = map.get(roman.charAt(l-1));;
        for (int i = l - 2; i >= 0; i--) {
            if (map.get(roman.charAt(i)) < map.get(roman.charAt(i + 1))) {
                ans -= map.get(roman.charAt(i));
            } else {
                ans +=  map.get(roman.charAt(i));
            }
        }
        return ans;
    }
}
