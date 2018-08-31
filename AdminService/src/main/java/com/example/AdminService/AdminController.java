package com.example.AdminService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
class AdminController {
	
	@Autowired
	private AdminService service;
	
	//localhost:9022/ValidateAdmin/admin/admin
	@GetMapping("/validateAdmin/{username}/{password}")
	public Boolean validate(@PathVariable("username") String username, @PathVariable("password") String password) {
		if(username.equals("admin")&&password.equals("admin")) return true;
		else return false;
		
	}
		
		
	
	
	
	@PostMapping("/api/Match")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Match create(@RequestBody Match match) {
		
		service.create(match.getId(), match.getDate(),match.getTiming(), match.getStadium(), match.getTeamAName(), match.getTeamBName());
		
		return match;
		
	}
	
	
	@PutMapping("/api/update")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Match update(@RequestBody  Match item) {

		
		

		service.update(item.getId(), item.getDate(),item.getTiming(), item.getStadium(), item.getTeamAName(), item.getTeamBName());
		
		return item;
		
		
	}
	
	
	/*@GetMapping("/api/Match/{id}")
	public Match getMatch(@PathVariable("id") int id) {
		
		return service.getId(id);
		
	}*/
	
	@GetMapping("/api/Match")
	public List<Match> getMatchs() {
		return service.getAll();
	}
	
	@DeleteMapping("/api/delete")
	public List<Match> deleteProd(@RequestBody Match match){
		service.delete(match.getId());
		return service.getAll();
	}

}
