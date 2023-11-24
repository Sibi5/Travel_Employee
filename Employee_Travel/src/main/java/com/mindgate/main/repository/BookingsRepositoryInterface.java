package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Bookings;

public interface BookingsRepositoryInterface {
	
	public boolean addNewBooking(Bookings bookings );
	public Bookings updateBooking(Bookings bookings);
	public boolean deleteBookingByBookingId(int bookingId);
	public Bookings getBookingByBookingId(int bookingId);
	public Bookings getBookingByTravelRequestId(int travelRequestId);
	public List<Bookings> getAllBookings();
	public List<Bookings> getBookingsByEmployeeId(int employeeId);
	public boolean insertFile(Bookings bookings2);
}
