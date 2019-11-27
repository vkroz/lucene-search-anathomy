package org.samplets.lucene.demo1;

import com.google.common.io.Files;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.samplets.lucene.TestUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/** */
public class QueriesDemo {
  private static final Logger logger = LogManager.getLogger(QueriesDemo.class);

  private static final File indexDir = Files.createTempDir();
  public QueriesDemo() {
    indexDir.deleteOnExit();
  }

  public static void main(String[] args) {

    try {
      IndexDemoWriter writer = new IndexDemoWriter(indexDir);
      writer.writeFiles(TestUtils.listResources("/docs"));


    } catch (IOException e) {
      logger.error(e.getMessage());
    } catch (URISyntaxException e) {
      logger.error(e.getMessage());
  }


  public int createIndex() throws IOException, URISyntaxException {
    logger.debug("Hello");
    List<String> srcDocs = loadData("hubble_sample_small.txt");

    IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
    try (IndexWriter writter = new IndexWriter(memoryIndex, indexWriterConfig)) {

      String title = "What about angels";
      String song =
          "We know full well there's just time\n"
              + "So is it wrong to toss this line?\n"
              + "If your heart was full of love\n"
              + "Could you give it up?";

      writter.addDocument(makeDocument(title, song));

      title = "We're the champions";
      song =
          "We are the champions, my friends\n"
              + "And we'll keep on fighting till the end\n"
              + "We are the champions, we are the champions\n"
              + "No time for losers";

      writter.addDocument(makeDocument(title, song));

      writter.addDocument(new Document());

    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  private Document makeDocument(String title, String body) {
    Document doc = new Document();
    doc.add(new TextField("title", title, Field.Store.YES));
    doc.add(new TextField("body", body, Field.Store.YES));
    return doc;
  }

  public void searchIndex() {

    String inField = "title";
    String queryString = "angels";

    StandardAnalyzer analyzer = new StandardAnalyzer();
    Query query = null;
    try {
      query = new QueryParser(inField, analyzer).parse(queryString);
      IndexReader indexReader = DirectoryReader.open(memoryIndex);
      IndexSearcher searcher = new IndexSearcher(indexReader);
      TopDocs topDocs = searcher.search(query, 10);
      List<Document> documents = new ArrayList<>();
      for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
        documents.add(searcher.doc(scoreDoc.doc));
      }

      System.out.println(documents);

    } catch (ParseException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
