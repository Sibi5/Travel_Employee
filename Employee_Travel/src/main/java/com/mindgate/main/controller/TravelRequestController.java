package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.TravelRequests;
import com.mindgate.main.service.TravelRequestServiceInterface;

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

}
