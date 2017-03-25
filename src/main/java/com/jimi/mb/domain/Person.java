package com.jimi.mb.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 用户实体类
 * @author jimiStephen
 *
 */
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -643950705024094672L;
	
	
	private Integer id;
    private String username;
    private Date birthday;
    
    
    public Person(Integer id,String username,Date birthday){
    	this.id = id;
        this.username =  username;
        this.birthday = birthday;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
