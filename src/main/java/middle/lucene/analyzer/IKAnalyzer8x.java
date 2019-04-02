package middle.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

public class IKAnalyzer8x extends Analyzer {
    private boolean useSmart;

    public boolean useSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public IKAnalyzer8x() {
        // IK 分词器Lucene Analyzer 接口实现类;
        this(false);
    }

    public IKAnalyzer8x(boolean useSmart) {
        super();
        this.useSmart = useSmart;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer _IKTokenizer = new IKTokenizer8x(this.useSmart());
        return new TokenStreamComponents(_IKTokenizer);
    }
}