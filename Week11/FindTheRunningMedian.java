package Week11;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class FindTheRunningMedian {
    public static void median(TreeSet<Integer> tree) {
        ArrayList<Integer> arr = new ArrayList<Integer>(tree);
        int size = arr.size();
        if(size == 1)
            System.out.printf("%.1f\n", (double) arr.get(0));
        else if(size % 2 != 0)
            System.out.printf("%.1f\n", (double) arr.get(size / 2));
        else System.out.printf("%.1f\n",(double) (arr.get(size / 2) + arr.get(size / 2 - 1)) / 2);
    }

    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0;i < n;i++) {
            tree.add(scanner.nextInt());
            median(tree);
        }

    }
}
