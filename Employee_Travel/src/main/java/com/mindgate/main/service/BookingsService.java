package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Bookings;
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

}
