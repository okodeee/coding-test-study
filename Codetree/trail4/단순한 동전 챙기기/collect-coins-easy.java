import java.util.*;

public class Main {
    static int[] start, end;
    static List<Coin> coins = new ArrayList<>();
    static List<Coin> selected = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

    static class Coin {
        int num;
        int x;
        int y;
        
        public Coin(int n, int x, int y) {
            this.x = x;
            this.y = y;
            this.num = n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] grid = new String[N];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.next();
            for (int j = 0; j < N; j++) {
                if (grid[i].charAt(j) >= '1' && grid[i].charAt(j) <= '9') {
                    coins.add(new Coin(grid[i].charAt(j), i, j));
                } else if (grid[i].charAt(j) == 'S') {
                    start = new int[] {i, j};
                } else if (grid[i].charAt(j) == 'E') {
                    end = new int[] {i, j};
                }
            }
        }
        
        // Please write your code here.
        Collections.sort(coins, (o1, o2) -> o1.num - o2.num);

        getCombi(0);

        System.out.println(minDistance == Integer.MAX_VALUE ? -1 : minDistance);
    }

    static void getCombi(int idx) {
        if (selected.size() >= 3) { // 조합 구함
            getDistance();
            return;
        }

        if (idx >= coins.size()) {   // 조합 못 구함
            return;
        }

        selected.add(coins.get(idx));  // 현재 동전 선택
        getCombi(idx + 1);

        selected.remove(selected.size() - 1); // 원상복구
        getCombi(idx + 1);  // 현재 동전을 선택하지 않고 넘어가는 경우
    }

    static void getDistance() {
        int distance = 0;

        int currX = start[0];
        int currY = start[1];
        for (int i = 0; i < 3; i++) {
            int nextX = selected.get(i).x;
            int nextY = selected.get(i).y;
            distance += Math.abs(nextX - currX);
            distance += Math.abs(nextY - currY);
            currX = nextX;
            currY = nextY;
        }

        distance += Math.abs(currX - end[0]);
        distance += Math.abs(currY - end[1]);

        minDistance = Math.min(minDistance, distance);
    }
}