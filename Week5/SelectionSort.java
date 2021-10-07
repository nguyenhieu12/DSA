package Week5;

public class SelectionSort {
    public static void selectionSort(int[] a) {
        for(int i = 0;i < a.length;i++) {
            int pos = i;
            for(int j = i + 1;j < a.length;j++) {
                if(a[j] < a[pos]) {
                    pos = j;
                }
            }
            int tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 9, 8};
        selectionSort(a);
        for(int i = 0;i < a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
}
