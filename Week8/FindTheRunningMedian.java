package Week8;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheRunningMedian {
    private static PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> maxPQ = new PriorityQueue<>();

    public static void median() {
        if(maxPQ.size() > minPQ.size())
            System.out.printf("%.1f\n", (double) maxPQ.peek());
        else if(maxPQ.size() == minPQ.size())
            System.out.printf("%.1f\n", (double) ((maxPQ.peek() + minPQ.peek())/2.0));
    }

    public static void addElement(int n) {
        if(maxPQ.isEmpty())
            maxPQ.add(n);
        else if(!maxPQ.isEmpty() && minPQ.isEmpty()) {
            if(n > maxPQ.peek()) {
                minPQ.add(maxPQ.poll());
                maxPQ.add(n);
            }
            else minPQ.add(n);
        }
        else if(maxPQ.size() == minPQ.size()) {
            if(n < minPQ.peek()) {
                maxPQ.add(minPQ.poll());
                minPQ.add(n);
            }
            else maxPQ.add(n);
        }
        else if(maxPQ.size() - minPQ.size() == 1) {
            if(n < maxPQ.peek()) {
                minPQ.add(n);
            }
            else {
                minPQ.add(maxPQ.poll());
                maxPQ.add(n);
            }
        }
        median();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0;i < n;i++)
            addElement(scanner.nextInt());
    }
}
