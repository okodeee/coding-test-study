import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if (i < M) {
                a.add(A[i]);
            }
        }
        int[] B = new int[M];
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
            b.add(B[i]);
        }
        // Please write your code here.

        int answer = 0;

        for (int i = M - 1; i < N - 1; i++) {
            if (equal(a, b)) answer++;

            a.remove(0);
            a.add(A[i + 1]);
        }
        if (equal(a, b)) answer++;

        System.out.println(answer);
    }

    static boolean equal(List A, List B) {
        List<Integer> newA = new ArrayList<>(A);
        List<Integer> newB = new ArrayList<>(B);

        Collections.sort(newA);
        Collections.sort(newB);
        
        if (newA.equals(newB)) return true;
        return false;
    }
}