package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Agents;

public interface AgentServiceInterface {
	public boolean addNewAgent(Agents agent);
	public Agents updateAgent(Agents agent);
	public boolean deleteAgent(int AgentId);
	public Agents getAgentByAgentId(int AgentID);
	public List<Agents>getAllAgent();
	public Agents Login(Agents agents);

	
}
