package Week7;

import java.util.Scanner;

public class IntroToTutorial {
    public static int binarySearch(int[] a, int number) {
        int l = 0, r = a.length - 1, mid;
        while (r >= l) {
            mid = l + (r - l)/2;
            if(a[mid]==number) {
                return mid;
            }else if(a[mid] > number) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++)
            a[i] = scanner.nextInt();
        System.out.println(binarySearch(a, number));
    }
}
