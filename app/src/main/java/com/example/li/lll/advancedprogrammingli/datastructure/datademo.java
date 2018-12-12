package com.example.li.lll.advancedprogrammingli.datastructure;

import android.util.Log;

public class datademo {

    public static void main(String []args){
        int[] a6 = {49, 38, 65, 97, 176, 213, 227, 50, 78, 34, 12, 164, 11, 18, 1};
         quickSort(a6, 0,a6.length-1);
    }



    //快速排序
    public static void quickSort(int[] a,int low,int high){
        int[] a6 = {49, 38, 65, 97, 176, 213, 227, 50, 78, 34, 12, 164, 11, 18, 1};
        int start = low;
        int end = high;
        int key = a[low];

        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        StringBuilder sb = new StringBuilder("a6 =");
        for (int i = 0; i < a6.length; i++) {
            sb.append(a6[i] + ",");

        }
     //   Log.d("aaa",sb.toString() );

        System.out.println(sb.toString());
        //递归
        if(start>low) quickSort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) quickSort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
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
