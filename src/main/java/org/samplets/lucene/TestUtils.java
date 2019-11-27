package org.samplets.lucene;

import com.google.common.io.Files;
import org.samplets.lucene.demo1.QueriesDemo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

public class TestUtils {

  public static List<String> linesFromResource(String fileName) throws URISyntaxException, IOException {
    return Files.asCharSource(
            new File(QueriesDemo.class.getClassLoader().getResource(fileName).toURI()),
            Charset.defaultCharset())
        .readLines();
  }

  /** Gets a resource from the test's classpath as {@link InputStream}. */
  public static InputStream getDataInputStream(String name) throws IOException {
    InputStream in = TestUtils.class.getResourceAsStream(name);
    if (in == null) {
      throw new IOException("Cannot find resource: " + name);
    }
    return in;
  }

    public static List<File> listResources(String resourcePath) {
        return null;
    }
}
