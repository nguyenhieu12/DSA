package Week6;

import edu.princeton.cs.algs4.*;
import java.util.Random;

public class MergeSort {
    public static void sort(int[] a, int lo, int hi) {
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        if(a[mid] < a[mid + 1]) return;
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i, j, k;
        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        int[] aux1 = new int[n1];
        int[] aux2 = new int[n2];
        for(i = 0;i < n1;i++)
            aux1[i] = a[lo + i];
        for(j = 0;j < n2;j++)
            aux2[j] = a[mid + j + 1];
        i = 0;
        j = 0;
        k = lo;
        while(i < n1 && j < n2) {
            if(aux1[i] <= aux2[j]) {
                a[k] = aux1[i];
                i++;
                k++;
            }
            else {
                a[k] = aux2[j];
                j++;
                k++;
            }
        }
        while(i < n1) {
            a[k] = aux1[i];
            i++;
            k++;
        }
        while(j < n2) {
            a[k] = aux2[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        for (int i=0; i<1000; i++) {
            Random rand = new Random();
            int ranNum = rand.nextInt(1000) + 1;
            a[i] = ranNum;
        }
        long start = System.currentTimeMillis();
        sort(a, 0, a.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
