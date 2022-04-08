package week20;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 51,112 kb	584 ms
public class 네트워크연결 {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1]; // 노드수만큼을 가지는 arr 생성 (0은 편의상 미사용)
        // 연결정보 초기화
        for (int i = 0; i < arr.length; i++)
            arr[i] =i;
        // input 초기화
        int networks[][] = new int[m][3];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            networks[i][0] = Integer.parseInt(st.nextToken());
            networks[i][1] = Integer.parseInt(st.nextToken());
            networks[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(networks, Comparator.comparingInt(o->o[2])); // cost 낮은순 정렬

        int res=0;
        for (int[] network : networks) {
            if(union(network[0],network[1])) { // 연결했으면
                res += network[2]; // 비용값 더함
            }
        }
        bw.write(res+"\n");
        bw.flush();
        br.close();
        bw.close();

    }
    static int find(int a){ // 연결 끝지점 탐색
        if(a == arr[a])
            return a;
        return arr[a] = find(arr[a]); // 최적화 (값최신화 안해도 무방함)
    }
    static boolean union(int from,int to){
        int a = find(from);
        int b = find(to);
        if(a != b) { // 연결이 없으면
            arr[a] = b; // 연결정보가 없는 끝쪽에 갱신시켜야 연결이 안끝어짐 (중요★)
            return true;
        }
        return false;
    }
}
