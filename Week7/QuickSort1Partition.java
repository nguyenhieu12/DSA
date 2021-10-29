package Week7;

import java.util.Scanner;

public class QuickSort1Partition {
    public static void sort(int[] a) {
        int temp;
        int pivot = a[0];
        int pos = a.length-1;
        for(int i = a.length-1;i >= 1;i--){
            if(a[i] >= pivot){
                temp = a[i];
                a[i] = a[pos];
                a[pos] = temp;
                pos--;
            }
        }
        temp = a[pos];
        a[pos] = a[0];
        a[0] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++)
            a[i] = scanner.nextInt();
        sort(a);
        for(int i = 0;i < n;i++)
            System.out.print(a[i] + " ");
    }
}
