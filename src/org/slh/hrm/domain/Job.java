package org.slh.hrm.domain;

import java.io.Serializable;

/**
 * 
    * @ClassName: Job  
    * @Description: 对应职位类pojo
    * @author Song  
    *
 */
public class Job implements Serializable {
	private Integer id;			// id
	private String name;		// 职位名称
	private String remark;		// 详细描述
	// 无参数构造器
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
