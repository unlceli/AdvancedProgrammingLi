package com.example.li.lll.advancedprogrammingli.datastructure;

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



}
