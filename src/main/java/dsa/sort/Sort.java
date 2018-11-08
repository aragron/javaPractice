package dsa.sort;

/**
 * @Author: Jakot
 * @Date: 2018/11/6 9:22
 */
public class Sort {
    int n = 0;
    int[] arr = {};

    public Sort(int[] arr){
        this.arr = arr;
        this.n = arr.length;
    }

    public int[] bubbleSort(){
        return bubbleSort(this.arr);
    }

    //冒泡排序
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        if (n <= 1){return arr;}
        for (int i = 0; i < n; ++i){
            //提前退出冒泡排序循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i -1; ++j){
                //交换
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    //表示有数据交换
                    flag = true;
                }
            }
            //没有数据交换，提前退出
            if (!flag) {break;}
        }
        return arr;
    }
    //插入排序
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        if (n <= 1){return arr;}
        for (int i = 1; i < n; ++i){
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; --j){
                if (value < arr[j]){
                    arr[j+1] = arr[j];
                }else {break;}
            }
            arr[j+1] = value;
        }
        return arr;
    }
    // 选择排序
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        if (n <= 1){return arr;}
        for (int i = 0; i < n; ++i){
            int MinArr = arr[i];
            int index = i;
            for (int j = i; j < n; ++j) {
                if (MinArr > arr[j]){
                    MinArr = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = MinArr;
        }
        return arr;
    }
}
