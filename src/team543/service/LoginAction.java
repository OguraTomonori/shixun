package team543.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

 /**
 * 	锟斤拷陆锟斤拷锟斤拷 
 *	锟斤拷锟斤拷锟斤拷锟斤拷锟絬serId password
 *  锟斤拷锟斤拷list
 *  锟斤拷陆锟缴癸拷锟斤拷锟斤拷  0锟斤拷 锟矫伙拷权锟斤拷 锟斤拷 md5锟斤拷锟杰猴拷锟斤拷没锟絠d
 *  锟斤拷陆失锟杰凤拷锟斤拷 1锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟�
 *  		 2锟斤拷没锟叫达拷锟矫伙拷
 */
public class LoginAction {

	
	public static ArrayList login(String userId, String password) {
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			Connection con = team543.utils.DBUtils.getConnection();
			Statement createStatement = con.createStatement();
			String sql = "select user_password,user_root,user_name from t_user where user_id ='"+userId+"';";
			
			//执锟斤拷sql锟斤拷锟�
			ResultSet re = createStatement.executeQuery(sql);
			//锟叫断斤拷锟斤拷锟斤拷欠锟斤拷锟街�
			if(re.next()==true) {
				//锟叫讹拷锟斤拷锟斤拷锟角凤拷锟斤拷锟斤拷锟斤拷确
				if(re.getString("user_password").equals(password)) {
					//锟斤拷锟斤拷锟斤拷确
					list.add(0);      
					list.add(re.getString("user_root"));
					list.add(team543.utils.MyMD5Util.encrypt(userId+re.getString("user_root")));
					list.add(re.getString("user_name"));
				} else list.add(1);
			} else list.add(2);
			//锟截憋拷锟斤拷锟斤拷
			team543.utils.DBUtils.closeConn();
		} catch (ReflectiveOperationException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
