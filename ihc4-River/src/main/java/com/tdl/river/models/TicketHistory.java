package com.tdl.river.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itx_ticket_status_logs")
public class TicketHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int ticketID;
	private int companyID;
	private int status;
	private String followup_note;
	private String ccm_note;
	private String ccm1_note;
	private String ccm2_note;
	private String om_qm_note;
	private String gm_note;
	private long escalationID;
	private long update_by;
	private LocalDateTime update_date;
	private String closureComments;
	private String closureFile;
	private int attachment;
	private int closedInternally;
	private String rootCause;
	private String Preventive;
	private String priority;
	private String category;
	private String subCategory;
	
	
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getPreventive() {
		return Preventive;
	}
	public void setPreventive(String preventive) {
		Preventive = preventive;
	}
	public String getCcm1_note() {
		return ccm1_note;
	}
	public void setCcm1_note(String ccm1_note) {
		this.ccm1_note = ccm1_note;
	}
	public String getCcm2_note() {
		return ccm2_note;
	}
	public void setCcm2_note(String ccm2_note) {
		this.ccm2_note = ccm2_note;
	}
	public int getClosedInternally() {
		return closedInternally;
	}
	public void setClosedInternally(int closedInternally) {
		this.closedInternally = closedInternally;
	}
	public String getClosureComments() {
		return closureComments;
	}
	public void setClosureComments(String closureComments) {
		this.closureComments = closureComments;
	}
	public String getClosureFile() {
		return closureFile;
	}
	public void setClosureFile(String closureFile) {
		this.closureFile = closureFile;
	}
	public int getAttachment() {
		return attachment;
	}
	public void setAttachment(int attachment) {
		this.attachment = attachment;
	}
	
	
	
	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFollowup_note() {
		return followup_note;
	}
	public void setFollowup_note(String followup_note) {
		this.followup_note = followup_note;
	}
	public String getCcm_note() {
		return ccm_note;
	}
	public void setCcm_note(String ccm_note) {
		this.ccm_note = ccm_note;
	}
	public String getOm_qm_note() {
		return om_qm_note;
	}
	public void setOm_qm_note(String om_qm_note) {
		this.om_qm_note = om_qm_note;
	}
	public String getGm_note() {
		return gm_note;
	}
	public void setGm_note(String gm_note) {
		this.gm_note = gm_note;
	}
	public long getEscalationID() {
		return escalationID;
	}
	public void setEscalationID(long escalationID) {
		this.escalationID = escalationID;
	}
	public long getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(long update_by) {
		this.update_by = update_by;
	}
	public LocalDateTime getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(LocalDateTime update_date) {
		this.update_date = update_date;
	}
	public String getRootCause() {
		return rootCause;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
