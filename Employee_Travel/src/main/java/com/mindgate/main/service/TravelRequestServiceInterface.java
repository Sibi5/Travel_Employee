package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.TravelRequests;

public interface TravelRequestServiceInterface {

	public boolean createNewTravelRequest(TravelRequests travel_Requests);
	public TravelRequests updateTravelRequest(TravelRequests travel_Requests);
	public TravelRequests getTravelRequestById(int travelRequestId);
	public List<TravelRequests> getAllTravelRequests();
	public boolean deleteTravelRequestById(int travelRequestId);
	
	public TravelRequests updateRequest(TravelRequests travel_Requests);
	
	 public List<TravelRequests> getTravelRequestByEmployeeId(int employeeId);
	 public List<TravelRequests> getTravelRequestByManagerId(int managerId);
	 
	 public List<TravelRequests>getTravelRequestByManagerApproval(String agentApproval);
}
