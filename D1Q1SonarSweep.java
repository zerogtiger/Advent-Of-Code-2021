import java.lang.*;
import java.util.*;

public class D1Q1SonarSweep {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N1 = s.nextInt();
		int N2;
		int I= 0;
		while (true) {
			N2 = s.nextInt();
			if (N2 == -1) {
				break;
			}
			if (N2 > N1) {
				I++;
			}
			N1 = N2;
		}
		System.out.println(I);

	}

}
