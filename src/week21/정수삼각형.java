package week21;
/*
정확성  테스트
테스트 1 〉	통과 (0.04ms, 52.8MB)
테스트 2 〉	통과 (0.04ms, 52.1MB)
테스트 3 〉	통과 (0.04ms, 52.8MB)
테스트 4 〉	통과 (0.08ms, 53.1MB)
테스트 5 〉	통과 (0.28ms, 52.9MB)
테스트 6 〉	통과 (0.10ms, 54.1MB)
테스트 7 〉	통과 (0.28ms, 52.8MB)
테스트 8 〉	통과 (0.08ms, 52.4MB)
테스트 9 〉	통과 (0.03ms, 52.3MB)
테스트 10 〉	통과 (0.06ms, 52.6MB)
효율성  테스트
테스트 1 〉	통과 (5.94ms, 59.9MB)
테스트 2 〉	통과 (5.73ms, 60.3MB)
테스트 3 〉	통과 (6.96ms, 60.7MB)
테스트 4 〉	통과 (8.02ms, 60.5MB)
테스트 5 〉	통과 (5.72ms, 59.8MB)
테스트 6 〉	통과 (6.89ms, 62.4MB)
테스트 7 〉	통과 (6.34ms, 61.6MB)
테스트 8 〉	통과 (5.85ms, 58.7MB)
테스트 9 〉	통과 (10.06ms, 59.7MB)
테스트 10 〉	통과 (6.33ms, 60.3MB)
 */
public class 정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; // 30
        System.out.println(solution(triangle));
    }
    // 뒤집어 순회하면서 메모이제이션!
    public static int solution(int[][] triangle) {
        for (int i = triangle.length-2; i >= 0 ; i--) { // 맨 바로 위층을 기준삼고 top까지 올라감
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]); // 아래층 두개의 값을 비교해서 큰값으로 경로값 셋팅
            }
        }
        return triangle[0][0];
    }
}