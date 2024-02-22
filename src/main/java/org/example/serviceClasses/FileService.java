package org.example.serviceClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileService {
    public static String getFileContent(String filePath){
        try {
            return Files.lines(Paths.get(filePath))
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            System.err.println("Error with reading file: " + e.getMessage());
        }
        return "Empty file";
    }
}
