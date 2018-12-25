package glaucus.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import glaucus.config.AppConfig;
import glaucus.dao.DaoFactory;


public class AbstractService {

	public  DaoFactory dao;
	private SessionFactory sessionFactory;
	AppConfig config;
	
	public AbstractService(DaoFactory dao, AppConfig config){
		this.dao = dao;
		this.sessionFactory = config.getSessionFactory();
		this.config  = config;
	}
	
	public Session getSession(){
		Session session = sessionFactory.openSession();
		return session;
	}
	
	public void close(Session session){
		session.close();
	}
}
