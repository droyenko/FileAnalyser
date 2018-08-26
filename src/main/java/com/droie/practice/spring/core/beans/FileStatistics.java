package com.droie.practice.spring.core.beans;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class FileStatistics {

    private Connection connObj;
    private PreparedStatement pstmtObj;
    private ConnectionPool jdbcObj = new ConnectionPool();

    public void process(File unprocessedFile) {

        try {
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();

            List<Line> lines = unprocessedFile.getLines();
            for (Line line : lines) {
                String sql = "INSERT INTO Line (idFile, number, longestWord, shortestWord, length, awgWordLength)"
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                pstmtObj = connObj.prepareStatement(sql);
                pstmtObj.setInt(1, 1);
                pstmtObj.setInt(2, line.getNumber());
                pstmtObj.setInt(3, line.getLongestWord());
                pstmtObj.setInt(4, line.getShortestWord());
                pstmtObj.setInt(5, line.getLength());
                pstmtObj.setInt(6, line.getAwgWordLength());
                pstmtObj.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
