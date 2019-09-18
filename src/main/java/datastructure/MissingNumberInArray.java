package datastructure;

import lombok.extern.slf4j.Slf4j;

import java.util.BitSet;

@Slf4j
public class MissingNumberInArray {

    public static void main(String args[]) {

        // one missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

        // two missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

        // three missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

        // four missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);
    }

    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        log.info("缺失元素个数:{}", missingCount);
        BitSet bitSet = new BitSet(count);
        for (int number : numbers) {
            bitSet.set(number - 1);
        }
        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);

            log.info("原始数据:{}--缺失数字:{}", numbers, ++lastMissingIndex);
        }
    }
}
