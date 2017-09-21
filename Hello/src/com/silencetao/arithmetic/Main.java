package com.silencetao.arithmetic;

/**
 * 测试入口方法
 * @author Silence
 * create time 2017年9月13日 上午10:18:50
 * @version 1.0.1
 */
public class Main {

    public static void main(String[] args) {
        int[] arr1 = {5, 10, 4, 3, 2, 9, 8, 7, 6, 1};
        int[] arr2 = {5, 10, 4, 3, 2, 9, 8, 7, 6, 1};
        int[] arr3 = {5, 10, 4, 3, 2, 9, 3, 7, 6, 1};
        int[] arr4 = {5, 10, 4, 3, 2, 9, 8, 7, 6, 1};
        int[] arr5 = {5, 10, 4, 3, 2, 9, 8, 7, 6, 1};
        int[] arr6 = {5, 10, 4, 3, 2, 9, 8, 7, 6, 1};
        int[] arr7 = {5, 10, 4, 3, 2, 9, 8, 7, 6, 1};
        int[] arr8 = {5, 10, 4, 3, 5, 9, 3, 7, 6, 1};
        Sort.selectSort(arr1);
        Sort.insertSort(arr2);
        Sort.bubbleSort(arr3);
        Sort.mergeSort(arr4);
        Sort.mergeSortBU(arr5);
        Sort.quickSort1(arr6);
        Sort.quickSort2(arr7);
        Sort.quickSort3(arr8);
        Sort.printArray(arr1);
        Sort.printArray(arr2);
        Sort.printArray(arr3);
        Sort.printArray(arr4);
        Sort.printArray(arr5);
        Sort.printArray(arr6);
        Sort.printArray(arr7);
        Sort.printArray(arr8);
    }
}
