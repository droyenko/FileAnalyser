package com.droie.practice.spring.core.beans;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;


public class ConnectionPool {

    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/file_analyser";
    static final String USER = "root";
    static final String PASS = "";

    private static GenericObjectPool gPool = null;

    public DataSource setUpPool() throws Exception {
        Class.forName(DRIVER);

        gPool = new GenericObjectPool();
        gPool.setMaxActive(5);

        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(URL, USER, PASS);
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, gPool, null, null, false, true);
        return new PoolingDataSource(gPool);
    }

    public GenericObjectPool getConnectionPool() {
        return gPool;
    }

}
