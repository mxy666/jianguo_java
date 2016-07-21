package com.jianguo.servlet.pc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jianguo.bean.T_use_Money_Bean;

public class CZ_Excel
{
	/**
	 * @功能：手工构建一个简单格式的Excel
	 */

	@SuppressWarnings("deprecation")
	public static void init(List<T_use_Money_Bean> list2)
	{
		String result="系统提示：Excel文件导出成功！"; 
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("用户结算表");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("业务经手人");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("工作日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("商家");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("电话号码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("应付工资");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("提现金额");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("提现日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("备注");
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List list = null;
		try {
			list = list2;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++)
		{
			row = sheet.createRow((int) i + 1);
			T_use_Money_Bean cz = (T_use_Money_Bean) list.get(i);
			// 第四步，创建单元格，并设置值
			//row.createCell((short) 0).setCellValue(i+1);
			row.createCell((short) 0).setCellValue(cz.getAdmin());		
			row.createCell((short) 1).setCellValue(cz.getWorkDate());
			row.createCell((short) 2).setCellValue(cz.getMerchant());
			row.createCell((short) 3).setCellValue(cz.getName());
			row.createCell((short) 4).setCellValue(cz.getTel());
			row.createCell((short) 5).setCellValue(cz.getHouldMoney());
			row.createCell((short) 6).setCellValue(cz.getMoneyOut());
			row.createCell((short) 7).setCellValue(cz.getMoneyOutDate());
			row.createCell((short) 8).setCellValue(cz.getRemarks());
		}
		// 第六步，将文件存到指定位置
		try
		{
			
			
			FileOutputStream fout = new FileOutputStream("D:/tomcat/webapps/JianGuo_Server/downLoadFile/UseMoney.xls");
			wb.write(fout);
			fout.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}