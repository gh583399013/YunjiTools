package com.ft;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mask
 * @date 2017/10/27 14:48
 * @desc
 */
public class SQLCreator {

    /**
     * 给开发环境数据库 增加system_time字段,其他环境已经加上了
     * @throws IOException
     */
    public void createAddColumn1() throws IOException {
        List<String> resultList = new ArrayList<>(1100);
        String tableSuffix = null;
        for (int i = 0; i <= 63; i++) {
            tableSuffix = "" + i;
            while (tableSuffix.length() < 2){
                tableSuffix = "0" + tableSuffix;
            }
            tableSuffix = "_" + tableSuffix;
            String text = "alter table t_common_order### add COLUMN system_time DATETIME DEFAULT NULL COMMENT '系统发货时间' after is_presell;";
            text = text.replaceAll("###",tableSuffix);
            resultList.add(text);
        }
        System.out.println("common_order sql已经生成");

        for (int i = 0; i <= 1023; i++) {
            tableSuffix = "" + i;
            while (tableSuffix.length() < 4){
                tableSuffix = "0" + tableSuffix;
            }
            tableSuffix = "_" + tableSuffix;
            String text = "alter table t_supplier_order### add COLUMN system_time DATETIME DEFAULT NULL COMMENT '系统发货时间' after is_presell;";
            text = text.replaceAll("###",tableSuffix);
            resultList.add(text);
        }
        System.out.println("supplier_order sql已经生成");

        String fileName = "D:/sqlResult/sql" + System.currentTimeMillis() + ".txt";

        FileUtils.writeLines(FileUtils.getFile(fileName),"UTF-8",resultList,false);
        System.out.println("输出文件为:" + fileName);
    }

    public void func2(){
        System.out.println("222");
    }
}