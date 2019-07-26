package team543.test;

import java.sql.SQLException;

public class StudentActionTest {
	public void main(String[] args) throws ReflectiveOperationException, SQLException {
		
		System.out.println(team543.service.studentAction.getStudentClass("1"));
	}

}
