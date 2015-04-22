package models;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import entities.Relationships;
import entities.Users;

public class RelationshipModel {
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	public static final String USER1_ID = "user1Id";
	public static final String USER2_ID = "user2Id";
	public static final String STATUS = "status";
	public static final int USER1_REQUEST_USER2 = 0;
	public static final int BE_FRIEND = 1;
	/*
	 * 1: be friend
	 * 0: not friend
	 */
	private List<Relationships> getByProperty(String property, String value) {
		try {
			sf.getCurrentSession().beginTransaction();
			String stringQuery = "from Relationships where " + property
					+ " = :value";
			Query query = sf.getCurrentSession().createQuery(stringQuery);
			query.setString("value", value);
			List<Relationships> result = query.list();
			return result;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public List<Relationships> getRelationships(int user2Id, int status) {
		try {
			sf.getCurrentSession().beginTransaction();
			String stringQuery = "from Relationships where " + USER2_ID
					+ " = :user2Id and " + STATUS + " = :status or " + USER1_ID
					+ " = :user2Id and " + STATUS + " = :status";
			Query query = sf.getCurrentSession().createQuery(stringQuery);
			query.setInteger("user2Id", user2Id);
			query.setInteger("status", status);
			List<Relationships> result = query.list();
			return result;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}
	public Relationships getRelationship(int user1Id, int user2Id) {
		try {
			sf.getCurrentSession().beginTransaction();
			String stringQuery = "from Relationships where " + USER1_ID
					+ " = :user1Id and " + USER2_ID + " = :user2Id";
			Query query = sf.getCurrentSession().createQuery(stringQuery);
			query.setInteger("user1Id", user1Id);
			query.setInteger("user2Id", user2Id);
			List<Relationships> result = query.list();
			return result.size()==0?null:result.get(0);
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}
	public ArrayList<Integer> getFriends(int user2Id) {
		List<Relationships> relList = getRelationships(user2Id, BE_FRIEND);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (Relationships rel : relList) {
			System.out.println(rel.getuser1Id() + " " + rel.getuser2Id());
			if(rel.getuser1Id()==user2Id){
				result.add(rel.getuser2Id());
			}else{
				result.add(rel.getuser1Id());
			}
		}
		result.add(user2Id);
		return result;
	}

	public ArrayList<Integer> getFriendRequests(int user2Id) {
		List<Relationships> relList = getRelationships(user2Id, USER1_REQUEST_USER2);
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (Relationships rel : relList) {
			if(rel.getuser1Id()==user2Id){
				result.add(rel.getuser2Id());
			}else{
				result.add(rel.getuser1Id());
			}
		}
		return result;
	}
	
	public List<Relationships> getAll() {
		try {
			sf.getCurrentSession().beginTransaction();
			return sf.getCurrentSession().createCriteria(Relationships.class)
					.list();
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public boolean delete(Relationships relationship) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(relationship);
			sf.getCurrentSession().getTransaction().commit();
			return true;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public Relationships getById(Integer id) {
		try {
			sf.getCurrentSession().beginTransaction();
			return (Relationships) sf.getCurrentSession().get(
					Relationships.class, id);
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public boolean add(Relationships relationship) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().saveOrUpdate(relationship);
			sf.getCurrentSession().getTransaction().commit();
			return true;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			sf.getCurrentSession().close();
		}
	}
	public int getNumberRequest(int userId2){
		return getFriendRequests(userId2).size();
	}
	private void makeRequest(int user1Id, int user2Id){
		Relationships rel = new Relationships(user1Id, user2Id, USER1_REQUEST_USER2);
		new RelationshipModel().add(rel);
	}
	private void setBeFriend(Relationships relationship){
		relationship.setStatus(BE_FRIEND);
		new RelationshipModel().add(relationship);
	}
	/**
	 * Trả về trạng thái của mối quan hệ 2 người dùng
	 * - Giá trị trả về là 1 nếu là bạn
	 * - Giá trị trả về là 0 nếu người 1 gửi yêu cầu kết bạn cho người 2
	 * - Giá trị tra về là -1 nếu người 1 chưa gửi yêu cầu kết bạn cho người 2
	 *
	 * @param  user1Id  id của người gửi yêu cầu
	 * @param  user2Id  id của người nhận yêu cầu
	 * @return      
	 * - Giá trị trả về là 1 nếu là bạn
	 * - Giá trị trả về là 2nếu người 2 gửi yêu cầu kết bạn cho người 1
	 * - Giá trị trả về là 0 nếu người 1 gửi yêu cầu kết bạn cho người 2
	 * - Giá trị tra về là -1 nếu người 1 chưa gửi yêu cầu kết bạn cho người 2
	 */
	public int getStatusOfRel(int user1Id, int user2Id){
		Relationships rel12 = new RelationshipModel().getRelationship(user1Id, user2Id);
		Relationships rel21 = new RelationshipModel().getRelationship(user2Id, user1Id);
		if(rel12!=null){
			return rel12.getStatus();
		}else{
			if(rel21!=null){
				if(rel21.getStatus()==BE_FRIEND){
					return 1;
				}else return 2;
			}
			else return -1;
		}
	}
	public void makeFriend(int user1Id,int user2Id) {
		List<Relationships> relList = new RelationshipModel().getAll();
		System.out.println(relList.size());
		for (Relationships rel : relList) {
			System.out.println(rel.getuser1Id() + " " + rel.getuser2Id());
			if (rel.getuser1Id() == user1Id && rel.getuser2Id() == user2Id || rel.getuser1Id() == user2Id && rel.getuser2Id() == user1Id) {
				if(rel.getStatus() == USER1_REQUEST_USER2){
					System.out.print("eo hieu");
					new RelationshipModel().setBeFriend(rel);
					return;
				}else{ // BE FRIEND
					// DO NOTHING
					System.out.print("Vi sao");
					return;
				}
			}
		}
		new RelationshipModel().makeRequest(user1Id, user2Id);
	}
	
	public static void main(String[] args) {
		List<Integer> friendList = new RelationshipModel().getFriendRequests(1);
		System.out.print(friendList);
	}

}
