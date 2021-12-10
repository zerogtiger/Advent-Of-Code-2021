import java.lang.*;
import java.util.*;

public class D8Q2SegmentSearch {

	public static boolean contains(String[] S, String[] key) {
		boolean contains = true;
		boolean temp = true;
		for (int i = 0; i< key.length; i++) {
			temp = false;
			for (int j = 0; j < S.length; j++) {
				if (S[j].equals(key[i])) {
					temp = true;
					break;
				}
			}
			if (temp == false) {
				contains = false;
				break;
			}
		}
		return contains;
	}
	
	public static Integer search(String[] S, String key) {
		Integer index = -1;
		for (int i = 0; i < S.length; i++) {
			
			
			if (S[i].equals(key)) {
				index = i;
			}	
		}
		return index;
	}
	
	public static String sort(String S) {
		String out = "";
		String[] temp = S.split("");
		Arrays.sort(temp);
		for (int i = 0; i < S.length(); i++) {
			out+= temp[i];
		}
		return out;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String[] temp = s.nextLine().split(" | ");
		ArrayList<String> unfiltered = new ArrayList<String>();
		String[] key = new String[10];
		String[] result = new String[4];
		String anstemp = "";
		int ans = 0;

		while(!temp[0].equals("-1")) {
			for(int i = 0; i < 10; i++) {
				unfiltered.add(sort(temp[i]));
			}
			for (int i = 0; i < 4; i++) {
				result[i] = sort(temp[i+11]);
			}
			Collections.sort(unfiltered);
			//System.out.println(unfiltered);
			//be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe

			//acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf


			
			//first pass
			for (int i = 0; i < 10; i++) {
				if (unfiltered.get(9-i).length()==2) {
					key[1] = unfiltered.get(9-i);
					unfiltered.remove(9-i);
				}else if (unfiltered.get(9-i).length()==4) {
					key[4] = unfiltered.get(9-i);
					unfiltered.remove(9-i);
				}else if (unfiltered.get(9-i).length()==3) {
					key[7] = unfiltered.get(9-i);
					unfiltered.remove(9-i);
				}else if (unfiltered.get(9-i).length()==7) {
					key[8] = unfiltered.get(9-i);
					unfiltered.remove(9-i);
				}	
			}
			//System.out.println(Arrays.toString(key));
			//System.out.println(unfiltered);
			
			//Second pass
			for (int i = 0; i < unfiltered.size(); i++) {
				if (unfiltered.get(i).length() == 5) {
					String[] letter = unfiltered.get(i).split("");
					Arrays.sort(letter);
					String[] tempkey = key[1].split("");
					
					if (contains(letter, tempkey)) {
						key[3] = unfiltered.get(i);
						unfiltered.remove(i);
						break;
					}
				}
			}
			
			//System.out.println(Arrays.toString(key));
			//System.out.println(unfiltered);
			
			//Third pass
			for (int i = 0; i < unfiltered.size(); i++) {
				if (unfiltered.get(i).length() == 6) {
					String[] letter = unfiltered.get(i).split("");
					Arrays.sort(letter);
					String[] tempkey = key[4].split("");
					
					if (contains(letter, tempkey)) {
						key[9] = unfiltered.get(i);
						unfiltered.remove(i);
						break;
					}
				}
			}
			//System.out.println(Arrays.toString(key));
			//System.out.println(unfiltered);
			
			//Forth pass
			for (int i = 0; i < unfiltered.size(); i++) {
				if (unfiltered.get(i).length() == 5) {
					String[] letter = unfiltered.get(i).split("");
					Arrays.sort(letter);
					String[] tempkey = key[9].split("");
					
					if (contains(tempkey, letter)) {
						key[5] = unfiltered.get(i);
						unfiltered.remove(i);
						break;
					}
				}
			}
			//System.out.println(Arrays.toString(key));
			//System.out.println(unfiltered);
			
			//Fifth pass
			for (int i = 0; i < unfiltered.size(); i++) {
				if (unfiltered.get(i).length() == 5) {
					key[2] = unfiltered.get(i);
					unfiltered.remove(i);
					
				}
			}
			//System.out.println(Arrays.toString(key));
			//System.out.println(unfiltered);
			
			//Sixth pass
			for (int i = 0; i < unfiltered.size(); i++) {
				if (unfiltered.get(i).length() == 6) {
					String[] letter = unfiltered.get(i).split("");
					Arrays.sort(letter);
					String[] tempkey = key[1].split("");
					
					if (contains(letter, tempkey)) {
						key[0] = unfiltered.get(i);
						unfiltered.remove(i);
						break;
					}
				}
			}
			//System.out.println(Arrays.toString(key));
			//System.out.println(unfiltered);
			
			key[6] = unfiltered.get(0);
			
			//System.out.println(Arrays.toString(key));
			//System.out.println(unfiltered);
			
			for (int i = 0; i < 4; i++) {
				anstemp += search(key, result[i]).toString();
			}
			ans += Integer.parseInt(anstemp);
			anstemp = "";
			temp = s.nextLine().split(" | ");
			unfiltered.clear();

		}
		System.out.println(ans);


	}

}
