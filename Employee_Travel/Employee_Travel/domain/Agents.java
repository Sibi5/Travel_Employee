package com.mindgate.main.domain;

public class Agents {

	private int agentId;
	private String agentName;
	private String agentEmail;
	private String agentPassword;
	private String loginStatus;
	private int agentLogincount;
	
	
	public Agents(int agentId, String agentName, String agentEmail, String agentPassword, String loginStatus,
			int agentLogincount) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.agentEmail = agentEmail;
		this.agentPassword = agentPassword;
		this.loginStatus = loginStatus;
		this.agentLogincount = agentLogincount;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentEmail() {
		return agentEmail;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	public String getAgentPassword() {
		return agentPassword;
	}

	public void setAgentPassword(String agentPassword) {
		this.agentPassword = agentPassword;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public int getAgentLogincount() {
		return agentLogincount;
	}

	public void setAgentLogincount(int agentLogincount) {
		this.agentLogincount = agentLogincount;
	}

	@Override
	public String toString() {
		return "Agents [agentId=" + agentId + ", agentName=" + agentName + ", agentEmail=" + agentEmail
				+ ", agentPassword=" + agentPassword + ", loginStatus=" + loginStatus + ", agentLogincount="
				+ agentLogincount + "]";
	}
	
	
	
}
