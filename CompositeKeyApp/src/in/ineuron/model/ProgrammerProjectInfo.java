package in.ineuron.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "programmer")
public class ProgrammerProjectInfo {

	@EmbeddedId
	ProjectInfo info;
	private String name;
	private String dept;
	private String pname;

	public ProgrammerProjectInfo(ProjectInfo info, String name, String dept, String pname) {
		this.info = info;
		this.name = name;
		this.dept = dept;
		this.pname = pname;
	}

	public ProjectInfo getInfo() {
		return info;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public String getPname() {
		return pname;
	}

	@Override
	public String toString() {
		return "ProgrammerProjectInfo [info=" + info + ", name=" + name + ", dept=" + dept + ", pname=" + pname + "]";
	}

}
