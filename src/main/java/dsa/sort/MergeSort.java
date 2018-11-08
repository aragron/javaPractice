package dsa.sort;

import java.util.Arrays;

/**
 * @Author: Jakot
 * @Date: 2018/11/6 15:31
 */
public class MergeSort {
//    private int n ;
//    private int [] arr;
//
//    public MergeSort(){
//        this.arr = arr;
//        this.n = arr.length;
//    }

    public static void main(String[] args){
        int[] arr = {9,8,7,5,6,4,11,34,99,22,10,101,3,2,1,98};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSortC(int[] arr, int start, int stop){
        if (start >= stop){
            return;
        }
        int mid = (start + stop)/2;
        mergeSortC(arr, start, mid);
        mergeSortC(arr, mid + 1, stop);
        merge(arr,start,mid,stop);
    }

    public static void  merge(int[] arr,int p, int q, int r){
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r){
            if (arr[i] <= arr[j]){
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }
        //判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if(j<=r){
            start = j;
            end = r;
        }
        //将剩余的数据拷贝到临时数组tmp
        while (start<=end){
            tmp[k++] = arr[start++];
        }
        for(i = 0; i<=r-p; ++i){
            arr[p+i] = tmp[i];
        }
    }

    public static void mergeSort(int[] arr){
        int n = arr.length;
        mergeSortC(arr, 0, n-1);
    }
}
