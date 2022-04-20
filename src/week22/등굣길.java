package week22;
/*
정확성  테스트
테스트 1 〉	통과 (0.02ms, 78.7MB)
테스트 2 〉	통과 (0.03ms, 77.6MB)
테스트 3 〉	통과 (0.04ms, 75.1MB)
테스트 4 〉	통과 (0.03ms, 69.4MB)
테스트 5 〉	통과 (0.03ms, 77.3MB)
테스트 6 〉	통과 (0.03ms, 78.8MB)
테스트 7 〉	통과 (0.03ms, 77.1MB)
테스트 8 〉	통과 (0.03ms, 72.8MB)
테스트 9 〉	통과 (0.02ms, 76.9MB)
테스트 10 〉	통과 (0.02ms, 75.9MB)
효율성  테스트
테스트 1 〉	통과 (0.74ms, 52.5MB)
테스트 2 〉	통과 (0.29ms, 52.3MB)
테스트 3 〉	통과 (0.34ms, 51.8MB)
테스트 4 〉	통과 (0.51ms, 68.3MB)
테스트 5 〉	통과 (0.44ms, 52.1MB)
테스트 6 〉	통과 (0.87ms, 51.8MB)
테스트 7 〉	통과 (0.35ms, 52.3MB)
테스트 8 〉	통과 (0.34ms, 51.7MB)
테스트 9 〉	통과 (0.54ms, 52.5MB)
테스트 10 〉	통과 (0.53ms, 51.6MB)
 */
public class 등굣길 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(solution(m, n, puddles));
    }
    public static int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[m+1][n+1]; // 0은 미사용
        // 웅덩이 초기화
        for (int[] puddle : puddles)
            arr[puddle[0]][puddle[1]] = -1;
        // 경로 Dp
        arr[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(arr[i][j]==-1) {
                    arr[i][j]=0;
                    continue;
                }
               arr[i][j] += (arr[i-1][j] + arr[i][j-1]) %1000000007; // + 가 빠져도 되야하는게 아닌가??... 의문이다
            }
        }
        return arr[m][n];
    }
}
