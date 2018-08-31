package com.example.AdminService;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//@Document(collection="Teams")
public class Teams {

	//@Id
	//private int teamId;
	private String teamCode;
	private String teamName;
	//private String teamDescription;
	
	public Teams() {
		
	}

	public Teams( String teamCode, String teamName) {
		
		this.teamCode = teamCode;
		this.teamName = teamName;
	
	}

	/*public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
*/
	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/*public String getTeamDescription() {
		return teamDescription;
	}

	public void setTeamDescription(String teamDescription) {
		this.teamDescription = teamDescription;
	}
	*/
	
}
