import java.lang.*;
import java.util.*;

public class D3Q1BinaryDiagnostic {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int size = 12;
		
		int[][] C = new int[size][2];
		Integer N = 0;
		String S = "";
		S = s.nextLine();
		while (!S.equals("terminate")){
			for (int i = 0; i < size; i++) {
				C[i][Integer.parseInt(S.substring(i, i+1))]++;
			}
			S = s.nextLine();
		}
		
		int g = 0;
		int e = 0;
		
		int[] G = new int[size];
		int[] E = new int[size];
		
		for (int i = 0; i < size; i++) {
			if(C[i][0] > C[i][1]) {
				G[i] = 0;
				E[i] = 1;
				e+=(Math.pow(2, (size-1-i)));
			}else {
				G[i] = 1;
				E[i] = 0;
				g+=(Math.pow(2, (size-1-i)));
			}
			
		}
		System.out.println(e*g);

	}

}
