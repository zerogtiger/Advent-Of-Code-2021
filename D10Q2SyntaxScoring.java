import java.util.*;
import java.io.*;

public class D10Q2SyntaxScoring {
    public static int scoreOf(String s) {
        int out = switch (s) {
            case "(" -> 1;
            case "[" -> 2;
            case "{" -> 3;
            case "<" -> 4;
            default -> 0;
        };
        return out;
    }

    public static boolean isClosing(String open, String close) {
        boolean isClosing = false;
        switch (open) {
            case "(":
                if (close.equals(")")) isClosing = true;
                break;
            case "[":
                if (close.equals("]")) isClosing = true;
                break;
            case "{":
                if (close.equals("}")) isClosing = true;
                break;
            case "<":
                if (close.equals(">")) isClosing = true;
                break;
        }
        return isClosing;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String temp = s.nextLine();
        ArrayList<Long> scores = new ArrayList<>();
        long score = 0;
        while (!temp.equals("-1")) {
            String[] brk = temp.split("");
            Stack<String> recbrk = new Stack<>();
            boolean isCurrupt = false;
            innerLoop:
            for (int i = 0; i < brk.length; i++) {
                if (brk[i].equals("(") || brk[i].equals("{") || brk[i].equals("[") || brk[i].equals("<")) recbrk.push(brk[i]);
                if (brk[i].equals(")") || brk[i].equals("}") || brk[i].equals("]") || brk[i].equals(">")) {
                    temp = recbrk.pop();
                    if (!isClosing(temp, brk[i])) {
                        isCurrupt = true;
                        break innerLoop;
                    }
                }
            }
            if (!isCurrupt) {
                while (!recbrk.isEmpty()) {
                    score = (score * 5 + scoreOf(recbrk.pop()));
                }
                scores.add(score);
            }
            score = 0;
            temp = s.nextLine();
        }
        Collections.sort(scores);
        System.out.println(scores.get(scores.size()/2));
        System.out.println(scores);
    }
}
