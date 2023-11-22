package com.mindgate.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.TravelRequests;
import com.mindgate.main.repository.TravelRequestRepositoryInterface;

@Service
public class TravelRequestService implements TravelRequestServiceInterface {
	
	@Autowired
	private TravelRequestRepositoryInterface travelRequestRepository;

	@Override
	public boolean createNewTravelRequest(TravelRequests travel_Requests) {
		return travelRequestRepository.createNewTravelRequest(travel_Requests);
	}

	@Override
	public TravelRequests updateTravelRequest(TravelRequests travel_Requests) {
		return travelRequestRepository.updateTravelRequest(travel_Requests);
	}

	@Override
	public TravelRequests getTravelRequestById(int travelRequestId) {
		return travelRequestRepository.getTravelRequestById(travelRequestId);
	}

	@Override
	public List<TravelRequests> getAllTravelRequests() {
		return travelRequestRepository.getAllTravelRequests();
	}

	@Override
	public boolean deleteTravelRequestById(int travelRequestId) {
		return travelRequestRepository.deleteTravelRequestById(travelRequestId);
	}

	
	 public List<TravelRequests>  getTravelRequestByEmployeeId(int employeeId) {
		 return travelRequestRepository.getTravelRequestByEmployeeId(employeeId);
	 }

	 @Override
	 public List<TravelRequests> getTravelRequestByManagerId(String managerApproval ,int managerId){
		 List<TravelRequests> allRequests =travelRequestRepository.getAllTravelRequests();
		 List<TravelRequests> requestsForManager = new ArrayList<TravelRequests>();
		 for (TravelRequests travelRequests : allRequests) {
			if(travelRequests.getEmployees().getManagerId() == managerId && travelRequests.getManagerApproval().equalsIgnoreCase(managerApproval)) {
				requestsForManager.add(travelRequests);
			}
		}
		 
		 return requestsForManager;
	 }
	 
	 @Override
	 public List<TravelRequests>getTravelRequestByAgentApproval(String agentApproval){
		 return travelRequestRepository.getTravelRequestByAgentApproval(agentApproval);
	 }
	 
	 @Override
	 public List<TravelRequests> getTravelRequestsForDirector(String directorApproval){
		 return travelRequestRepository.getTravelRequestsForDirector(directorApproval);
	 }

	@Override
	public List<TravelRequests> getRequestsReadyForBooking() {
		return travelRequestRepository.getRequestsReadyForBooking();
	}

	@Override
	public boolean insertFile(TravelRequests travelRequests) {
		return travelRequestRepository.insertFile(travelRequests);
	}
}
