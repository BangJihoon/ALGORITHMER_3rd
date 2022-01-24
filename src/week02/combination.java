package week02;

public class combination {
	/**
	 * 조합 : n 개 중에서 r 개 선택
	 */
    public static void main(String[] args) {
        String arr = "abcde";
        int n = arr.length();
        boolean[] visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combinationFunc(arr, visited, 0, n, i);
        }
    }

    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combinationFunc(String arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combinationFunc(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        } 
    }	
    // 배열 출력
    static void print(String arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) { 
            if (visited[i]) {
                System.out.print(arr.charAt(i) + " ");
            }
        }
        System.out.println();
    }
}