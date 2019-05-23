package util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

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
        String date = LocalDate.now().plusDays(-1).toString();
        log.info("date:{}", date);
        String time = LocalTime.of(0, 0, 0).toString();
        String time1 = LocalTime.parse("00:00:00").toString();
        log.info("time:{}    time1:{}", time, time1);

    }

}
