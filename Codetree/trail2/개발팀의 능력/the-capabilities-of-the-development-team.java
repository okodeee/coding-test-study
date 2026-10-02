import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        // Please write your code here.
        int[] dev = new int[5];
        dev[0] = a;
        dev[1] = b;
        dev[2] = c;
        dev[3] = d;
        dev[4] = e;
        int sum = a + b + c + d + e;

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == i) continue;
                for (int k = 0; k < 5; k++) {
                    if (k == i || k == j) continue;

                    int team1 = dev[j] + dev[k];
                    int team2 = sum - dev[i] - team1;

                    if (dev[i] == team1 || dev[i] == team2 || team1 == team2) continue;

                    int max = Math.max(dev[i], Math.max(team1, team2));
                    int min = Math.min(dev[i], Math.min(team1, team2));

                    answer = Math.min(answer, max - min);
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}