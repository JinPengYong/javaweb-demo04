package com.cheer.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    //保证系统中只有一个factory实例
    private static SqlSessionFactory factory;

    //静态代码块，在静态变量初始化之后执行，并且只执行一次
    static {
        InputStream in = null;
        try {
            //in = Resources.getResourceAsStream("mybatis-config.xml");
            in=Resources.getResourceAsStream("mybatis-config.xml");
            //factory=new SqlSessionFactoryBuilder().build(in);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //打开session并获取
    public static SqlSession getSqlSession() {
        return factory.openSession();
    }

    public static void closeSession(SqlSession session) {
        session.commit();
        session.close();
    }

}
