package com.tdl.river.models;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "itx_ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="ticket_number")
	private int ticketNumber;
	private int feedbackID;
	private int escalationID;
	private int status;
	@Column(name="feedback_comments")
	private String feedbackComments;
	private String Note;
	private String Note1;
	private String Note2;
	private int staffID;
	private int created_by;
	private LocalDateTime createdDate;
	private int updated_by;
	private LocalDateTime updated_date;
	private int companyID;
	private int branchID;
	private String time_taken;
	private String callcenter;
	private String Corrective;
	private String Preventive;
	@Column(name="pcm_data")
	private String pcmData;
	private int deptID;
	private String clinical_dept;
	private int subDeptID;
	private String nonclinical_dept;
	private int clinicalID;
	@Column(name="factor_number")
	private int factorNumber;
	@Column(name = "factor_name")
	private String factorName;
	@Column(name = "sub_factor_name")
	private String subFactorName;	
	private int closedBy;
	public LocalDateTime getActualClosedByDate() {
		return actualClosedByDate;
	}

	public void setActualClosedByDate(LocalDateTime actualClosedByDate) {
		this.actualClosedByDate = actualClosedByDate;
	}
	@Column(name="closed_by_date")
	private LocalDateTime closedByDate;
	@Column(name="actual_closed_by_date")
	private LocalDateTime actualClosedByDate;
	@Column(name="auto_escalation")
	private int autoEscalation;
	//private String qmData;
	private String type;
	private int level;
	@Column(name="file_path")
	private String filePath;
	@Column(name="closed_internally")
	private int closedInternally;
	@Column(name="audio_comments")
	private String audioComments;
	private String priority;
	private String category;
	@Column(name = "sub_category")
	private String subCategory;
	@Column(name="sub_category_index")
	private int subCategoryIndex;
	public String getSubCategory() {
		return subCategory;
	}
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(int id, int ticketNumber, int feedbackID, int escalationID, int status, String feedbackComments,
			String note, String note1, String note2, int staffID, int created_by, LocalDateTime createdDate,
			int updated_by, LocalDateTime updated_date, int companyID, int branchID, String time_taken,
			String callcenter, String corrective, String preventive, String pcmData, int deptID, String clinical_dept,
			int subDeptID, String nonclinical_dept, int clinicalID, int factorNumber, String factorName,
			String subFactorName, int closedBy, LocalDateTime closedByDate, int autoEscalation, String type, int level,
			String filePath, int closedInternally, String audioComments, String priority, String category,
			String subCategory, int subCategoryIndex, String closureComments, String depNote, int subFactorNumber,
			int isSubTicket, String rootCause) {
		super();
		this.id = id;
		this.ticketNumber = ticketNumber;
		this.feedbackID = feedbackID;
		this.escalationID = escalationID;
		this.status = status;
		this.feedbackComments = feedbackComments;
		Note = note;
		Note1 = note1;
		Note2 = note2;
		this.staffID = staffID;
		this.created_by = created_by;
		this.createdDate = createdDate;
		this.updated_by = updated_by;
		this.updated_date = updated_date;
		this.companyID = companyID;
		this.branchID = branchID;
		this.time_taken = time_taken;
		this.callcenter = callcenter;
		Corrective = corrective;
		Preventive = preventive;
		this.pcmData = pcmData;
		this.deptID = deptID;
		this.clinical_dept = clinical_dept;
		this.subDeptID = subDeptID;
		this.nonclinical_dept = nonclinical_dept;
		this.clinicalID = clinicalID;
		this.factorNumber = factorNumber;
		this.factorName = factorName;
		this.subFactorName = subFactorName;
		this.closedBy = closedBy;
		this.closedByDate = closedByDate;
		this.autoEscalation = autoEscalation;
		this.type = type;
		this.level = level;
		this.filePath = filePath;
		this.closedInternally = closedInternally;
		this.audioComments = audioComments;
		this.priority = priority;
		this.category = category;
		this.subCategory = subCategory;
		this.subCategoryIndex = subCategoryIndex;
		this.closureComments = closureComments;
		this.depNote = depNote;
		this.subFactorNumber = subFactorNumber;
		this.isSubTicket = isSubTicket;
		this.rootCause = rootCause;
	}
	public int getSubCategoryIndex() {
		return subCategoryIndex;
	}
	public void setSubCategoryIndex(int subCategoryIndex) {
		this.subCategoryIndex = subCategoryIndex;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	@Column(name="closure_comments")
	private String closureComments;
	
	@Column(name="dep_note")
	private String depNote;
	@Column(name="sub_factor_number")
	private int subFactorNumber;
	@Column(name="is_sub_ticket")
	private int isSubTicket;
	
	@Column(name="root_cause")
	private String rootCause;
	
	
	
	
	
	public String getRootCause() {
		return rootCause;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	public int getIsSubTicket() {
		return isSubTicket;
	}
	public void setIsSubTicket(int isSubTicket) {
		this.isSubTicket = isSubTicket;
	}
	public int getSubFactorNumber() {
		return subFactorNumber;
	}
	public void setSubFactorNumber(int subFactorNumber) {
		this.subFactorNumber = subFactorNumber;
	}
	public String getNote1() {
		return Note1;
	}
	public void setNote1(String note1) {
		Note1 = note1;
	}
	public String getNote2() {
		return Note2;
	}
	public void setNote2(String note2) {
		Note2 = note2;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getClosureComments() {
		return closureComments;
	}
	public void setClosureComments(String closureComments) {
		this.closureComments = closureComments;
	}
	
	public String getSubFactorName() {
		return subFactorName;
	}
	public void setSubFactorName(String subFactorName) {
		this.subFactorName = subFactorName;
	}
	public String getDepNote() {
		return depNote;
	}
	public void setDepNote(String depNote) {
		this.depNote = depNote;
	}
	public int getId() {
		return id;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public int getFeedbackID() {
		return feedbackID;
	}
	public int getEscalationID() {
		return escalationID;
	}
	public int getStatus() {
		return status;
	}
	public String getFeedbackComments() {
		return feedbackComments;
	}
	public String getNote() {
		return Note;
	}
	public int getStaffID() {
		return staffID;
	}
	public int getCreated_by() {
		return created_by;
	}
	public int getUpdated_by() {
		return updated_by;
	}
	public int getCompanyID() {
		return companyID;
	}
	public int getBranchID() {
		return branchID;
	}
	public String getTime_taken() {
		return time_taken;
	}
	public String getCallcenter() {
		return callcenter;
	}
	public String getCorrective() {
		return Corrective;
	}
	public String getPreventive() {
		return Preventive;
	}
	public String getPcmData() {
		return pcmData;
	}
	public int getDeptID() {
		return deptID;
	}
	public String getClinical_dept() {
		return clinical_dept;
	}
	public int getSubDeptID() {
		return subDeptID;
	}
	public String getNonclinical_dept() {
		return nonclinical_dept;
	}
	public int getClinicalID() {
		return clinicalID;
	}
	public int getFactorNumber() {
		return factorNumber;
	}
	public String getFactorName() {
		return factorName;
	}
	public int getClosedBy() {
		return closedBy;
	}
	public int getAutoEscalation() {
		return autoEscalation;
	}

	/*
	 * public String getQmData() { return qmData; }
	 */
	public String getType() {
		return type;
	}
	public int getLevel() {
		return level;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	public void setEscalationID(int escalationID) {
		this.escalationID = escalationID;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setFeedbackComments(String feedbackComments) {
		this.feedbackComments = feedbackComments;
	}
	public void setNote(String note) {
		Note = note;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public void setTime_taken(String time_taken) {
		this.time_taken = time_taken;
	}
	public void setCallcenter(String callcenter) {
		this.callcenter = callcenter;
	}
	public void setCorrective(String corrective) {
		Corrective = corrective;
	}
	public void setPreventive(String preventive) {
		Preventive = preventive;
	}
	public void setPcmData(String pcmData) {
		this.pcmData = pcmData;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public void setClinical_dept(String clinical_dept) {
		this.clinical_dept = clinical_dept;
	}
	public void setSubDeptID(int subDeptID) {
		this.subDeptID = subDeptID;
	}
	public void setNonclinical_dept(String nonclinical_dept) {
		this.nonclinical_dept = nonclinical_dept;
	}
	public void setClinicalID(int clinicalID) {
		this.clinicalID = clinicalID;
	}
	public void setFactorNumber(int factorNumber) {
		this.factorNumber = factorNumber;
	}
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}
	public void setClosedBy(int closedBy) {
		this.closedBy = closedBy;
	}
	public void setAutoEscalation(int autoEscalation) {
		this.autoEscalation = autoEscalation;
	}

	/*
	 * public void setQmData(String qmData) { this.qmData = qmData; }
	 */
	public void setType(String type) {
		this.type = type;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public LocalDateTime getUpdated_date() {
		return updated_date;
	}
	public LocalDateTime getClosedByDate() {
		return closedByDate;
	}
	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}
	public void setClosedByDate(LocalDateTime closedByDate) {
		this.closedByDate = closedByDate;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getAudioComments() {
		return audioComments;
	}
	public void setAudioComments(String audioComments) {
		this.audioComments = audioComments;
	}
	public int getClosedInternally() {
		return closedInternally;
	}
	public void setClosedInternally(int closedInternally) {
		this.closedInternally = closedInternally;
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
