import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 1024;

    static int K, N;
    static int[] a = new int[MAX_N + 1];
    static int[] treeNum = new int[MAX_N + 1];
    static int cnt = 1;

    // 중위 순회를 진행하여 각 트리의 위치에 맞는 번호를 채워 넣기
    public static void inOrder(int x) {
        if(x > N)
            return;
    
        inOrder(x * 2);
        treeNum[x] = a[cnt++];
        inOrder(x * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        // 2^i은 (1 << i)로 쉽계 계산
        N = (1 << K) - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        inOrder(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= K; i++) {
            for (int j = (1 << (i - 1)); j <= (1 << i) - 1; j++) {
                sb.append(treeNum[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}