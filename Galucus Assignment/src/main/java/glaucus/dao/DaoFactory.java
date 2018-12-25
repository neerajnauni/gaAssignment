package glaucus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// Factory class to implement factory class pattern

@Repository
public class DaoFactory {

	@Autowired
	NumberDao numberdao;

	public NumberDao getNumberdao() {
		return numberdao;
	}

	public void setNumberdao(NumberDao numberdao) {
		this.numberdao = numberdao;
	}

}
