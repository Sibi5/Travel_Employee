package com.mindgate.main.repository;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Bookings;
import com.mindgate.main.domain.Employees;
import com.mindgate.main.domain.Slab;
import com.mindgate.main.domain.TravelRequests;

public class BookingsRowMapper implements RowMapper<Bookings>{

	@Override
	public Bookings mapRow(ResultSet rs, int rowNum) throws SQLException {
		//For Slab
        int slabId = rs.getInt("slab_id");
        String employeeCategory = rs.getString("employee_category");
        double maxBudget = rs.getDouble("max_budget");
        String internationalTravelAllowed = rs.getString("international_travel_allowed");
        String flightTravelAllowed = rs.getString("flight_travel_allowed");

        Slab slab = new Slab(slabId, employeeCategory, maxBudget, internationalTravelAllowed, flightTravelAllowed);

        // For Employee object
        int employeeId = rs.getInt("employee_id");
        String employeeName = rs.getString("employee_name");
        String role = rs.getString("role");
        int managerId = rs.getInt("manager_id");
        String projectName = rs.getString("project_name");
        String email = rs.getNString("email");
        String employeePassword = rs.getString("employee_password");
        String loginStatus = rs.getString("login_status");
        int count = rs.getInt("count");

        Employees employees = new Employees(employeeId, employeeName, role, managerId, slab, projectName, email,
                employeePassword, loginStatus, count);
        
        int travelRequestId = rs.getInt("travel_request_id");
        String boardingPoint = rs.getString("boarding_point");
        String destination = rs.getString("destination");
        Date fromDate = rs.getDate("from_date");
        Date toDate = rs.getDate("to_date");
        String managerApproval = rs.getString("manager_approval");
        String agentApproval = rs.getString("agent_approval");
        String directorApproval = rs.getString("director_approval");
        double estimate = rs.getDouble("estimate");
        Blob aadhar = rs.getBlob("aadhar");
        if(aadhar==null || aadhar.length()<=0)
        	aadhar=null;
        Blob passport = rs.getBlob("passport");
        if(passport==null|| passport.length()<=0)
        	passport=null;
        String documentStatus = rs.getString("document_status");
        Timestamp createdAt = rs.getTimestamp("created_at");
        Timestamp updatedAt = rs.getTimestamp("updated_at");
		String requestedtransportationMode = rs.getString("transportation_mode");

        
		TravelRequests travel_Requests = new TravelRequests(travelRequestId, employees, boardingPoint, destination, fromDate, toDate, managerApproval, agentApproval, directorApproval, requestedtransportationMode, estimate, aadhar, passport, documentStatus, createdAt, updatedAt);
		
		int bookingId=rs.getInt("booking_id");
		String hotelName=rs.getString("hotel_name");
		String hotelLocation=rs.getString("hotel_location");
		Time checkInTime=rs.getTime("check_in_time");
		Time checkOutTime=rs.getTime("check_out_time");
		String transportationMode=rs.getString("transportation_mode");
		String busTicket=rs.getString("bus_ticket");
		String flightTicket=rs.getString("flight_ticket");
		String trainPnr=rs.getString("train_pnr");
		Blob ticket=rs.getBlob("ticket");
		double forex=rs.getDouble("forex");
		
		if(ticket==null || ticket.length()<=0)
			ticket=null;
		Bookings bookings=new Bookings(travel_Requests, bookingId, hotelName, hotelLocation, checkInTime, checkOutTime, transportationMode, flightTicket, busTicket, trainPnr, ticket, forex);
		
		return bookings;
	}

}
