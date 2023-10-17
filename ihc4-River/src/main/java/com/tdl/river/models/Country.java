package com.tdl.river.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "im_country")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String arname;
	
	@NotNull
	private String zhname;
	
	
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

	public Country() { }

	public Country(long id) { 
	    this.id = id;
	  }
	  
	public Country(long id, String name) {
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
