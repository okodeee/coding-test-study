import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n, m;
    public static int[] uf = new int[MAX_N + 1];
    
    public static int find(int x) {
        if(uf[x] == x)
            return x;
        return uf[x] = find(uf[x]);
    }
    
    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++)
            uf[i] = i;

        while(m-- > 0) {
            int qType = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(qType == 0)
                union(a, b);
            else {
                if(find(a) == find(b))
                    System.out.println(1);
                else
                    System.out.println(0);
            }
        }
    }
}
