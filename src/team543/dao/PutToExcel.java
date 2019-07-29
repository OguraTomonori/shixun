package team543.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import team543.entity.Student;

public class PutToExcel {
	public void PutStudent(ArrayList<Student> students , String fileName) throws RowsExceededException, WriteException, IOException {
		
		fileName = fileName+".xls";
		File xlsFile = new File(fileName);
//		File xlsFile = new File("jxl.xls");
		// 创建一个工作簿
		WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
		// 创建一个工作表
		WritableSheet sheet = workbook.createSheet("sheet1", 0);
		// 向行和列中写数据
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				// 向工作表中添加数据
				sheet.addCell(new Label(col, row, "data" + row + col));
				}
			}
			workbook.write();
			workbook.close();
	}
		 
}
