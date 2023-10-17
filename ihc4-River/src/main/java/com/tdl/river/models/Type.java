package com.tdl.river.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "im_type")
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int companyid;
	private String typeid;
	private String typename;
	private String typearname;
	private String typezhname;
	
	
	public String getTypearname() {
		return typearname;
	}
	public void setTypearname(String typearname) {
		this.typearname = typearname;
	}
	public String getTypezhname() {
		return typezhname;
	}
	public void setTypezhname(String typezhname) {
		this.typezhname = typezhname;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getId() {
		return id;
	}
	public int getCompanyid() {
		return companyid;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
}
