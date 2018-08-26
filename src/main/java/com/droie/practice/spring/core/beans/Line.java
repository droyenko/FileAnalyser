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

    public int getNumber() {
        return number;
    }

    public Line(String content, int number) {
        this.content = content;
        this.number = number;
        init();
    }

    private void init() {
        String[] words = content.split(" ");
        this.longestWord = calcLongestWordLength(words);
        this.shortestWord = calcShortestWordLength(words);
        this.awgWordLength = calcAwgWordLength(words);
        this.length = content.length();
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
