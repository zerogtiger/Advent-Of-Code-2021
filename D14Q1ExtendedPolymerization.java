import java.util.*;
import java.io.*;

public class D14Q1ExtendedPolymerization {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<String, String> rules = new HashMap<>();
        String polymer = s.nextLine();

        s.nextLine();
        String[] temp = s.nextLine().split(" -> ");
        System.out.println(polymer);


        while (!temp[0].equals("")){
            System.out.println(Arrays.toString(temp));
            rules.put(temp[0], temp[1]);
            temp = s.nextLine().split(" -> ");
        }

        for (int j = 0; j < 40; j++) {
            int size = polymer.length();
            for (int i = 0; i < size-1; i++) {
                String sub = polymer.substring(size-i-2, size-i);
                if (rules.containsKey(sub)) polymer = polymer.substring(0, size-i-1)
                        + rules.get(sub) + polymer.substring(size-i-1);
            }
        }
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < polymer.length(); i++) {
            if(!count.containsKey(polymer.charAt(i))) count.put(polymer.charAt(i),0);
            count.replace(polymer.charAt(i), count.get(polymer.charAt(i)) + 1);
        }
        int min = 0x7fffffff;
        int max = 0;
        for (Integer i: count.values()) {
            if (i>max) max = i;
            if (i<min) min = i;
        }
        System.out.println(max-min);
    }
}
