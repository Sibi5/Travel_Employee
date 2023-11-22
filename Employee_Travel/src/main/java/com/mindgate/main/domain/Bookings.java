package com.mindgate.main.domain;

import java.sql.Blob;
import java.sql.Time;

public class Bookings {

	private TravelRequests travel_Requests;
	private int bookingId;
	private String hotelName;
	private String hotelLocation;
	private Time checkInTime;
	private Time checkOutTime;
	private String flightTicket;
	private String busTicket;
	private String trainPnr;
	private Blob ticket;
	

//	hotelLocation=connection.createClob();

	public Bookings() {
		// TODO Auto-generated constructor stub
	}


public Bookings(TravelRequests travel_Requests, int bookingId, String hotelName, String hotelLocation, Time checkInTime,
		Time checkOutTime, String flightTicket, String busTicket, String trainPnr, Blob ticket) {
	super();
	this.travel_Requests = travel_Requests;
	this.bookingId = bookingId;
	this.hotelName = hotelName;
	this.hotelLocation = hotelLocation;
	this.checkInTime = checkInTime;
	this.checkOutTime = checkOutTime;
	this.flightTicket = flightTicket;
	this.busTicket = busTicket;
	this.trainPnr = trainPnr;
	this.ticket = ticket;
}


public TravelRequests getTravel_Requests() {
	return travel_Requests;
}


public void setTravel_Requests(TravelRequests travel_Requests) {
	this.travel_Requests = travel_Requests;
}


public int getBookingId() {
	return bookingId;
}


public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}


public String getHotelName() {
	return hotelName;
}


public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}


public String getHotelLocation() {
	return hotelLocation;
}


public void setHotelLocation(String hotelLocation) {
	this.hotelLocation = hotelLocation;
}


public Time getCheckInTime() {
	return checkInTime;
}


public void setCheckInTime(Time checkInTime) {
	this.checkInTime = checkInTime;
}


public Time getCheckOutTime() {
	return checkOutTime;
}


public void setCheckOutTime(Time checkOutTime) {
	this.checkOutTime = checkOutTime;
}


public String getFlightTicket() {
	return flightTicket;
}


public void setFlightTicket(String flightTicket) {
	this.flightTicket = flightTicket;
}


public String getBusTicket() {
	return busTicket;
}


public void setBusTicket(String busTicket) {
	this.busTicket = busTicket;
}


public String getTrainPnr() {
	return trainPnr;
}


public void setTrainPnr(String trainPnr) {
	this.trainPnr = trainPnr;
}


public Blob getTicket() {
	return ticket;
}


public void setTicket(Blob ticket) {
	this.ticket = ticket;
}


@Override
public String toString() {
	return "Bookings [travel_Requests=" + travel_Requests + ", bookingId=" + bookingId + ", hotelName=" + hotelName
			+ ", hotelLocation=" + hotelLocation + ", checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime
			+ ", flightTicket=" + flightTicket + ", busTicket=" + busTicket + ", trainPnr=" + trainPnr + ", ticket="
			+ ticket + "]";
}


	
}
