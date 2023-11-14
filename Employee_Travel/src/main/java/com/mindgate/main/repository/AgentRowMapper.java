package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Agents;

public class AgentRowMapper implements RowMapper<Agents> {

	@Override
	public Agents mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		
		int agentId = rs.getInt("agent_id");
		String agentName = rs.getString("agent_name");
		String agentEmail=rs.getString("email");
        String agentPassword=rs.getString("agent_password");
        String loginStatus=rs.getString("login_status");
        int agentLogincount=rs.getInt("count");
        
        
        
		Agents agents=new Agents(agentId, agentName, agentEmail, agentPassword, loginStatus, agentLogincount);
		
		return agents;
		
		
		
		
	
	}
	
	
	

}
