package com.ft;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author mask
 * @date 2017/10/27 15:06
 * @desc
 */
public class SQLCreatorTest {

    private SQLCreator sqlCreator = null;

    @Before
    public void init(){
        sqlCreator = new SQLCreator();
    }

    @Test
    public void test() throws Exception {
        System.out.println("开始");
        sqlCreator.createAddColumn6();
        System.out.println("结束");
    }

    @Test
    public void tes1t() throws Exception {
        System.out.println("开始");
        sqlCreator.fixSql();
        System.out.println("结束");
    }

    @Test
    public void test1() throws Exception {
        System.out.println("开始");
        sqlCreator.createAddColumnSO();
        System.out.println("结束");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("开始");
        sqlCreator.fixSql1();
        System.out.println("结束");
    }

    @Test
    public void test3() throws Exception {
        System.out.println("开始");
        sqlCreator.createAddColumnSODetail();
        System.out.println("结束");
    }

    @Test
    public void test4() throws Exception {
        System.out.println("开始");
        sqlCreator.fixSql2();
        System.out.println("结束");
    }

    @Test
    public void test5() throws Exception {
        System.out.println("开始");
        sqlCreator.createAddColumn7();
        System.out.println("结束");
    }
}