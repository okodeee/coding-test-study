import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        // Please write your code here.

        int num = 1;
        while(true) {
            boolean dis = true;
            int temp = num;

            for (int i = 0; i < n; i++) {
                temp *= 2;
                if (a[i] > temp || temp > b[i])  {
                    dis = false;
                    break;
                }
            }

            if (dis) {
                break;
            }
            

            num++;
        }

        System.out.println(num);
    }
}