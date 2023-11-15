package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Slab;

@Repository
public class SlabRepository implements SlabRepositoryInterface {
	
	private final static String INSERT_NEW_SLAB = "insert into slab values( slab_id_sequence.nextVal,?,?,?,?)";
	private final static String UPDATE_EXISTING_SLAB = "update slab set employee_category=?,max_budget=? , international_travel_allowed=? , flight_travel_allowed=? where slab_id=?";
	private final static String DELETE_EXISTING_SLAB = "delete from slab where slab_id =?";
	private final static String SELECT_ALL_SLAB = "select * from slab";
	private final static String SELECT_ONE_SLAB = "select * from slab where slab_id =?";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addNewSlab(Slab slab) {
		Object[] parameters= {
				//slab.getSlabId(),
				slab.getEmployeeCategory(),
				slab.getMaxBudget(),
				slab.getFlightTravelAllowed(),
				slab.getInternationalTravelAllowed()
				
		};
		jdbcTemplate.update(INSERT_NEW_SLAB, parameters);
		return true;
	}
	

	@Override
	public Slab updateSlab(Slab slab) {
		Object[] parameters = {
				slab.getEmployeeCategory(), 
				slab.getMaxBudget(),
				slab.getInternationalTravelAllowed(),
				slab.getFlightTravelAllowed(),
				slab.getSlabId()
				};
		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_SLAB, parameters);
		if(rowCount > 0){
			return getSlabBySlabId(slab.getSlabId());
		}
		return null;
		
	}
	

	@Override
	public boolean deleteSlab(int slabId) {
		int rowCount = jdbcTemplate.update(DELETE_EXISTING_SLAB, slabId);
		if(rowCount > 0){
			
		return true;
		}
		else
			return false;
		
	}

	@Override
	public Slab getSlabBySlabId(int slabId) {
		
		SlabRowMapper slabRowMapper = new SlabRowMapper();
		Slab slab = jdbcTemplate.queryForObject(SELECT_ONE_SLAB, slabRowMapper, slabId);
		return slab;
		
		
	}

	@Override
	public List<Slab> getAllSlab() {
		SlabRowMapper slabRowMapper = new SlabRowMapper();
		return jdbcTemplate.query(SELECT_ALL_SLAB, slabRowMapper);
		
	}

}
