package week21;
/*
위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중,
거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다.
아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다.
3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

제한사항
삼각형의 높이는 1 이상 500 이하입니다.
삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
 */
public class 정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; // 30
        System.out.println(solution(triangle));
    }
    // 대박.... 뒤집을 생각을 못했다... 뒤집어 순회하면서 한번메 메모이제이션!
    public static int solution(int[][] triangle) {
        for (int i = triangle.length-2; i >= 0 ; i--) { // 맨 바로 위층을 기준삼고 top까지 올라감
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]); // 아래층 두개의 값을 비교해서 큰값으로 경로값 셋팅
            }
        }
        return triangle[0][0];
    }
}