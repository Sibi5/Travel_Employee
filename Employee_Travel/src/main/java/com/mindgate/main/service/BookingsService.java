package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Bookings;
import com.mindgate.main.domain.TravelRequests;
import com.mindgate.main.repository.BookingsRepositoryInterface;

@Service
public class BookingsService implements BookingsServiceInterface {
	
	@Autowired
	private BookingsRepositoryInterface bookingsRepositoryInterface;

	@Override
	public boolean addNewBooking(Bookings bookings) {
		return bookingsRepositoryInterface.addNewBooking(bookings);
	}

	@Override
	public Bookings updateBooking(Bookings bookings) {
		return bookingsRepositoryInterface.updateBooking(bookings);
	}

	@Override
	public boolean deleteBookingByBookingId(int bookingId) {
		return bookingsRepositoryInterface.deleteBookingByBookingId(bookingId);
	}

	@Override
	public Bookings getBookingByBookingId(int bookingId) {
		return bookingsRepositoryInterface.getBookingByBookingId(bookingId);
	}

	@Override
	public List<Bookings> getAllBookings() {
		return bookingsRepositoryInterface.getAllBookings();
	}

	@Override
	public List<Bookings> getBookingsByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return bookingsRepositoryInterface.getBookingsByEmployeeId(employeeId);
	}

	@Override
	public boolean insertFile(Bookings bookings) {
		Bookings bookings2=bookingsRepositoryInterface.getBookingByBookingId(bookings.getBookingId());
		bookings2.setTicket(bookings.getTicket());
		return bookingsRepositoryInterface.insertFile(bookings2);
	}

	@Override
	public Bookings getBookingByTravelRequestId(int travelRequestId) {
		return bookingsRepositoryInterface.getBookingByTravelRequestId(travelRequestId);
	}

}
