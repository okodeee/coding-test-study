import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            double r2 = (double) o2[1] / o2[0];
            double r1 = (double) o1[1] / o1[0];
            return Double.compare(r2, r1);
        });

        double weight = 0;
        double value = 0;
        for (int i = 0; i < N; i++) {
            if (weight + arr[i][0] > M) {
                double left = M - weight;
                value += left * ((double)arr[i][1] / arr[i][0]);
                weight += left;
                break; 
            }
            else {
                value += arr[i][1];
                weight += arr[i][0];
            }
        }

        System.out.printf("%.3f", value);

    }
}