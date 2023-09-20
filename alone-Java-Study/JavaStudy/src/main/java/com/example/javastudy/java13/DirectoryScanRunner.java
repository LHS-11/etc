package com.example.javastudy.java13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

public class DirectoryScanRunner {
    public static void main(String[] args) throws IOException {

        Path currentDirectory = Paths.get(".");
//        Files.list(currentDirectory).forEach(System.out::println);

//        Files.walk(currentDirectory).filter(s->String.valueOf(s).contains(".java")).forEach(System.out::println);

        BiPredicate<Path, BasicFileAttributes> javaMatcher = (path, attributes) -> String.valueOf(path).contains(".java");

        BiPredicate<Path, BasicFileAttributes> directoryMatcher = (path, attributes) -> attributes.isDirectory();

        Files.find(currentDirectory,10,javaMatcher).forEach(System.out::println);


    }
}

