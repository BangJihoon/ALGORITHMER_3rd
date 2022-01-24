package week05;

import java.util.ArrayList;

public class 모의고사 {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5}; 
		int[] res = solution(answers);
		for(int i : res) System.out.println(i);
	}
	public static int[] solution(int[] answers) {
        int[] a= {1,2,3,4,5}; //5
        int[] b= {2,1,2,3,2,4,2,5}; //8
        int[] c= {3,3,1,1,2,2,4,4,5,5}; //10
		
        int aa=0,bb=0,cc=0;
        
        for(int i=0;i<answers.length;i++) {
        	if(a[i%5]==answers[i]) aa++;
        	if(b[i%8]==answers[i]) bb++;
        	if(c[i%10]==answers[i]) cc++;
        }
        int max = Math.max(Math.max(aa, bb), cc);

        ArrayList<Integer> list = new ArrayList<>();
        if(max==aa)	list.add(1);
        if(max==bb) list.add(2);
        if(max==cc)	list.add(3);
        
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++) arr[i] = list.get(i);
        return arr;
	}
}
