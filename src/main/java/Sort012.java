import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
public class Sort012 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(input.readLine().trim());
            String[] strs = input.readLine().trim().split("\\s+");
            sort(strs);
            print(strs);
        }
        input.close();
    }

    public static void print(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s: strs) {
            stringBuilder.append(s).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void sort(String[] array) {
        int low = 0, mid = 0;
        int high = array.length - 1;

        while(mid <= high) {
            if ("0".equals(array[mid])) {
                swap(array, mid, low);
                low++;
                mid++;
            }else if ("2".equals(array[mid])) {
                swap(array, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void swap(String[] array, int i , int j) {
        String t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}

