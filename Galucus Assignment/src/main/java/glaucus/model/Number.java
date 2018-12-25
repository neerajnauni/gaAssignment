package glaucus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// POJO class/model where the column and corresponding mapping is defined

@Entity
@Table(name="Number")

public class Number {
	
	@Id
	@GeneratedValue
	Integer id;
	
	@Column(name="number")
	private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
