package datastructure;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Desc
 * @Author gongzhao
 * @Date 2019/9/1715:22
 */
@Data
@Slf4j
public final class Sort {


    public static void main(String[] arg) {
        int[] arr = {5, 2, 8, 3, 6, 10, 7, 9};
        quickSort(arr, 0, arr.length - 1);
        log.info("quickSort:{}", arr);
        bubbleSort();
        //selectSort();

    }

    private static void bubbleSort() {
        int[] arr = {5, 2, 8, 3, 6, 10, 7, 9};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - (i + 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        log.info("bubbleSort:{}", arr);
    }

    private static void selectSort() {
        int[] arr = {5, 2, 8, 3, 6, 10, 7, 9};
        int position;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            position = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[position]) {
                    position = j;
                }
            }
            temp = arr[position];
            arr[position] = arr[arr.length - (i + 1)];
            arr[arr.length - (i + 1)] = temp;
        }
        log.info("selectSort:{}", arr);
    }


    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        //基准值
        int position = start;
        //初始化两个指针
        int l = start;
        int r = end;

        while (l != r) {
            while (arr[r] >= arr[position] && l < r) {
                r--;
            }
            while (arr[l] <= arr[position] && l < r) {
                l++;
            }
            if (l < r) {
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        //退出循环说明碰头了
        int temp = arr[position];
        arr[position] = arr[r];
        arr[r] = temp;

        quickSort(arr, start, l - 1);
        quickSort(arr, l + 1, end);
    }


}
