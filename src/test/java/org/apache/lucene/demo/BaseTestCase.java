package org.apache.lucene.demo;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTestCase {

    /**
     * Gets a resource from the test's classpath as {@link Path}. This method should only
     * be used, if a real file is needed. To get a stream, code should prefer
     * {@link #getDataInputStream(String)}.
     */
    protected Path getDataPath(String name) throws IOException {
        try {
            URL url = this.getClass().getResource(name);
            URI uri = url.toURI();
            return Paths.get(this.getClass().getResource(name).toURI());
        } catch (Exception e) {
            throw new IOException("Cannot find resource: " + name);
        }
    }

    /**
     * Gets a resource from the test's classpath as {@link InputStream}.
     */
    protected InputStream getDataInputStream(String name) throws IOException {
        InputStream in = this.getClass().getResourceAsStream(name);
        if (in == null) {
            throw new IOException("Cannot find resource: " + name);
        }
        return in;
    }

    public static Path createTempDir() throws IOException {
        return createTempDir("tempDir");
    }

    public static Path createTempDir(String prefix) throws IOException {
        return Files.createTempDir().toPath();
    }

    public static Path createTempFile(String prefix, String suffix) throws IOException {
        return File.createTempFile(prefix, "").toPath();
    }

}
