/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.*;

import org.hibernate.*;

import java.util.*;

/**
 *
 * @author HongSon
 */
public class StudentBasicModel {
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	private List<StudentBasic> getByProperty(String property, String value) {
		try {
			sf.getCurrentSession().beginTransaction();
			String stringQuery = "from StudentBasic where " + property
					+ " = :value";
			Query query = sf.getCurrentSession().createQuery(stringQuery);
			query.setString("value", value);
			List<StudentBasic> sbList = query.list();
			return sbList;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public List<StudentBasic> getByStudentId(int studentId) {
		return getByProperty("studentId", "" + studentId);
	}

	public List<StudentBasic> getAll() {
		try {
			sf.getCurrentSession().beginTransaction();
			return sf.getCurrentSession().createCriteria(StudentBasic.class)
					.list();
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public boolean delete(StudentBasic sb) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(sb);
			sf.getCurrentSession().getTransaction().commit();
			return true;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public StudentBasic getById(Integer id) {
		try {
			sf.getCurrentSession().beginTransaction();
			return (StudentBasic) sf.getCurrentSession().get(
					StudentBasic.class, id);
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public boolean add(StudentBasic sb) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().saveOrUpdate(sb);
			sf.getCurrentSession().getTransaction().commit();
			return true;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public static void main(String[] args) {
		Users user = new UserModel().getByUsername("nhs3108").get(0);
		new StudentBasicModel().add(new StudentBasic(user.getId(), new Date(),
				"", "", 0, "", "", "", ""));
	}
}
