package com.tdl.river.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "itx_users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int companyID;
	private int countryID;
	private int clusterID;
	private int branchID;
	private int groupID;
	private String form_type;
	private String username;
	private String first_name;
	private String email;
	private String contactNo;
	private String PCIPHERPASSWORD;
	private String prev_password;
	private int deptID;
	private int level;
	private int routeto;
	private String route_to_time;
	private String salt;
	private int active;
	private String cipherkey;
	private String ISLOGGEDIN;
	private LocalDateTime created_date;
	private LocalDateTime last_loggedin;
	private LocalDateTime account_valid_till;
	private String SLA;
	private int roll;
	private String favouriteMenus;
	private int created_by;
	private int modified_by;
	private LocalDateTime modified_date;
	
	private int deviceID;
	
	@Column(name="language",columnDefinition = "varchar(45) default 'en'")
	private String Language;
	
	@Column(name="landing_page",columnDefinition = "varchar(45) default 'welcomeScreen'")
	private String landingPage;
	
	
	public String getLandingPage() {
		return landingPage;
	}
	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
//	@Column(columnDefinition = "boolean default false")
//	private boolean isLocked;
//	@Column(columnDefinition = "int default 0")
//	private int counter;
//	
//	public boolean isLocked() {
//		return isLocked;
//	}
//	public void setLocked(boolean isLocked) {
//		this.isLocked = isLocked;
//	}
//	public int getCounter() {
//		return counter;
//	}
//	public void setCounter(int counter) {
//		this.counter = counter;
//	}
	@ManyToMany
	@JoinTable(name="branchConfig",
	joinColumns = @JoinColumn(name="userFk"),
	inverseJoinColumns = @JoinColumn(name="branchFk"))
//	private List<Branch> branchList;
//	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name="FunConfig",
//	joinColumns = @JoinColumn(name="userID"),
//	inverseJoinColumns = @JoinColumn(name="funID"))
//	private List<FunctionMaster> funList;
//	@ManyToMany
//	@JoinTable(name="clusterConfig",
//	joinColumns = @JoinColumn(name="userFk"),
//	inverseJoinColumns = @JoinColumn(name="clusterFk"))
//	private List<Cluster> clusterList;
//	@Column(columnDefinition = "integer default 0")
//	private int medicalUnit;
//	
//	public int getDeviceID() {
//		return deviceID;
//	}
//	public void setDeviceID(int deviceID) {
//		this.deviceID = deviceID;
//	}
//	public List<FunctionMaster> getFunList() {
//		return funList;
//	}
//	public void setFunList(List<FunctionMaster> funList) {
//		this.funList = funList;
//	}
//	public List<Branch> getBranchList() {
//		return branchList;
//	}
//	public void setBranchList(List<Branch> branchList) {
//		this.branchList = branchList;
//	}
	@Transient
	private String password;
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public int getCountryID() {
		return countryID;
	}
	public int getClusterID() {
		return clusterID;
	}
	public int getBranchID() {
		return branchID;
	}
	public int getGroupID() {
		return groupID;
	}
	public String getForm_type() {
		return form_type;
	}
	public String getUsername() {
		return username;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getEmail() {
		return email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public String getPCIPHERPASSWORD() {
		return PCIPHERPASSWORD;
	}
	public String getPrev_password() {
		return prev_password;
	}
	public int getDeptID() {
		return deptID;
	}
	public int getLevel() {
		return level;
	}
	public int getRouteto() {
		return routeto;
	}
	public String getRoute_to_time() {
		return route_to_time;
	}
	public String getSalt() {
		return salt;
	}
	public int getActive() {
		return active;
	}
	public String getCipherkey() {
		return cipherkey;
	}
	public String getISLOGGEDIN() {
		return ISLOGGEDIN;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public LocalDateTime getLast_loggedin() {
		return last_loggedin;
	}
	public LocalDateTime getAccount_valid_till() {
		return account_valid_till;
	}
	public String getSLA() {
		return SLA;
	}
	public int getRoll() {
		return roll;
	}
	public String getFavouriteMenus() {
		return favouriteMenus;
	}
	public int getCreated_by() {
		return created_by;
	}
	public int getModified_by() {
		return modified_by;
	}
	public LocalDateTime getModified_date() {
		return modified_date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}
	public void setClusterID(int clusterID) {
		this.clusterID = clusterID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public void setForm_type(String form_type) {
		this.form_type = form_type;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public void setPCIPHERPASSWORD(String pCIPHERPASSWORD) {
		PCIPHERPASSWORD = pCIPHERPASSWORD;
	}
	public void setPrev_password(String prev_password) {
		this.prev_password = prev_password;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setRouteto(int routeto) {
		this.routeto = routeto;
	}
	public void setRoute_to_time(String route_to_time) {
		this.route_to_time = route_to_time;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public void setCipherkey(String cipherkey) {
		this.cipherkey = cipherkey;
	}
	public void setISLOGGEDIN(String iSLOGGEDIN) {
		ISLOGGEDIN = iSLOGGEDIN;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public void setLast_loggedin(LocalDateTime last_loggedin) {
		this.last_loggedin = last_loggedin;
	}
	public void setAccount_valid_till(LocalDateTime account_valid_till) {
		this.account_valid_till = account_valid_till;
	}
	public void setSLA(String sLA) {
		SLA = sLA;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public void setFavouriteMenus(String favouriteMenus) {
		this.favouriteMenus = favouriteMenus;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}
	public void setModified_date(LocalDateTime modified_date) {
		this.modified_date = modified_date;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	  
	
	
}
