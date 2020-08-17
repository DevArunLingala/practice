import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/minimum-platforms/0
public class NumOfPlatforms {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        while (T-- > 0) {
            int[] timeAxis = new int[24*60];
            int N = Integer.parseInt(input.readLine().trim());
            String[] arrivals = input.readLine().trim().split("\\s+");
            String[] departures = input.readLine().trim().split("\\s+");
            maxPlatformUsingTimeAxis(arrivals, departures, N);
        }
        input.close();
    }

    // NOTE : Not working, much thinking needed
    private static void maxPlatformUsingOverlapDetermination(String[] arrivals, String[] departures, int N) {
        int[] as = new int[N];
        int[] ds = new int[N];
        for (int i = 0; i < N; i++) {
            as[i] = Integer.parseInt(arrivals[i].substring(0, 2)) * 60 + Integer.parseInt(arrivals[i].substring(2, 4));
            ds[i] = Integer.parseInt(departures[i].substring(0, 2)) * 60 + Integer.parseInt(departures[i].substring(2, 4));
        }
        // assumption is that input is sorted based on arrival times
        int neededPlatforms = 1;
        for(int i = 1; i < N; i++) {
            // extra platform not required if halt time does not overlap, otherwise needed
            if (as[i - 1]  != as[i] && ds[i - 1] < as[i]) {
                // no overlap
            } else {
                neededPlatforms++;
            }
        }
        System.out.println(neededPlatforms);

    }


    private static void maxPlatformUsingTimeAxis(String[] arrivals, String[] departures, int N) {
        int[] timeAxis = new int[24*60];
        int maxPlatformsSoFar = 0;
        for(int i = 0; i < N ; i++) {
            int arrivalTime = Integer.parseInt(arrivals[i].substring(0, 2)) * 60 + Integer.parseInt(arrivals[i].substring(2, 4));
            int departureTime = Integer.parseInt(departures[i].substring(0, 2)) * 60 + Integer.parseInt(departures[i].substring(2, 4));
            for (int j = arrivalTime; j <= departureTime; j++) {
                timeAxis[j]++;
                if (maxPlatformsSoFar < timeAxis[j]) {
                    maxPlatformsSoFar = timeAxis[j];
                }
            }
        }
        System.out.println(maxPlatformsSoFar);
    }
}

