package com.yunji.ft.FixStatus;

import org.junit.Test;

/**
 * @author mask
 * @date 2017/11/9 15:10
 * @desc
 */
public class FixStatusTool {
    private String getCommonOrderSuffix(String orderId){
        long routeValue = Math.abs(orderId.hashCode());
        long index = routeValue%64;
        String format = "%0"+("_00".length()-1)+"d";
        return "_"+String.format(format, index);
    }

    @Test
    public void test() throws Exception {
        String orderIdsStr = "SO1711092656202463809,SO1711093535502481542,SO1711096999502481548,SO1711095556702472694,SO1711094796102467733,SO1711093021902470710,SO1711095783702459832,SO1711097862802513133,SO1711093141102457877,SO1711093212702470708,SO1711095875402509188,SO1711092105802499307,SO1711091785302457871,";
        String updateSQL = "UPDATE t_common_order### SET `status` = 10 WHERE `id` = '@@@'";
        for (String orderId : orderIdsStr.split(",")) {
            String tableSuffix = getCommonOrderSuffix(orderId);
            System.out.println(updateSQL.replaceAll("###",tableSuffix).replaceAll("@@@",orderId));
        }
    }
}
