package com.droie.practice.spring.core.util;

import com.droie.practice.spring.core.entities.File;
import com.droie.practice.spring.core.entities.Line;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static Logger logger = Logger.getLogger(FileReader.class.getName());

    public File read(String path) {
        File file = new File();
        java.io.File rawFile = new java.io.File(path);
        List<Line> lines = new ArrayList<Line>();

        try {
            String content = FileUtils.readFileToString(rawFile, (String) null);
            String[] linesArray = content.split("\\r?\\n");
            for (int i = 0; i < linesArray.length; i++) {
                lines.add(new Line(linesArray[i], i + 1));
            }
            file.setLines(lines);

        } catch (IOException e) {
            logger.error("FileReader.read method exception", e);
        }
        return file;
    }
}
