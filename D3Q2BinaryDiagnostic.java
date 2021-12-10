import java.lang.*;
import java.util.*;

public class D3Q2BinaryDiagnostic {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int size = 12;
		int temp = 0;
		ArrayList<String> OG = new ArrayList<String>();
		ArrayList<Integer> OGR = new ArrayList<Integer>();
		ArrayList<String> OS = new ArrayList<String>();
		ArrayList<Integer> OSR = new ArrayList<Integer>();
		Integer[] G = new Integer[size];
		Integer[] SC = new Integer[size];
		int ones = 0;
		
		String S = s.nextLine();
		while(!S.equals("terminate")) {
			OG.add(S);
			OS.add(S);
			S = s.nextLine();
		}
		System.out.println(OG);
		System.out.println(OS);
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < OG.size(); i++) {
				if (OG.get(i).substring(j, j+1).equals("1")) {
					ones++;
				}
			}
			if (ones >= (OG.size()-ones)) {
				G[j] = 1;
			}else {
				G[j] = 0;
			}
			System.out.println("G[j]: " + G[j]);
			temp = OG.size();
			System.out.println(OG.size());
			for (int i = 0; i < temp; i++) {
				System.out.println("OG.get(i).substring(j, j+1): " + OG.get(i).substring(j, j+1) + "\nG[j]: " + G[j].toString());
				if (!G[j].toString().equals(OG.get(i).substring(j, j+1))) {
					//System.out.println(OG.get(i));
					OGR.add(i);
					System.out.println(OGR);
				}
			}
			for (int i = 0; i < OGR.size(); i++) {
				System.out.println("OGR.get(OGR.size()-i-1)" + OGR.get(OGR.size()-i-1));
				
				OG.remove(OG.get(OGR.get(OGR.size()-i-1)));
			}
			ones = 0;
			temp = 0;
			OGR.clear();
			System.out.println(OG);
			if(OG.size()==1) {
				break;
			}
			
		}
		
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < OS.size(); i++) {
				if (OS.get(i).substring(j, j+1).equals("1")) {
					ones++;
				}
			}
			if (ones >= (OS.size()-ones)) {
				SC[j] = 0;
			}else {
				SC[j] = 1;
			}

			temp = OS.size();
			System.out.println(OS.size());
			for (int i = 0; i < temp; i++) {
				if (!SC[j].toString().equals(OS.get(i).substring(j, j+1))) {
					OSR.add(i);
					System.out.println(OSR);
				}
			}
			for (int i = 0; i < OSR.size(); i++) {				
				OS.remove(OS.get(OSR.get(OSR.size()-i-1)));
			}
			ones = 0;
			temp = 0;
			OSR.clear();
			System.out.println(OS);
			if(OS.size()==1) {
				break;
			}
			
		}
		
		int generator = 0;
		int scrubber = 0;
		for (int i = 0; i < size; i++) {
			if(OG.get(0).substring(i, i+1).equals("1")) {
				generator+= Math.pow(2, size-i-1);
			}
			if(OS.get(0).substring(i, i+1).equals("1")) {
				scrubber+= Math.pow(2, size-i-1);
			}
		}
		
		System.out.println(generator*scrubber);
		
	}

}
