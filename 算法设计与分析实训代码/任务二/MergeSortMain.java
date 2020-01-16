package com.company;
import java.util.Arrays;
public class MergeSortMain {
    static int arr[] = {100, 20, 15, 30, 5, 75, 40};
    public static void main(String args[]) {
        System.out.println("数据排序之前 ： ");
        printArray(arr, 0, arr.length - 1);             // 排序前打印数组
        System.out.println("-----------------------------");
        mergeSort(0, arr.length - 1);                                // 用递归实现排序
        System.out.println("-----------------------------");
        System.out.println("排序后打印数组:");
        printArray(arr, 0, arr.length - 1);             // 排序后打印数组
    }

    public static void mergeSort(int start, int end) {               //start数组从哪开始 ，end结束
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(start, mid);                                   // 排序左半部分
            mergeSort(mid + 1, end);                                 // 排序右半部分
            merge(start, mid, end);                                  // 合并左右两半
        }
    }

    private static void merge(int start, int mid, int end) {         //start数组从哪开始 ，end结束
        int[] tempArray = new int[arr.length];                       //初始化临时数组和索引
        int tempArrayIndex = start;

        System.out.print("合并前:  ");
        printArray(arr, start, end);

        int startIndex = start;
        int midIndex = mid + 1;

        while (startIndex <= mid && midIndex <= end) {               // 它将迭代直到较小的列表到达结尾
            if (arr[startIndex] < arr[midIndex])
                tempArray[tempArrayIndex++] = arr[startIndex++];
             else
                tempArray[tempArrayIndex++] = arr[midIndex++];
        }

        while (startIndex <= mid) {                                  // 复制剩余的元素
            tempArray[tempArrayIndex++] = arr[startIndex++];
        }
        while (midIndex <= end) {
            tempArray[tempArrayIndex++] = arr[midIndex++];
        }

        for (int i = start; i <= end; i++) {                         // 排序后将tempArray复制到实际数组
            arr[i] = tempArray[i];
        }
        System.out.print("合并后:   ");
        printArray(tempArray, start, end);
        System.out.println();
    }

    public static void printArray(int arr[], int start, int end) {   //打印数组，arr传入的数组，start 遍历开始的位置，end   遍历结束的位置
        for (int i = start; i <= end; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}