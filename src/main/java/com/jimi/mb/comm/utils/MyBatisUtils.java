package com.jimi.mb.comm.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class MyBatisUtils {
    private static volatile SqlSessionFactory sqlSessionFactory;
 
    public static final String MyBatisConfigLocation = "mybatis-config.xml";
 
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (sqlSessionFactory == null) {
            synchronized (MyBatisUtils.class) {
                if (sqlSessionFactory == null) {
                    InputStream input = Resources.getResourceAsStream(MyBatisConfigLocation);
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
                    input.close();
                }
            }
        }
        return sqlSessionFactory;
    }
}