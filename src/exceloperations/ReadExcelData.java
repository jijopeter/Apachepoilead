package exceloperations;

import lib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args) {
		ExcelDataConfig excel=new ExcelDataConfig("D:\\data files\\datadrivendata3.xlsx");
		System.out.println(excel.getData(1, 0, 1));

	}

}
