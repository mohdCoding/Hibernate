package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bike_db")
public class Bike {

	@Id
	@Column(name="number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer number;
	@Column(name="name")
	private String name;
	@Column(name="cost")
	private Integer cost;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		System.out.println("Bike.setNumber()");
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Bike.setName()");
		this.name = name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		System.out.println("Bike.setCost()");
		this.cost = cost;
	}

	public String toString() {
		return "Bike [number=" + number + ", name=" + name + ", cost=" + cost + "]";
	}

}
