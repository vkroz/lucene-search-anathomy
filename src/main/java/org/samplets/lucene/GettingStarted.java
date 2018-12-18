package org.samplets.lucene;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo for basics Lucene API *
 *
 * <ul>
 *   <li>org.apache.lucene.index
 *   <li>org.apache.lucene.document
 *   <li>org.apache.lucene.search
 *   <li>org.apache.lucene.analysis
 * </ul>
 */
public class GettingStarted {
  private static final Logger logger = LogManager.getLogger(GettingStarted.class);

  // Objects shared across writing and reading methods
  Directory memoryIndex = new RAMDirectory();
  StandardAnalyzer analyzer = new StandardAnalyzer();

  public static void main(String[] args) {
    GettingStarted luceneDemo = new GettingStarted();
    luceneDemo.writeIndex();
    luceneDemo.searchIndex();
  }

  public int writeIndex() {
    logger.debug("Hello");

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
