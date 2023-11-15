package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Slab;
import com.mindgate.main.repository.SlabRepositoryInterface;

@Service
public class SlabService implements SlabServiceInterface {
	
	@Autowired
	SlabRepositoryInterface slabRepositoryInterface;

	@Override
	public boolean addNewSlab(Slab slab) {
		
		return slabRepositoryInterface.addNewSlab(slab);
	}

	@Override
	public Slab updateSlab(Slab slab) {
		
		return slabRepositoryInterface.updateSlab(slab);
	}

	@Override
	public boolean deleteSlab(int slabId) {
		
		return slabRepositoryInterface.deleteSlab(slabId);
	}

	@Override
	public Slab getSlabBySlabId(int slabId) {
		return slabRepositoryInterface.getSlabBySlabId(slabId);
	}

	@Override
	public List<Slab> getAllSlab() {
		return slabRepositoryInterface.getAllSlab();
	}
	
	

}
