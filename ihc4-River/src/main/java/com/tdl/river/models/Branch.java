
package com.tdl.river.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "im_branch")
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String name;
	
	
	private String arname;
	
	
	private String zhname;
	
	
	private String branch_code;
	
	private String companyID;
	
	private String countryID;
	
	private String clusterID;
	private String city;
	
	private int active;
	private String domain_name;
	private int SMTP_port;
	private String SMTP_email;
	private String SMTP_password;
	public String getClusterID() {
		return clusterID;
	}


	public void setClusterID(String clusterID) {
		this.clusterID = clusterID;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	private String state;
	
	
	
	public String getCountryID() {
		return countryID;
	}

	
	public String getArname() {
		return arname;
	}


	public void setArname(String arname) {
		this.arname = arname;
	}


	public String getZhname() {
		return zhname;
	}


	public void setZhname(String zhname) {
		this.zhname = zhname;
	}


	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public Branch() { }

	public Branch(long id) { 
	    this.id = id;
	  }
	  
	public Branch(long id, String name) {
	    this.id = id;
	    this.name = name;
	  }
	  
	// Getter and setter methods

	  public long getId() {
	    return id;
	  }

	  public void setId(long value) {
	    this.id = value;
	  }

	  public String getName() {
		    return name;
		  }

	  public void setName(String value) {
		    this.name = value;
		  }
	  
	  public String getBranch_code() {
		    return branch_code;
		  }

	  public void setBranch_code(String value) {
		    this.branch_code = value;
		  }


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
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
	  
}
