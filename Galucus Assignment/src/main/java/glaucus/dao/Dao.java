package glaucus.dao;

import javax.sql.DataSource;
import org.hibernate.Session;
import org.springframework.stereotype.Component;


@Component
public class Dao<T>{
	
	protected DataSource dataSource;
		
	public Dao(){
	}

	
   public T update(Session session , T t) {
	   session.update(t);
	   return t;
   }
	
   	
}
