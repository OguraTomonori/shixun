package team543.test;

import  team543.dao.StudentDao;
import team543.entity.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoTest {



    @Test
    public void TestGetStudentByIdDao() throws ReflectiveOperationException, SQLException {
        StudentDao studentDao = new StudentDao ();
        int id = 123;
        Student student = studentDao.getStudentById(id);
        System.out.println (student.toString ());

    }

    @Test
    public void testGetStudents () throws ReflectiveOperationException, SQLException {
        StudentDao studentDao = new StudentDao ();
        List<Student> students = studentDao.getStudents();
        for (int i = 0; i < students.size (); i++) {

            Student student = students.get (i);
            student.toString ();

        }
        System.out.println(students);
    }

    @Test
    public void testUpdateStudent() throws ReflectiveOperationException, SQLException{
        Student a = new Student ();
        a.setS_id ("1212");
        a.setS_name ("b");
        a.setS_sex ("b");
        a.setS_dp ("bb");
        a.setS_major ("b");
        a.setS_class ("121");
        a.setS_state ("c");
        //a.setEntertame (null);
        Student[] s = {a};
        StudentDao.updateStudent (s);
    }

    @Test
    public void testAddStudent() throws ReflectiveOperationException, SQLException{
        StudentDao studentDao = new StudentDao ();
        ArrayList<Student> students = new ArrayList<> ();
        Student a = new Student ();
        a.setS_id ("12555");
        a.setS_name ("b");
        a.setS_sex ("b");
        a.setS_dp ("bb");
        a.setS_major ("b");
        a.setS_class ("12");
        a.setS_state ("c");
        //a.setEntertame (null);

        students.add (a);
        studentDao.addStudent (students);

    }

    @Test
    public void testDeleteStudent() throws ReflectiveOperationException, SQLException{
        int[] id = {2017061226,2017061207};
        StudentDao.deleteStudent (id);
    }


}
	
	

