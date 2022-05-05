package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피자판매 {
    public static void main(String[] args) throws IOException {
        // 1.입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); // 구하고자 하는 값
        String[] x =  br.readLine().split(" ");
        int m = Integer.parseInt(x[0]);
        int n = Integer.parseInt(x[1]);
        int[] arrA = new int[m];
        int[] arrB = new int[n];
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < m; i++) {
            arrA[i] = Integer.parseInt(br.readLine());
            sumA +=arrA[i];
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(br.readLine());
            sumB +=arrB[i];
        }
        br.close();
        // 경우의 수 count
        sumA = sumA > k ? 0 : sumA;
        sumB = sumB > k ? 0 : sumB;
        // 경우의수로 풀자...
        int[] DP1 = new int[k+1];
        int[] DP2 = new int[k+1];
        // 아무것도 선택 안하는 경우는 1번
        DP1[0] = 1;
        DP2[0] = 1;
        // 개수 count
        count_pieces(DP1,arrA,k);
        count_pieces(DP2,arrB,k);
        // 전체 다 선택하는 경우도 1번
        DP1[sumA]=1;
        DP2[sumB]=1;

        // 출력
        int res=0;
        for (int i = 0; i <= k; i++)
            res += DP1[i] * DP2[k-i];

        System.out.println(res);
        br.close();
    }
    static void count_pieces(int[] DP, int[] arr, int k){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len-1; j++) { // 맨끝까지 돌지 말것
                if(arr[(i+j)%len] + sum > k)
                    break;
                sum += arr[(i+j)%len];
                DP[sum]++;
            }
        }
    }
}
