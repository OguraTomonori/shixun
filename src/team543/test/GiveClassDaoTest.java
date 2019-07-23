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

		@Test
        public void testUpdateGiveClass()throws ReflectiveOperationException, SQLException{
            GiveClass gc = new GiveClass ();
            gc.setT_site ("math");
            gc.setC_id ("12");
            gc.setT_id ("312312312");
            gc.setC_time ("2019");
            giveClass.updateGiveClass (gc);

        }

        @Test
        public void testAddGiveClass()throws ReflectiveOperationException, SQLException{
            GiveClass gc = new GiveClass ();
            gc.setT_site ("eng");
            gc.setC_id ("add");
            gc.setT_id ("add");
            gc.setC_time ("2018");
            giveClass.addGiveClass (gc);

        }

        @Test
        public void testGetGiveClassById()throws ReflectiveOperationException, SQLException{
            String id = "12";

            List<GiveClass> classList = giveClass.getGiveClassById (id);
            System.out.println (classList);

        }

        @Test
        public void testGetAllGiveClass()throws ReflectiveOperationException, SQLException{
            List<GiveClass> classList = giveClass.getAllGiveClass ();
            System.out.println (classList);
        }


}
