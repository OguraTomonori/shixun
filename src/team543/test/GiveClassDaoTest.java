package team543.test;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import team543.dao.GiveClassDao;
import team543.entity.GiveClass;

public class GiveClassDaoTest {

		GiveClassDao giveClass =new GiveClassDao();

        @Test
		public void testDeleteGiveClass() throws ReflectiveOperationException, SQLException {
            String id="1";
            giveClass.deleteGiveClass (id);
		}

}
