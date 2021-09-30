package Week3;

public class BinarySearch {
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
}
