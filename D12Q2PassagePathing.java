import java.io.*;
import java.util.*;

public class D12Q2PassagePathing {
    //Thanks Max
    public static Integer DFSR(HashMap<String, ArrayList<String>> adj, ArrayList<String> visited,
                              String to, String repeat) {
        int sum = 0;

        int count = 0;
        for (String temp : visited) if (temp.equals(repeat)) count++;
        if (to.equals("end")) {
            sum = 0;
            if (count == 2) {
                sum = 1;
            }
        } else {
            for (String s : adj.get(to)) {
                ArrayList<String> vis = new ArrayList<>(visited);
                //System.out.println(vis);
                if ((Character.isUpperCase(s.charAt(0)) || (!visited.contains(s) && Character.isLowerCase(s.charAt(0))) ||
                        (s.equals(repeat) && count < 2))) {
                    vis.add(s);
                    sum += DFSR(adj, vis, s, repeat);
                }
            }
        }
        return sum;
    }

    public static Integer DFS(HashMap<String, ArrayList<String>> adj, ArrayList<String> visited, String to) {
        int sum = 0;
        if (to.equals("end")) {
            sum = 1;
        }else {
            for (String s: adj.get(to)) {
                ArrayList<String> vis = new ArrayList<>(visited);
                if (Character.isUpperCase(s.charAt(0)) || (!visited.contains(s) && Character.isLowerCase(s.charAt(0)))) {
                    if (Character.isLowerCase(s.charAt(0))) vis.add(s);
                    sum += DFS(adj, vis, s);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<String, ArrayList<String>> caves= new HashMap<>();
        ArrayList<String> visited = new ArrayList<>();
        String[] temp = s.nextLine().split("-");
        while(!temp[0].equals("1")) {
            if (!caves.containsKey(temp[0])) caves.put(temp[0], new ArrayList<>());
            if (!caves.containsKey(temp[1])) caves.put(temp[1], new ArrayList<>());
            caves.get(temp[0]).add(temp[1]);
            caves.get(temp[1]).add(temp[0]);
            temp = s.nextLine().split("-");
        }
        visited.add("start");
        System.out.println(caves);
        int sum = 0;
        sum += DFS(caves, visited, "start");
        for (String key: caves.keySet()) {
            if (!key.equals("start") && Character.isLowerCase(key.charAt(0)) && !key.equals("end") ) {
                System.out.println(key);
                sum += DFSR(caves, visited, "start", key);
            }
        }
        System.out.println(sum);
    }
}