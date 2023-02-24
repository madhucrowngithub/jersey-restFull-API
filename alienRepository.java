package com.jersey.DemoREstFul;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

//TODO: need to implement this logic here

import org.apache.tomcat.util.http.ContentType;



public class alienRepository {
	
	private static final Logger log= Logger.getLogger(alienRepository.class.getName());
   public static Gson gson = new Gson();
	 public Connection con =null ;
	 
	public alienRepository() {
		 String url ="jdbc:mysql://localhost:3303/jersey_connection";
			String usr ="root";
			String pwd ="Madhu@02";
			try {
				log.info("connecting to database..  ..  ..");
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection(url,usr,pwd);
				log.info("DataBase is cannected Successfully..");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
	 public List<alian> getAlians()throws Exception {
		List<alian>  ls = new ArrayList<>();
		System.out.println("calling get method...");
		log.info("calling get method...");
		 
			String sql ="select * from emp";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			log.info("reading Data base");
			
			while(rs.next()) {
			alian a= new alian();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				System.out.println(a);
				ls.add(a);
			}
			log.info("got response as:{}");
		return ls;
	}
	 
	 public alian getAlien(int id) {
		 alian a= new alian();
		 String sql ="select * from emp where id="+id;
		 Statement st;
		try {
			st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 
			 if(rs.next()) {
					a.setId(rs.getInt(1));
					a.setName(rs.getString(2));
					a.setPoints(rs.getInt(3));
					System.out.println(a);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return a ;
	 }
	 
	public void createAlien( alian as) {
		 
		String qsl ="insert into emp values (?,?,?)";
		try {
			System.out.println("createAlien method calling....");
			PreparedStatement st =con.prepareStatement(qsl);
			st.setInt(1, as.getId());
			st.setString(2, as.getName());
			st.setInt(3, as.getPoints());
			st.executeUpdate();
			System.out.println("Data succesfully updated");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void updateAlienData(alian as) {
		String sql ="update emp set name=? where id=?";
	   System.out.println("update method calling..");
	   try {
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, as.getName());
		st.setInt(2, as.getId());
		
		st.executeUpdate();
		System.out.println("data updated in DB");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void killAlies(int id) {
		String sql ="delete from emp where id="+id;
		
	   try {
		Statement st = con.createStatement();
		st.execute(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	}
}


