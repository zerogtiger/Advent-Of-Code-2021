import java.io.*;
import java.util.*;

public class D12Q1PassagePathing {
    //Thanks Max
    public static Integer DFS(HashMap<String, ArrayList<String>> adj, ArrayList<String> visited, String to) {
        int sum = 0;
        if (to.equals("end")) {
            sum = 1;
        }else {
            for (String s: adj.get(to)) {
                ArrayList<String> vis = new ArrayList<>();
                vis.addAll(visited);
                System.out.println(to + ": " + s);
                System.out.println(vis);
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
            if (!caves.containsKey(temp[0])) caves.put(temp[0], new ArrayList<String>());
            if (!caves.containsKey(temp[1])) caves.put(temp[1], new ArrayList<String>());
            caves.get(temp[0]).add(temp[1]);
            caves.get(temp[1]).add(temp[0]);
            temp = s.nextLine().split("-");
        }
        visited.add("start");
        System.out.println(caves);
        System.out.println(DFS(caves, visited, "start"));
    }
}