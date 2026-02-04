import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());

        int index = 0;
        while (index < N) {
            int maxIndex = index;
            for (int i = index + 1; i <= index + S; i++) {
                if (i >= N || S <= 0) break;

                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }

            S -= (maxIndex - index);
            for (int i = maxIndex; i > index; i--) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }

            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}
