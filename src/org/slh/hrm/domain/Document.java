package org.slh.hrm.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
    * @ClassName: Document  
    * @Description: 对应文件pojo  
    * @author Song  
    *
 */
public class Document implements Serializable {
	private int id; // 编号
	private String title; // 标题
	private String fileName; // 文件名
	private MultipartFile file; // 文件
	private String remark; // 描述
	private java.util.Date createDate; // 上传时间
	private User user; // 上传人
	// 无参数构造器

	public Document() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
