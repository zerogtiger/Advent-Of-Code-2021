import java.io.*;
import java.util.*;

public class D14Q2ExtendedPolymerization {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<String, Long> polymer = new HashMap<>();
        HashMap<String, ArrayList<String>> rules = new HashMap<>();
        String temp = s.nextLine();
        for (int i = 0; i < temp.length()-1; i++) {
            if (!polymer.containsKey(temp.substring(i, i+2))) {
                polymer.put(temp.substring(i, i+2), 0L);
            }
            polymer.replace(temp.substring(i, i+2), polymer.get(temp.substring(i, i+2))+1);
        }
        System.out.println(polymer);

        s.nextLine();

        String[] temp2 = s.nextLine().split(" -> ");
        while(!temp2[0].equals("1")) {
            if (!rules.containsKey(temp2[0])) rules.put(temp2[0], new ArrayList<String>());
            rules.get(temp2[0]).add(temp2[0].charAt(0) + temp2[1]);
            rules.get(temp2[0]).add(temp2[1] + temp2[0].charAt(1));
            temp2 = s.nextLine().split(" -> ");
        }
        System.out.println(rules);

        HashMap<String, Long> tempPol = new HashMap<>();
        for (int i = 0; i < 40; i++) {
            System.out.println(polymer);
            for (String key: rules.keySet()) {
                if (polymer.containsKey(key) && polymer.get(key) > 0) {
                    if (!polymer.containsKey(rules.get(key).get(0))) polymer.put(rules.get(key).get(0), 0L);
                    if (!polymer.containsKey(rules.get(key).get(1))) polymer.put(rules.get(key).get(1), 0L);
                    if (!tempPol.containsKey(rules.get(key).get(0))) tempPol.put(rules.get(key).get(0), 0L);
                    if (!tempPol.containsKey(rules.get(key).get(1))) tempPol.put(rules.get(key).get(1), 0L);

                    tempPol.replace(rules.get(key).get(0), tempPol.get(rules.get(key).get(0)) + polymer.get(key));
                    tempPol.replace(rules.get(key).get(1), tempPol.get(rules.get(key).get(1)) + polymer.get(key));
                    polymer.replace(key, 0L);
                }
            }

            for(String key: tempPol.keySet()) polymer.replace(key, polymer.get(key)+tempPol.get(key));
            System.out.println(tempPol);
            tempPol.clear();
        }

        System.out.println(polymer);

        HashMap<String, Long> out = new HashMap<>();
        for (String key: polymer.keySet()) {
            System.out.println(out);
            if (!out.containsKey(key.substring(0,1))) out.put(key.substring(0,1), 0L);
            if (!out.containsKey(key.substring(1,2))) out.put(key.substring(1,2), 0L);
            out.replace(key.substring(0,1), out.get(key.substring(0,1)) + polymer.get(key));
            out.replace(key.substring(1,2), out.get(key.substring(1,2)) + polymer.get(key));
        }
        out.replace(temp.substring(0,1), out.get(temp.substring(0,1))+1);
        out.replace(temp.substring(temp.length()-1), out.get(temp.substring(temp.length()-1))+1);

        System.out.println(out);

        long max = 0;
        long min = Long.MAX_VALUE;
        for (Long values: out.values()) {
            if (values > max) max = values;
            if (values < min) min = values;
        }
        System.out.println((max-min)/2);
    }
}