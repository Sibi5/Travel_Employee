package com.mindgate.main.domain;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

public class TravelRequests {

	private int travelRequestId;
	private Employees employees;
	private String boardingPoint;
	private String destination;
	private Date fromDate;
	private Date toDate;
	private String managerApproval;
	private String agentApproval;
	private String directorApproval;
	private double estimate;
	private byte[] document;
	private String documentStatus;
	private String transportationMode;
//	private byte[] passport;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private double forex;
	private String comments;
	
	public TravelRequests() {
		// TODO Auto-generated constructor stub
	}

	public TravelRequests(int travelRequestId, Employees employees, String boardingPoint, String destination,
			Date fromDate, Date toDate, String managerApproval, String agentApproval, String directorApproval,
			double estimate, byte[] document, String documentStatus, String transportationMode, Timestamp createdAt,
			Timestamp updatedAt, double forex, String comments) {
		super();
		this.travelRequestId = travelRequestId;
		this.employees = employees;
		this.boardingPoint = boardingPoint;
		this.destination = destination;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.managerApproval = managerApproval;
		this.agentApproval = agentApproval;
		this.directorApproval = directorApproval;
		this.estimate = estimate;
		this.document = document;
		this.documentStatus = documentStatus;
		this.transportationMode = transportationMode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.forex = forex;
		this.comments = comments;
	}

	public int getTravelRequestId() {
		return travelRequestId;
	}

	public void setTravelRequestId(int travelRequestId) {
		this.travelRequestId = travelRequestId;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getManagerApproval() {
		return managerApproval;
	}

	public void setManagerApproval(String managerApproval) {
		this.managerApproval = managerApproval;
	}

	public String getAgentApproval() {
		return agentApproval;
	}

	public void setAgentApproval(String agentApproval) {
		this.agentApproval = agentApproval;
	}

	public String getDirectorApproval() {
		return directorApproval;
	}

	public void setDirectorApproval(String directorApproval) {
		this.directorApproval = directorApproval;
	}

	public double getEstimate() {
		return estimate;
	}

	public void setEstimate(double estimate) {
		this.estimate = estimate;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getTransportationMode() {
		return transportationMode;
	}

	public void setTransportationMode(String transportationMode) {
		this.transportationMode = transportationMode;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public double getForex() {
		return forex;
	}

	public void setForex(double forex) {
		this.forex = forex;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "TravelRequests [travelRequestId=" + travelRequestId + ", employees=" + employees + ", boardingPoint="
				+ boardingPoint + ", destination=" + destination + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", managerApproval=" + managerApproval + ", agentApproval=" + agentApproval + ", directorApproval="
				+ directorApproval + ", estimate=" + estimate + ", document=" + Arrays.toString(document)
				+ ", documentStatus=" + documentStatus + ", transportationMode=" + transportationMode + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", forex=" + forex + ", comments=" + comments + "]";
	}

	
	
	
	
}