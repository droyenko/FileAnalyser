package com.droie.practice.spring.core.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;

import javax.sql.DataSource;


public class ConnectionPool {
    private static Properties properties = new PropertyReader().getProperties("src/main/resources/jdbc.properties");;
    private static Logger logger = Logger.getLogger(ConnectionPool.class.getName());

    private static final String DRIVER = properties.getProperty("driver");
    private static final String URL = properties.getProperty("url");
    private static final String USER = properties.getProperty("username");
    private static final String PASS =properties.getProperty("password");
    private DataSource dataSource;

    public ConnectionPool() {
        this.dataSource = setUpPool();
    }

    private static GenericObjectPool gPool = null;

    private DataSource setUpPool() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("ConnectionPool.setUpPool() method exception", e);
        }

        gPool = new GenericObjectPool();
        gPool.setMaxActive(5);

        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(URL, USER, PASS);
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, gPool, null, null, false, true);
        return new PoolingDataSource(gPool);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
