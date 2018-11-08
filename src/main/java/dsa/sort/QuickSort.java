package dsa.sort;
import java.util.Arrays;

/**
 * @Author: Jakot
 * @Date: 2018/11/6 20:26
 */
public class QuickSort {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {9,8,7,5,6,4,11,34,99,22,10,101,3,1,98};
        //int[] arr = {72,6,57,88,60,42,83,73,48,85};
        //int[] arr = {3,5,4,1,2,7,0,9,8};

        quickSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // 快速排序，a是数组，n表示数组的大小
    private static void quickSort(int[] a, int n) throws InterruptedException {
        quickSortInternally(a, 0, n-1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) throws InterruptedException {
        if (p >= r) {return;}
        // 获取分区点
        int q = partition(a, p, r);
        //int q = adjustArray(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                ++i;
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }
}
