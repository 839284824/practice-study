package util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * @Desc 时间类工具
 * @Author gongzhao
 * @Date 2019/4/1617:58
 */
@Slf4j
public final class TimeUtil {

    public static String getMonthByOffset(Date date, int offset) {
        if (date == null) {
            log.error("当前日期为空");
            throw new IllegalArgumentException("当前日期为空");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("M");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        return formatter.format(c.getTime());
    }


    public static void main(String[] arg) {
        Integer num = 64;
        log.info("原始数据:{}", num);
        log.info("左移一位数据:{}", num << 1);
        log.info("左移两位数据:{}", num << 2);
        log.info("左移三位数据:{}", num << 3);
        log.info("左移四位数据:{}", num << 4);
        log.info("右移1位数据:{}", num >> 1);
        log.info("右移2位数据:{}", num >> 2);
        log.info("右移3位数据:{}", num >> 3);
        log.info("右移4位数据:{}", num >> 4);
        log.info("无符号右移1位数据:{}", num >>> 1);
        log.info("无符号右移2位数据:{}", num >>> 2);
        log.info("无符号右移3位数据:{}", num >>> 3);
        log.info("无符号右移4位数据:{}", num >>> 4);
    }

}
