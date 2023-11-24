package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Bookings;

public interface BookingsServiceInterface {
	public boolean addNewBooking(Bookings bookings );
	public Bookings updateBooking(Bookings bookings);
	public boolean deleteBookingByBookingId(int bookingId);
	public Bookings getBookingByBookingId(int bookingId);
	public List<Bookings> getAllBookings();
	public List<Bookings> getBookingsByEmployeeId(int employeeId);
	
	public Bookings getBookingByTravelRequestId(int travelRequestId);
	public boolean insertFile(Bookings bookings);
	public boolean sendMail(int travelRequestId);
}
