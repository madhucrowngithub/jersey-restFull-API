package com.jersey.DemoREstFul;



import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("alian")
public class alienResource {
 
	static alienRepository res = new alienRepository();
	
	@Path("get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	static public List<alian> getAliens() throws Exception {
		System.out.println("this method is calling...");
		return res.getAlians();
	}
	
	@Path("getid/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public alian getId(@PathParam("id") int id) {
		System.out.println("calling..>..>..>.....<..<..<..");
		return res.getAlien(id);
	}
	
	@POST
	@Path("send")
	@Consumes(MediaType.APPLICATION_JSON)
	public  alian createAlien(alian as) {
		System.out.println("Sendurl calling");
		res.createAlien(as);
		
		return as;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public alian updateAlien(alian as) {
		System.out.println("updating data");
     
		 res.updateAlienData(as);
		 return as;
	}
   
	@DELETE
	@Path("del/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public alian killAlien(@PathParam("id") int id) {
		alian a = res.getAlien(id);
		res.killAlies(id);
		return a;
	}
	
	
	
}
