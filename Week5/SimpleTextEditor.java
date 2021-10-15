package Week5;

import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        Stack<String> stack = new Stack<String>();
        stack.push(s);
        int n, choice;
        n = scanner.nextInt();
        for(int i = 0;i < n;i++) {
            choice = scanner.nextInt();
            if(choice == 1) {
                s += scanner.next();
                stack.push(s);
            }
            else if(choice == 2) {
                s = s.substring(0, s.length() - scanner.nextInt());
                stack.push(s);
            }
            else if(choice == 3) {
                System.out.println(s.charAt(scanner.nextInt() - 1));
            }
            else {
                stack.pop();
                s = stack.peek();
            }
        }
    }
}
