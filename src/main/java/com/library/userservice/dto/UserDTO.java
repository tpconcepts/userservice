package com.library.userservice.dto;

import java.time.LocalDateTime;


public class UserDTO {

	private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String membershipType;
    private LocalDateTime membershipStartDate;
    private LocalDateTime membershipEndDate;
    
    
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	public LocalDateTime getMembershipStartDate() {
		return membershipStartDate;
	}
	public void setMembershipStartDate(LocalDateTime membershipStartDate) {
		this.membershipStartDate = membershipStartDate;
	}
	public LocalDateTime getMembershipEndDate() {
		return membershipEndDate;
	}
	public void setMembershipEndDate(LocalDateTime membershipEndDate) {
		this.membershipEndDate = membershipEndDate;
	}
}
