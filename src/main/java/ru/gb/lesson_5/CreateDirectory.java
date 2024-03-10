package ru.gb.lesson_5;


import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;


//Домашнее задание
//1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup

public class CreateDirectory {


    public static void main(String[] args) throws IOException {
        String directoryPath = String.valueOf(Path.of("./backup"));




        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean created = directory.mkdir();
            if (created) {
                System.out.println("Директория успешно создана!");
            } else {
                System.out.println("Не удалось создать директорию!");
            }
        }

        DirectoryStream<Path> dir = Files.newDirectoryStream(Path.of("."));
        for (Path file : dir) {
            if (Files.isDirectory(file)) continue;
            Files.copy(file, Path.of("./backup/" + file.toString()));
        }
    }
}






