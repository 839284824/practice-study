package datastructure.array;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Desc 去除重复元素
 * @Author gongzhao
 * @Date 2019/9/1911:21
 */
@Slf4j
@Data
public class RemoveDuplicate {


    /**
     * 去除重复元素的话涉及到很多的delete操作，需要移动数据，比较耗时。所以需要把数据
     * 移动到数组的一侧，这样删除的时候就不用在移动数据了。
     * 返回:将重复元素都移动到后面了，返回分界点
     */
    public static int removeDuplicate(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        /**
         * 初始化两个指针，快指针负责先遍历，慢指针随后。
         * 当快指针遇到一个不重复的数字的时候，这个时候告诉慢指针移动
         * 同时将不重复的数据交换到前面来。
         * 当快指针遍历完成的时候会，慢指针后面的元素都是重复元素了
         */
        int slow = 0;
        int fast = 1;

        while (fast < n) {
            if (arr[fast] != arr[slow]) {
                //快指针找到了不重复的元素，1 ，先让慢指针向前移动
                slow++;
                //将fast找到的不重复元素交换到重复的元素后面
                arr[slow] = arr[fast];
            } else {
                //快指针还没找到不重复元素，一直向后找
                fast++;
            }
        }
        return slow + 1;
    }

    public static void main(String[] arg) {
        int[] arr = {0, 0, 1, 2, 2, 3, 4, 5, 6, 8, 8};
        log.info("去重前：{}", arr);
        int boundary = removeDuplicate(arr);
        int[] b = new int[boundary];
        for (int i = 0; i < boundary; i++) {
            b[i] = arr[i];
        }
        log.info("去重后：{}", b);
    }
}
