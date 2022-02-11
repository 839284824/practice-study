package util;

import cn.hutool.extra.emoji.EmojiUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class EmojiUtils {

    public static void main(String[] args) {

        //处理表情
        String emoji = "😄😁";
        String emoji1 = "哈哈哈😄😁";
        String emoji2 = "哈哈哈😄😁呵呵呵";
        String emoji3 = "😄但是😁";
        String emoji4 = "我没有表情呀";
        log.info("包含表情:{}", EmojiUtil.containsEmoji(emoji));
        log.info("包含表情:{}",EmojiUtil.containsEmoji(emoji1));
        log.info("包含表情:{}",EmojiUtil.containsEmoji(emoji2));
        log.info("包含表情:{}",EmojiUtil.containsEmoji(emoji3));
        log.info("包含表情:{}",EmojiUtil.containsEmoji(emoji4));

        String str = "!@#$!#$#@";
        String str1 = "呵呵呵#$#@";
        String str2 = "【大大】";
        String str3 = "「大大」";
        String str4 = "哈哈哈";
        log.info("包含特殊字符:{}", containsSpecialChar(str));
        log.info("包含特殊字符:{}", containsSpecialChar(str1));
        log.info("包含特殊字符:{}", containsSpecialChar(str2));
        log.info("包含特殊字符:{}", containsSpecialChar(str3));
        log.info("包含特殊字符:{}", containsSpecialChar(str4));

        StringUtils.isEmpty(str);

    }


    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean containsSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】「」‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
}
