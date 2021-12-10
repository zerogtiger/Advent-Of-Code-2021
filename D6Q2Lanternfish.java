import java.lang.*;
import java.util.*;

public class D6Q2Lanternfish {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		long[] fish = new long[9];
		String[] temp = s.nextLine().split(",");
		for (int i = 0; i < temp.length; i++) {
			fish[Integer.parseInt(temp[i])]++;
		}
		for (int i = 0; i < 4096; i++) {
			long baby = fish[0];
			for (int j = 0; j < 8; j++) {
				fish[j] = fish[j+1];
			}
			fish[8] = baby;
			fish[6] += baby;
		}
		long sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += fish[i];
		}
		System.out.println(sum);
		
	}

}
