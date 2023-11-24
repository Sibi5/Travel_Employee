package com.mindgate.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mindgate.main.domain.Bookings;
import com.mindgate.main.domain.TravelRequests;
import com.mindgate.main.service.BookingsServiceInterface;

import jakarta.websocket.server.PathParam;

@CrossOrigin("*")
@RestController
@RequestMapping("bookingsapi")
public class BookingsController {
	
	@Autowired
	private BookingsServiceInterface bookingsServiceInterface;
		
	
	//http://localhost:8081/bookingsapi/bookings
	
	@RequestMapping(value="bookings" , method=RequestMethod.POST)
	public boolean addNewBooking(@RequestBody Bookings bookings ) {
		return bookingsServiceInterface.addNewBooking(bookings);
	}
	
	//http://localhost:8081/bookingsapi/bookings
	
	@RequestMapping(value="bookings",method = RequestMethod.PUT)
	public Bookings updateBooking(@RequestBody Bookings bookings) {
		return bookingsServiceInterface.updateBooking(bookings);
	}
	
	//http://localhost:8081/bookingsapi/bookings/20
	
	@RequestMapping(value="bookings/{bookingId}",method = RequestMethod.DELETE)
	public boolean deleteBookingByBookingId(@PathVariable int bookingId) {
		return bookingsServiceInterface.deleteBookingByBookingId(bookingId);
	}
	
	//http://localhost:8081/bookingsapi/bookings/20
	
	@RequestMapping(value="bookings/{bookingId}",method = RequestMethod.GET)
	public Bookings getBookingByBookingId(@PathVariable int bookingId) {
		return bookingsServiceInterface.getBookingByBookingId(bookingId);
	}
	
	//http://localhost:8081/bookingsapi/bookings
	
	@RequestMapping(value="bookings",method = RequestMethod.GET)
	public List<Bookings> getAllBookings(){
		return bookingsServiceInterface.getAllBookings();
	}
	
	
	//http://localhost:8081/bookingsapi/bookingsList/2
		@RequestMapping(value="bookingsList/{employeeId}",method = RequestMethod.GET)
		public List<Bookings> getBookingsByEmployeeId(@PathVariable int employeeId){
			return bookingsServiceInterface.getBookingsByEmployeeId(employeeId);
		}
		
		//http://localhost:8081/bookingsapi/booking/download/
	    @RequestMapping(value="download/{bookingId}")
	    public ResponseEntity<byte[]> getFile(@PathVariable int bookingId){
	    	Bookings bookings=bookingsServiceInterface.getBookingByBookingId(bookingId);
	    	return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION,  "attachment; filename=\"" + bookings.getTravelRequests().getTransportationMode() +"_ticket"+ "\"") 
					.body(bookings.getTicket());
	    }
	    
	  //http://localhost:8081/bookingsapi/bookings/upload
	    @RequestMapping(value="bookings/{bookingId}",method=RequestMethod.POST)
	    public boolean insertFileBookings(@PathParam ("file") MultipartFile file , @PathVariable int bookingId) {
	    	
	    	
	    	Bookings bookings=new Bookings();
	    	bookings.setBookingId(bookingId);
	    	try {
	    		bookings.setTicket(file.getBytes());
			} catch (IOException e) {
				System.out.println("Exception while file upload");
			}
	    	
	    	return bookingsServiceInterface.insertFile(bookings);
	    } 
}
