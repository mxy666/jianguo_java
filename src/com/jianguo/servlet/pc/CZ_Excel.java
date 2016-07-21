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
	 * @���ܣ��ֹ�����һ���򵥸�ʽ��Excel
	 */

	@SuppressWarnings("deprecation")
	public static void init(List<T_use_Money_Bean> list2)
	{
		String result="ϵͳ��ʾ��Excel�ļ������ɹ���"; 
		// ��һ��������һ��webbook����Ӧһ��Excel�ļ�
		HSSFWorkbook wb = new HSSFWorkbook();
		// �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
		HSSFSheet sheet = wb.createSheet("�û������");
		// ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
		HSSFRow row = sheet.createRow((int) 0);
		// ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("ҵ������");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("��������");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("�̼�");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("����");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("�绰����");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("Ӧ������");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("���ֽ��");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("��������");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("��ע");
		cell.setCellStyle(style);

		// ���岽��д��ʵ������ ʵ��Ӧ������Щ���ݴ����ݿ�õ���
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
			// ���Ĳ���������Ԫ�񣬲�����ֵ
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
		// �����������ļ��浽ָ��λ��
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