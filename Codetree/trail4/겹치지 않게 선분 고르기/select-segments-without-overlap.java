import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        // Please write your code here.

        Arrays.sort(segments, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int point = -1;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (point >= segments[i][0]) continue;
            answer++;
            point = segments[i][1];
        }

        System.out.println(answer);
    }
}