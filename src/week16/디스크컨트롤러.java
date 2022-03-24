package week16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
//        int[][] jobs = {{0, 10}, {4, 10}, {5, 11}, {15, 2}};
        System.out.println(solution(jobs));
    }
    public static int solution(int[][] jobs) {        // 요청시간, 수행시간
        Arrays.sort(jobs, Comparator.comparingInt(o->o[0])); // 요청시간순으로 정렬
        PriorityQueue<Disk> pq = new PriorityQueue<>(); // Disk 객체 주입시 ,실행시간 순으로 삽입
        int now=0;
        int total=0;
        int diskIndex=0;
        int finished=0;
        while(finished < jobs.length) {
            while (diskIndex < jobs.length && jobs[diskIndex][0] <= now) { // 현재시간에 수행가능한 Job을 넣어준다
                pq.add(new Disk(jobs[diskIndex][0], jobs[diskIndex][1]));  // 수행가능 Job을 추가
                diskIndex++;
            }
            if(pq.isEmpty()){ // 현재시간에 수행시킬 Job이 없으면
                now = jobs[diskIndex][0]; // 현재시간을 다음 Job 요청시간으로 갱신
            }else{ // 수행가능한 Job들을
                Disk disk = pq.poll(); // 짧은 Job부터 하나씩 빼서
                total += disk.duration + (now - disk.startTime); // 전체소요 시간 추가
                now += disk.duration; // 현재시간 갱신
                finished++;
            }
        }
        return total / jobs.length;
    }
    // 내부 정적 클래스
    private static class Disk implements Comparable {
        int startTime;
        int duration;

        public Disk(int stime, int duration) {
            this.startTime = stime;
            this.duration = duration;
        }

        @Override
        public int compareTo(Object o) {
            Disk d = (Disk) o;
            return duration - d.duration; // 수행시간 순으로 정렬되도록
        }
    }
}

