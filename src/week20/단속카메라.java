package week20;

import java.util.Arrays;
/*
정확성  테스트
테스트 1 〉	통과 (0.74ms, 73MB)
테스트 2 〉	통과 (0.75ms, 75.6MB)
테스트 3 〉	통과 (0.51ms, 75.6MB)
테스트 4 〉	통과 (0.84ms, 72.3MB)
테스트 5 〉	통과 (0.55ms, 79.6MB)
효율성  테스트
테스트 1 〉	통과 (8.52ms, 52.6MB)
테스트 2 〉	통과 (7.74ms, 53MB)
테스트 3 〉	통과 (6.87ms, 53.8MB)
테스트 4 〉	통과 (1.00ms, 52MB)
테스트 5 〉	통과 (7.30ms, 56.2MB)
* */

public class 단속카메라 {
    public static void main(String[] args) {
        int[][] route = {{-20,-15}, {-14,-5},{-18,-13},{-5,-3}};
        System.out.println(solution(route));
    }
    public static int solution(int[][] routes) {
        // 시작점 기준으로 정렬
        Arrays.sort(routes,((o1, o2) -> o1[1] - o2[1])); // 나가는 값으로 오름차순
        int next=routes[0][1],ans=1; // 초기설치 구역
        for (int[] route : routes) {
            if(route[0] >next) {
                next = route[1];
                ans++;
            }
        }
        return ans;
    }

}
