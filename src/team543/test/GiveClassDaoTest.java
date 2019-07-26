package team543.test;
import org.junit.Test;
import team543.dao.GiveClassDao;
import team543.entity.GiveClass;

import java.sql.SQLException;
import java.util.ArrayList;

public class GiveClassDaoTest {
	
		static GiveClassDao giveclass =new GiveClassDao();
		
		@Test
		public static void main(String[] args) throws ReflectiveOperationException, SQLException {
			ArrayList<GiveClass> gc = giveclass.getAllGiveClass();
			System.out.println(gc);
		}

}
