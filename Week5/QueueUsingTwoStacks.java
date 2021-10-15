package Week5;

import java.util.*;

public class QueueUsingTwoStacks {
    public static void main(String[] args) throws EmptyStackException {
        int number, query;
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        number = scanner.nextInt();
        for(int i = 0;i < number;i++) {
            query = scanner.nextInt();
            if(query == 1) {
                s1.push(scanner.nextInt());
            }
            else if(query == 2) {
                if(s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                s2.pop();
            }
            else {
                if(s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                System.out.println(s2.peek());
            }
        }
    }
}