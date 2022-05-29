package week26;
/*
* 정확성  테스트
테스트 1 〉	통과 (0.04ms, 69.2MB)
테스트 2 〉	통과 (0.03ms, 70.4MB)
테스트 3 〉	통과 (0.07ms, 68.1MB)
테스트 4 〉	통과 (0.07ms, 80MB)
테스트 5 〉	통과 (0.85ms, 61.1MB)
테스트 6 〉	통과 (1.76ms, 58.7MB)
테스트 7 〉	통과 (4.32ms, 62.5MB)
테스트 8 〉	통과 (12.70ms, 71.8MB)
테스트 9 〉	통과 (14.56ms, 76.3MB)
테스트 10 〉	통과 (11.19ms, 61.8MB)
* */
public class 가장먼노드 {
    static int [][] matrix;
    public int solution(int n, int[][] results) {
        // 0 초기화
        matrix = new int [n][n];
        for(int i=0; i<n;i++)	for(int j=0; j<n; j++) matrix[i][j]=0;
        // 승패 기록
        for(int[] a : results)	update(a[0]-1,a[1]-1);
        // 승리한 사람의 승리정보 가져와 update
        for(int i=0; i<n;i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==1) {
                    for(int k=0;k<n;k++)
                        if(matrix[j][k]==1)
                            update(i,k);
                }else if(matrix[i][j]==-1){
                    for(int k=0;k<n;k++)
                        if(matrix[i][k]==1)
                            update(j,k);
                }
            }
        }
        int sum,answer=0;
        for(int[] a : matrix) {
            sum=0;
            for(int b : a) {
                if(b==0) sum+=1;
            }
            if(sum==1)
                answer+=1;
        }

        return answer;
    }
    public static void update(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = -1;
    }
}
