package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.TravelRequests;

@Repository
public class TravelRequestRepository implements TravelRequestRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

//	private static String CREATE_REQUEST_QUERY = "insert into travel_requests values(travel_request_id_sequence.nextVal,?,?,?,?,?,?,?,?,?,empty_blob(),empty_blob(),?,systimestamp,systimestamp)";
	private static String CREATE_REQUEST_QUERY = "insert into travel_requests values(travel_request_id_sequence.nextVal,?,?,?,?,?,'pending','pending','approved',?,empty_blob(),?,?,systimestamp,systimestamp, ?,?)";
	private static String UPDATE_QUERY = "update travel_requests set boarding_point=?,destination=?,from_date=?,to_date=?, manager_approval=?,agent_approval=?,director_approval=?,estimate=?,document_status=?, updated_at= systimestamp where travel_request_id = ?";
//	private String UPDATE_QUERY_1st = "update travel_requests set ";

//	private String UPDATE_QUERY_2st = " updated_at=systimestamp where travel_request_id = ?";
	private static String GET_REQUEST_QUERY = "select * from TRAVEL_REQUESTS t inner join employees e on t.EMPLOYEE_ID = e.employee_id inner join slab s  on e.slab_id = s.SLAB_ID and t.TRAVEL_REQUEST_ID=?";
	private static String GET_ALL_REQUESTS_QUERY = "select * from TRAVEL_REQUESTS inner join EMPLOYEES e on travel_requests.employee_id = e.EMPLOYEE_ID inner join SLAB s on s.SLAB_ID = e.SLAB_ID";
	private static String DELETE_QUERY = "delete from travel_requests where travel_request_id=?";
	
	private static String GET_TRAVEL_REQUEST_BY_EMPLOYEE_ID="select * from TRAVEL_REQUESTS join EMPLOYEES using (EMPLOYEE_ID) join SLAB using (SLAB_ID) where EMPLOYEE_ID=?";
	
	private static String GET_TRAVEL_REQUEST_BY_MANAGER_APPROAL="select * from TRAVEL_REQUESTS join Employees using (employee_Id) join Slab using (slab_id) where manager_approval='approved' and agent_approval=?";
	
	private static String GET_TRAVEL_REQUEST_BY_AGENT_REJECTED="select * from TRAVEL_REQUESTS join Employees using (employee_Id) join Slab using (slab_id) where agent_approval='rejected' and director_approval=?";
	
	private static String GET_TRAVEL_REQUESTS_READY_FOR_BOOKING="select * from TRAVEL_REQUESTS join Employees using (employee_Id) join Slab using (slab_id) where agent_approval!='pending' and director_approval='approved'";
	
	private static String INSERT_BLOB="update travel_requests set document=? where travel_request_id=?";


	@Override
	public boolean createNewTravelRequest(TravelRequests travel_Requests) {
		Object[] parameters = { travel_Requests.getEmployees().getEmployeeId(), travel_Requests.getBoardingPoint(),
				travel_Requests.getDestination(), travel_Requests.getFromDate(), travel_Requests.getToDate(),
				travel_Requests.getEstimate(),travel_Requests.getDocumentStatus(), travel_Requests.getTransportationMode(), travel_Requests.getForex(),travel_Requests.getComments()};
		int rowCount = jdbcTemplate.update(CREATE_REQUEST_QUERY, parameters);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public TravelRequests updateRequest(TravelRequests travel_Requests) {
		String UPDATE_QUERY_1st = "update travel_requests set ";
		String UPDATE_QUERY_2st = " updated_at=systimestamp where travel_request_id = ?";
		if (travel_Requests.getEmployees() != null)
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "employee_id=" + travel_Requests.getEmployees().getEmployeeId() + ",";
		if (travel_Requests.getBoardingPoint() != null && travel_Requests.getBoardingPoint() != "")
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "boarding_point='" + travel_Requests.getBoardingPoint() + "',";
		if (travel_Requests.getDestination() != null && travel_Requests.getDestination() != "")
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "destination='" + travel_Requests.getDestination() + "',";
		if (travel_Requests.getFromDate() != null)
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "from_date=" + travel_Requests.getFromDate() + ",";
		if (travel_Requests.getToDate() != null)
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "to_date=" + travel_Requests.getToDate() + ",";
		if (travel_Requests.getManagerApproval() != null && travel_Requests.getManagerApproval() != "")
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "manager_approval='" + travel_Requests.getManagerApproval() + "',";
		if (travel_Requests.getAgentApproval() != null && travel_Requests.getAgentApproval() != "")
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "agent_approval='" + travel_Requests.getAgentApproval() + "',";
		if (travel_Requests.getDirectorApproval() != null && travel_Requests.getDirectorApproval() != "")
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "director_approval='" + travel_Requests.getDirectorApproval() + "',";
		if (Integer.valueOf((int) travel_Requests.getEstimate()) != null)
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "estimate=" + travel_Requests.getEstimate() + ",";
		if (travel_Requests.getDocumentStatus() != null && travel_Requests.getDocumentStatus() != "")
			UPDATE_QUERY_1st = UPDATE_QUERY_1st + "document_status='" + travel_Requests.getDocumentStatus() + "',";

		int rowCount = jdbcTemplate.update(UPDATE_QUERY_1st + UPDATE_QUERY_2st, travel_Requests.getTravelRequestId());
		if (rowCount > 0)
			return getTravelRequestById(travel_Requests.getTravelRequestId());
		else
			return travel_Requests;
	}

	@Override
	public TravelRequests updateTravelRequest(TravelRequests travel_Requests) {
		Object[] parameters = { travel_Requests.getBoardingPoint(), travel_Requests.getDestination(),
				travel_Requests.getFromDate(), travel_Requests.getToDate(), travel_Requests.getManagerApproval(),
				travel_Requests.getAgentApproval(), travel_Requests.getDirectorApproval(),
				travel_Requests.getEstimate(), travel_Requests.getDocumentStatus(),
				travel_Requests.getTravelRequestId() };
		int rowCount = jdbcTemplate.update(UPDATE_QUERY, parameters);
		if (rowCount > 0)
			return travel_Requests;
		else
			return travel_Requests;
	}

	@Override
	public TravelRequests getTravelRequestById(int travelRequestId) {
		TravelRequestRowMapper travelRequestRowMapper = new TravelRequestRowMapper();
		TravelRequests travel_Requests = jdbcTemplate.queryForObject(GET_REQUEST_QUERY, travelRequestRowMapper,
				travelRequestId);
		return travel_Requests;
	}

	@Override
	public List<TravelRequests> getAllTravelRequests() {
		TravelRequestRowMapper travelRequestRowMapper = new TravelRequestRowMapper();
		List<TravelRequests> travelRequestsList = jdbcTemplate.query(GET_ALL_REQUESTS_QUERY, travelRequestRowMapper);
		return travelRequestsList;
	}

	@Override
	public boolean deleteTravelRequestById(int travelRequestId) {
		int rowCount = jdbcTemplate.update(DELETE_QUERY, travelRequestId);
		if (rowCount > 0)
			return true;
		else
			return false;
	}
	
	@Override
    public List<TravelRequests> getTravelRequestByEmployeeId(int employeeId){
        TravelRequestRowMapper travelRequestRowMapper = new TravelRequestRowMapper();
        return jdbcTemplate.query(GET_TRAVEL_REQUEST_BY_EMPLOYEE_ID, travelRequestRowMapper , employeeId);
    }
	
	@Override
	public List<TravelRequests>getTravelRequestByAgentApproval(String agentApproval){
		TravelRequestRowMapper travelRequestRowMapper = new TravelRequestRowMapper();
		return jdbcTemplate.query(GET_TRAVEL_REQUEST_BY_MANAGER_APPROAL, travelRequestRowMapper, agentApproval);
	}

	@Override
	public List<TravelRequests> getTravelRequestsForDirector(String directorApproval) {
		TravelRequestRowMapper travelRequestRowMapper = new TravelRequestRowMapper();
		return jdbcTemplate.query(GET_TRAVEL_REQUEST_BY_AGENT_REJECTED, travelRequestRowMapper, directorApproval);
	}

	@Override
	public List<TravelRequests> getRequestsReadyForBooking() {
		TravelRequestRowMapper travelRequestRowMapper = new TravelRequestRowMapper();
		return jdbcTemplate.query(GET_TRAVEL_REQUESTS_READY_FOR_BOOKING, travelRequestRowMapper);
	}

	@Override
	public boolean insertFile(TravelRequests travelRequests) {
		
		Object[] parameters= {travelRequests.getDocument(), travelRequests.getTravelRequestId()};
		int rowCount =jdbcTemplate.update(INSERT_BLOB, parameters);
		if(rowCount>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	

}
