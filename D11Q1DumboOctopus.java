import java.io.*;
import java.util.*;

class pair{
    ArrayList<int[]> g = new ArrayList<>();
    int p;

    public pair(ArrayList<int[]> x, int y) {
        g = x;
        p = y;
    }

    public String toString() {
        String s = "";
        for(int[] i: g) {
            s += Arrays.toString(i)+ "\n";
        }
        return s;
    }
}

public class D11Q1DumboOctopus {

    public static pair countFlash(ArrayList<int[]> g) {
        int f = 0;
        boolean newFlash = true;
        for (int i = 1; i < g.size()-1; i++) {
            for (int j = 1; j < g.get(i).length-1; j++) {
                g.get(i)[j]++;
            }
        }
        while(newFlash) {
            newFlash = false;
            for (int i = 1; i < g.size()-1; i++) {
                for (int j = 1; j < g.get(i).length-1; j++) {
                    if (g.get(i)[j] > 9) {
                        newFlash = true;
                        f++;
                        g.get(i)[j] = 0;
                        if (g.get(i-1)[j-1] >0) g.get(i-1)[j-1]++;
                        if (g.get(i-1)[j] >0) g.get(i-1)[j]++;
                        if (g.get(i-1)[j+1] >0) g.get(i-1)[j+1]++;

                        if (g.get(i)[j-1] >0) g.get(i)[j-1]++;
                        if (g.get(i)[j] >0) g.get(i)[j]++;
                        if (g.get(i)[j+1] >0) g.get(i)[j+1]++;

                        if (g.get(i+1)[j-1] >0) g.get(i+1)[j-1]++;
                        if (g.get(i+1)[j] >0) g.get(i+1)[j]++;
                        if (g.get(i+1)[j+1] >0) g.get(i+1)[j+1]++;
                        }
                    }
                }
            }
        return new pair(g, f);
        }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] temp = s.nextLine().split("");
        ArrayList<int[]> graph = new ArrayList<>();
        pair out;
        
        int[] neg1 = new int[temp.length+2];
        for (int i = 0; i < temp.length+2; i++) neg1[i] = -1;
        int flash = 0;
        graph.add(neg1);

        while(!temp[0].equals("-")) {
            int[] octopi = new int[temp.length+2];
            octopi[0] = -1;
            octopi[temp.length+1] = -1;
            for (int i = 1; i < temp.length+1; i++) {
                octopi[i] = Integer.parseInt(temp[i-1]);
            }
            graph.add(octopi);
            temp = s.nextLine().split("");
        }
        graph.add(neg1);

        for (int i = 0; i < 100; i++) {
            out = countFlash(graph);
            graph = out.g;
            flash += out.p;
            //Please delete the comment if you would like to see the steps
            /*for (int i = 1; i < graph.size()-1; i++) {
                for (int j = 1; j < graph.get(1).length-1; j++) {
                    System.out.print(graph.get(i)[j] + " ");
                }
                System.out.println("");
            }*/
        }

        System.out.println(flash);

    }
}