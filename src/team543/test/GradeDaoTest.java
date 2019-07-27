package team543.test;

import org.junit.Test;
import team543.dao.GradeDao;
import team543.entity.Grade;

import java.sql.SQLException;

public class GradeDaoTest {

    GradeDao gradeDao = new GradeDao ();

    @Test
    public void testAddGrade()throws ReflectiveOperationException, SQLException{
        Grade grade = new Grade ();
        grade.setC_id ("123");
        grade.setS_id ("123");
        grade.setG_OrdTimGra ("20");
        grade.setG_ExaPopGra ("80");
        grade.setG_evaluate ("100");
        Grade[] g = {grade};
        gradeDao.addGrade (g);
    }

    @Test
    public void testUpdateGrade() throws ReflectiveOperationException, SQLException{
        Grade grade = new Grade ();
        grade.setC_id ("123");
        grade.setS_id ("123");
        grade.setG_OrdTimGra ("2");
        grade.setG_ExaPopGra ("8");
        grade.setG_evaluate ("10");
        Grade[] g = {grade};
        gradeDao.updateGrade (g);
    }

}
