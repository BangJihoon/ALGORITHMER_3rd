package week16;
import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
//        int[][] jobs = {{0, 10}, {4, 10}, {5, 11}, {15, 2}};
        System.out.println(solution(jobs));
    }
    // SJF 로 구현되야 함
    public static int solution(int[][] jobs) {        // 요청시간, 수행시간
        PriorityQueue<Disk> pq = new PriorityQueue<>(); //수행시간이 짧은 순서로 들어감
        Arrays.sort(jobs,(Comparator.comparingInt(o -> o[0]))); // 요청시간별로 정렬
        int total=0;
        int current=0,i=0;
        while(true){
            // 현재시간에 수행가능한 Job을 pq에 넣음
            while(current>=jobs[i][0]){
                pq.add(new Disk(jobs[i][0],jobs[i][1]));
                i++;
            }
            if(pq.isEmpty()){
                current = jobs[i][0];
            }else{
                Disk disk = pq.poll();
                total++;
                break;
            }

        }
        return total / jobs.length;
    }
}

class Disk implements Comparable{
    int stime;
    int duration;

    public Disk(int stime, int duration) {
        this.stime = stime;
        this.duration = duration;
    }

    @Override
    public int compareTo(Object o) {
        Disk disk = (Disk)o;
        return duration - disk.duration;
    }
}
