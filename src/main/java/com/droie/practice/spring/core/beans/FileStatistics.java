package com.droie.practice.spring.core.beans;

import com.droie.practice.spring.core.entities.File;
import com.droie.practice.spring.core.entities.Line;
import com.droie.practice.spring.core.persistence.FileStatisticsDao;
import com.droie.practice.spring.core.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

public class FileStatistics {
    FileStatisticsDao fsd = new FileStatisticsDao();

    private ConnectionPool jdbc = new ConnectionPool();

    public void process(File unprocessedFile) {
        List<Line> lines = unprocessedFile.getLines();
        for (Line line : lines) {
            fsd.save(line);
        }
    }

    private void processLine(Line line) {
        String content = line.getContent();
        String[] words = content.split(" ");
        line.setLongestWord(calcLongestWordLength(words));
        line.setShortestWord(calcShortestWordLength(words));
        line.setAwgWordLength(calcAwgWordLength(words));
        line.setLength(content.length());
    }

    private int calcLongestWordLength(String[] words) {
        int longestWordLength = 0;
        for (String word : words) {
            if (word.length() > longestWordLength) {
                longestWordLength = word.length();
            }
        }
        return longestWordLength;
    }

    private int calcShortestWordLength(String[] words) {
        int shortestWordLength = words[0].length();
        for (String word : words) {
            if (word.length() < shortestWordLength) {
                shortestWordLength = word.length();
            }
        }
        return shortestWordLength;
    }

    private int calcAwgWordLength(String[] words) {
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        return totalLength/(words.length);
    }



}
