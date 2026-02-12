import java.io.*;
import java.util.*;

public class Main {
    static class Schedule {
        int start;
        int end;

        Schedule(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Schedule> schedules = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            }

            return o1.start - o2.start;
        });

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            schedules.offer(new Schedule(S, E));
        }

        int length = 0;
        int width = 0;
        int answer = 0;
        PriorityQueue<Schedule> calendar = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);

        for (int i = 1; i <= 365; i++) {
            // 지난 일정 달력에서 빼기
            while (!calendar.isEmpty() && calendar.peek().end < i) {
                calendar.poll();
            }

            // 시작하는 일정 달력에 넣기
            while (!schedules.isEmpty() && schedules.peek().start <= i) {
                calendar.offer(schedules.poll());
            }

            // 세로 길이 갱신
            length = Math.max(length, calendar.size());

            // 하나의 직사각형
            if (calendar.size() == 0) {
                answer += length * width;
                length = 0;
                width = 0;
            } else {
                width++;
            }
        }

        answer += length * width;

        System.out.println(answer);
    }
}