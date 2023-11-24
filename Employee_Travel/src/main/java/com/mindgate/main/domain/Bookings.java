package com.mindgate.main.domain;

import java.sql.Blob;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;

public class Bookings {

	private TravelRequests travelRequests;
	private int bookingId;
	private String hotelName;
	private String hotelLocation;
	private String checkInTime;
	private String checkOutTime;
	private String flightTicket;
	private String busTicket;
	private String trainPnr;
	private byte[] ticket;

//	hotelLocation=connection.createClob();

	public Bookings() {
		// TODO Auto-generated constructor stub
	}

	public Bookings(TravelRequests travelRequests, int bookingId, String hotelName, String hotelLocation,
			String checkInTime, String checkOutTime, String flightTicket, String busTicket, String trainPnr,
			byte[] ticket) {
		super();
		this.travelRequests = travelRequests;
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

	public TravelRequests getTravelRequests() {
		return travelRequests;
	}

	public void setTravelRequests(TravelRequests travelRequests) {
		this.travelRequests = travelRequests;
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

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
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

	public byte[] getTicket() {
		return ticket;
	}

	public void setTicket(byte[] ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Bookings [travelRequests=" + travelRequests + ", bookingId=" + bookingId + ", hotelName=" + hotelName
				+ ", hotelLocation=" + hotelLocation + ", checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime
				+ ", flightTicket=" + flightTicket + ", busTicket=" + busTicket + ", trainPnr=" + trainPnr + ", ticket="
				+ Arrays.toString(ticket) + "]";
	}
	

}
