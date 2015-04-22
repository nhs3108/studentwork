package models;

import entities.*;

import org.hibernate.*;

import java.util.*;

/**
 *
 * @author HongSon
 */
public class MessageModel {
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	public static final String OWNER_ID = "ownerId";
	public static final String SENDER_ID = "senderId";
	public static final String STATUS = "status";
	public static final int HAVE_SEEN = 1;
	public static final int NOT_HAVE_SEEN = 0;
	
	private List<Messages> getByProperty(String property, String value) {
		try {
			sf.getCurrentSession().beginTransaction();
			String stringQuery = "from Messages where " + property
					+ " = :value order by sendTime desc";
			Query query = sf.getCurrentSession().createQuery(stringQuery);
			query.setString("value", value);
			List<Messages> result = query.list();
			return result;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}
	public List<Integer> getSenderList(int ownerId){
		try {
			sf.getCurrentSession().beginTransaction();
			String stringQuery = "select distinct "+SENDER_ID+" from Messages where "+OWNER_ID+" = :ownerId order by sendTime desc";
			Query query = sf.getCurrentSession().createQuery(stringQuery);
			query.setInteger("ownerId", ownerId);
			List<Integer> msgList = query.list();
			//List<Integer> senderIdList = new ArrayList<Integer>();
			return msgList;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}
	public List<Messages> getByOwnerId(int ownerId) {
		return getByProperty(OWNER_ID, "" + ownerId);
	}

	public List<Messages> getBySenderId(int senderId) {
		return getByProperty(SENDER_ID, "" + senderId);
	}
	
	public List<Messages> getUnread(int ownerId) {
		List<Messages> unreadList = new ArrayList<Messages>();
		List<Messages> allMessages = getByOwnerId(ownerId);
		int i = 0;
		for (Messages messages : allMessages) {
			if (messages.getStatus() != HAVE_SEEN){
				unreadList.add(messages);
			}
			i++;
		}
		return unreadList;
	}
	public List<Messages> getReadAlready(int ownerId) {
		List<Messages> unreadList = new ArrayList<Messages>();
		List<Messages> allMessages = getByOwnerId(ownerId);
		int i = 0;
		for (Messages messages : allMessages) {
			if (messages.getStatus() == HAVE_SEEN){
				unreadList.add(messages);
			}
			i++;
		}
		return unreadList;
	}
	public int getNumberOfUnread(int ownerId) {
		List<Messages> unreadList = new MessageModel().getUnread(ownerId);
		return unreadList==null?0:unreadList.size();
	}
	public List<Messages> getByOwnerAndSender(int ownerId, int senderId) {
		try {
			sf.getCurrentSession().beginTransaction();
			String stringQuery = "from Messages where " + OWNER_ID
					+ " = :ownerId and " + SENDER_ID + " = :senderId or "+ SENDER_ID
					+ " = :ownerId and " + OWNER_ID +" = :senderId order by sendTime asc";
			Query query = sf.getCurrentSession().createQuery(stringQuery);
			query.setInteger("ownerId", ownerId);
			query.setInteger("senderId", senderId);
			List<Messages> result = query.list();
			return result;
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public List<Messages> getAll() {
		try {
			sf.getCurrentSession().beginTransaction();
			return sf.getCurrentSession().createCriteria(Messages.class).list();
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public boolean delete(Messages messages) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(messages);
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

	public Messages getById(Integer id) {
		try {
			sf.getCurrentSession().beginTransaction();
			return (Messages) sf.getCurrentSession().get(Messages.class, id);
		} catch (Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			sf.getCurrentSession().close();
		}
	}

	public boolean add(Messages messages) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().saveOrUpdate(messages);
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

	public static void main(String[] args) {
		List<Integer> userList = new MessageModel().getSenderList(1);
		for (int u : userList) {
			System.out.println(u);
		}
	}
}
