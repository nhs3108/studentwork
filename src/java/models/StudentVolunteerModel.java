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
public class StudentVolunteerModel {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    public List<StudentSkills> getAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(StudentSkills.class).list();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    private List <StudentVolunteers> getByProperty(String property, String value){  
        try {
            sf.getCurrentSession().beginTransaction();
            String stringQuery = "from StudentVolunteers where "+property+" = :value";
            Query query = sf.getCurrentSession().createQuery(stringQuery);
            query.setString("value", value);
            List<StudentVolunteers> svList = query.list();
            return svList;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public List <StudentVolunteers> getByStudentId(String value){  
        return getByProperty("studentId", value);
    } 
    
    public boolean delete(StudentSkills ss){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(ss);
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
    public StudentSkills getById(Integer studentId){
        try {
            sf.getCurrentSession().beginTransaction();
            return (StudentSkills)sf.getCurrentSession().get(StudentSkills.class, studentId);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean add(StudentSkills ss){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(ss);
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
//    public static void main(String a[]){
//        StudentVolunteerModel sm = new StudentVolunteerModel();
//        List<StudentVolunteers> sv = sm.getByStudentId("0");
//        for(StudentVolunteers s:sv){
//            System.out.println(s.getOrganization());
//        }
//    }
}
