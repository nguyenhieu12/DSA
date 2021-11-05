package Week8;

import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {
    public static int cookies(PriorityQueue<Integer> p, int k) {
        if(p.size() == 0 || (p.size() == 1 && p.peek() < k))
            return -1;
        int count = 0;
        while(true) {
            if (p.peek() >= k)
                return count;
            if ((p.size() == 1 && p.peek() < k))
                return -1;
            int sw1 = p.poll();
            int sw2 = p.poll();
            p.add(sw1 + 2 * sw2);
            count++;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
        Scanner scanner = new Scanner(System.in);
        int n, k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        for(int i = 0;i < n;i++)
            pqueue.add(scanner.nextInt());
        System.out.println(cookies(pqueue, k));
    }
}
