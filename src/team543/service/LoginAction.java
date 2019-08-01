package team543.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

 /**
 * 	��½���� 
 *	���������userId password
 *  ����list
 *  ��½�ɹ�����  0�� �û�Ȩ�� �� md5���ܺ���û�id
 *  ��½ʧ�ܷ��� 1���û��������
 *  		 2��û�д��û�
 */
public class LoginAction {

	
	public static ArrayList login(String userId, String password) {
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			Connection con = team543.utils.DBUtils.getConnection();
			Statement createStatement = con.createStatement();
			String sql = "select user_password,user_root,user_name from t_user where user_id ='"+userId+"';";
			
			//ִ��sql���
			ResultSet re = createStatement.executeQuery(sql);
			//�жϽ�����Ƿ���ֵ
			if(re.next()==true) {
				//�ж������Ƿ�������ȷ
				if(re.getString("user_password").equals(password)) {
					//������ȷ
					list.add(0);      
					list.add(re.getString("user_root"));
					list.add(team543.utils.MyMD5Util.encrypt(userId+re.getString("user_root")));
					list.add(re.getString("user_name"));
				} else list.add(1);
			} else list.add(2);
			//�ر�����
			team543.utils.DBUtils.closeConn();
		} catch (ReflectiveOperationException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
