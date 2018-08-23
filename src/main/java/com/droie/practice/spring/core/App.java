package com.droie.practice.spring.core;

import com.droie.practice.spring.core.beans.FileReader;
import com.droie.practice.spring.core.beans.FileStatistics;

import java.util.Arrays;
import java.util.List;

public class App {

    private FileReader fileReader;
    private FileStatistics fileStatistics;

    public App(FileReader fileReader, FileStatistics fileStatistics) {
        this.fileReader = fileReader;
        this.fileStatistics = fileStatistics;
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        FileStatistics fileStatistics = new FileStatistics();

        App app = new App(fileReader, fileStatistics);

        List<String> arguments = Arrays.asList(args);
        if (arguments.contains("--path")) {
            String path = arguments.get(1);
            fileReader.read(path);
        }

    }
}
