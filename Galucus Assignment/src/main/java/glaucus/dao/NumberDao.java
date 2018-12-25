package glaucus.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import glaucus.model.Number;

// DAO Layer
// Dao class for model Number where methods are defined for performing operations in the database

@Repository
public class NumberDao extends Dao<Number>{

	public int getNumberCount(Session session) {
		Criteria cr = session.createCriteria(Number.class);
		int maxCount = (int) cr.setProjection(Projections.property("number")).uniqueResult();
		return maxCount;
	}

	public Number getByNumber(Session session, int number) {
		Criteria cr = session.createCriteria(Number.class);
		cr.add(Restrictions.eq("number", number));
		Number numberObj = (Number)cr.uniqueResult();
		return numberObj;
	}
	
}
