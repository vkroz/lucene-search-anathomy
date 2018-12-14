package org.samplets.lucene;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;

public class GettingStarted {
    private static final Logger logger = LogManager.getLogger(GettingStarted.class);

    public static void main(String[] args) {
        System.exit(new GettingStarted().run());
    }

    private int run() {
        logger.debug("Hello");

        String title = "xxx";
        String body = "yyy";

        Directory memoryIndex = new RAMDirectory();
        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        try (IndexWriter writter = new IndexWriter(memoryIndex, indexWriterConfig)) {
            Document document = new Document();
            document.add(new TextField("title", title, Field.Store.YES));
            document.add(new TextField("body", body, Field.Store.YES));
            writter.addDocument(document);

            document = new Document();
            document.add(new TextField("title", title, Field.Store.YES));
            document.add(new TextField("body", body, Field.Store.YES));
            writter.addDocument(new Document());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
