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
public class StudentProjectModel {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    public List<StudentProjects> getAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(StudentProjects.class).list();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean delete(StudentProjects sp){
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
    public StudentProjects getById(Integer studentId){
        try {
            sf.getCurrentSession().beginTransaction();
            return (StudentProjects)sf.getCurrentSession().get(StudentProjects.class, studentId);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean add(StudentProjects sp){
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
