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
public class StudentLanguageModel {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    public static final String STUDENT_ID = "studentId"; 
    private List <StudentLanguages> getByProperty(String property, String value){  
        try {
            sf.getCurrentSession().beginTransaction();
            String stringQuery = "from StudentLanguages where "+property+" = :value";
            Query query = sf.getCurrentSession().createQuery(stringQuery);
            query.setString("value", value);
            List<StudentLanguages> result = query.list();
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
    public List <StudentLanguages> getByStudentId(int studentId){  
        return getByProperty(STUDENT_ID, ""+ studentId);
    }
    public List<StudentLanguages> getAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(StudentLanguages.class).list();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean delete(StudentLanguages sl){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(sl);
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
    public StudentLanguages getById(Integer id){
        try {
            sf.getCurrentSession().beginTransaction();
            return (StudentLanguages)sf.getCurrentSession().get(StudentLanguages.class, id);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean add(StudentLanguages sl){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(sl);
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
}
