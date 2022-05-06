package week24;

import java.util.Scanner;

public class 팰린드롬만들기 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        // 계산
        int res = count_diff(0,n-1,arr);
        // 결과
        System.out.println(res);
    }
    static int count_diff(int left , int right, int[] arr){
        int res=0;
        for (int i=left ; i<right; i++){
            if(arr[i] != arr[right])
                res++;
            else
                right--;
        }
        int min = res;
        res =0;
        for (int i=right ; i>left; i--){
            if(arr[i] != arr[left])
                res++;
            else
                left++;
        }
        return Math.min(min,res);
    }
}
