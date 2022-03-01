package week15;

import java.util.LinkedList;
import java.util.Queue;

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
