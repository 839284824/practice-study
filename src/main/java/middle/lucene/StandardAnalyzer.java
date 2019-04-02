package middle.lucene;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.StringReader;

/**
 * @Desc Lucene默认的分词器
 * @Author gongzhao
 * @Date 2019/4/217:10
 */
@Slf4j
public class StandardAnalyzer {

    private static String ch = "洛杉矶湖人队一共夺取了16座总冠军奖杯。";
    private static String en = "everything well be good！";


    public static void main(String[] strings) throws Exception {
        log.info("标准分词器对中文分词:");
        standardAnalyzer(ch);
        log.info("标准分词器对英文分词:");
        standardAnalyzer(en);

    }

    private static void standardAnalyzer(String token) throws Exception {
        Analyzer analyzer = new org.apache.lucene.analysis.standard.StandardAnalyzer();
        StringReader stringReader = new StringReader(token);
        TokenStream tokenStream = analyzer.tokenStream(token, stringReader);
        tokenStream.reset();
        CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
        log.info("分词结果:");
        while (tokenStream.incrementToken()) {
            log.info(charTermAttribute.toString() + " | ");
        }
        analyzer.close();

    }


}
