package middle.lucene.index;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;
import middle.lucene.analyzer.IKAnalyzer8x;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

@Slf4j
public class IndexRead {
    public static void main(String[] args) throws ParseException, IOException {
        String field = "title";
        Path indexPath = Paths.get("D:\\study\\ES\\index");
        Directory dir = FSDirectory.open(indexPath);
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        Analyzer analyzer = new IKAnalyzer8x(true);
        QueryParser parser = new QueryParser(field, analyzer);
//        parser.setDefaultOperator(QueryParser.Operator.AND);
        Query query = parser.parse("杭州");
        log.info("Query:" + query.toString());
        TopDocs tds = searcher.search(query, 10);
        for (ScoreDoc sd : tds.scoreDocs) {
            Document doc = searcher.doc(sd.doc);
            log.info("DocID:" + sd.doc);
            log.info("id:" + doc.get("id"));
            log.info("title:", doc.get("title"));
            log.info("文档评分：" + sd.score);
        }
        dir.close();
        reader.close();
    }
}