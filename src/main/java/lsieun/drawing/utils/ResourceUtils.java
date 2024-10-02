package lsieun.drawing.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ResourceUtils {
    public static Path readFilePath(String relativePath, boolean verbose) {
        URL resource = ResourceUtils.class.getClassLoader().getResource(relativePath);
        if (resource == null) {
            String msg = String.format("relativePath NOT FOUND: %s", relativePath);
            throw new IllegalArgumentException(msg);
        }

        try {
            URI uri = resource.toURI();
            Path path = Paths.get(uri);

            if (verbose) {
                String info = String.format("[READ] %s", path.toUri());
                System.out.println(info);
            }

            return path.toAbsolutePath().normalize();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readLines(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static void writeLines(Path path, List<String> lines) throws IOException {
        Path dir = path.getParent();
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }

        Files.write(path, lines);
    }
}
