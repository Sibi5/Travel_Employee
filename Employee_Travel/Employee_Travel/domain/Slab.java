package com.mindgate.main.domain;

public class Slab {
	
	private int slabId;
	private String employeeCategory;
	private double maxBudget;
	private String internationalTravelAllowed;
	private String flightTravelAllowed;
	
	public Slab() {
		
	}

	public Slab(int slabId, String employeeCategory, double maxBudget, String internationalTravelAllowed,
			String flightTravelAllowed) {
		super();
		this.slabId = slabId;
		this.employeeCategory = employeeCategory;
		this.maxBudget = maxBudget;
		this.internationalTravelAllowed = internationalTravelAllowed;
		this.flightTravelAllowed = flightTravelAllowed;
	}

	public int getSlabId() {
		return slabId;
	}

	public void setSlabId(int slabId) {
		this.slabId = slabId;
	}

	public String getEmployeeCategory() {
		return employeeCategory;
	}

	public void setEmployeeCategory(String employeeCategory) {
		this.employeeCategory = employeeCategory;
	}

	public double getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(double maxBudget) {
		this.maxBudget = maxBudget;
	}

	public String getInternationalTravelAllowed() {
		return internationalTravelAllowed;
	}

	public void setInternationalTravelAllowed(String internationalTravelAllowed) {
		this.internationalTravelAllowed = internationalTravelAllowed;
	}

	public String getFlightTravelAllowed() {
		return flightTravelAllowed;
	}

	public void setFlightTravelAllowed(String flightTravelAllowed) {
		this.flightTravelAllowed = flightTravelAllowed;
	}

	@Override
	public String toString() {
		return "Slab [slabId=" + slabId + ", employeeCategory=" + employeeCategory + ", maxBudget=" + maxBudget
				+ ", internationalTravelAllowed=" + internationalTravelAllowed + ", flightTravelAllowed="
				+ flightTravelAllowed + "]";
	}
	
	
	

}
