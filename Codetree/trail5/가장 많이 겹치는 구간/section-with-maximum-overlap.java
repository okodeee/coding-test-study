import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] checked = new int[200001];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            checked[Integer.parseInt(st.nextToken())]++;
            checked[Integer.parseInt(st.nextToken())]--;
        }

        int answer = 0;
        int sum = 0;
        for (int i = 1; i < 200001; i++) {
            sum += checked[i];
            answer = Math.max(answer, sum);
        }


        System.out.println(answer);
    }
}