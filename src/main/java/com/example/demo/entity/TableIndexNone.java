package com.example.demo.entity;//package com.example.demo.entity;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//
//
//@Entity
//@Table(name = "table_index_none")
//public class TableIndexNone implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	
//	private Long id;
//
//	private String name;
//	
//	private int age;
//	
//	private int sex;
//
//	private Date createTime;
//	
//	
//	
//	
//	
//	
//	@Column(name = "name")
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	@Column(name = "age")
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	@Column(name = "sex")
//	public int getSex() {
//		return sex;
//	}
//	public void setSex(int sex) {
//		this.sex = sex;
//	}
//	
//	@Column(name = "create_time")
//	public Date getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//	
//	public TableIndexNone(Long id, String name, int age, int sex, Date createTime) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.sex = sex;
//		this.createTime = createTime;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	
//
//}