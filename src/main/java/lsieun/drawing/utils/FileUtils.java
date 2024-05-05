package lsieun.drawing.utils;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FileUtils {
    public static final int BUFFER_SIZE = 16 * 1024;

    public static String getFilePath(String relativePath) {
        String dir = Objects.requireNonNull(FileUtils.class.getResource("/")).getPath();
        String filepath = dir + relativePath;
        if (filepath.contains(":")) {
            return filepath.substring(1);
        }
        return filepath;
    }

    public static byte[] readBytes(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            throw new IllegalArgumentException("File Not Exist: " + filepath);
        }

        try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis)
        ) {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            byte[] buf = new byte[BUFFER_SIZE];
            int len;
            while ((len = bis.read(buf)) != -1) {
                bao.write(buf, 0, len);
            }
            return bao.toByteArray();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void writeBytes(String filepath, byte[] bytes) {
        File file = new File(filepath);
        File dirFile = file.getParentFile();
        mkdirs(dirFile);

        try (OutputStream out = new FileOutputStream(filepath);
             BufferedOutputStream buff = new BufferedOutputStream(out)) {
            buff.write(bytes);
            buff.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readLines(String filepath) {
        return readLines(filepath, "UTF8");
    }

    public static List<String> readLines(String filepath, String charsetName) {
        File file = new File(filepath);
        if (!file.exists()) {
            throw new IllegalArgumentException("File Not Exist: " + filepath);
        }

        try (
                InputStream in = new FileInputStream(file);
                Reader reader = new InputStreamReader(in, charsetName);
                BufferedReader bufferReader = new BufferedReader(reader)
        ) {
            List<String> list = new ArrayList<>();
            String line;
            while ((line = bufferReader.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> readLinesFromClasspath(String relativePath) {
        URL resource = FileUtils.class.getClassLoader().getResource(relativePath);
        if (resource == null) {
            return Collections.emptyList();
        }

        List<String> lines = new ArrayList<>();
        try (
                InputStream inputStream = TreeUtils.class.getClassLoader().getResourceAsStream(relativePath);
                InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr)) {
            String line;
            while ((line = reader.readLine())!= null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void writeLines(String filepath, List<String> lines) {
        if (lines == null || lines.size() < 1) return;

        File file = new File(filepath);
        File dirFile = file.getParentFile();
        mkdirs(dirFile);

        try (
                OutputStream out = new FileOutputStream(file);
                Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mkdirs(File dirFile) {
        boolean file_exists = dirFile.exists();

        if (file_exists && dirFile.isDirectory()) {
            return;
        }

        if (file_exists && dirFile.isFile()) {
            throw new RuntimeException("Not A Directory: " + dirFile);
        }

        if (!file_exists) {
            boolean flag = dirFile.mkdirs();
            if (!flag) {
                throw new RuntimeException("Create Directory Failed: " + dirFile.getAbsolutePath());
            }
        }
    }
}
