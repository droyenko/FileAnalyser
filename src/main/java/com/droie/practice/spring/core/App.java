package com.droie.practice.spring.core;

import com.droie.practice.spring.core.entities.File;
import com.droie.practice.spring.core.util.FileReader;
import com.droie.practice.spring.core.beans.FileStatistics;

import java.util.Arrays;
import java.util.List;

public class App {

    private FileReader fileReader;
    private FileStatistics fileStatistics;

    private App(FileReader fileReader, FileStatistics fileStatistics) {
        this.fileReader = fileReader;
        this.fileStatistics = fileStatistics;
    }

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader();
        FileStatistics fileStatistics = new FileStatistics();

        App app = new App(fileReader, fileStatistics);

        String filePath = "";

        List<String> arguments = Arrays.asList(args);
        if (arguments.contains("--path")) {
            filePath = arguments.get(1);
        }
        File analysedFile = fileReader.read(filePath);

        fileStatistics.process(analysedFile);

    }
}
