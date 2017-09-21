package com.silencetao.arithmetic;

/**
 * 排序算法
 * @author Silence
 * create time 2017年9月13日 上午9:58:40
 * @version 1.0.1
 */
public class Sort {

    /**
     * 选择排序
     * @version 1.0.1 
     * @param arr
     */
    public static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            
            exchangeArray(arr, minIndex, i);
        }
    }
    
    /**
     * 插入排序
     * @version 1.0.1 
     * @param arr
     */
    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                arr[j] = arr[j - 1];
            }
            
            arr[j] = e;
        }
    }
    
    /**
     * 冒泡排序
     * @version 1.0.1 
     * @param arr
     */
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    exchangeArray(arr, j - 1, j);
                    flag = false;
                }
            }
            
            if (flag) {
                break ;
            }
        }
    }
    
    /**
     * 交换数组中两个元素的位置
     * @version 1.0.1 
     * @param arr
     * @param posx
     * @param posy
     */
    private static void exchangeArray(int arr[], int posx, int posy) {
        int temp = arr[posx];
        arr[posx] = arr[posy];
        arr[posy] = temp;
    }
    
    /**
     * 打印数组
     * @version 1.0.1 
     * @param arr
     */
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
    }
    
    /**
     * 归并排序（自顶向下）
     * @version 1.0.1 
     * @param arr
     */
    public static void mergeSort(int arr[]) {
        divide(arr, 0, arr.length - 1);
    }
    
    /**
     * 对数组进行分组
     * @version 1.0.1 
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void divide(int arr[], int l, int r) {
        if (l >= r) {
            return ;
        }
        
        int mid = (r + l) / 2;
        divide(arr, l, mid);
        divide(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }
    
    /**
     * 对分组排序并合并分组
     * @version 1.0.1 
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int arr[], int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        
        int i = l;
        int j = mid + 1;
        for (int k = i; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j -l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
    
    /**
     * 归并排序（自底向上）
     * @version 1.0.1 
     * @param arr
     */
    public static void mergeSortBU(int arr[]) {
        int n = arr.length;
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz * 2) {
                if (arr[i + sz - 1] > arr[i + sz]) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz * 2 - 1, n - 1));
                }
            }
        }
    }
    
    /**
     * 将元素移动到应该放的位置
     * @version 1.0.1 
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition1(int arr[], int l, int r) {
        int v = arr[l];
        
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                exchangeArray(arr, ++j, i);
            }
        }
        
        exchangeArray(arr, l, j);
        
        return j;
    }
    
    /**
     * 分组
     * @version 1.0.1 
     * @param arr
     * @param l
     * @param r
     */
    private static void quickDivide1(int arr[], int l, int r) {
        if (l >= r) {
            return ;
        }
        
        int p = partition1(arr, l, r);
        quickDivide1(arr, l, p - 1);
        quickDivide1(arr, p + 1, r);
    }
    
    /**
     * 快速排序1
     * @version 1.0.1 
     * @param arr
     */
    public static void quickSort1(int arr[]) {
        quickDivide1(arr, 0, arr.length - 1);
    }
    
    /**
     * 将元素移动到应该放的位置
     * @version 1.0.1 
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition2(int arr[], int l, int r) {
        int v = arr[l];
        
        int i = l, j = r;
        while (true) {
            while (i <= r && arr[++i] < v) ;
            while (j > l && arr[j] > v) j--;
            
            if (i >= j) {
                break ;
            }
            
            exchangeArray(arr, i, j);
        }
        
        exchangeArray(arr, l, j);
        
        
        return j;
    }

    /**
     * 分组
     * @version 1.0.1 
     * @param arr
     * @param l
     * @param r
     */
    private static void quickDivide2(int arr[], int l, int r) {
        if (l >= r) {
            return ;
        }
        
        int p = partition2(arr, l, r);
        quickDivide2(arr, l, p - 1);
        quickDivide2(arr, p + 1, r);
    }
    
    /**
     * 快速排序2
     * @version 1.0.1 
     * @param arr
     */
    public static void quickSort2(int arr[]) {
        quickDivide2(arr, 0, arr.length - 1);
    }
    
    /**
     * 将元素移动到应该放的位置并分组
     * @version 1.0.1 
     * @param arr
     * @param l
     * @param r
     */
    private static void partition3(int arr[], int l, int r) {
        if (l >= r) {
            return ;
        }
        
        int v = arr[l];
        
        int i = l + 1, j = r, k = l;
        while (true) {
            while (i <= r && arr[i] <= v) {
                if (arr[i] < v && i != ++k) {
                    exchangeArray(arr, i, k);
                }
                i++;
            }
            
            while (j > l && arr[j] > v) j--;
            
            if (i > j) {
                break ;
            }
            
            exchangeArray(arr, i, j);
        }
        
        exchangeArray(arr, l, k);
        
        partition3(arr, l, k - 1);
        partition3(arr, j + 1, r);
    }
    
    /**
     * 快速排序3
     * @version 1.0.1 
     * @param arr
     */
    public static void quickSort3(int arr[]) {
        partition3(arr, 0, arr.length - 1);
    }
}
