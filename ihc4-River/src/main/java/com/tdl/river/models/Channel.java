package com.tdl.river.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "channel")
public class Channel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	@NotNull
	private String arname;
	@NotNull
	private String zhname;
	private int isActive;
	
	
	
	
	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	private String companyID;
	
	
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

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public Channel() { }

	public Channel(long id) { 
	    this.id = id;
	  }
	  
	public Channel(long id, String name) {
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
	  
	 
}
