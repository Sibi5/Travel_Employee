package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.TravelRequests;

public interface TravelRequestRepositoryInterface {

	public boolean createNewTravelRequest(TravelRequests travel_Requests);
	public TravelRequests updateTravelRequest(TravelRequests travel_Requests);
	public TravelRequests getTravelRequestById(int travelRequestId);
	public List<TravelRequests> getAllTravelRequests();
	public boolean deleteTravelRequestById(int travelRequestId);
	

	
	 public List<TravelRequests>  getTravelRequestByEmployeeId(int employeeId);
	 
	 public List<TravelRequests>getTravelRequestByAgentApproval(String agentApproval);
	 
	 public List<TravelRequests>getTravelRequestsForDirector(String directorApproval);
	 
	 public List<TravelRequests>getRequestsReadyForBooking();
	 
	 public boolean insertFile(TravelRequests travelRequests);
	 
	 
	 
}