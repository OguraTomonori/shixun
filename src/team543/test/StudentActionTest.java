package team543.test;

import java.sql.SQLException;

public class StudentActionTest {
	public void main(String[] args) throws ReflectiveOperationException, SQLException {
		
		System.out.println(new team543.service.StudentAction().getStudentClass("1"));
	}

}
