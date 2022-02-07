package week12;

import java.util.Arrays;
/*
* 정확성  테스트
테스트 1 〉	통과 (0.32ms, 76.4MB)
테스트 2 〉	통과 (0.35ms, 72MB)
테스트 3 〉	통과 (0.34ms, 73.5MB)
테스트 4 〉	통과 (0.46ms, 77.1MB)
테스트 5 〉	통과 (0.36ms, 73.7MB)
테스트 6 〉	통과 (0.45ms, 74.7MB)
테스트 7 〉	통과 (0.36ms, 67.8MB)
* */
public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}; // start, end, 정렬후 K번째 수 -> 배열에 저장후 반환
        int[] res = solution(array,commands);
        for(int i : res) System.out.println("i = " + i);
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }
        return answer;
    }
}

