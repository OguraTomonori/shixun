package team543.service;

import java.sql.SQLException;
import java.util.ArrayList;

import team543.dao.*;
import team543.entity.ElectiveClass;
import team543.entity.Student;

public class studentAction {
	StudentDao studentDao = new StudentDao();
	/**
	 * ��ȡѧ����Ϣ
	 * @return
	 * @throws SQLException
	 * @throws ReflectiveOperationException 
	 */
	public  Student getStudentInfo(String id) throws ReflectiveOperationException, SQLException {
		//�ж�id�Ƿ�Ϊ����
		if(team543.utils.Basic.isNumeric(id)) {
			return studentDao.getStudentById(id);
		}else {
			return null;
		}
	}
	
	/**
	 * ��ȡѧ��ѡ����Ϣ
	 * @param c_id
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public static ArrayList<team543.entity.Class> getStudentClass(String c_id) throws ReflectiveOperationException, SQLException{
		ElectiveClassDao electiveClassDao = new ElectiveClassDao();
		ClassDao classDao = new ClassDao();
		//��������ѧ��ѡ�εĿγ�id���б�
		ArrayList<String> list = new ArrayList<String>();
		
		ArrayList<ElectiveClass> ec = new ArrayList<ElectiveClass>();
		
		ec = electiveClassDao.getClassId(c_id);
		//���ú�����ȡ
//		System.out.println(ec.get(0).getC_id());
//		String str = "1" ; 
		for(int i = 0 ; i < ec.size() ; i++) {

			list.add(ec.get(i).getC_id());
		
		}
		//��������γ���Ϣ���б�
		ArrayList<team543.entity.Class> cl = new ArrayList<team543.entity.Class>();
		
//		System.out.println(list);
		//��ѧ��ѡ�γ̵�id
		for(int i = 0 ; i<list.size();i++) {
			//��ѯ�γ���Ϣ
			cl.add(classDao.getClassById(list.get(i)));
		}
		return cl;
	}

	/**
	 * ��ȡѧ���ɼ��б�
	 * @param s_id
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<String> getGrade(String s_id) throws ReflectiveOperationException, SQLException{
		
		return null;
	}

}
