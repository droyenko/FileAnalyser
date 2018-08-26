package com.droie.practice.spring.core.beans;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public File read(String path) {
        File file = new File();
        java.io.File rawFile = new java.io.File(path);
        List<Line> lines = new ArrayList<Line>();

        try {
            String content = FileUtils.readFileToString(rawFile, (String) null);
            String[] linesArray = content.split("\\n");
            for (int i = 0; i < linesArray.length; i++) {
                lines.add(new Line(linesArray[i], i + 1));
            }
            file.setLines(lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
