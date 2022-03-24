package week17;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class 이중우선순위큐 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        //최소 힙, 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String judge = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            switch (judge) {
                case "I":
                    pq.offer(value);
                    maxPq.offer(value);
                    break;
                case "D":
                    if(pq.size()<1)
                        break;
                    if(value > 0){
                        int max = maxPq.poll();
                        pq.remove(max);
                    }else{
                        int min = pq.poll();
                        maxPq.remove(min);
                    }
                    break;
            }
        }
        if(pq.size() > 0 ) {
            answer[0] = maxPq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] oper = {"I 7","I 5","I -5","D -1"};
        int[] res = solution(oper);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
