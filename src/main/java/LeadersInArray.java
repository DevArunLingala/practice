import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0
public class LeadersInArray {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main1(String[] args) throws IOException {
        FastReader input = new FastReader();
        int T = input.nextInt();
        while (T-- > 0) {
            int N = input.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = input.nextInt();
            }
            StringBuilder result = new StringBuilder();
            int maxSofar = array[N-1];
            result.insert(0, maxSofar);
            for (int i = N-2; i >= 0; i--) {
                int cur = array[i];
                if (cur >= maxSofar) {
                    result.insert(0, " ").insert(0, cur);
                    maxSofar = cur;
                }
            }
            System.out.println(result.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(input.readLine().trim());
            String[] array = input.readLine().trim().split("\\s+");
            StringBuilder result = new StringBuilder(array[N-1]);
            int maxSofar = Integer.parseInt(array[N-1]);
            for (int i = N-2; i >= 0; i--) {
                int cur = Integer.parseInt(array[i]);
                if (cur >= maxSofar) {
                    result.insert(0, " ").insert(0, cur);
                    maxSofar = cur;
                }
            }
            System.out.println(result.toString());
        }
        input.close();
    }
}




