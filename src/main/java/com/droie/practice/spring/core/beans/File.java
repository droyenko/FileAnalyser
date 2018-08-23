package com.droie.practice.spring.core.beans;

import java.util.List;

public class File {
    private List<Line> lines;
    private String path;

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
