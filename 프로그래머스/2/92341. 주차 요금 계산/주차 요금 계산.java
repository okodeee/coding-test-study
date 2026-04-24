import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalTime = new HashMap<>();
        Map<String, String> inTime = new HashMap<>(); // { 차량번호: 입차시간 }

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String num = parts[1];
            String type = parts[2];

            if (type.equals("IN")) {
                inTime.put(num, time);
            } else {
                totalTime.put(num, totalTime.getOrDefault(num, 0) + calcTime(inTime.get(num), time));
                inTime.remove(num);
            }
        }

        // 미출차 차량 23:59로 처리
        for (String num : inTime.keySet()) {
            totalTime.put(num, totalTime.getOrDefault(num, 0) + calcTime(inTime.get(num), "23:59"));
        }

        // 차량번호 오름차순 정렬 후 요금 계산
        List<String> carNums = new ArrayList<>(totalTime.keySet());
        Collections.sort(carNums);

        int[] answer = new int[carNums.size()];
        for (int i = 0; i < carNums.size(); i++) {
            answer[i] = calcFee(fees, totalTime.get(carNums.get(i)));
        }

        return answer;
    }

    // 두 시각 사이 분 계산
    int calcTime(String in, String out) {
        int inM = Integer.parseInt(in.substring(0, 2)) * 60 + Integer.parseInt(in.substring(3, 5));
        int outM = Integer.parseInt(out.substring(0, 2)) * 60 + Integer.parseInt(out.substring(3, 5));
        return outM - inM;
    }

    // 요금 계산
    int calcFee(int[] fees, int time) {
        if (time <= fees[0]) return fees[1];
        return fees[1] + (int) Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
    }
}