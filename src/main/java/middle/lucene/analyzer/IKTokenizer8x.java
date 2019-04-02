package middle.lucene.analyzer;

import java.io.IOException;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKTokenizer8x extends Tokenizer {
    // IK 分词器实现
    private IKSegmenter _IKImplement;
    // 词元文本属性
    private CharTermAttribute termAtt;
    // 词元位移属性
    private OffsetAttribute offsetAtt;
    //词元分类属性
    // ( 该属性分类参考org.wltea.analyzer.core.Lexeme 中的分类常量）
    private TypeAttribute typeAtt;
    //记录最后一个词元的结束位置
    private int endPosition;

    // Lucene 6.x Tokenizer 适配器类构造函数;实现最新的Tokenizer 接口
    public IKTokenizer8x(boolean useSmart) {
        super();
        offsetAtt = addAttribute(OffsetAttribute.class);
        termAtt = addAttribute(CharTermAttribute.class);
        typeAtt = addAttribute(TypeAttribute.class);
        _IKImplement = new IKSegmenter(input, useSmart);
    }

    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();
        Lexeme nextLexeme = _IKImplement.next();
        if (nextLexeme != null) {
            // 将Lexeme 转成Attributes
            //清除所有的词元属性
            termAtt.append(nextLexeme.getLexemeText());
            //设置词元文本
            termAtt.setLength(nextLexeme.getLength());
            //设置词元长度;
            offsetAtt.setOffset(nextLexeme.getBeginPosition(), nextLexeme.getEndPosition());
            endPosition = nextLexeme.getEndPosition();
            typeAtt.setType(nextLexeme.getLexemeText());
            return true;
        }
        return false;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        _IKImplement.reset(input);
    }

    @Override
    public final void end() {
        int finalOffset = correctOffset(this.endPosition);
        offsetAtt.setOffset(finalOffset, finalOffset);
    }
}

