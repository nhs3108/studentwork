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
    public StudentCertifications getById(Integer studentId){
        try {
            sf.getCurrentSession().beginTransaction();
            return (StudentCertifications)sf.getCurrentSession().get(StudentCertifications.class, studentId);
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
