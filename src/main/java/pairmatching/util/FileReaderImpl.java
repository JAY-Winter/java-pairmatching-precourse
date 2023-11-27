package pairmatching.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl {

    public static List<String> readAndPrintResourceFile(String fileName) {
        List<String> names = new ArrayList<>();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (InputStreamReader streamReader = new InputStreamReader(inputStream,
                StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(streamReader)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    names.add(line);
                }
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
        }
        return names;
    }
}
