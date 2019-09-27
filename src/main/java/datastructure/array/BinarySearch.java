package datastructure.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc 二分查找
 * @Author gongzhao
 * @Date 2019/9/2716:13
 */
@Slf4j
public class BinarySearch {


    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 2;
        log.info("数字:{}   在数组中的位置是:{},递归查找 ", k, recursionBinarySearch(arr, k, 0, arr.length - 1));
        log.info("数字:{}   在数组中的位置是:{},非递归查找 ", k, binarySearch(arr, k));
    }

    /**
     * 递归调用
     *
     * @param arr
     * @param k
     * @param low
     * @param high
     * @return
     */
    public static int recursionBinarySearch(int[] arr, int k, int low, int high) {
        if (arr[low] > k || arr[high] < k || low > high) {
            return -1;
        }
        int middle = (low + high) / 2;

        if (arr[middle] > k) {
            return recursionBinarySearch(arr, k, low, middle);
        } else if (arr[middle] < k) {
            return recursionBinarySearch(arr, k, middle + 1, high);
        } else {
            return middle;
        }
    }


    /**
     * 非递归
     *
     * @param arr
     * @param k
     * @return
     */
    public static int binarySearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        if (arr[low] > k || arr[high] < k) {
            return -1;
        }
        //退出条件是遍历完成,找到的话返回index，没找到返回-1
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] > k) {
                high = middle - 1;
            } else if (k > arr[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
