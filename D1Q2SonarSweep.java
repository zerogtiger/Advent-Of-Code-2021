import java.lang.*;
import java.util.*;

public class D1Q2SonarSweep {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[] N = new int[4];
		N[1] = s.nextInt();
		N[2] = s.nextInt();
		N[3] = s.nextInt();
		N[0] = (N[1] + N[2] + N[3]);
		int I= 0;
		while (true) {
			if (N[3] == -1) {
				break;
			}
			if ((N[1] + N[2] + N[3]) > N[0]) {
				I++;
			}
			N[0] = (N[1] + N[2] + N[3]);
			N[1] = N[2];
			N[2] = N[3];
			N[3] = s.nextInt();
		}
		System.out.println(I);

	}

}
