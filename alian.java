package com.jersey.DemoREstFul;

import javax.xml.bind.annotation.XmlRootElement;

//http://localhost:8080/project_name/webapi/alian

@XmlRootElement
public class alian {
  
	
	private String name;
	private int points;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "alian [name=" + name + ", points=" + points + ", id=" + id + "]";
	}
	
	
}
