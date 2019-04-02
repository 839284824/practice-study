package middle.lucene.index;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import middle.lucene.analyzer.IKAnalyzer8x;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * 创建索引
 */
@Slf4j
public class Createlndex {


    public static void main(String[] args) {
// 创建3 个News 对象
        News newsl = new News();
        newsl.setId(1);
        newsl.setTitle("习近平会见美国总统奥巴马, 学习国外经验");
        newsl.setContent(" 国家主席习近平9 月3 日在杭州西湖国宾馆会见前来出席");
        newsl.setIssue(672);
        News news2 = new News();
        news2.setId(2);
        news2.setTitle("北大迎4380 名新生农村学生700 多人近年最多");
        news2.setContent(" 昨天，北京大学迎来4380 名来自全国各地及数十个国家 的本科新生。其中， 农村学生共700 余名，为近年最多");
        news2.setIssue(995);
        News news3 = new News();
        news3.setId(3);
        news3.setTitle("特朗普宣誓（ Donald Trump) 就任美国第45 任总统 ");
        news3.setContent("当地时间1 月20 日，唐纳德􂀢特朗普在美国国会宣誓就 职，正式成为美国第45 任总统。");
        news3.setIssue(1872);
        //创建IK 分词器
        Analyzer analyzer = new IKAnalyzer8x(true);
        IndexWriterConfig icw = new IndexWriterConfig(analyzer);
        icw.setOpenMode(OpenMode.CREATE);
        Directory dir = null;
        IndexWriter inWriter = null;
        //索引目录
        Path indexPath = Paths.get("D:\\study\\ES\\index");
        // 开始时间
        Date start = new Date();
        try {
            if (!Files.isReadable(indexPath)) {
                System.exit(1);
            }
            dir = FSDirectory.open(indexPath);
            inWriter = new IndexWriter(dir, icw);
            //设置新闻ID 索引并存储
            FieldType idType = new FieldType();
            idType.setIndexOptions(IndexOptions.DOCS);
            idType.setStored(true);
            //设置新闻标题索引文档、词项频率、位移信息和偏移量，存储并词条化
            FieldType titleType = new FieldType();
            titleType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
            titleType.setStored(true);
            titleType.setTokenized(true);

            FieldType contentType = new FieldType();
            contentType.setIndexOptions(IndexOptions.
                    DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
            contentType.setStored(true);
            contentType.setTokenized(true);
            contentType.setStoreTermVectors(true);
            contentType.setStoreTermVectorPositions(true);
            contentType.setStoreTermVectorOffsets(true);
            contentType.setStoreTermVectorPayloads(true);


            Document docl = new Document();
            docl.add(new Field("id", String.valueOf(newsl.getId()), idType));
            docl.add(new Field(" title", newsl.getTitle(), titleType));
            docl.add(new Field(" content", newsl.getContent(), contentType));
            docl.add(new IntPoint(" issue", newsl.getIssue()));
            docl.add(new StoredField("issue_dispaly", newsl.getIssue()));

            Document doc2 = new Document();
            doc2.add(new Field(" id", String.valueOf(news2.getId()), idType));
            doc2.add(new Field(" title", news2.getTitle(), titleType));
            doc2.add(new Field(" content", news2.getContent(), contentType));
            doc2.add(new IntPoint("issue", news2.getIssue()));
            doc2.add(new StoredField("issue_display", news2.getIssue()));
            Document doc3 = new Document();
            doc3.add(new Field(" id", String.valueOf(news3.getId()), idType));
            doc3.add(new Field("title", news3.getTitle(), titleType));
            doc3.add(new Field(" content ", news3.getContent(), contentType));
            doc3.add(new IntPoint(" issue", news3.getIssue()));
            doc3.add(new StoredField(" issue_display", news3.getIssue()));

            //添加文档
            inWriter.addDocument(docl);
            inWriter.addDocument(doc2);
            inWriter.addDocument(doc3);
            inWriter.commit();
            inWriter.close();
            dir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date end = new Date();
        log.info("索引文档耗时:" + (end.getTime() - start.getTime()) + "毫秒");
    }
}


