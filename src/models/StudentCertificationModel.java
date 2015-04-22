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
public class StudentCertificationModel {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    public static final String STUDENT_ID = "studentId"; 
    private List <StudentCertifications> getByProperty(String property, String value){  
        try {
            sf.getCurrentSession().beginTransaction();
            String stringQuery = "from StudentCertifications where "+property+" = :value";
            Query query = sf.getCurrentSession().createQuery(stringQuery);
            query.setString("value", value);
            List<StudentCertifications> result = query.list();
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
    public List <StudentCertifications> getByStudentId(int studentId){  
        return getByProperty(STUDENT_ID, ""+ studentId);
    }
    public List<StudentCertifications> getAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(StudentCertifications.class).list();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean delete(StudentCertifications sc){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(sc);
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
    public StudentCertifications getById(Integer id){
        try {
            sf.getCurrentSession().beginTransaction();
            return (StudentCertifications)sf.getCurrentSession().get(StudentCertifications.class, id);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean add(StudentCertifications sc){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(sc);
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
