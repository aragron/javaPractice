package dsa.sort;

import java.util.Arrays;

/**
 * @Author: Jakot
 * @Date: 2018/11/6 9:17
 */
public class testSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,1,3,2,6,4,5};

        //int[] arrSort = Sort.bubbleSort(arr);
        //int[] arrSort = Sort.insertionSort(arr);
        int[] arrSort = Sort.selectionSort(arr);
//        Sort bs = new Sort(arr);
//        int[] arrSort = bs.bubbleSort();

        System.out.println(Arrays.toString(arrSort));
    }
}
