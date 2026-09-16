import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] color = new int[200001];  // -1: 흰색, 1: 검은색

        int position = 100000;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if (d == 'L') {
                for (int l = position; l > position - x; l--) {
                    color[l] = -1;
                }

                position = position - x + 1;
            } else {
                for (int l = position; l < position + x; l++) {
                    color[l] = 1;
                }

                position = position + x - 1;
            }
        }
        
        int white = 0; int black = 0;
        for (int i = 0; i < 200001; i++) {
            if (color[i] == -1) white++;
            else if (color[i] == 1) black++;
        }

        System.out.println(white + " " + black);
        
    }
}