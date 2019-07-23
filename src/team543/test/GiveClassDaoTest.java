package team543.test;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

<<<<<<< HEAD
import dao.*;
import entity.GiveClass;
=======
import team543.dao.*;
import team543.entity.GiveClass;
>>>>>>> 714e94c69eb11df8764314c862088b9c7c34a96e

public class GiveClassDaoTest {
	
		static GiveClassDao giveclass =new GiveClassDao();
		
		public static  void test() throws ReflectiveOperationException, SQLException {
		
		}
		public static void main(String[] args) throws ReflectiveOperationException, SQLException {
			List<GiveClass> gc = giveclass.getAllGiveClass();
			System.out.println(gc);
		}

}
