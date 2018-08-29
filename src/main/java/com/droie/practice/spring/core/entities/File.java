package com.droie.practice.spring.core.entities;

import java.util.List;

public class File {
    private List<Line> lines;
    private String path;
    private int longestWordLength;
    private int shortestWordLenght;
    private int awgWordLength;
    private int contentLength;

    public void setLongestWordLength(int longestWordLength) {
        this.longestWordLength = longestWordLength;
    }

    public void setShortestWordLenght(int shortestWordLenght) {
        this.shortestWordLenght = shortestWordLenght;
    }

    public void setAwgWordLength(int awgWordLength) {
        this.awgWordLength = awgWordLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
