package com.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-05
 * Time : 17:41
 */
public class JDBCUtil {
    private static final DataSource DS;
    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0,1");
        mysqlDataSource.setPort(8080);
        mysqlDataSource.setCharacterEncoding("utf-8");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("WOaini91154576@qq.com");
        mysqlDataSource.setDatabaseName("db2020");
        mysqlDataSource.setUseSSL(false);
        DS = mysqlDataSource;
    }
    public static Connection getConnection() throws SQLException {
        return DS.getConnection();
    }


}
