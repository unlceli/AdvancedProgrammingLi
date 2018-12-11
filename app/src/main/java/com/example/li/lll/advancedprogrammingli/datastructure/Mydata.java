package com.example.li.lll.advancedprogrammingli.datastructure;

import java.util.Arrays;

//https://blog.csdn.net/weixin_38552969/article/details/80469951
public class Mydata {
    /**
     * 两个整形数据交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int []arr,int i, int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] =arr[j];
    }

    /**
     * 直接插入排序
     * @param arr
     * @return
     */
    public static int [] insertSort(int [] arr ){
        if (arr.length ==0){
            return  arr;
        }
        int i , j , temp;

        for ( i =1; i<arr.length;i ++){
            temp =arr[i];
            for (j = i-1; j>=0 && arr[j]> temp; j--){
                arr[j+1] = arr[j];
            }

            arr[j+1] =temp;
        }
        return arr;
    }

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int [] arr){
        if (arr.length == 0){
            return arr;
        }
        int i, j;
        boolean flag =true;

        for ( i =1 ; i<arr.length && flag; i++){
            flag =false;
            for (j =0; j < arr.length -i; j++){
                swap(arr,j,j++);
                flag =true;
            }
        }

        return arr;
    }



    public static void main(String [] args){
        int[] arr = {7,2,4,5,3,6,2,8};
        int[] brr = insertSort(arr);
        brr =bubbleSort(arr);
        System.out.println(Arrays.toString(brr));

    }
    //一趟快速排序
    private static int partition(int[] arr, int i, int j) {
        int pivot = arr[i];       //暂存基准数据
        while (i != j) {
            while (i < j && arr[j] >= pivot) {
                j--;         //从后遍历查找小于基准的数据
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            while (i < j && arr[i] <= pivot) {
                i++;         //从前遍历查找大于基准的数据
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = pivot;
        return i;
    }

}
