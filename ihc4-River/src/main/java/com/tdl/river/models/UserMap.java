package com.tdl.river.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="itx_user_ticket_map")
public class UserMap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "drilldown_name")
	private String drilldownName;
	private int userID;
	private int companyID;
	private int branchID;
	private int drilldownID;
	private int level;
	@Column(name = "form_type")
	private String formType;
	private int location;
	@Column(name = "ward_name")
	private String wardName;
	private int wardID;
	@Column(columnDefinition = "datetime default null")
	private LocalDateTime createdDate;
	@Column(columnDefinition = "integer default 0")
	private int createdBy;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="ccConfig",
	joinColumns = @JoinColumn(name="userMapId"),
	inverseJoinColumns = @JoinColumn(name="ccId"))
	private List<Users> ccListId;
	
	
	@ManyToMany
	@JoinTable(name="ccConfigMob",
	joinColumns = @JoinColumn(name="userid"),
	inverseJoinColumns = @JoinColumn(name="ccmobnum"))
	private List<Users> ccListNum;

	
	public List<Users> getCcListNum() {
		return ccListNum;
	}
	public void setCcListNum(List<Users> ccListNum) {
		this.ccListNum = ccListNum;
	}
	
	
	
	public List<Users> getCcListId() {
		return ccListId;
	}
	public void setCcListId(List<Users> ccListNum) {
		this.ccListId = ccListNum;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDrilldownName() {
		return drilldownName;
	}
	public void setDrilldownName(String drilldownName) {
		this.drilldownName = drilldownName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public int getDrilldownID() {
		return drilldownID;
	}
	public void setDrilldownID(int drilldownID) {
		this.drilldownID = drilldownID;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	public int getWardID() {
		return wardID;
	}
	public void setWardID(int wardID) {
		this.wardID = wardID;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	
	
	

}
