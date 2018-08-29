package com.droie.practice.spring.core.persistence;

import com.droie.practice.spring.core.beans.FileStatistics;
import com.droie.practice.spring.core.entities.Line;
import com.droie.practice.spring.core.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FileStatisticsDao {
    private static Logger logger = Logger.getLogger(FileStatistics.class.getName());
    private ConnectionPool jdbc = new ConnectionPool();

    public void save(Line line) {

        try (Connection conn = jdbc.getConnection()) {

            String sql = "INSERT INTO Line (idFile, number, longestWord, shortestWord, length, awgWordLength)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, 1);
                pstmt.setInt(2, line.getNumber());
                pstmt.setInt(3, line.getLongestWord());
                pstmt.setInt(4, line.getShortestWord());
                pstmt.setInt(5, line.getLength());
                pstmt.setInt(6, line.getAwgWordLength());
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            logger.error("FileStatistics.process method exception", e);
        }
    }
}
