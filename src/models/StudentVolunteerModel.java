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
    public List<StudentVolunteers> getAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(StudentVolunteers.class).list();
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
    public List <StudentVolunteers> getByStudentId(int studentId){  
        return getByProperty("studentId", ""+studentId);
    } 
    
    public boolean delete(StudentVolunteers sv){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(sv);
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
    public StudentVolunteers getById(Integer id){
        try {
            sf.getCurrentSession().beginTransaction();
            return (StudentVolunteers)sf.getCurrentSession().get(StudentVolunteers.class, id);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean add(StudentVolunteers ss){
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
