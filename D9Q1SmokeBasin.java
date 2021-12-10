import java.lang.*;
import java.util.*;

public class D9Q1SmokeBasin {

	public static int[] toIntArr(String[] S) {
		int[] out = new int[S.length];
		for (int i = 0; i < S.length; i++) {
			out[i] = Integer.parseInt(S[i]);
		}
		return out;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String[] temp = s.nextLine().split("");
		int[] top = new int[temp.length];
		int[] mid = toIntArr(temp);
		temp = s.nextLine().split("");
		int[] bot = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			top[i] = 9;
		}
		
		Integer sum = 0;
		
		do {
			bot = toIntArr(temp);
			for (int i = 0; i < top.length; i++) {
				if (i == 0) {
					if (mid[i] < top[i] && mid[i] < mid[i+1] && mid[i] < bot[i]) {
						sum += mid[i]+1;
					}
				}else if (i == top.length-1) {
					if (mid[i] < top[i] && mid[i] < mid[i-1] && mid[i] < bot[i]) {
						sum += mid[i]+1;
					}
				}else {
					if (mid[i] < top[i] && mid[i] < mid[i-1] && mid[i] < mid[i+1] && mid[i] < bot[i]) {
						sum += mid[i]+1; 
					}
				}
			}
			top = mid;
			mid = bot;
			temp = s.nextLine().split("");
			
		}while(temp.length == mid.length);
		
		System.out.println(sum);

	}

}
