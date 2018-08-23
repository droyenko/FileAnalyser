package com.droie.practice.spring.core.beans;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {
    public File read(String path) {
        File file = new File();
        java.io.File rawFile = new java.io.File(path);

        try {
            String content = FileUtils.readFileToString(rawFile, (String) null);
            String[] linesArray = content.split("\\n");
            List<String> lines = Arrays.asList(linesArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
