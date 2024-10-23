package lsieun.drawing.utils.io.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class ResourceUtils {
    public static Path readFilePath(String filepath, boolean verbose) {
        ResourceStrategy[] values = ResourceStrategy.values();
        int length = values.length;
        for (int i = 0; i < length; i++) {
            ResourceStrategy strategy = values[i];
            Optional<Path> op = strategy.parse(filepath);
            if (op.isPresent()) {
                Path path = op.get();
                if (verbose) {
                    String info = String.format("[READ] %s", path.toUri());
                    System.out.println(info);
                }
                return path;
            }
        }

        String msg = String.format("filepath NOT FOUND: %s", filepath);
        throw new IllegalArgumentException(msg);
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
