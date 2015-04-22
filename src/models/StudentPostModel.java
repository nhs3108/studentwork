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
public class StudentPostModel {
    public static final String STUDENT_ID = "studentId"; 
    private SessionFactory sf = HibernateUtil.getSessionFactory();

    private List<StudentPosts> getByProperty(String property, String value) {
        try {
            sf.getCurrentSession().beginTransaction();
            String stringQuery = "from StudentPosts where " + property + " = :value";
            Query query = sf.getCurrentSession().createQuery(stringQuery);
            query.setString("value", value);
            List<StudentPosts> spList = query.list();
            return spList;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    public List<StudentPosts> getByStudentId(int studentId) {
        return getByProperty(STUDENT_ID, ""+studentId);
    }
    public List<StudentPosts> getAll() {
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(StudentPosts.class).list();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    public boolean delete(StudentPosts sp) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(sp);
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

    public StudentPosts getById(Integer id) {
        try {
            sf.getCurrentSession().beginTransaction();
            return (StudentPosts) sf.getCurrentSession().get(StudentPosts.class, id);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    public boolean add(StudentPosts sp) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(sp);
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
         List<StudentPosts> spl = new StudentPostModel().getAll();
         for(int i = 0; i<spl.size();i++){
            
            System.out.print(spl.get(i).getContent());
        }
    }
    
}
