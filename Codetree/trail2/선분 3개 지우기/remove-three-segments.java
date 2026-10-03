import java.util.*;

public class Main {
    static int n;
    static int[][] lines;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();
        }
        // Please write your code here.
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isDisjoint(i, j, k)) answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean isDisjoint(int a, int b, int c) {
        int[][] temp = new int[n-3][2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i == a || i == b || i == c) continue;

            temp[idx][0] = lines[i][0];
            temp[idx][1] = lines[i][1];

            idx++;
        }


        Arrays.sort(temp, (o1, o2) -> o1[1] - o2[1]);

        int pos = -1;
        boolean disjoint = true;
        for (int i = 0; i < n - 3; i++) {
            if (temp[i][0] <= pos) {
                disjoint = false;
                break;
            }

            pos = temp[i][1];
        }
        
        return disjoint;
    }
}