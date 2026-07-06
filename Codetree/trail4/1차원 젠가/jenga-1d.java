import java.io.*;
import java.util.*;

public class Main {
    static int[] blocks;
    static int N;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        blocks = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            blocks[i] = Integer.parseInt(br.readLine());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        remove(N, s, e);

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        remove(N, s, e);

        print();
    }

    // 배열 길이, start부터 end까지 제거
    static void remove(int length, int start, int end) {
        int[] temp = new int[length - end + start - 1];
        int endOfTemp = 0;
        for (int i = 0; i < length; i++) {
            // 삭제
            if (i >= N - end && i <= N - start) {
                continue;
            }

            temp[endOfTemp] = blocks[i];
                endOfTemp++;
        }

        blocks = temp;
        N = length - end + start - 1;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(N).append('\n');

        if (N > 0) {
            for (int i = N - 1; i >= 0; i--) {
                sb.append(blocks[i]).append('\n');
            }
        }

        System.out.println(sb);
    }
}