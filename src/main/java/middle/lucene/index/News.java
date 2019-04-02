package middle.lucene.index;

import lombok.Data;

/**
 * @Desc 新闻信息实体类
 * @Author gongzhao
 * @Date 2019/4/218:03
 */
@Data
public class News {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 评论数
     */
    private Integer issue;
}
