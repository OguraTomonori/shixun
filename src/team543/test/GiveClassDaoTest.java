package team543.test;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;


import team543.dao.*;
import team543.entity.*;

public class GiveClassDaoTest {
	
		static GiveClassDao giveclass =new GiveClassDao();
		
		public static  void test() throws ReflectiveOperationException, SQLException {
		
		}
		public static void main(String[] args) throws ReflectiveOperationException, SQLException {
			List<GiveClass> gc = giveclass.getAllGiveClass();
			System.out.println(gc);
		}

}
