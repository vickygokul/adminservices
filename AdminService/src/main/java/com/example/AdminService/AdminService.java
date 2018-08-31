package com.example.AdminService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo repo;
	
	/*public Admin validate(String username, String password) {
		Admin obj=repo.findByUsernameAndPassword(username, password);
		return obj;
	}*/
/*	public Boolean  validate(Admin admin) {
		Admin admin2 = repo.findByUsername(admin.getUsername());
		try {
		if(admin.getPassword().equals(admin2.getPassword())) {
			return true;
		}
		
	}catch(Exception e) {
		
	}
	return false;
}*/
	@Autowired
	private MatchRepo mrepo;
	
	private static AtomicInteger counter = new AtomicInteger();

	public static int nextValue() {
        return counter.getAndIncrement();
    }

  
	
	public Match create(int id, String date, String timing, String stadium,String teamAName, String teamBName) {
		id = nextValue()+1;
		return mrepo.save(new Match(id,date, timing, stadium,teamAName,teamBName));
	}

	public List<Match> getAll(){
		return mrepo.findAll();
		
	}
	
	/*public Matches getById(int id) {
		Matches m= repo.findByMatchId(id);
		return m;
	}*/
	
	public Match update(int id,String date, String timing, String stadium,String teamAName, String teamBName) {
		Match p=mrepo.findByid(id);
		

		
		p.setDate(date);
		p.setTiming(timing);
		p.setStadium(stadium);

		p.setTeamAName(teamAName);
		p.setTeamBName(teamBName);
		return mrepo.save(p);
		
	}
	
	public void delete(int id) {
		Match p= mrepo.findByid(id);
		mrepo.delete(p);
		
		
		
	}
}
