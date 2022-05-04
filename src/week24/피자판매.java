package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피자판매 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); // 구하고자 하는 값
        String[] x =  br.readLine().split(" ");
        int m = Integer.parseInt(x[0]);
        int n = Integer.parseInt(x[1]);
        int[] arrA = new int[m];
        int[] arrB = new int[n];
        for (int i = 0; i < m; i++)
            arrA[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            arrB[i] = Integer.parseInt(br.readLine());
        // 이분탐색으로 못하겠다ㅠ 경우의수로 풀자...
        int[] DP = new int[k+1];
        DP[0]++;
        for (int i = 0; i < m; i++){
            if(arrA[i]<=k){ // 입력받은 A에서 k 이하의 수를 count
                int prev = arrA[i];
                DP[prev]++;
                int j = 0;
                while(++j <= m && prev + arrA[(i+j)%m] <= k){ // 이어지는 값의 조합들에서 만족하는 경우도 count
                    prev += arrA[(i+j)%m];
                    DP[prev]++;
                    j++;
                }
                if(j>m)
                    DP[prev]=1;
            }
        }
        int[] DP2 = new int[k+1];
        DP2[0] = 1;
        for (int i = 0; i < n; i++) {
            if(arrB[i]<=k){ // 입력받은 A에서 k 이하의 수를 count
                int prev = arrB[i];
                DP2[prev]++;
                int j = 0;
                while(++j <= n && prev + arrB[(i+j)%n] <= k){ // 이어지는 값의 조합들에서 만족하는 경우도 count
                    prev += arrB[(i+j)%n];
                    DP2[prev]++;
                    j++;
                }
                if(j>n)
                    DP2[prev]=1;

            }
        }
//        for (int i = 0; i < DP2.length; i++) {
//            System.out.println("DP[i] = " + DP[i] +" " +DP2[i]);
//        }
        // 출력
        int res=0;
        for (int i = 0; i <= k; i++)
            res += DP[i] * DP2[k-i];

        System.out.println(res);
        br.close();
    }
}
