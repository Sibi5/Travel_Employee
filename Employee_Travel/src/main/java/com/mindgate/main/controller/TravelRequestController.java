package com.mindgate.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mindgate.main.domain.TravelRequests;
import com.mindgate.main.service.TravelRequestServiceInterface;


import jakarta.websocket.server.PathParam;

@CrossOrigin("*")
@RestController
@RequestMapping("travelRequests")
public class TravelRequestController {

	@Autowired
	TravelRequestServiceInterface travelRequestService;

	// UPDATE BY ID PARTIAL UPDATE METHOD (STRING CONCATINATION
	// http://localhost:8081/travelRequests/requesttest
	@RequestMapping(value = "requesttest", method = RequestMethod.PUT)
	public TravelRequests updateRequest(@RequestBody TravelRequests requests) {
		return travelRequestService.updateRequest(requests);
	}

	// INSERT BY ID
	// http://localhost:8081/travelRequests/request
	@RequestMapping(value = "request", method = RequestMethod.POST)
	public boolean insertTravelRequestById(@RequestBody TravelRequests requests) {
		return travelRequestService.createNewTravelRequest(requests);
	}

	// UPDATE BY ID
	// http://localhost:8081/travelRequests/request
	@RequestMapping(value = "request", method = RequestMethod.PUT)
	public TravelRequests updateTravelRequestById(@RequestBody TravelRequests requests) {
		return travelRequestService.updateTravelRequest(requests);
	}

	// GET ALL
	// http://localhost:8081/travelRequests/requests
	@RequestMapping(value = "requests", method = RequestMethod.GET)
	public List<TravelRequests> getAllTravelRequests() {
		List<TravelRequests> list = travelRequestService.getAllTravelRequests();
		return list;
	}

	// GET BY ID
	// http://localhost:8081/travelRequests/request/2
	@RequestMapping(value = "request/{travelRequestId}", method = RequestMethod.GET)
	public TravelRequests getTravelRequestById(@PathVariable int travelRequestId) {
		TravelRequests travel_Requests = travelRequestService.getTravelRequestById(travelRequestId);
		return travel_Requests;
	}

	// DELETE BY ID
	// http://localhost:8081/travelRequests/request/2
	@RequestMapping(value = "request/{travelRequestId}", method = RequestMethod.DELETE)
	public boolean deleteTravelRequestById(@PathVariable int travelRequestId) {
		return travelRequestService.deleteTravelRequestById(travelRequestId);
	}
	
	//GET BY EMPLOYEE ID 
    // http://localhost:8081/travelRequests/requestbyemployee/2
    @RequestMapping(value="requestbyemployee/{employeeId}", method=RequestMethod.GET)
    public List<TravelRequests>  getTravelRequestByEmployeeId(@PathVariable int employeeId) {
        return travelRequestService.getTravelRequestByEmployeeId(employeeId);
    }
    
    //GET BY MANAGER ID AND APPROVAL
    // http://localhost:8081/travelRequests/requestsbyemployees/Pending/2
    @RequestMapping(value = "requestsbyemployees/{managerApproval}/{managerId}", method = RequestMethod.GET)
    public List<TravelRequests> getTravelRequestByManagerId(@PathVariable String managerApproval ,@PathVariable int managerId){
    	return travelRequestService.getTravelRequestByManagerId(managerApproval, managerId);
    }
    
    //GET BY AGENT APPROVAL
    //For Agent Page
    //http://localhost:8081/travelRequests/requestbyAgentapproval/agentApproval
    @RequestMapping(value="requestbyAgentapproval/{agentApproval}", method=RequestMethod.GET)
    public List<TravelRequests> getTravelRequestByAgentApproval(@PathVariable String agentApproval){
    	return travelRequestService.getTravelRequestByAgentApproval(agentApproval.toLowerCase());
    }
    
  //GET BY AGENT  REJECTION 
    //For DIRECTOR Page
    //http://localhost:8081/travelRequests/requestbyManagerapproval/agentApproval
    @RequestMapping(value="requestbyManagerapproval/{directorApproval}", method=RequestMethod.GET)
    public List<TravelRequests> getTravelRequestsForDirector(@PathVariable String directorApproval){
    	return travelRequestService.getTravelRequestsForDirector(directorApproval.toLowerCase());
    }
    
    
    //http://localhost:8081/travelRequests/readyForBooking
    @RequestMapping(value="readyForBooking", method=RequestMethod.GET)
    public List<TravelRequests> getRequestsReadyForBooking(){
    	return travelRequestService.getRequestsReadyForBooking();
    }
    
    
  //http://localhost:8081/travelRequests/upload
    @RequestMapping(value="upload/{travelRequestId}",method=RequestMethod.POST)
    public boolean insertFile(@PathParam ("file") MultipartFile file , @PathVariable int travelRequestId) {
    	
    	TravelRequests travelRequests=travelRequestService.getTravelRequestById(travelRequestId);
    	try {
			travelRequests.setDocument(file.getBytes());
		} catch (IOException e) {
			System.out.println("Exception while file upload");
		}
    	
    	return travelRequestService.insertFile(travelRequests);
    } 
    
//    //http://localhost:8081/travelRequests/upload
//    @RequestMapping(value="upload/{travelRequestId}",method=RequestMethod.POST)
//    public TravelRequests insertFile(@PathParam ("file") MultipartFile file , @PathVariable int travelRequestId) {
//    	
//    	TravelRequests travelRequests=travelRequestService.getTravelRequestById(travelRequestId);
//    	try {
//			travelRequests.setDocument(file.getBytes());
//		} catch (IOException e) {
//			System.out.println("Exception while file upload");
//		}
//    	
//    	return travelRequestService.updateTravelRequest(travelRequests);
//    } 
}
