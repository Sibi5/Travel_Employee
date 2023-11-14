package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Agents;
import com.mindgate.main.domain.Employees;

public interface AgentRepositoryInterface {
	public boolean addNewAgent(Agents agent);
	public Agents updateAgent(Agents agent);
	public boolean deleteAgent(int AgentId);
	public Agents getAgentByAgentId(int AgentID);
	public List<Agents>getAllAgent();
	public Agents updateAgentCount(Agents agents);
	public Agents getAgentByAgentMail(String agentEmail);
//	 public Agents resetAgentCount(Agents agents);
	
}
