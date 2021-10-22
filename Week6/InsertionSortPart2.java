package Week6;

import java.util.*;

public class InsertionSortPart2 {
    public static void insertionSort(int[] a) {
        for(int i = 1;i < a.length;i++) {
            for(int j = i;j > 0;j--) {
                if(a[j] < a[j-1])
                    exch(a, j, j - 1);
                else break;
            }
            print(a);
        }
    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(int[] a) {
        for(int i = 0;i < a.length;i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++)
            a[i] = scan.nextInt();
        insertionSort(a);
    }
}