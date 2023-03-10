package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectInfo implements Serializable {

	@Column(name = "pdid")
	private Integer pgid;
	@Column(name = "pid")
	private Integer pid;

	public ProjectInfo(Integer pgid, Integer pid) {
		this.pgid = pgid;
		this.pid = pid;
		System.out.println("setting values in cons");
	}

	public Integer getPgid() {
		return pgid;
	}

	public Integer getPid() {
		return pid;
	}

	@Override
	public String toString() {
		return "ProjectInfo [pgid=" + pgid + ", pid=" + pid + "]";
	}

}
