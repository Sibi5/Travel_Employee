package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Bookings;
import com.mindgate.main.domain.TravelRequests;
import com.mindgate.main.repository.BookingsRepositoryInterface;

@Service
public class BookingsService implements BookingsServiceInterface {
	
	@Autowired
    private JavaMailSender mailSender;
	
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
	
	

	@Override
	public boolean sendMail(int travelRequestId) {
		Bookings bookings=bookingsRepositoryInterface.getBookingByTravelRequestId(travelRequestId);
		
		String msg="your booking has been confirmed,please check your portal for more information";
		try {
		 SimpleMailMessage message = new SimpleMailMessage();
	     	message.setFrom("fromemail@gmail.com");
	        message.setTo(bookings.getTravelRequests().getEmployees().getEmail());
	       
	        message.setText(bookings.getTravelRequests().getEmployees().getEmployeeName());
	        message.setSubject("Bookings Confirmed");
	        mailSender.send(message);
	        return true;
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		
		
	}

}
