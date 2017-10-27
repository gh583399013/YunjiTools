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
    public void createAddColumn1() throws Exception {
        System.out.println("111");
        sqlCreator.createAddColumn1();
    }

}