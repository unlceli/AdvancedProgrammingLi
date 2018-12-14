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


    /**合并排序
     * 一直在分割
     * 然后 两部分 一直分割  然后一直递归*/
    public static int[] mesh(int[] array){
        int length = array.length - 1 ;
        int[] mysort = mysort(array, 0, length);
        return mysort;

    }

    private static int[] mysort(int[] array, int low, int length) {
        int mid = (length + low)/2;
        if (low < length){
            mysort(array,low,mid);
            mysort(array,mid + 1,length);
            merge(array,low,mid,length);
        }
        return array;

    }

    private static void merge(int[] array, int low, int mid, int length) {
        int[] temp = new int[length - low + 1];

        int i = low;
        int j = mid + 1;
        int n = 0;
        while (i <= mid && j <= length){
            if (array[i] > array[j]){
                temp[n++] = array[j++];
            }else {
                temp[n++] = array[i++];
            }
        }

        while (i <= mid){
            temp[n++] = array[i++];
        }


        while (j <= length){
            temp[n++] = array[j++];
        }


        //合并的逻辑  赋值给array

        for (int k = 0; k < temp.length; k++) {
            array[low + k] = temp[k];
        }


    }
    /**
     * 堆算法  大顶堆 小顶堆
     * 每次取堆定 然后放入数组 重构堆   再取再重构
     * */
    public static int[] heap(int[] array){
        int length = array.length - 1;
        for (int i = 0; i < length; i++) {
            buildHeap(array,length - i);
            swapHeap(array,0,length - i);
        }


        return array;
    }

    private static void swapHeap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;

    }

    private static void buildHeap(int[] array, int lastIndex) {
        //获取左孩子和右孩子
        int pos = (lastIndex - 1)/2;
        for (int i = pos; i >= 0; i--) {
            int childL = i * 2 + 1;
            int childR = i * 2 + 2;
            int maxIndex = childL;
            if (childR <= lastIndex){
                //有右孩子
                if (array[childL] < array[childR]){
                    maxIndex ++;
                }
            }else if (childL <= lastIndex){
                //有左孩子
            }

            if (array[i] < array[maxIndex]){
                swrap(array,i,maxIndex);
            }
        }


    }
    private static void swrap(int[] array, int low, int length) {
        int temp = array[length];
        array[length] = array[low];
        array[low] = temp;
        //return array;
    }


}
