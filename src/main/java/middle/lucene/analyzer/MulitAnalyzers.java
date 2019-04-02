package middle.lucene.analyzer;

import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.StringReader;

/**
 * @Desc 测试多个分词器的效果
 * @Author gongzhao
 * @Date 2019/4/217:22
 */
@Slf4j
public class MulitAnalyzers {

    private static String ch = "洛杉矶湖人队一共夺取了16座总冠军奖杯。";
    private static String en = "everything well be good！";

    public static void main(String[] args) throws Exception {
        Analyzer analyzer = null;
        //标准分词器
        log.info("标准分词");
        analyzer = new StandardAnalyzer();
        printAnalyzers(analyzer, ch);
        //空格分词器
        log.info("空格分词");
        analyzer = new WhitespaceAnalyzer();
        printAnalyzers(analyzer, ch);
        //简单分词器
        log.info("简单分词");
        analyzer = new SimpleAnalyzer();
        printAnalyzers(analyzer, ch);
        //二分法分词
        log.info("二分法分词");
        analyzer = new CJKAnalyzer();
        printAnalyzers(analyzer, ch);
        //关键词分词
        log.info("关键词分词");
        analyzer = new KeywordAnalyzer();
        printAnalyzers(analyzer, ch);
        //中文智能分词
        log.info("中文智能分词");
        analyzer = new SmartChineseAnalyzer();
        printAnalyzers(analyzer, ch);
        //Ik分词器
        log.info("IK分词器");
        analyzer = new IKAnalyzer8x();
        printAnalyzers(analyzer, ch);
        //智能切割算法
        log.info("IK智能分词");
        analyzer = new IKAnalyzer8x(true);
        printAnalyzers(analyzer, ch);
    }

    private static void printAnalyzers(Analyzer analyzer, String token) throws Exception {
        StringReader stringReader = new StringReader(token);
        TokenStream tokenStream = analyzer.tokenStream(token, stringReader);
        tokenStream.reset();
        CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
        log.info("分词结果:");
        while (tokenStream.incrementToken()) {
            log.info(charTermAttribute.toString() + " | ");
        }
        log.info("\n");
        analyzer.close();
    }
}
