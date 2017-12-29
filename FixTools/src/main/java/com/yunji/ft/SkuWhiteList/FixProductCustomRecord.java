package com.yunji.ft.SkuWhiteList;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author mask
 * @date 2017/12/12 17:26
 * @desc
 */
public class FixProductCustomRecord {
    @Test
    public void test() throws IOException {
        List<String> list = FileUtils.readLines(new File("d://test001.txt"));
        for (String sku : list) {
            String[] arr = sku.split("\\t");
            System.out.println("update t_product_customs_record set `spec` = " + arr[2] + " where sku = '" + arr[0] + "' and warehouse_no = '" + arr[1] + "';");
        }
    }
}
