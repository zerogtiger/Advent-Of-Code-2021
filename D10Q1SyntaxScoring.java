import java.util.*;
import java.io.*;

public class D10Q1SyntaxScoring {
    public static int scoreOf(String s) {
        int out = 0;
        switch (s) {
            case ")":
                out = 3;
                break;
            case "]":
                out = 57;
                break;
            case "}":
                out = 1197;
                break;
            case ">":
                out = 25137;
                break;
        }
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
        int sum = 0;
        while (!temp.equals("-1")) {
            String[] brk = temp.split("");
            Stack<String> recbrk = new Stack<>();
            innerLoop:
            for (int i = 0; i < brk.length; i++) {
                if (brk[i].equals("(") || brk[i].equals("{") || brk[i].equals("[") || brk[i].equals("<")) recbrk.push(brk[i]);
                if (brk[i].equals(")") || brk[i].equals("}") || brk[i].equals("]") || brk[i].equals(">")) {
                    temp = recbrk.pop();
                    if (!isClosing(temp, brk[i])) {
                        sum += scoreOf(brk[i]);
                        break innerLoop;
                    }
                }
            }
            temp = s.nextLine();
        }
        System.out.println(sum);
    }
}
