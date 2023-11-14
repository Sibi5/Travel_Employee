package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Bookings;

@Repository
public class BookingsRepository implements BookingsRepositoryInterface{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String INSERT_NEW_BOOKING = "insert into BOOKINGS values(booking_id_sequence.nextVal,?,?,?,?,?,?,?,?,?,empty_Blob(),?)";
    
	private final static String UPDATE_EXISTING_BOOKING = "update BOOKINGS set hotel_name=?,hotel_location=?,check_in_time=?,check_out_time=?,transportation_mode=?,flight_ticket=?,bus_ticket=?,train_pnr=?,ticket=?,forex=? where booking_id=?" ;
    
	private final static String DELETE_EXISTING_BOOKING = "delete from BOOKINGS where booking_id =?";
    
	private final static String SELECT_ALL_BOOKING = "select * from BOOKINGS join TRAVEL_REQUESTS using (TRAVEL_REQUEST_ID) join EMPLOYEES using (employee_id) join SLAB using (slab_id)";
    
	private final static String SELECT_ONE_BOOKING = "select * from BOOKINGS join TRAVEL_REQUESTS using (TRAVEL_REQUEST_ID) join EMPLOYEES using (employee_id) join SLAB using (slab_id) where BOOKING_ID=?";

	@Override
	public boolean addNewBooking(Bookings bookings) {

		Object[] parameters= {
				bookings.getTravel_Requests().getTravelRequestId(),
				bookings.getHotelName(),
				bookings.getHotelLocation(),
				bookings.getCheckInTime(),
				bookings.getCheckOutTime(),
				bookings.getTransportationMode(),
				bookings.getFlightTicket(),
				bookings.getBusTicket(),
				bookings.getTrainPnr(),
//				bookings.getTicket(),
				bookings.getForex()
				
		};
		int rowCOunt=jdbcTemplate.update(INSERT_NEW_BOOKING, parameters);
		if(rowCOunt!=0){
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public Bookings updateBooking(Bookings bookings) {
		Object[] parameters= {bookings.getHotelName(),
				bookings.getHotelLocation(),
				bookings.getCheckInTime(),
				bookings.getCheckOutTime(),
				bookings.getTransportationMode(),
				bookings.getBusTicket(),
				bookings.getTrainPnr(),
				bookings.getFlightTicket(),
				bookings.getTicket(),
				bookings.getForex(),
//				bookings.getTravel_Requests(),
				bookings.getBookingId()};
		
		int rowCount=jdbcTemplate.update(UPDATE_EXISTING_BOOKING, parameters);
		
		if(rowCount!=0) {
			return getBookingByBookingId(bookings.getBookingId());
		}
		else {
			return null;
		}
	}

	@Override
	public boolean deleteBookingByBookingId(int bookingId) {
		jdbcTemplate.update(DELETE_EXISTING_BOOKING, bookingId);
		return true;
	}

	@Override
	public List<Bookings> getAllBookings() {
		BookingsRowMapper bookingsRowMapper=new BookingsRowMapper();	
		return jdbcTemplate.query(SELECT_ALL_BOOKING, bookingsRowMapper);
	}

	@Override
	public Bookings getBookingByBookingId(int bookingId) {
		BookingsRowMapper bookingsRowMapper=new BookingsRowMapper();	
		return jdbcTemplate.queryForObject(SELECT_ONE_BOOKING,bookingsRowMapper, bookingId);
	}
	
}
