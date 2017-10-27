package com.ft;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SqlCreatorTemp {
	/**
	 * 删除common_order_detail_xx 的 rule_id brand_id
	 */
	public static void func1(){
		for(int i = 0;i <= 63 ;i++){
			String text = "alter table t_common_order_detail_xx DROP COLUMN rule_id,"
					+ "DROP COLUMN brand_id;";
			String content = "";
			if(i < 10){
				content = "0" + i;
			}else{
				content = content + i;
			}
			text = text.replace("xx", content);
			System.out.println(text);
		}
	}
	
	/**
	 * 删除t_common_order_xx is_own_warehouse字段
	 * presell_time字段
	 */
	public static void func3(){
		for(int i = 0;i <= 63 ;i++){
			String text = "alter table t_common_order_xx DROP COLUMN is_own_warehouse,"
					+ "DROP COLUMN presell_time;";
			String content = "";
			if(i < 10){
				content = "0" + i;
			}else{
				content = content + i;
			}
			text = text.replace("xx", content);
			System.out.println(text);
		}
	}	
	
	/**
	 * 删除supplier_order_detail_xx 的 rule_id brand_id
	 */
	public static void func2(){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(new File("d:/test.txt")));
			bw.write("");
			bw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i <= 1023 ;i++){
			String text = "alter table t_supplier_order_detail_xxxx DROP COLUMN rule_id,"
					+ "DROP COLUMN brand_id;";
			
			String content = "";
			content = content + i;
			while(content.length() < 4){
				content = 0 + content;
			}
			text = text.replace("xxxx", content);
			try {
				bw.write(text + "\r\n");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(text);
		}	
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除t_supplier_order_xxxx is_own_warehouse字段
	 * presell_time字段
	 */
	public static void func4(){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(new File("d:/test.txt")));
			bw.write("");
			bw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i <= 1023 ;i++){
			String text = "alter table t_supplier_order_xxxx DROP COLUMN is_own_warehouse,"
					+ "DROP COLUMN presell_time;";
			
			String content = "";
			content = content + i;
			while(content.length() < 4){
				content = 0 + content;
			}
			text = text.replace("xxxx", content);
			try {
				bw.write(text + "\r\n");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(text);
		}	
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 给t_common_order_xx 添加system_time字段
	 */
	public static void func5(){
		for(int i = 0;i <=63 ;i++){
		String text = "alter table t_common_order_xx add COLUMN system_time DATETIME DEFAULT NULL COMMENT '系统发货时间';";
		String content = "";
		if(i < 10){
			content = "0" + i;
		}else{
			content = content + i;
		}
		text = text.replace("xx", content);
		System.out.println(text);
	}
	}
	
	
	public static void func9(){
		for(int i = 0;i <=63 ;i++){
//			alter table test1 modify column field_name int comment '修改后的字段注释';
		String text = "alter table t_common_order_xx modify COLUMN error_type TINYINT(4) DEFAULT NULL COMMENT '报错类型 0正常  1下传仓库失败 2同步平台发货失败 3系统异常 4超时未发货 5其他 6报关失败';";
		String content = "";
		if(i < 10){
			content = "0" + i;
		}else{
			content = content + i;
		}
		text = text.replace("xx", content);
		System.out.println(text);
	}
	}	
	
	public static void func10(){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(new File("d:/test.txt")));
			bw.write("");
			bw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i <= 1023 ;i++){
			String text = "alter table t_supplier_order_xxxx modify COLUMN error_type TINYINT(4) DEFAULT NULL COMMENT '报错类型 0正常  1下传仓库失败 2同步平台发货失败 3系统异常 4超时未发货 5其他 6报关失败';";
			
			String content = "";
			content = content + i;
			while(content.length() < 4){
				content = 0 + content;
			}
			text = text.replace("xxxx", content);
			try {
				bw.write(text + "\r\n");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(text);
		}	
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void func7(){
		for(int i = 0;i <=63 ;i++){
		String text = "alter table t_common_order_xx add COLUMN audit_name VARCHAR(50) DEFAULT NULL COMMENT '审核人',"
				+"add COLUMN audit_time DATETIME DEFAULT NULL COMMENT '审核时间';";
		String content = "";
		if(i < 10){
			content = "0" + i;
		}else{
			content = content + i;
		}
		text = text.replace("xx", content);
		System.out.println(text);
	}
	}	
	
	public static void func6(){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(new File("d:/test.txt")));
			bw.write("");
			bw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i <= 1023 ;i++){
			String text = "alter table t_supplier_order_xxxx add COLUMN system_time DATETIME DEFAULT NULL COMMENT '系统发货时间';";
			
			String content = "";
			content = content + i;
			while(content.length() < 4){
				content = 0 + content;
			}
			text = text.replace("xxxx", content);
			try {
				bw.write(text + "\r\n");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(text);
		}	
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void func8(){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(new File("d:/test.txt")));
			bw.write("");
			bw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i <= 1023 ;i++){
			String text = "alter table t_supplier_order_xxxx add COLUMN audit_name VARCHAR(50) DEFAULT NULL COMMENT '审核人',"
					+"add COLUMN audit_time DATETIME DEFAULT NULL COMMENT '审核时间';";
			
			String content = "";
			content = content + i;
			while(content.length() < 4){
				content = 0 + content;
			}
			text = text.replace("xxxx", content);
			try {
				bw.write(text + "\r\n");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(text);
		}	
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		SqlCreator.func1();

//		alter table user add (COLUMN new2 VARCHAR(20) NOT NULL)
		
		//common_order
//		for(int i = 0;i <=63 ;i++){
//			String text = "alter table t_common_order_xx add COLUMN warehouse_code VARCHAR(50) DEFAULT NULL COMMENT '仓库编码',"
//					+ "add COLUMN `source` TINYINT(4) DEFAULT NULL COMMENT '订单来源 0云集平台、1补发、2业务测试、3数字专柜',"
//					+ "add COLUMN `sign` TINYINT(4) DEFAULT NULL COMMENT '标记',"
//					+ "add COLUMN error_type TINYINT(4) DEFAULT NULL COMMENT '报错类型 0报关失败 1下传仓库失败 2同步平台发货失败 3系统异常 4超时未发货 5其他',"
//					+ "add COLUMN error_message VARCHAR(200) DEFAULT NULL COMMENT '报错信息',"
//					+ "add COLUMN is_presell TINYINT(4) DEFAULT NULL COMMENT '是否预售 0否 1是';";
//			String content = "";
//			if(i < 10){
//				content = "0" + i;
//			}else{
//				content = content + i;
//			}
//			text = text.replace("xx", content);
//			System.out.println(text);
//		}
		
//		for(int i = 0;i <=63 ;i++){
////			change t_name t_name_new varchar(20);	
//			
//		String text = "alter table t_common_order_xx change warehouse_code warehouse_code VARCHAR(50) DEFAULT NULL COMMENT '仓库编码',"
//				+ "change is_ownWarehouse is_ownWarehouse TINYINT(4) DEFAULT NULL COMMENT '是否是自营仓 0：自营仓，1：代销仓',"
//				+ "change error_type error_type TINYINT(4) DEFAULT NULL COMMENT '报错类型 0报关失败 1下传仓库失败 2同步平台发货失败 3系统异常 4超时未发货 5其他',"
//				+ "change error_message error_message VARCHAR(200) DEFAULT NULL COMMENT '报错信息',"
//				+ "change auto_split_flag auto_split_flag TINYINT(4) DEFAULT 1 COMMENT '是否需要自动审核  0否 1是',"
//				+ "change is_presell is_presell TINYINT(4) DEFAULT NULL COMMENT '是否预售 0否 1是',"
//				+ "change presell_time presell_time DATETIME DEFAULT NULL COMMENT '预计发货时间';";
//		
//		String content = "";
//		if(i < 10){
//			content = "0" + i;
//		}else{
//			content = content + i;
//		}
//		text = text.replace("xx", content);
//		System.out.println(text);
//	}		
		
		
		//common_order_detail
//		for(int i = 0;i <=63 ;i++){
//			String text = "alter table t_common_order_detail_xx add COLUMN brand_id int(11) DEFAULT NULL COMMENT '品牌id',"
//					+ "add COLUMN `rule_id` int(11) DEFAULT NULL COMMENT '分类id',"
//					+ "add COLUMN is_presell TINYINT(4) DEFAULT NULL COMMENT '是否预售 0否 1是',"
//					+ "add COLUMN presell_type VARCHAR(255) DEFAULT NULL COMMENT '预售类型 交易平台直接传字符串过来',"
//					+ "add COLUMN presell_time DATETIME DEFAULT NULL COMMENT '预计发货时间';";
//			
//			String content = "";
//			if(i < 10){
//				content = "0" + i;
//			}else{
//				content = content + i;
//			}
//			text = text.replace("xx", content);
//			System.out.println(text);
//		}
		
		
//		BufferedWriter bw = null;
//		try {
//			bw = new BufferedWriter(new FileWriter(new File("d:/test.txt")));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for(int i = 0;i <= 1023 ;i++){	
//			
//			String text = "alter table t_supplier_order_xxxx add COLUMN warehouse_code VARCHAR(50) DEFAULT NULL COMMENT '仓库编码',"
//					+ "add COLUMN `source` TINYINT(4) DEFAULT NULL COMMENT '订单来源 0云集平台、1补发、2业务测试、3数字专柜',"
//					+ "add COLUMN is_own_warehouse TINYINT(4) DEFAULT NULL COMMENT '是否是自营仓 0：自营仓，1：代销仓',"
//					+ "add COLUMN sign TINYINT(4) DEFAULT NULL COMMENT '标记',"
//					+ "add COLUMN error_type TINYINT(4) DEFAULT NULL COMMENT '报错类型 0报关失败 1下传仓库失败 2同步平台发货失败 3系统异常 4超时未发货 5其他',"
//					+ "add COLUMN error_message VARCHAR(200) DEFAULT NULL COMMENT '报错信息',"
//					+ "add COLUMN auto_audit_flag TINYINT(4) DEFAULT 1 COMMENT '是否需要自动审核  0否 1是',"
//					+ "add COLUMN is_presell TINYINT(4) DEFAULT NULL COMMENT '是否预售 0否 1是',"
//					+ "add COLUMN presell_time DATETIME DEFAULT NULL COMMENT '预计发货时间';";
//			
//			String content = "";
//			content = content + i;
//			while(content.length() < 4){
//				content = 0 + content;
//			}
//			text = text.replace("xxxx", content);
//			try {
//				bw.write(text + "\r\n");
//				bw.flush();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(text);
//		}	
//		try {
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//supplier_order
//		BufferedWriter bw = null;
//		try {
//			bw = new BufferedWriter(new FileWriter(new File("d:/test.txt")));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for(int i = 0;i <= 1023 ;i++){
//			String text = "alter table t_supplier_order_xxxx add COLUMN warehouse_code VARCHAR(50) DEFAULT NULL COMMENT '仓库编码',"
//					+ "add COLUMN `source` TINYINT(4) DEFAULT NULL COMMENT '订单来源 0云集平台、1补发、2业务测试、3数字专柜',"
//					+ "add COLUMN `sign` TINYINT(4) DEFAULT NULL COMMENT '标记',"
//					+ "add COLUMN error_type TINYINT(4) DEFAULT NULL COMMENT '报错类型 0报关失败 1下传仓库失败 2同步平台发货失败 3系统异常 4超时未发货 5其他',"
//					+ "add COLUMN error_message VARCHAR(200) DEFAULT NULL COMMENT '报错信息',"
//					+ "add COLUMN is_presell TINYINT(4) DEFAULT NULL COMMENT '是否预售 0否 1是';";
//			
//			String content = "";
//			content = content + i;
//			while(content.length() < 4){
//				content = 0 + content;
//			}
//			text = text.replace("xxxx", content);
//			try {
//				bw.write(text + "\r\n");
//				bw.flush();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(text);
//		}	
//		try {
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//supplier_order_detail
//		BufferedWriter bw = null;
//		try {
//			bw = new BufferedWriter(new FileWriter(new File("d:/test.txt")));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for(int i = 0;i <= 1023 ;i++){
//			String text = "alter table t_supplier_order_detail_xxxx add COLUMN brand_id int(11) DEFAULT NULL COMMENT '品牌id',"
//					+ "add COLUMN `rule_id` int(11) DEFAULT NULL COMMENT '分类id',"
//					+ "add COLUMN is_presell TINYINT(4) DEFAULT NULL COMMENT '是否预售 0否 1是',"
//					+ "add COLUMN presell_type VARCHAR(255) DEFAULT NULL COMMENT '预售类型 交易平台直接传字符串过来',"
//					+ "add COLUMN presell_time DATETIME DEFAULT NULL COMMENT '预计发货时间';";
//			
//			String content = "";
//			content = content + i;
//			while(content.length() < 4){
//				content = 0 + content;
//			}
//			text = text.replace("xxxx", content);
//			try {
//				bw.write(text + "\r\n");
//				bw.flush();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(text);
//		}	
//		try {
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
