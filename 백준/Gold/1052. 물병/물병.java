import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;

        // N의 1의 개수가 K 이하가 될 때까지 반복
        while (Integer.bitCount(N) > K) {
            N++;
            answer++;
        }

        System.out.println(answer);
    }
}
