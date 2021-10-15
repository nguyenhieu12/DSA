package Week5;

import java.util.Scanner;

public class SimpleTextEditor {
    private static final Scanner scanner = new Scanner(System.in);
    private static String s = "";
    private static Stack<String> stack = new Stack<String>();

    public static void append() {
        s += scanner.next();
        stack.push(s);
    }

    public static void delete() {
        if(scanner.nextInt() > s.length())
            s = "";
        else if(scanner.nextInt() < 0)
            return;
        else s = s.substring(0, s.length() - scanner.nextInt());
        stack.push(s);
    }

    public static void print() {
        if(scanner.nextInt() > s.length())
            System.out.println("");
        else System.out.println(s.charAt(scanner.nextInt() - 1));
    }

    public static void undo() {
        stack.pop();
        s = stack.peek();
    }

    public static void main(String[] args) {
        stack.push(s);
        int n, choice;
        n = scanner.nextInt();
        for(int i = 0;i < n;i++) {
            choice = scanner.nextInt();
            if(choice == 1) {
                append();
            }
            else if(choice == 2) {
                delete();
            }
            else if(choice == 3) {
                print();
            }
            else {
                undo();
            }
        }
    }
}

