import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] temp = p.clone();
        int answer = 0;

        for (int i = 0; i < n; i++) {   // 반값으로 설정
            temp[i] /= 2;

            Arrays.sort(temp);

            int sum = 0;
            int t = 0;
            while (t < n) {
                sum += temp[t++];

                if (sum > b) {
                    t--;
                    break;
                }
            }

            answer = Math.max(answer, t);

            temp = p.clone();
        }

        System.out.println(answer);
    }
}