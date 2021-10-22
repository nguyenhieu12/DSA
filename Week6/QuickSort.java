package Week6;

import edu.princeton.cs.algs4.*;

import java.util.Random;

public class QuickSort {
    public static void sort(int a[], int l, int r){
        int p = a[(l+r)/2];
        int i = l, j = r;
        while (i < j){
            while (a[i] < p){
                i++;
            }
            while (a[j] > p){
                j--;
            }
            if (i <= j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (i < r){
            sort(a, i, r);
        }
        if (l < j){
            sort(a, l, j);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[20000];
        for(int i = 0;i < 20000;i++)
            a[i] = 8000 - i;
        StdRandom.shuffle(a);
        long start = System.currentTimeMillis();
        sort(a, 0, a.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
