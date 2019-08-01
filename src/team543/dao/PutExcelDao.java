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
import team543.entity.Class;
import team543.entity.Student;

public class PutExcelDao {
	
	/**
	 * 设置标题框
	 * @param workbook
	 * @param sheet
	 * @param name
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws IOException
	 */
	public void setTitle(WritableWorkbook workbook,WritableSheet sheet,String[] name) throws RowsExceededException, WriteException, IOException {
		int i = 0;
		for (String n :name) {
			sheet.addCell(new Label(i, 0, n));
			i++;
		}
	}
	/**
	 * 学生excel
	 * @param students
	 * @param fileName
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws IOException
	 */
	public void putStudent( ArrayList<Student> students , String fileName) throws RowsExceededException, WriteException, IOException {
		//文件名
		fileName ="excel/Student/"+ fileName+".xls";
		File xlsFile = new File(fileName);
	
		WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
		WritableSheet sheet = workbook.createSheet("sheet1", 0);
		//设置表头信息
		String[] name = {"学生id","学生姓名","性别",	"院系","学院","班级","状态","入学时间"};
		setTitle(workbook,sheet, name);
		//
		int col = 1;
		for (Student s:students) {
			sheet.addCell(new Label(0, col, s.getS_id()));
			sheet.addCell(new Label(1, col, s.getS_name()));
			sheet.addCell(new Label(2, col, s.getS_sex()));
			sheet.addCell(new Label(3, col, s.getS_dp()));
			sheet.addCell(new Label(4, col, s.getS_major()));
			sheet.addCell(new Label(5, col, s.getS_class()));
			sheet.addCell(new Label(6, col, s.getS_state()));
			sheet.addCell(new Label(7, col, s.getEntertime()));
			col++;
		}
		workbook.write();
		workbook.close();
	}
	
	/**
	 * 课程excel
	 * @param cs
	 * @param fileName
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public void putClass(ArrayList<team543.entity.Class> cs ,String fileName) throws IOException, RowsExceededException, WriteException {
		fileName ="excel/Class/"+ fileName+".xls";
		File xlsFile = new File(fileName);
		
		WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
		WritableSheet sheet = workbook.createSheet("sheet1", 0);
		
		String[] name = {"课程编号","课程名称","课程状态",	"学分","开课院系/学院"};
		setTitle(workbook,sheet, name);
		int col = 1;
		for (Class c:cs) {
			sheet.addCell(new Label(0, col, c.getC_id()));
			sheet.addCell(new Label(1, col, c.getC_name()));
			sheet.addCell(new Label(2, col, c.getC_classstate()));
			sheet.addCell(new Label(3, col, c.getC_score()));
			sheet.addCell(new Label(4, col, c.getC_opendp()));
			col++;
		}
		workbook.write();
		workbook.close();
	}
}
