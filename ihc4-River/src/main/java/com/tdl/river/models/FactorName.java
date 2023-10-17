package com.tdl.river.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "im_factor_questions")
public class FactorName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String commpanyid;
	private String type;
	private int sequence;
	private String factor_name;
	private int isHeader;
	private int parentID;
	private int formSequence;
	private int rating;
	private int colQue;
	private int ticketRating; // ticket genertion logic 
	private int pointers;  // 4 ponitor / 3 pointor
	private int haveSubQue; // does have sub que 1-yes 2-no
	private int subTicket;// sub que ticketing 1-yes 2-no
	private String rating1;
	private String rating2;
	private String rating3;
	private String rating4;
	private String rating5;
	private int cmtCol;
	private int wardTicket;
	@Transient
	private int val;
	private int noofSubque;
	
	
	public int getSubTicket() {
		return subTicket;
	}
	public void setSubTicket(int subTicket) {
		this.subTicket = subTicket;
	}
	public int getTicketRating() {
		return ticketRating;
	}
	public void setTicketRating(int ticketRating) {
		this.ticketRating = ticketRating;
	}
	public int getPointers() {
		return pointers;
	}
	public void setPointers(int pointers) {
		this.pointers = pointers;
	}
	public int getHaveSubQue() {
		return haveSubQue;
	}
	public void setHaveSubQue(int haveSubQue) {
		this.haveSubQue = haveSubQue;
	}
	public int getColQue() {
		return colQue;
	}
	public void setColQue(int colQue) {
		this.colQue = colQue;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public String getCommpanyid() {
		return commpanyid;
	}
	public String getType() {
		return type;
	}
	public int getSequence() {
		return sequence;
	}
	public String getFactor_name() {
		return factor_name;
	}
	public int getIsHeader() {
		return isHeader;
	}
	public int getParentID() {
		return parentID;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCommpanyid(String commpanyid) {
		this.commpanyid = commpanyid;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public void setFactor_name(String factor_name) {
		this.factor_name = factor_name;
	}
	public void setIsHeader(int isHeader) {
		this.isHeader = isHeader;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public int getFormSequence() {
		return formSequence;
	}
	public void setFormSequence(int formSequence) {
		this.formSequence = formSequence;
	}
	public String getRating1() {
		return rating1;
	}
	public void setRating1(String rating1) {
		this.rating1 = rating1;
	}
	public String getRating2() {
		return rating2;
	}
	public void setRating2(String rating2) {
		this.rating2 = rating2;
	}
	public String getRating3() {
		return rating3;
	}
	public void setRating3(String rating3) {
		this.rating3 = rating3;
	}
	public String getRating4() {
		return rating4;
	}
	public void setRating4(String rating4) {
		this.rating4 = rating4;
	}
	public String getRating5() {
		return rating5;
	}
	public void setRating5(String rating5) {
		this.rating5 = rating5;
	}
	public int getCmtCol() {
		return cmtCol;
	}
	public void setCmtCol(int cmtCol) {
		this.cmtCol = cmtCol;
	}
	public int getWardTicket() {
		return wardTicket;
	}
	public void setWardTicket(int wardTicket) {
		this.wardTicket = wardTicket;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public int getNoofSubque() {
		return noofSubque;
	}
	public void setNoofSubque(int noofSubque) {
		this.noofSubque = noofSubque;
	}
	
}
