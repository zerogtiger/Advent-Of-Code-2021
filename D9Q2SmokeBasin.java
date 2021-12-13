import java.util.*;
import java.io.*;
class pair {
    int p;
    int q;
    public pair(int x, int y) {
        p = x;
        q = y;
    }
    public String toString() {
        return("(" + p + ", " + q + ")");
    }
}

public class D9Q2SmokeBasin {

    public static Integer flood(ArrayList<int[]> graph, int x, int y) {
        int size = 0;
        if (graph.get(x)[y] == 9) {
            return 0;
        }else {
            graph.get(x)[y] = 9;
            if ((graph.get(x-1)[y] != 9)) {
                size += 1 + flood(graph, x-1, y);
            }
            if ((graph.get(x)[y-1] != 9)) {
                size += 1 + flood(graph, x, y-1);
            }
            if ((graph.get(x+1)[y] != 9)) {
                size += 1 + flood(graph, x+1, y);
            }
            if ((graph.get(x)[y+1] != 9)) {
                size += 1 + flood(graph, x, y+1);
            }
        }
        return size;
    }

    public static int[] toIntArr(String[] S) {
        int[] out = new int[S.length];
        for (int i = 0; i < S.length; i++) {
            out[i] = Integer.parseInt(S[i]);
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Finding low points
        ArrayList<int[]> graph = new ArrayList<>();

        String[] temp = ("9" + s.nextLine() + "9").split("");
        int[] top = new int[temp.length];
        for (int i = 0; i < temp.length; i++) top[i] = 9;
        graph.add(top);
        int[] mid = toIntArr(temp);
        graph.add(mid);
        temp = ("9" + s.nextLine() + "9").split("");
        int[] bot;
        ArrayList<pair> LP = new ArrayList<>();

        Integer v = 0;

        do {
            v ++;
            bot = toIntArr(temp);
            graph.add(bot);
            for (int i = 1; i < top.length-1; i++) {
                boolean low = false;
                if (mid[i] < top[i] && mid[i] < mid[i-1] && mid[i] < mid[i+1] && mid[i] < bot[i]) {
                    LP.add(new pair(v, i));
                }
            }
            top = mid;
            mid = bot;
            temp = ("9" + s.nextLine() + "9").split("");

        }while(temp.length == mid.length);

        for (int[] br: graph) {
            System.out.println(Arrays.toString(br));
        }
        ArrayList<Integer> basinSize = new ArrayList<>();
        for (pair p: LP) System.out.println(p.toString());
        for (pair p: LP) basinSize.add(flood(graph, p.p, p.q)+1);
        Collections.sort(basinSize);
        System.out.println(basinSize);

        System.out.println(basinSize.get(basinSize.size()-1)*basinSize.get(basinSize.size()-2)*
                basinSize.get(basinSize.size()-3));

    }
}
