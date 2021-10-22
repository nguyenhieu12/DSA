package Week6;

import edu.princeton.cs.algs4.*;

import java.util.Random;

public class InsertionSort {
    public static void insertionSort(int[] a) {
        for(int i = 1;i < a.length;i++) {
            for(int j = i;j > 0;j--) {
                if(a[j] < a[j-1]) {
                    exch(a, j, j - 1);
                }
                else {
                    break;
                }
            }
        }
    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        In in = new In("D\\:algs4-data\\8Kints");
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis();
        insertionSort(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}