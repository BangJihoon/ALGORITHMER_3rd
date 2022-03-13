package week16;

import java.util.PriorityQueue;
public class 더맵게 {
    public static void main(String[] args) {
        int[] scoville = {1,2,3,7,10,12};
        int k = 7;
        System.out.println(solution(scoville,k));
    }
    /*정확성  테스트
    테스트 1 〉	통과 (0.50ms, 74.3MB)
    테스트 2 〉	통과 (0.31ms, 77.6MB)
    테스트 3 〉	통과 (0.44ms, 73.3MB)
    테스트 4 〉	통과 (0.29ms, 71.7MB)
    테스트 5 〉	통과 (0.34ms, 77.4MB)
    테스트 6 〉	통과 (2.09ms, 78.1MB)
    테스트 7 〉	통과 (1.85ms, 78.1MB)
    테스트 8 〉	통과 (0.81ms, 69.7MB)
    테스트 9 〉	통과 (0.85ms, 71.1MB)
    테스트 10 〉	통과 (2.12ms, 84.7MB)
    테스트 11 〉	통과 (1.18ms, 66.2MB)
    테스트 12 〉	통과 (1.97ms, 78.1MB)
    테스트 13 〉	통과 (1.63ms, 71.7MB)
    테스트 14 〉	통과 (0.38ms, 76.9MB)
    테스트 15 〉	통과 (2.14ms, 74.2MB)
    테스트 16 〉	통과 (0.34ms, 73.4MB)
    효율성  테스트
    테스트 1 〉	통과 (167.32ms, 66.7MB)
    테스트 2 〉	통과 (340.54ms, 106MB)
    테스트 3 〉	통과 (1537.64ms, 135MB)
    테스트 4 〉	통과 (110.98ms, 63.7MB)
    테스트 5 〉	통과 (1629.59ms, 123MB)
    */
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 우선순위큐 초기화
        for(int i : scoville)
            pq.add(i);
        int result,count=0;
        // 2개를 하나로 만듬
        while(pq.peek() < K) {
            if(pq.size() <2) return -1; // 다 섞어도 제일 작은값이 k를 못넘으면 -1
            pq.add(pq.poll() + (pq.poll()*2));
            count++;
        }
        return count;
    }

}
