package Week7;

import java.util.Scanner;

public class FindTheMedian {
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
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++)
            a[i] = scanner.nextInt();
        sort(a, 0, a.length - 1);
        System.out.println(a[(n-1)/2]);
    }
}
