package com.tdl.river.models;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="im_company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String company_name;
	private String header_message;
	private String domain_name;
	private int SMTP_port;
	private String SMTP_email;
	private String SMTP_password;
	private LocalDateTime activation_date;
	private LocalDateTime created_date;
	private int created_by;
	
	private String version;
	private int force_update_apk;
	private String pathName;
	private String companyCode;
	private int sendmsg;
	private int autoRouting;
	private int autoRoutingSocial;
	private String hisUser;
	private String hisPassword;
	
	@ManyToMany
	@JoinTable(name="channelConfig",joinColumns = @JoinColumn(name="companyID"),
	inverseJoinColumns = @JoinColumn(name="channelID"))
	private List<Channel> channelList;
	private int serviceCmts;
	private int highPsi;
	private int mediumPsi;
	private int lowPsi;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="super_fun_config",
	joinColumns = @JoinColumn(name="companyID"),
	inverseJoinColumns = @JoinColumn(name="funID"))
	private List<FunctionMaster> superFunList;
	private int alertMsg;
	private Integer escalationLevel;
	
	@ManyToMany
	@JoinTable(name="typeConfig",joinColumns = @JoinColumn(name="companyID"),
	inverseJoinColumns = @JoinColumn(name="typeID"))
	private List<Type> typeList;
	
	@ManyToMany
	@JoinTable(name="countryConfig",joinColumns = @JoinColumn(name="companyID"),
	inverseJoinColumns = @JoinColumn(name="countryID"))
	private List<Country> countryList;
	
	public int getAutoRouting() {
		return autoRouting;
	}
	public void setAutoRouting(int autoRouting) {
		this.autoRouting = autoRouting;
	}
	public int getSendmsg() {
		return sendmsg;
	}
	public void setSendmsg(int sendmsg) {
		this.sendmsg = sendmsg;
	}
	
	
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public LocalDateTime getActivation_date() {
		return activation_date;
	}
	public void setActivation_date(LocalDateTime activation_date) {
		this.activation_date = activation_date;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	public int getId() {
		return id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public String getHeader_message() {
		return header_message;
	}
	public String getDomain_name() {
		return domain_name;
	}
	public int getSMTP_port() {
		return SMTP_port;
	}
	public String getSMTP_email() {
		return SMTP_email;
	}
	public String getSMTP_password() {
		return SMTP_password;
	}
	public int getCreated_by() {
		return created_by;
	}
	public String getVersion() {
		return version;
	}
	public int getForce_update_apk() {
		return force_update_apk;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public void setHeader_message(String header_message) {
		this.header_message = header_message;
	}
	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}
	public void setSMTP_port(int sMTP_port) {
		SMTP_port = sMTP_port;
	}
	public void setSMTP_email(String sMTP_email) {
		SMTP_email = sMTP_email;
	}
	public void setSMTP_password(String sMTP_password) {
		SMTP_password = sMTP_password;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setForce_update_apk(int force_update_apk) {
		this.force_update_apk = force_update_apk;
	}
	public List<Channel> getChannelList() {
		return channelList;
	}
	public void setChannelList(List<Channel> channelList) {
		this.channelList = channelList;
	}
	public String getHisUser() {
		return hisUser;
	}
	public void setHisUser(String hisUser) {
		this.hisUser = hisUser;
	}
	public String getHisPassword() {
		return hisPassword;
	}
	public void setHisPassword(String hisPassword) {
		this.hisPassword = hisPassword;
	}
	public int getServiceCmts() {
		return serviceCmts;
	}
	public void setServiceCmts(int serviceCmts) {
		this.serviceCmts = serviceCmts;
	}
	public int getHighPsi() {
		return highPsi;
	}
	public void setHighPsi(int highPsi) {
		this.highPsi = highPsi;
	}
	public int getMediumPsi() {
		return mediumPsi;
	}
	public void setMediumPsi(int mediumPsi) {
		this.mediumPsi = mediumPsi;
	}
	public int getLowPsi() {
		return lowPsi;
	}
	public void setLowPsi(int lowPsi) {
		this.lowPsi = lowPsi;
	}
	public List<FunctionMaster> getSuperFunList() {
		return superFunList;
	}
	public void setSuperFunList(List<FunctionMaster> superFunList) {
		this.superFunList = superFunList;
	}
	public int getAlertMsg() {
		return alertMsg;
	}
	public void setAlertMsg(int alertMsg) {
		this.alertMsg = alertMsg;
	}
	public Integer getEscalationLevel() {
		return escalationLevel;
	}
	public void setEscalationLevel(Integer escalationLevel) {
		this.escalationLevel = escalationLevel;
	}
	public List<Type> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}
	public List<Country> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}
	public int getAutoRoutingSocial() {
		return autoRoutingSocial;
	}
	public void setAutoRoutingSocial(int autoRoutingSocial) {
		this.autoRoutingSocial = autoRoutingSocial;
	}
	
}
