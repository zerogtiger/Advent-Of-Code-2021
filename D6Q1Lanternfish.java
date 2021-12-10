import java.util.*;

public class D6Q1Lanternfish {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		ArrayList<Integer> fish = new ArrayList<Integer>();
		
		String S = s.nextLine();
		String[] temp = S.split(",");
		for (int i = 0; i < temp.length; i++) {
			fish.add(Integer.parseInt(temp[i]));
		}
		
		for (int j = 0; j < 256; j++) {
			int size = fish.size();
			for (int i = 0; i < size; i++) {
				if (fish.get(i)== 0) {
					fish.set(i, 6);
					fish.add(8);
				}else if(fish.get(i)>0) {
					fish.set(i, fish.get(i)-1);
				}
				
			}
		}
		System.out.println(fish.size());

	}

}
