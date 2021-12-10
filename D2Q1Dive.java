import java.lang.*;
import java.util.*;

public class D2Q1Dive {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int H = 0;
		int D = 0;
		
		while (true) {
			String[] S = s.nextLine().split(" ");
			
			if(S[0].equals("-1")) {
				break;
			}
			switch (S[0]) {
			case "forward": 
				H += Integer.parseInt(S[1]);
				break;
			case "down":
				D += Integer.parseInt(S[1]);
				break;
			case "up":
				D-= Integer.parseInt(S[1]);
			}
		}
		System.out.println(H*D);

	}

}
