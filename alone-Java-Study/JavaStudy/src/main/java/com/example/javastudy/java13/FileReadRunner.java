package com.example.javastudy.java13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadRunner {

    public static void main(String[] args) throws IOException {

        Path pathFileToRead = Paths.get("./src/main/java/com/example/javastudy/java13/resources/data.txt");

        List<String> lines = Files.readAllLines(pathFileToRead); // 파일에서 모든 줄의 내용을 가져와서 리스트 형식으로 출력
//        System.out.println(lines);

        Files.lines(pathFileToRead)
                .filter(s->String.valueOf(s).endsWith("at"))
                .map(String::toLowerCase)
                .forEach(System.out::println);

//        Files.list(currentDirectory).forEach(System.out::println);
    }
}
