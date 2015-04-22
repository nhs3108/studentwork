package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import entities.Comments;;

public class CommentModel {
	private SessionFactory sf = HibernateUtil.getSessionFactory();
    public static final String USER_ID = "userId";
    public static final String POST_ID = "postId";
    private List <Comments> getByProperty(String property, String value){  
        try {
            sf.getCurrentSession().beginTransaction();
            String stringQuery = "from Comments where "+property+" = :value";
            Query query = sf.getCurrentSession().createQuery(stringQuery);
            query.setString("value", value);
            List<Comments> result = query.list();
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
    public List <Comments> getByUserId(int userId){  
        return getByProperty(USER_ID, ""+ userId);
    }
    public List <Comments> getByPostId(int postId){  
        return getByProperty(POST_ID, ""+ postId);
    }
    public List<Comments> getAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Comments.class).list();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean delete(Comments cmt){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(cmt);
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
    public Comments getById(Integer id){
        try {
            sf.getCurrentSession().beginTransaction();
            return (Comments)sf.getCurrentSession().get(Comments.class, id);
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{
            sf.getCurrentSession().close();
        }
    }
    public boolean add(Comments sc){
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
    public static void main(String a[]){
    	
    }
}
