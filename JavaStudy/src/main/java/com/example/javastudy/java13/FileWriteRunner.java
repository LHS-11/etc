package com.example.javastudy.java13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileWriteRunner {

    public static void main(String[] args) throws IOException {
        Path pathFileToWrite = Paths.get("./src/main/java/com/example/javastudy/java13/resources/file-write.txt");

        List<String> list = List.of("A", "B", "C", "D");

        Files.write(pathFileToWrite, list);

    }
}
