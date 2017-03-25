package com.jimi.mb.test; 

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jimi.mb.comm.utils.MyBatisUtils;
import com.jimi.mb.domain.Person;
 
public class MyBatisTest extends Assert {
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
 
    @BeforeClass
    public static void init() throws IOException {
        sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
    }
 
    @Before
    public void before() {
        sqlSession = sqlSessionFactory.openSession(true);//自动提交
        sqlSession.delete("deleteAllPerson");
    }
 
    @After
    public void after() {
        sqlSession.close();
    }
 
    @Test
    public void testMyBatisUtils() {
        assertNotNull(sqlSessionFactory);
    }
 
    @Test
    public void testInsert() {
    	
        Person p = new Person(new Random().nextInt(Integer.MAX_VALUE), "yitian", new Date(1993, 5, 6));
        sqlSession.insert("insertPerson", p);
 
        Person s = sqlSession.selectOne("selectPersonByName", p.getUsername());
        assertNotNull(s);
        System.out.println(s);
 
        //sqlSession.delete("deletePerson", s);
    }
 
    @Test
    public void testUpdate() {
        Person p = new Person(1, "leo", new Date(1993, 5, 6));
        sqlSession.insert("insertPerson", p);
 
        p = sqlSession.selectOne("selectPersonByName", p.getUsername());
        Date b = new Date(1987, 7, 8);
        p.setBirthday(b);
        sqlSession.update("updatePerson", p);
        Person s = sqlSession.selectOne("selectPersonByName", p.getUsername());
        assertEquals(s.getBirthday(),b);
        System.out.println(s);
 
      //  sqlSession.delete("deletePerson", s);
    }
}