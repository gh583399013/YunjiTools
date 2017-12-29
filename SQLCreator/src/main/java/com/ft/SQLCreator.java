package com.ft;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mask
 * @date 2017/10/27 14:48
 * @desc
 */
public class SQLCreator {

    private final String DB_YUNJIOMS = "yunjioms";

    private final String DB_YUNJIOMSORDER = "yunjiomsorder";

    private final String FILES_DIR = "D:/sqlResult/";

    /**
     * 修改标记字段为 int
     *
     * @throws IOException
     */
    public void updateColumn1() throws IOException {
        List<String> resultList = new ArrayList<>(1100);
        String tableSuffix = null;
        for (int i = 0; i <= 63; i++) {
            tableSuffix = "" + i;
            while (tableSuffix.length() < 2) {
                tableSuffix = "0" + tableSuffix;
            }
            tableSuffix = "_" + tableSuffix;
            String text = "alter table t_common_order### modify COLUMN `sign` INT(11) DEFAULT NULL COMMENT '标记';";
            text = text.replaceAll("###", tableSuffix);
            resultList.add(text);
        }
        System.out.println("common_order sql已经生成");

        for (int i = 0; i <= 1023; i++) {
            tableSuffix = "" + i;
            while (tableSuffix.length() < 4) {
                tableSuffix = "0" + tableSuffix;
            }
            tableSuffix = "_" + tableSuffix;
            String text = "alter table t_supplier_order### modify COLUMN `sign` INT(11) DEFAULT NULL COMMENT '标记';";
            text = text.replaceAll("###", tableSuffix);
            resultList.add(text);
        }
        System.out.println("supplier_order sql已经生成");

        String fileName = FILES_DIR + "sql" + System.currentTimeMillis() + ".txt";

        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
    }

    /**
     * 给开发环境数据库 增加system_time字段,其他环境已经加上了
     *
     * @throws IOException
     */
    public void createAddColumn3() throws IOException {
        String tableSuffix = null;
        for (int i = 0; i <= 63; i++) {
            tableSuffix = "" + i;
            while (tableSuffix.length() < 2) {
                tableSuffix = "0" + tableSuffix;
            }
            tableSuffix = "_" + tableSuffix;
            String text = "alter table t_src_order_detail### add COLUMN include_tax_flag TINYINT(4) DEFAULT NULL COMMENT '包税标识: 0不包税 1包税',add COLUMN include_tax_share DOUBLE DEFAULT NULL COMMENT '包税分摊金额';";
            text = text.replaceAll("###", tableSuffix);
            System.out.println(text);
        }
        System.out.println("common_order sql已经生成");
    }

    /**
     * 给开发环境数据库 增加system_time字段,其他环境已经加上了
     *
     * @throws IOException
     */
    public void createAddColumn1() throws IOException {
        List<String> resultList = new ArrayList<>(1100);
        String tableSuffix = null;
        for (int i = 0; i <= 63; i++) {
            tableSuffix = "" + i;
            while (tableSuffix.length() < 2) {
                tableSuffix = "0" + tableSuffix;
            }
            tableSuffix = "_" + tableSuffix;
            String text = "alter table t_common_order### add COLUMN system_time DATETIME DEFAULT NULL COMMENT '系统发货时间' after is_presell;";
            text = text.replaceAll("###", tableSuffix);
            resultList.add(text);
        }
        System.out.println("common_order sql已经生成");

        for (int i = 0; i <= 1023; i++) {
            tableSuffix = "" + i;
            while (tableSuffix.length() < 4) {
                tableSuffix = "0" + tableSuffix;
            }
            tableSuffix = "_" + tableSuffix;
            String text = "alter table t_supplier_order### add COLUMN system_time DATETIME DEFAULT NULL COMMENT '系统发货时间' after is_presell;";
            text = text.replaceAll("###", tableSuffix);
            resultList.add(text);
        }
        System.out.println("supplier_order sql已经生成");

        String fileName = FILES_DIR + "sql" + System.currentTimeMillis() + ".txt";

        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
    }

    public void createAddColumn2() {
        String text = "alter table t_supplier_compensate add COLUMN item_price double DEFAULT NULL COMMENT '商品单价' before create_time,"
                + "add COLUMN qty int(11) DEFAULT NULL COMMENT '审核时间' before create_time;";
    }

    public void modifyColumn() {
        System.out.println("alter table t_supplier_compensate modify COLUMN compensate_one_reason int(11) DEFAULT NULL COMMENT '补偿一级原因';");
        System.out.println("alter table t_supplier_compensate modify COLUMN compensate_two_reason int(11) DEFAULT NULL COMMENT '补偿二级原因';");
    }

    private List<String> createHead(String dbName, String desc, int size) {
//        /***********************************************************************
//         ** 作者：冯涛
//         ** 数据库：yunjioms
//         ** 修改时间：2017.11.30
//         ** 描述：货币备案列头新增 规格
//         ***********************************************************************/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String fileName = FILES_DIR + "(" + dbName + ")" + desc + "_冯涛_" + sdf.format(new Date()) + ".txt";

        List<String> headList = new ArrayList<String>(size + 100);
        headList.add("/***********************************************************************");
        headList.add(" ** 作者：冯涛");
        headList.add(" ** 数据库：" + dbName);
        headList.add(" ** 修改时间：" + sdf.format(new Date()));
        headList.add(" ** 描述：" + desc);
        headList.add(" ***********************************************************************/");
        headList.add("use " + dbName + ";");
        return headList;
    }

    /**
     * 给开发环境数据库 增加system_time字段,其他环境已经加上了
     *
     * @throws IOException
     */
    public void createAddColumn4() throws IOException {
        String dbName = DB_YUNJIOMS;
        String desc = "修改部分货品备案信息的规格";
        List<String> sourceList = FileUtils.readLines(new File("D:/productRecord.txt"), "UTF-8");

        List<String> resultList = createHead(DB_YUNJIOMSORDER, desc, sourceList.size());
        for (String str : sourceList) {
            if (str != null && str.length() != 0) {
                String sql1 = "select count(1),sku,warehouse_no from t_product_customs_record where sku = '#2' and warehouse_no = '#3' \n union all";


                String sql = "update t_product_customs_record set `spec` = #1 where sku = '#2' and warehouse_no = '#3';";
                String[] strArr = str.split("\\t");
                sql = sql.replace("#1", strArr[strArr.length - 1]);
                sql = sql.replace("#2", strArr[0]);
                sql = sql.replace("#3", strArr[1]);

                sql1 = sql1.replace("#2", strArr[0]);
                sql1 = sql1.replace("#3", strArr[1]);
                System.out.println(sql1);

                resultList.add(sql);
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String fileName = FILES_DIR + "(" + dbName + ")" + desc + "_冯涛_" + sdf.format(new Date()) + ".sql";
        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
    }

    /**
     * 给开发环境数据库 增加system_time字段,其他环境已经加上了
     *
     * @throws IOException
     */
    public void fixSql() throws IOException {
        String dbName = DB_YUNJIOMSORDER;
        String desc = "修改数据因精度小数位过长保留两位小数四舍五入";
        List<String> sourceList = FileUtils.readLines(new File("D:/yjmingxi.txt"), "UTF-8");

        List<String> resultList = createHead(dbName, desc, sourceList.size());
        for (String str : sourceList) {
            if (str != null && str.length() != 0) {
                String[] strArr = str.split("\t");
//                System.out.println("##" + strArr[3].substring(strArr[3].indexOf(".")+1));
                if (strArr[3].substring(strArr[3].indexOf(".") + 1).length() > 2) {
                    String sql = "update t_src_order_detail" + strArr[0] + " set total_price = round(total_price,2) where `id` = " + strArr[1] + " and src_order_id = '" + strArr[2] + "';";
                    resultList.add(sql);
                } else {
                    System.out.println(strArr[3]);
                }
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String fileName = FILES_DIR + "(" + dbName + ")" + desc + "_冯涛_" + sdf.format(new Date()) + ".sql";
        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
    }

    /**
     * 给开发环境数据库 增加system_time字段,其他环境已经加上了
     *
     * @throws IOException
     */
    public void fixSql1() throws IOException {
        String dbName = DB_YUNJIOMSORDER;
        String desc = "so_result";
        List<String> sourceList = FileUtils.readLines(new File("D:/so.txt"), "UTF-8");

        List<String> resultList = createHead(dbName, desc, sourceList.size());
        for (String str : sourceList) {
            if (str != null && str.length() != 0) {
                String[] strArr = str.split("\t");
//                System.out.println("##" + strArr[3].substring(strArr[3].indexOf(".")+1));
                if (strArr[2].substring(strArr[2].indexOf(".") + 1).length() > 2) {
                    if (strArr[0].length() == 3) {
                        String sql = "update t_common_order" + strArr[0] + " set item_price = round(item_price,2) where `id` = '" + strArr[1] + "';";
                        resultList.add(sql);
                    } else {
                        String sql = "update t_supplier_order" + strArr[0] + " set item_price = round(item_price,2) where `id` = '" + strArr[1] + "';";
                        resultList.add(sql);
                    }
                }
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String fileName = FILES_DIR + "(" + dbName + ")" + desc + "_冯涛_" + sdf.format(new Date()) + ".sql";
        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
    }

    public void fixSql2() throws IOException {
        String dbName = DB_YUNJIOMSORDER;
        String desc = "sodetail_result";
        List<String> sourceList = FileUtils.readLines(new File("D:/sodetail.txt"), "UTF-8");

        List<String> resultList = createHead(dbName, desc, sourceList.size());
        for (String str : sourceList) {
            if (str != null && str.length() != 0) {
                String[] strArr = str.split("\t");
//                System.out.println("##" + strArr[3].substring(strArr[3].indexOf(".")+1));
                if (strArr[3].substring(strArr[3].indexOf(".") + 1).length() > 2) {
                    if (strArr[0].length() == 3) {
                        String sql = "update t_common_order_detail" + strArr[0] + " set total_price = round(total_price,2) where `id` = " + strArr[1] + " AND order_id = '" + strArr[2] + "';";
                        resultList.add(sql);
                    } else {
                        String sql = "update t_supplier_order_detail" + strArr[0] + " set total_price = round(total_price,2) where `id` = " + strArr[1] + " AND order_id = '" + strArr[2] + "';";
                        resultList.add(sql);
                    }
                }
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String fileName = FILES_DIR + "(" + dbName + ")" + desc + "_冯涛_" + sdf.format(new Date()) + ".sql";
        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
    }

    public void createAddColumnSO() throws IOException {
        String dbName = DB_YUNJIOMSORDER;
        String desc = "修复SO小数就精度";
//    List<String> sourceList = FileUtils.readLines(new File("D:/productRecord.txt"),"UTF-8");

        List<String> resultList = createHead(dbName, desc, 1100);
        for (int i = 0; i <= 63; i++) {
            String tableSuffix = "_";
            if (i <= 9) {
                tableSuffix = tableSuffix + "0" + i;
            } else {
                tableSuffix = tableSuffix + i;
            }
            String sql = "SELECT '" + tableSuffix + "',id,item_price FROM t_common_order" + tableSuffix + " WHERE create_time > '2017-12-26' AND CHAR_LENGTH(CONCAT(item_price,'')) > 6 \n union all";
            resultList.add(sql);
        }

        for (int i = 0; i <= 1023; i++) {
            String tableSuffix = "";
            tableSuffix = tableSuffix + i;
            while (tableSuffix.length() < 4) {
                tableSuffix = "0" + tableSuffix;
            }
            tableSuffix = "_" + tableSuffix;
            String sql = "SELECT '" + tableSuffix + "',id,item_price FROM t_supplier_order" + tableSuffix + " WHERE create_time > '2017-12-26' AND CHAR_LENGTH(CONCAT(item_price,'')) > 6 \n union all";
            resultList.add(sql);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String fileName = FILES_DIR + "(" + dbName + ")" + desc + "_冯涛_" + sdf.format(new Date()) + ".sql";
        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
    }

    public void createAddColumnSODetail() throws IOException {
        String dbName = DB_YUNJIOMSORDER;
        String desc = "修复SO明细小数就精度";
//    List<String> sourceList = FileUtils.readLines(new File("D:/productRecord.txt"),"UTF-8");

        List<String> resultList = createHead(dbName, desc, 1100);
        for (int i = 0; i <= 63; i++) {
            String tableSuffix = "_";
            if (i <= 9) {
                tableSuffix = tableSuffix + "0" + i;
            } else {
                tableSuffix = tableSuffix + i;
            }
            String sql = "SELECT '" + tableSuffix + "',id,order_id,total_price FROM t_common_order_detail" + tableSuffix + " WHERE create_time > '2017-12-26' AND CHAR_LENGTH(CONCAT(total_price,'')) > 6 \n union all";
            resultList.add(sql);
        }

        for (int i = 0; i <= 1023; i++) {
            String tableSuffix = "";
            tableSuffix = tableSuffix + i;
            while (tableSuffix.length() < 4) {
                tableSuffix = "0" + tableSuffix;
            }
            tableSuffix = "_" + tableSuffix;
            String sql = "SELECT '" + tableSuffix + "',id,order_id,total_price FROM t_supplier_order_detail" + tableSuffix + " WHERE create_time > '2017-12-26' AND CHAR_LENGTH(CONCAT(total_price,'')) > 6 \n union all";
            resultList.add(sql);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String fileName = FILES_DIR + "(" + dbName + ")" + desc + "_冯涛_" + sdf.format(new Date()) + ".sql";
        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
    }

    //    SELECT id,item_price FROM t_src_order_00 WHERE CHAR_LENGTH(SUBSTRING_INDEX(CONCAT(total_price,'.'), '.', -2)) > 6;
    public void createAddColumn6() throws IOException {
        String dbName = DB_YUNJIOMSORDER;
        String desc = "查找精度未保留两位小数yj单";
//    List<String> sourceList = FileUtils.readLines(new File("D:/productRecord.txt"),"UTF-8");

        List<String> resultList = createHead(dbName, desc, 100);
        for (int i = 0; i <= 63; i++) {
            String tableSuffix = "_";
            if (i <= 9) {
                tableSuffix = tableSuffix + "0" + i;
            } else {
                tableSuffix = tableSuffix + i;
            }
            String sql = "SELECT '" + tableSuffix + "',id,src_order_id,total_price FROM t_src_order_detail" + tableSuffix + " WHERE create_time > '2017-12-26' AND CHAR_LENGTH(CONCAT(total_price,'')) > 8 \n union all";
            resultList.add(sql);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String fileName = FILES_DIR + "(" + dbName + ")" + desc + "_冯涛_" + sdf.format(new Date()) + ".sql";
        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
    }

    //    SELECT id,item_price FROM t_src_order_00 WHERE CHAR_LENGTH(SUBSTRING_INDEX(CONCAT(total_price,'.'), '.', -2)) > 6;
    public void createAddColumn7() throws IOException {
        String dbName = DB_YUNJIOMSORDER;
        String version = "2018-01-11";
        String realFilesDir = FILES_DIR + version + "/";
        String desc = "设置t_supplier_compensate的compensate_id为主键索引";

        List<String> resultList = createHead(dbName, desc, 100);
//        ALTER TABLE `tablename` DROP PRIMARY KEY ,
//                ADD PRIMARY KEY ( 字段一 )
//                resultList.add("")

        resultList.add("ALTER TABLE t_supplier_compensate DROP INDEX idx_compensate_id,ADD PRIMARY KEY (compensate_id);");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String fileName = realFilesDir + "(" + dbName + ")" + desc + "_冯涛_" + sdf.format(new Date()) + ".sql";
        FileUtils.writeLines(FileUtils.getFile(fileName), "UTF-8", resultList, false);
        System.out.println("输出文件为:" + fileName);
        //生成之后 打开目录
        java.awt.Desktop.getDesktop().open(new File(realFilesDir + ""));
    }
}
