package wekk14;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location =0;
        System.out.println(solution(priorities,location));
    }
/*
정확성  테스트
테스트 1 〉	통과 (1.40ms, 74.6MB)
테스트 2 〉	통과 (3.57ms, 77.8MB)
테스트 3 〉	통과 (0.94ms, 77.5MB)
테스트 4 〉	통과 (0.74ms, 95.1MB)
테스트 5 〉	통과 (0.23ms, 75.9MB)
테스트 6 〉	통과 (1.48ms, 68.6MB)
테스트 7 〉	통과 (1.61ms, 85.9MB)
테스트 8 〉	통과 (2.39ms, 76.6MB)
테스트 9 〉	통과 (0.42ms, 77.2MB)
테스트 10 〉	통과 (0.97ms, 82MB)
테스트 11 〉	통과 (2.17ms, 83.1MB)
테스트 12 〉	통과 (0.64ms, 79.5MB)
테스트 13 〉	통과 (2.36ms, 71.9MB)
테스트 14 〉	통과 (0.24ms, 78.3MB)
테스트 15 〉	통과 (0.30ms, 74.2MB)
테스트 16 〉	통과 (0.65ms, 71.9MB)
테스트 17 〉	통과 (2.65ms, 83.4MB)
테스트 18 〉	통과 (0.29ms, 77.1MB)
테스트 19 〉	통과 (2.35ms, 76.3MB)
테스트 20 〉	통과 (0.95ms, 77.1MB)
*/
    public static int solution(int[] priorities, int location) {
        // 작업목록을 Queue에 초기화
        Queue<Integer> q = new LinkedList<>();
        for (int priority : priorities)
            q.offer(priority);
        int cnt=0;
        // location을 기록하면서 반환개수 count
        while(!q.isEmpty()){
            // poll과 count
            if(Collections.max(q) == q.peek()){// 최상위 우선순위면 빼주면서 count
                cnt++;
                q.poll();
                if(location==0) // 결과 반환
                    return cnt;
            }else{ // 우선순위가 아니면 뒤로 넣기
                q.add(q.poll());
            }
            // 위치 기록
            if(location!=0)
                location--;
            else
                location = q.size()-1;
        }
        return 0;
    }
}
