package Week9;

import java.util.Scanner;

public class ClosestNumbers {
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
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++)
            a[i] = scan.nextInt();
        sort(a, 0, a.length - 1);
        int min = a[1] - a[0];
        for(int i = 2;i < n;i++)
            if(a[i]-a[i-1] < min)
                min = a[i] - a[i-1];
        for(int i = 1;i < n;i++)
            if(a[i]-a[i-1]  == min)
                System.out.print(a[i-1] + " " + a[i] + " ");
    }
}
