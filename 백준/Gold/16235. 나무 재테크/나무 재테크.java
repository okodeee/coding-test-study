import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static class Tree {
        int age;
        int x;
        int y;
        boolean live;

        Tree(int age, int x, int y) {
            this.age = age;
            this.x = x;
            this.y = y;
            live = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 땅의 현재 양분
        int[][] ground = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ground[i][j] = 5;
            }
        }

        // 각 칸에 추가되는 양분
        int[][] plus = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                plus[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 땅의 나무들
        List<Tree>[][] trees = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                trees[i][j] = new ArrayList<Tree>();
            }
        }

        // 상도가 심은 나무
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            trees[x][y].add(new Tree(z, x, y));
        }

        while (K-- > 0) {
            // 봄
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    List<Tree> curr = trees[i][j];
                    Collections.sort(curr, (a, b) -> a.age - b.age);

                    boolean pos = true;
                    for (int k = 0; k < curr.size(); k++) {
                        if (!pos) {
                            curr.get(k).live = false;
                        } else if (ground[i][j] < curr.get(k).age) {
                            curr.get(k).live = false;
                            pos = false;
                        } else {
                            ground[i][j] -= curr.get(k).age;
                            curr.get(k).age++;
                        }
                    }
                }
            }

            // 여름
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = trees[i][j].size() - 1; k >= 0; k--) {
                        if (!trees[i][j].get(k).live) {
                            ground[i][j] += trees[i][j].get(k).age / 2;
                            trees[i][j].remove(k);
                        }
                    }
                }
            }

            // 가을
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < trees[i][j].size(); k++) {
                        if (trees[i][j].get(k).age % 5 == 0) {
                            for (int d = 0; d < 8; d++) {
                                int nx = i + dx[d];
                                int ny = j + dy[d];

                                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                                    continue;

                                trees[nx][ny].add(new Tree(1, nx, ny));
                            }
                        }
                    }
                }
            }

            // 겨울
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ground[i][j] += plus[i][j];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += trees[i][j].size();
            }
        }

        System.out.println(count);
    }
}
