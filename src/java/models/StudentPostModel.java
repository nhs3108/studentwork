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
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    public List<StudentPosts> getAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(StudentPosts.class).list();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean delete(StudentPosts sp){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(sp);
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
    public StudentPosts getById(Integer studentId){
        try {
            sf.getCurrentSession().beginTransaction();
            return (StudentPosts)sf.getCurrentSession().get(StudentPosts.class, studentId);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean add(StudentPosts sp){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(sp);
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
