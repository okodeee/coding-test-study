import java.io.*;
import java.util.*;


public class Main {
    static class Line {
        int start;
        int end;

        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines.add(new Line(x, y));
        }

        // 시작점 기준 오름차순 정렬
        lines.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        long length = 0;
        int currentStart = lines.get(0).start;
        int currentEnd = lines.get(0).end;

        // 구간 합치기
        for (int i = 1; i < N; i++) {
            Line line = lines.get(i);

            // 겹치거나 연결되는 경우
            if (line.start <= currentEnd) {
                currentEnd = Math.max(currentEnd, line.end);
            }
            // 떨어진 구간인 경우
            else {
                length += (currentEnd - currentStart);
                currentStart = line.start;
                currentEnd = line.end;
            }
        }

        // 마지막 구간 추가
        length += (currentEnd - currentStart);

        System.out.println(length);
    }
}