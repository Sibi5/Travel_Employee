package com.mindgate.main.domain;

import java.sql.Blob;
import java.sql.Timestamp;
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
	private String transportationMode;
	private double estimate;
	private Blob aadhar;
	private Blob passport;
	private String documentStatus;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public TravelRequests() {
		
	}

	public TravelRequests(int travelRequestId, Employees employees, String boardingPoint, String destination,
			Date fromDate, Date toDate, String managerApproval, String agentApproval, String directorApproval,
			String transportationMode, double estimate, Blob aadhar, Blob passport, String documentStatus,
			Timestamp createdAt, Timestamp updatedAt) {
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
		this.transportationMode = transportationMode;
		this.estimate = estimate;
		this.aadhar = aadhar;
		this.passport = passport;
		this.documentStatus = documentStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public String getTransportationMode() {
		return transportationMode;
	}

	public void setTransportationMode(String transportationMode) {
		this.transportationMode = transportationMode;
	}

	public double getEstimate() {
		return estimate;
	}

	public void setEstimate(double estimate) {
		this.estimate = estimate;
	}

	public Blob getAadhar() {
		return aadhar;
	}

	public void setAadhar(Blob aadhar) {
		this.aadhar = aadhar;
	}

	public Blob getPassport() {
		return passport;
	}

	public void setPassport(Blob passport) {
		this.passport = passport;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
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

	@Override
	public String toString() {
		return "TravelRequests [travelRequestId=" + travelRequestId + ", employees=" + employees + ", boardingPoint="
				+ boardingPoint + ", destination=" + destination + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", managerApproval=" + managerApproval + ", agentApproval=" + agentApproval + ", directorApproval="
				+ directorApproval + ", transportationMode=" + transportationMode + ", estimate=" + estimate
				+ ", aadhar=" + aadhar + ", passport=" + passport + ", documentStatus=" + documentStatus
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
