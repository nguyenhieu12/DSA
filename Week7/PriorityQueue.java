package Week7;

public class PriorityQueue {
    private static int[] a = new int[100];
    private static int[] b;
    private static int pos = 0;

    public static void insert(int value) {
        a[pos] = value;
        pos++;
    }

    public static int deleteMin() {
        int cur = 0, min = a[0], posB = 0;
        for(int i = 1;i < pos;i++) {
            if(a[i] < min) {
                min = a[i];
                cur = i;
            }
        }
        b = new int[pos-1];
        for(int i = 0;i < pos;i++) {
            if(i == cur)
                continue;
            else {
                b[posB] = a[i];
                posB++;
            }
        }
	pos--;
        a = b;
        return min;
    }
    
}
