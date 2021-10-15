package Week5;

import java.util.Scanner;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> newStack = new Stack<Character>();
        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                newStack.push(c);
            }
            else if(newStack.isEmpty())
                return "NO";
            else if(c == '}') {
                if (newStack.peek() == '{')
                    newStack.pop();
            }
            else if(c == ']') {
                if (newStack.peek() == '[')
                    newStack.pop();
            }
            else if(c == ')') {
                if (newStack.peek() == '(')
                    newStack.pop();
            }
        }
        if(!newStack.isEmpty())
            return "NO";
        else return "YES";
    }

}
