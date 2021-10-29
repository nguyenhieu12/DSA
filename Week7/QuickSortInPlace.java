package Week7;

import java.util.Scanner;

public class QuickSortInPlace {
    public static void print(int[] a) {
        for(int i = 0;i < a.length;i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo;
        for(int j = lo;j < hi;j++) {
            if(a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[hi];
        a[hi] = tmp;

        return i;
    }

    public static void sort(int[] a, int lo, int hi) {
        if(lo < hi) {
            int j = partition(a, lo, hi);
            print(a);
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++)
            a[i] = scanner.nextInt();
        sort(a, 0, a.length - 1);
    }

}
