package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SignoUtils {

   public static void escrever(Path path, String pessoas) {
        try {
            Files.write(path, pessoas.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public static List<String> lerCadaLinha(Path path) {
        Stream<String> lines;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> list = lines.collect(Collectors.toList());
        lines.close();

        return list;
    }
}
