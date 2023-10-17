package com.tdl.river.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "itx_ticket_escalation")
public class TicketEscalation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long ticketID;
	
	private long escalationID;
	
	
	private int level;
	
	private String note;
	
	private long created_by;
	
	private long modified_by;
	
	private LocalDateTime created_date;

	private LocalDateTime modified_date;
	
	private int companyID;
	
	private String closureComments;

	
	private int attachment;
	
	private String filePath;
	
	
	
	
	 
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getAttachment() {
		return attachment;
	}

	public void setAttachment(int attachment) {
		this.attachment = attachment;
	}

	public String getClosureComments() {
		return closureComments;
	}

	public void setClosureComments(String closureComments) {
		this.closureComments = closureComments;
	}

	public long getId() {
		return id;
	}

	public long getTicketID() {
		return ticketID;
	}

	public long getEscalationID() {
		return escalationID;
	}

	public int getLevel() {
		return level;
	}

	public String getNote() {
		return note;
	}

	public long getCreated_by() {
		return created_by;
	}

	public long getModified_by() {
		return modified_by;
	}


	

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTicketID(long ticketID) {
		this.ticketID = ticketID;
	}

	public void setEscalationID(long escalationID) {
		this.escalationID = escalationID;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setCreated_by(long created_by) {
		this.created_by = created_by;
	}

	public void setModified_by(long modified_by) {
		this.modified_by = modified_by;
	}


	public LocalDateTime getModified_date() {
		return modified_date;
	}


	public void setModified_date(LocalDateTime modified_date) {
		this.modified_date = modified_date;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	
}
