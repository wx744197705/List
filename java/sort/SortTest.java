package sort;

import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[200000];
        int[] brr = new int[200000];
        Random random = new Random();
        for (int i = 0; i < 200000; i++) {
            arr[i] = random.nextInt(1000);
            brr[i] = random.nextInt(1000);
        }
        shellSort(arr);
        bubbleSort(brr);
    }

    private static void shellSort(int[] a) {
        // long start = System.currentTimeMillis();
        // int len = arr.length / 2;
        // while (len >= 1) {
        //     for (int i = len; i < arr.length; i++) {//代表一个子序列
        //         for (int j = i % len;/*找到对应子序列的首个元素*/ j < arr.length - len; j += len) {//和已经排序好的子序列比较
        //             if (arr[j] > arr[i]) {
        //                 arr[i] = arr[i] ^ arr[j];
        //                 arr[j] = arr[j] ^ arr[i];
        //                 arr[i] = arr[i] ^ arr[j];
        //             }
        //         }
        //     }
        //     len = len / 2;
        // }
        // System.out.println(System.currentTimeMillis() - start);
        long start = System.currentTimeMillis();
        int n = a.length;
        int i, len = n / 2;
        while (len >= 1) {
            for (i = len; i < n; i++) {//从当前增量位置开始往后循环，往前每隔len个就是同一个子序列的元素
                if (a[i] < a[i - len]) {//前面已经有序，若最后一个比a[i]还小，说明a[i]已经在合适的位置了，大大减小循环量
                    //在排序好的子序列里找位置
                    int temp = a[i];//a[i]在while第一次循环值就会改变，所以要用临时变量记录下来，因为之后在子序列里给他找位置肯定是和他比较
                    int k = i - len;
                    while (k >= 0 && a[k] > temp) {
                        //已经排序好的子序列肯定是有序的，这里只是给a[i]找到合适的位置，每次比a[i]大的元素向后移动一个位置，然后把这个位置留给a[i]
                        a[k + len] = a[k];//这里就是向后移动一个位置
                        k -= len;//然后下标向前移动，判断是否还是比a[i]大，是的话就继续后移
                    }
                    a[k + len] = temp;//最后把a[i]放到合适的位置
                }
            }
            len /= 2;
        }
        long end = System.currentTimeMillis();
        System.out.println("希尔插入排序完成的时间：" + (end - start) + "毫秒");
    }

    private static void bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序完成的时间：" + (System.currentTimeMillis() - start) + "毫秒");
    }
}
