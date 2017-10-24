package com.yunji.ft.SkuWhiteList;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author mask
 * @date 2017/10/24 15:06
 * @desc 新增移除白名单
 */
public class SkuWhiteListTool {
    @Test
    public void test() throws IOException {
        List<String> list = FileUtils.readLines(new File("d://baimingdan.txt"));
        for (String sku : list) {
            System.out.println("ZADD oms:sku_is_not_split_order 100 \"\\\"" + sku.trim() + "\\\"\"");
        }
    }

    @Test
    public void test1() throws IOException {
        List<String> list = FileUtils.readLines(new File("d://baimingdan.txt"));
        for (String sku : list) {
            System.out.println("ZREM oms:sku_is_not_split_order  \"\\\"" + sku.trim() + "\\\"\"");
        }
    }
}
