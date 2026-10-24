import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] stones = new int[n + 1];
        int[][] group = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            stones[i] = sc.nextInt();   // 각 돌의 그룹 저장
            group[i][0] = group[i - 1][0] + (stones[i] == 1 ? 1 : 0);
            group[i][1] = group[i - 1][1] + (stones[i] == 2 ? 1 : 0);
            group[i][2] = group[i - 1][2] + (stones[i] == 3 ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            sb.append(group[b][0] - group[a-1][0]).append(" ");
            sb.append(group[b][1] - group[a-1][1]).append(" ");
            sb.append(group[b][2] - group[a-1][2]).append("\n");
        }

        System.out.println(sb);
    }
}