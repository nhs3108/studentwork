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
public class UserModel {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private List <Users> getByProperty(String property, String value){  
        try {
            sf.getCurrentSession().beginTransaction();
            String stringQuery = "from Users where "+property+" = :value";
            Query query = sf.getCurrentSession().createQuery(stringQuery);
            query.setString("value", value);
            List<Users> userList = query.list();
            return userList;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public List <Users> getByUsername(String username){  
        return getByProperty("username", username);
    }
    public List<Users> getAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Users.class).list();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean delete(Users user){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(user);
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
    public Users getById(Integer id){
        try {
            sf.getCurrentSession().beginTransaction();
            return (Users)sf.getCurrentSession().get(Users.class, id);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean add(Users user){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(user);
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
//    public static void main(String[] args) {
//        UserModel um = new UserModel();
//        um.delete(um.getById(1));
//    }
}
