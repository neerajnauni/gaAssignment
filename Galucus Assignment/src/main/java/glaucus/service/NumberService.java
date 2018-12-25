package glaucus.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import glaucus.config.AppConfig;
import glaucus.dao.DaoFactory;
import glaucus.model.Number;

//service layer/class which implements the business logic of incrementing the number consistently

@Service
public class NumberService extends AbstractService {

	@Autowired
	public NumberService(DaoFactory dao, AppConfig config) {
		super(dao, config);
	}

	//method to read and then update the count of number into the database consistently
	public String increaseAndUpdateNumber() {
		Session session = getSession();
		try {
			synchronized (this) {
				int number = dao.getNumberdao().getNumberCount(session);
				Number numberObj = dao.getNumberdao().getByNumber(session,number);
				
				//begin of transaction
				Transaction numberTx = session.beginTransaction();
				number+=1;
				System.out.println("number is :"+number+" numberObj :"+numberObj);
				numberObj.setNumber(number);
				dao.getNumberdao().update(session, numberObj);
				numberTx.commit();
				//end of transaction
			}
			return "success";
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();	
		}
		return null;
	}
	
}
