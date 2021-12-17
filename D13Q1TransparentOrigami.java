import java.util.*;

class coord{
    int x;
    int y;

    public coord(int XCoordinate, int YCoordinate) {
        x = XCoordinate;
        y = YCoordinate;
    }

    public String toString() {
        return ("(" + x + ", " + y + ")");
    }

    public boolean equals(coord compare) {
        boolean equals = false;
        if (x == compare.x && y == compare.y) {
            equals = true;
        }
        return equals;
    }

    public void fold(String dir, int crease) {
        if (dir.equals("y")) {
            if (y > crease) y = y-2*(y-crease);
        }else if (dir.equals("x")) {
            if (x > crease) x = x-2*(x-crease);
        }
    }
}

public class D13Q1TransparentOrigami {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<coord> dots = new ArrayList<>();
        String[] temp = s.nextLine().split(",");
        int[] coordtemp = new int[2];

        while (!temp[0].equals("")) {
            for (int i = 0; i < 2; i++) coordtemp[i] = Integer.parseInt(temp[i]);
            coord newCoord = new coord(coordtemp[0], coordtemp[1]);
            dots.add(newCoord);
            temp = s.nextLine().split(",");
        }
        temp = s.nextLine().split(" ");
        temp = temp[2].split("=");
        String dir = temp[0];
        int crease = Integer.parseInt(temp[1]);
        System.out.println(dir + " " + crease);
        for (coord c: dots) {
            c.fold(dir, crease);
        }
        int sum = 0;
        for (int i = 0; i < dots.size(); i++) {
            for (int j = 0; j < dots.size(); j++) {
                if (i!=j) if(dots.get(i).equals(dots.get(j))) sum++;
            }
        }
        System.out.println(dots.size()-sum/2);


    }
}
