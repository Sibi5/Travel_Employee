package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Slab;

public class SlabRowMapper implements RowMapper<Slab> {

	@Override
	public Slab mapRow(ResultSet rs, int rowNum) throws SQLException {
		int slabId = rs.getInt("slab_id");
		String employeeCategory = rs.getString("employee_category");
		double maxBudget = rs.getDouble("max_budget");
		String internationalTravelAllowed = rs.getString("international_travel_allowed");
		String flightTravelAllowed = rs.getString("flight_travel_allowed");
		
		Slab slab = new Slab(slabId, employeeCategory, maxBudget, internationalTravelAllowed, flightTravelAllowed);
		return slab;
	}
	
	

}
