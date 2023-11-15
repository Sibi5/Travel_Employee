package com.mindgate.main.service;

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

	@Override
	public TravelRequests updateRequest(TravelRequests travel_Requests) {
		return travelRequestRepository.updateRequest(travel_Requests);
	}

}
