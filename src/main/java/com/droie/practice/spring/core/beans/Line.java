package com.droie.practice.spring.core.beans;

public class Line {
    private int longestWord;
    private int shortestWord;
    private int length;
    private int awgWordLength;
    private String content;
    private int number;

    public int getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(int longestWord) {
        this.longestWord = longestWord;
    }

    public int getShortestWord() {
        return shortestWord;
    }

    public void setShortestWord(int shortestWord) {
        this.shortestWord = shortestWord;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAwgWordLength() {
        return awgWordLength;
    }

    public void setAwgWordLength(int awgWordLength) {
        this.awgWordLength = awgWordLength;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Line(String content) {
        this.content = content;
    }
}
