package binarysearch;

/**
 * @author gongzhao
 * @description
 * @Date 15:592018/9/10
 */
public class BinarySearch {

    static int index(int[] a, int x, int begin, int end) {

        if (begin > end) {
            return -1;
        } else if (begin == end) {
            if (x == a[end]) {
                return end;
            } else {
                return -1;
            }
        }
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    static int index1(int[] array, int x, int begin, int end) {
        if (begin > end) {
            return -1;
        } else if (begin == end) {
            if (x == array[end]) {
                return end;
            } else {
                return -1;
            }
        }
        int mid = (begin + end) / 2;
        if (array[mid] == x) {
            return mid;
        } else if (array[mid] < x) {
            return index1(array, x, mid + 1, end);
        } else {
            return index1(array, x, begin, mid - 1);
        }
    }


//    public static void main(String[] arg) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int x = 3;
//        int index = index(arr, x, 0, arr.length);
//        int index1 = index(arr, x, 0, arr.length);
//        System.out.println(index);
//        System.out.println(index1);
//    }

}
