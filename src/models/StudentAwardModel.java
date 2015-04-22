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
public class StudentAwardModel {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    public static final String STUDENT_ID = "studentId"; 
    private List <StudentAwards> getByProperty(String property, String value){  
        try {
            sf.getCurrentSession().beginTransaction();
            String stringQuery = "from StudentAwards where "+property+" = :value";
            Query query = sf.getCurrentSession().createQuery(stringQuery);
            query.setString("value", value);
            List<StudentAwards> result = query.list();
            return result;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public List <StudentAwards> getByStudentId(int studentId){  
        return getByProperty(STUDENT_ID, ""+ studentId);
    }
    public List<StudentAwards> getAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(StudentAwards.class).list();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean delete(StudentAwards sa){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(sa);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public StudentAwards getById(Integer id){
        try {
            sf.getCurrentSession().beginTransaction();
            return (StudentAwards)sf.getCurrentSession().get(StudentAwards.class, id);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean add(StudentAwards sa){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(sa);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public static void main(String[] args) {
       
    }
}
