package Week11;

import java.util.*;

public class MissingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        /**
         * Counting Sort
         */
        int[] a = new int[10000];
        int n = scanner.nextInt();
        for(int i = 0;i < n;i++)
            a[scanner.nextInt()]--;
        int m = scanner.nextInt();
        for(int i = 0;i < m;i++)
            a[scanner.nextInt()]++;

        /**
         * Sort
         */
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++)
            a[i] = scanner.nextInt();
        int m = scanner.nextInt();
        int[] b = new int[m];
        for(int i = 0;i < m;i++)
            b[i] = scanner.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);
        int posA = 0, posB = 0;
        while(posB < b.length) {
            if(posB >= a.length) {
                System.out.print(b[posB] + " ");
            }
            if(b[posB] == a[posA]) {
                posA++;
                posB++;
            }
            else if(b[posB] != a[posA]) {
                System.out.print(b[posB] + " ");
                posB++;
            }
        }
        if(posB < b.length) {
            while(posB < b.length)
                System.out.print(b[posB] + " ");
        }

    }
}
