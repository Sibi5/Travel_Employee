package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Slab;
import com.mindgate.main.service.SlabServiceInterface;

@RestController
@RequestMapping("slabapi")
public class SlabController {
	
	@Autowired
	private SlabServiceInterface slabServiceInterface;
	
	//http://localhost:8081/slabapi/slab
	
	@RequestMapping(value="slab", method = RequestMethod.GET)
	public List<Slab> getAllSlab(){
		return slabServiceInterface.getAllSlab();
	}
	
	//http://localhost:8081/slabapi/slab/add
	
	@RequestMapping(value="slab/add",method = RequestMethod.POST)
	public boolean addNewSlab(@RequestBody Slab slab) {
		return slabServiceInterface.addNewSlab(slab);
	}
	
	//http://localhost:8081/slabapi/slab/update
	
	@RequestMapping(value="slab/update", method = RequestMethod.PUT)
	public Slab updateSlab(@RequestBody Slab slab) {
		return slabServiceInterface.updateSlab(slab);
		
	}
	
	//http://localhost:8081/slabapi/slab/2
	
	@RequestMapping(value="slab/{slabId}", method = RequestMethod.GET)
	public Slab getOneSlab(@PathVariable int slabId){
		return slabServiceInterface.getSlabBySlabId(slabId);
	}
	
	//http://localhost:8081/slabapi/slab/2
	
	@RequestMapping(value="slab/{slabId}", method = RequestMethod.DELETE)
	public boolean deleteSlab(@PathVariable int slabId){
		return slabServiceInterface.deleteSlab(slabId);
	}
	
	

}
