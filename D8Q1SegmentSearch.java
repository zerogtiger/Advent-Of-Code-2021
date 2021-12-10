import java.lang.*;
import java.util.*;

public class D8Q1SegmentSearch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String[] temp = s.nextLine().split(" | ");
		String[] nums = new String[4];
		
		int sum = 0;
		while(!temp[0].equals("-1")) {
			for (int i = 0; i < 4; i ++) {
				nums[i] = temp[11+i];
			}
			for (int i = 0; i < 4; i++) {
				if (nums[i].length() == 2 || nums[i].length() == 4 || nums[i].length() == 3 || nums[i].length() == 7) {
					sum ++;
				}
			}
			temp = s.nextLine().split(" | ");
		}
		System.out.println(sum);
	}

}
