package week15;

import java.util.LinkedList;
import java.util.Queue;
/*
정확성  테스트
테스트 1 〉	통과 (1.19ms, 78.9MB)
테스트 2 〉	통과 (8.66ms, 80.9MB)
테스트 3 〉	통과 (0.14ms, 80.1MB)
테스트 4 〉	통과 (9.20ms, 82.2MB)
테스트 5 〉	통과 (25.49ms, 92.4MB)
테스트 6 〉	통과 (12.92ms, 85.7MB)
테스트 7 〉	통과 (1.06ms, 65.8MB)
테스트 8 〉	통과 (0.59ms, 77.2MB)
테스트 9 〉	통과 (2.63ms, 67.2MB)
테스트 10 〉	통과 (0.62ms, 74.4MB)
테스트 11 〉	통과 (0.18ms, 74.3MB)
테스트 12 〉	통과 (0.78ms, 74.5MB)
테스트 13 〉	통과 (2.06ms, 74MB)
테스트 14 〉	통과 (0.20ms, 80.2MB)
*/
public class 다리를지나는트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i=0;i<bridge_length ; i++) q.add(0); // 큐를 다리길이만큼 0원소로 초기화
        int sec=0,sum=0;
        for (int t : truck_weights) {
            while(sum + t - q.peek() >weight){ // 다음원소가 빠지고, 신규원소가 들어갈수 있는지 체크
                sum-=q.poll();
                q.offer(0);
                sec++;
            }
            sum = sum-q.poll()+t;
            q.offer(t);
            sec++;
        }
        return sec+bridge_length; // 마지막 트럭이 다 지나가기까지
    }

    public static void main(String[] args) {
        int bridge_length=2;
        int weight=10;
        int[] truck_weights = {7,4,5,6}; // 8s
        System.out.println(solution(bridge_length,weight,truck_weights));
    }
}
