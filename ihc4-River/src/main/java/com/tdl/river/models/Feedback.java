package com.tdl.river.models;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "ifb_feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int languageID;
	private int companyID;
	private int channelID;
	private String name;
	private String dateofadm;
	@Column(name = "ref_no")
	private String refNo;
	private int rating;
	private int feedback;
	@Column(name = "contact_no")
	private String contactNo;
	private String comments;
	@Column(name = "room_no")
	private String roomNo;
	private String roomtype;
	private String ipno;
	private int critical;
	private String deptID;
	private String cacrars;
	private String type;
	@Column(name = "audiance_type")
	private String audianceType;
	public String getAudienceType() {
		return audianceType;
	}
	public void setAudienceType(String audienceType) {
		this.audianceType = audienceType;
	}
	private String doctor;
	private LocalDate doa;
	private LocalDate dod;
	private int category;
	private LocalDate dateofvisit;
	private String email;
	@Column(name = "cc_list")
	private String ccList;
	@Column(name = "assign_to")
	private String assignTo;
	private String age;
	private String gender;
	@Column(name = "repeat_patient")
	private String repeatPatient;
	@Column(name = "visit_reason")
	private String visitReason;
	@Column(name = "referred_person_name")
	private String referredPersonName;
	@Column(name = "referred_person_ph_no")
	private String referredPersonPhNo;
	private String Staff_Recommendation;
	private String staff_dept;
	private String hospital_Recommendation;
	private String doctor_Recommendation;
	@Column(name = "issue_type")
	private int issueType;
	@Column(name = "complaint_source")
	private int complaintSource;
	@Column(name = "file_path")
	private String filePath;
	@Column(name = "file_path1")
	private String filePath1;
	@Column(name = "file_path2")
	private String filePath2;
	@Column(name = "file_path3")
	private String filePath3;
	@Column(name = "file_path4")
	private String filePath4;
	
	private int uploadID;
	private int audio;
	private String location;
	private String wardtype;
	@Column(name = "block_name")
	private String blockName;

	@Column(name = "wing_name")
	private String wingName;

	@Column(name = "floor_no")
	private String floorNo;

	@Column(name = "ward_no")
	private String wardNo;

	@Column(name = "bed_no")
	private String bedNo;

	@Column(name = "bed_type")
	private String bedType;

	@Column(name = "payment_detail")
	private String paymentDetail;
	
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public String getPaymentDetail() {
		return paymentDetail;
	}
	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	private String reason_comments;
	private int created_by;
	private LocalDateTime created_date;
	private String billing_payment;
	private String admission_payment;
	private String specialist_clinic;
	private String impression;
	private String about_our_service;
	private String address;
	private String department;
    @Column(name = "doctor_name")
    private String doctorName;
	private String age_group;
	private String not_impressed_department;
	private String nationality;
	private String cprno;
	private LocalDate dob;
	private String Staff_Not_Recommendation;
	private String staff_dept_Not_Recommented;
	private int branchID;
	private String tower;

    @Column(name = "referral_source1")
    private int referralSource1;

    @Column(name = "referral_source2")
    private int referralSource2;

    @Column(name = "referral_source3")
    private int referralSource3;

    @Column(name = "referral_source4")
    private int referralSource4;

    @Column(name = "referral_source5")
    private int referralSource5;

    @Column(name = "referral_source6")
    private int referralSource6;

    @Column(name = "referral_source7")
    private int referralSource7;

    @Column(name = "referral_source8")
    private int referralSource8;

    @Column(name = "referral_source9")
    private int referralSource9;

    @Column(name = "referral_source10")
    private int referralSource10;

    @Column(name = "referral_source11")
    private int referralSource11;

    @Column(name = "referral_source12")
    private int referralSource12;

    @Column(name = "referral_source13")
    private int referralSource13;

    @Column(name = "referral_source14")
    private int referralSource14;

    @Column(name = "referral_source15")
    private int referralSource15;

    @Column(name = "referral_source16")
    private int referralSource16;

    @Column(name = "referral_source17")
    private int referralSource17;

    @Column(name = "referral_source18")
    private int referralSource18;

    @Column(name = "referral_source19")
    private int referralSource19;

    @Column(name = "referral_source20")
    private int referralSource20;

    @Column(name = "referral_source21")
    private int referralSource21;
    
	@Column(name = "staff_recommendation1")
    private String staffRecommendation1;

    @Column(name = "staff_recommendation2")
    private String staffRecommendation2;
	@Column(name = "staff_recommendation3")
    private String staffRecommendation3;

    @Column(name = "staff_recommendation4")
    private String staffRecommendation4;

    @Column(name = "staff_recommendation5")
    private String staffRecommendation5;

    @Column(name = "staff_recommendation6")
    private String staffRecommendation6;

    @Column(name = "staff_recommendation7")
    private String staffRecommendation7;

    @Column(name = "staff_recommendation8")
    private String staffRecommendation8;

    @Column(name = "staff_recommendation9")
    private String staffRecommendation9;

    @Column(name = "staff_recommendation10")
    private String staffRecommendation10;

    @Column(name = "staff_recommendation11")
    private String staffRecommendation11;

    @Column(name = "staff_recommendation12")
    private String staffRecommendation12;
	private String staff_dept1;
	private String staff_dept2;
	private String staff_dept3;
	private String staff_dept4;
	private String staff_dept5;
	private String staff_dept6;
	private String staff_dept7;
	private String staff_dept8;
	private String staff_dept9;
	private String staff_dept10;
	private String staff_dept11;
	private String staff_dept12;
	@Column(name = "h_cahps")
	private String hCahps;
	@Column(name = "commit_comment")
	private String commitComment;

	@Column(name = "service_ques")
	private String serviceQues;

	@Column(name = "expe_comment")
	private String expeComment;
	public String getCcList() {
		return ccList;
	}
	public void setCcList(String ccList) {
		this.ccList = ccList;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String gethCahps() {	
		return hCahps;	
	}	
	public void sethCahps(String hCahps) {	
		this.hCahps = hCahps;	
	}
	private int commitment;
	@Column(name = "expe")
	private int experience;
	
	public int getCommitment() {
		return commitment;
	}

	public void setCommitment(int commitment) {
		this.commitment = commitment;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getServiceQues() {
		return serviceQues;
	}
	
	 public String getCommitComment() { 
		 return commitComment; 
		 }
	 
	 public void setCommitComment(String commitComment) {
		 this.commitComment = commitComment; 
		 }
	 

	public void setServiceQues(String serviceQues) {
		this.serviceQues = serviceQues;
	}

	public String getExpeComment() {
		return expeComment;
	}

	public void setExpeComment(String expeComment) {
		this.expeComment = expeComment;
	}

	
	
	public int _1;
	public int _2;
	public int _3;
	public int _4;
	public int _5;
	public int _6;
	public int _7;
	public int _8;
	public int _9;
	public int _10;
	public int _11;
	public int _12;
	public int _13;
	public int _14;
	public int _15;
	public int _16;
	public int _17;
	public int _18;
	public int _19;
	public int _20;
	public int _21;
	public int _22;
	public int _23;
	public int _24;
	public int _25;
	public int _26;
	public int _27;
	public int _28;
	public int _29;
	public int _30;
	public int _31;
	public int _32;
	public int _33;
	public int _34;
	public int _35;
	public int _36;
	public int _37;
	public int _38;
	public int _39;
	public int _40;
	public int _41;
	public int _42;
	public int _43;
	public int _44;
	public int _45;
	public int _46;
	public int _47;
	public int _48;
	public int _49;
	public int _50;
	public int _51;
	public int _52;
	public int _53;
	public int _54;
	public int _55;
	public int _56;
	public int _57;
	public int _58;
	public int _59;
	public int _60;
	public int _61;
	public int _62;
	public int _63;
	public int _64;
	public int _65;
	public int _66;
	public int _67;
	public int _68;
	public int _69;
	public int _70;
	public int _71;
	public int _72;
	public int _73;
	public int _74;
	public int _75;
	public int _76;
	public int _77;
	public int _78;
	public int _79;
	public int _80;
	public int _81;
	public int _82;
	public int _83;
	public int _84;
	public int _85;
	public int _86;
	public int _87;
	public int _88;
	public int _89;
	public int _90;
	public int _91;
	public int _92;
	public int _93;
	public int _94;
	public int _95;
	public int _96;
	public int _97;
	public int _98;
	public int _99;
	public int _100;
	public int _101;
	public int _102;
	public int _103;
	public int _104;
	public int _105;
	public int _106;
	public int _107;
	public int _108;
	public int _109;
	public int _110;
	public int _111;
	public int _112;
	public int _113;
	public int _114;
	public int _115;
	public int _116;
	public int _117;
	public int _118;
	public int _119;
	public int _120;
	public int _121;
	public int _122;
	public int _123;
	public int _124;
	public int _125;
	public int _126;
	public int _127;
	public int _128;
	public int _129;
	public int _130;
	public int _131;
	public int _132;
	public int _133;
	public int _134;
	public int _135;
	public int _136;
	public int _137;
	public int _138;
	public int _139;
	public int _140;
	public int _141;
	public int _142;
	public int _143;
	public int _144;
	public int _145;
	public int _146;
	public int _147;
	public int _148;
	public int _149;
	public int _150;
	public int _151;
	public int _152;
	public int _153;
	public int _154;
	public int _155;
	public int _156;
	public int _157;
	public int _158;
	public int _159;
	public int _160;
	public int _161;
	public int _162;
	public int _163;
	public int _164;
	public int _165;

	@Column(name = "psi_rating")
	public double psiRating;
	public int psi;

	@Column(name = "opd_name")
	private String opdName;

	@Column(name = "staff_not_recommendation1")
	private String staffNotRecommendation1;
	private String dept_not_recommended;
	@Transient
	private String[] drillDown;

	public String getOpdName() {
		return opdName;
	}

	public void setOpdName(String opdName) {
		this.opdName = opdName;
	}

	public String[] getDrillDown() {
		return drillDown;
	}

	public void setDrillDown(String[] drillDown) {
		this.drillDown = drillDown;
	}

	@Transient
	private String version;
	

	@Column(name = "hi_sid")
	private int HiSid;

	@Column(name = "filled_by")
	private String filledBy;

	@Column(name = "reg_loc")
	private String regLoc;

	@Column(name = "admitted_loc")
	private String admittedLoc;
	private String noise;
	private String ancillary;
	private String pharmacy;
	@Column(name = "noise_comment")
	private String noiseComment;
	private String ref_comment;
	private int countryID;
	private String comment1;
	private String comment2;
	private String comment3;
	private String comment4;
	private String comment5;
	private String comment6;
	private String comment7;
	private String comment8;
	private String comment9;
	private String comment10;
	private String comment11;
	private String comment12;
	private String comment13;
	private String comment14;
	private String comment15;
	@Column(name = "imp_val1")
	public int impVal1;

	@Column(name = "imp_val2")
	public int impVal2;

	@Column(name = "imp_val3")
	public int impVal3;

	@Column(name = "imp_val4")
	public int impVal4;

	@Column(name = "imp_val5")
	public int impVal5;

	@Column(name = "imp_val6")
	public int impVal6;
	@Column(name = "psi_indicator")
	public String psiIndicator;

	@Column(name = "payment_type")
	private String paymentType;

	@Column(name = "ces_comment")
	private String cesComment;

	@Column(name = "ces_cont_no")
	private String cesContNo;

	@Column(name = "sub_unit")
	private String subUnit;

	@Column(name = "survey_no")
	private String surveyNo;
	private int tei1;
	private int tei2;
	private int tei3;
	private int tei4;
	private int tei5;
	private int tei6;
	private int tei7;
	@Transient
	private int feedbackVal;
	@Transient
	private MultipartFile file;
	@Transient
	private MultipartFile file1;
	@Transient
	private MultipartFile file2;
	@Transient
	private MultipartFile file3;
	@Transient
	private MultipartFile file4;
	
	
	
	public MultipartFile getFile3() {
		return file3;
	}
	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}
	public MultipartFile getFile4() {
		return file4;
	}
	public void setFile4(MultipartFile file4) {
		this.file4 = file4;
	}
	public String getFilePath1() {
		return filePath1;
	}
	public void setFilePath1(String filePath1) {
		this.filePath1 = filePath1;
	}
	public String getFilePath2() {
		return filePath2;
	}
	public void setFilePath2(String filePath2) {
		this.filePath2 = filePath2;
	}
	public String getFilePath3() {
		return filePath3;
	}
	public void setFilePath3(String filePath3) {
		this.filePath3 = filePath3;
	}
	public String getFilePath4() {
		return filePath4;
	}
	public void setFilePath4(String filePath4) {
		this.filePath4 = filePath4;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public MultipartFile getFile2() {
		return file2;
	}
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
	@Column(name = "updated_by")
	private int updatedBy;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
	public String getDateofadm() {
		return dateofadm;
	}

	public void setDateofadm(String dateofadm) {
		this.dateofadm = dateofadm;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getFeedbackVal() {
		return feedbackVal;
	}

	public void setFeedbackVal(int feedbackVal) {
		this.feedbackVal = feedbackVal;
	}

	public int getImpVal1() {
		return impVal1;
	}

	public void setImpVal1(int impVal1) {
		this.impVal1 = impVal1;
	}

	public int getImpVal2() {
		return impVal2;
	}

	public void setImpVal2(int impVal2) {
		this.impVal2 = impVal2;
	}

	public int getImpVal3() {
		return impVal3;
	}

	public void setImpVal3(int impVal3) {
		this.impVal3 = impVal3;
	}

	public int getImpVal4() {
		return impVal4;
	}

	public void setImpVal4(int impVal4) {
		this.impVal4 = impVal4;
	}

	public int getImpVal5() {
		return impVal5;
	}

	public void setImpVal5(int impVal5) {
		this.impVal5 = impVal5;
	}

	public int getImpVal6() {
		return impVal6;
	}

	public void setImpVal6(int impVal6) {
		this.impVal6 = impVal6;
	}

	private String nric;
	
	@Column(name = "desktop_indicator")
	private int desktopIndicator;

	public int getDesktopIndicator() {
		return desktopIndicator;
	}

	public void setDesktopIndicator(int desktopIndicator) {
		this.desktopIndicator = desktopIndicator;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public String getComment3() {
		return comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getComment4() {
		return comment4;
	}

	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}

	public String getComment5() {
		return comment5;
	}

	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}

	public String getComment6() {
		return comment6;
	}

	public void setComment6(String comment6) {
		this.comment6 = comment6;
	}

	public String getComment7() {
		return comment7;
	}

	public void setComment7(String comment7) {
		this.comment7 = comment7;
	}

	public String getComment8() {
		return comment8;
	}

	public void setComment8(String comment8) {
		this.comment8 = comment8;
	}

	public String getComment9() {
		return comment9;
	}

	public void setComment9(String comment9) {
		this.comment9 = comment9;
	}

	public String getComment10() {
		return comment10;
	}

	public void setComment10(String comment10) {
		this.comment10 = comment10;
	}

	public String getComment11() {
		return comment11;
	}

	public void setComment11(String comment11) {
		this.comment11 = comment11;
	}

	public String getComment12() {
		return comment12;
	}

	public void setComment12(String comment12) {
		this.comment12 = comment12;
	}

	public String getComment13() {
		return comment13;
	}

	public void setComment13(String comment13) {
		this.comment13 = comment13;
	}

	public String getComment14() {
		return comment14;
	}

	public void setComment14(String comment14) {
		this.comment14 = comment14;
	}

	public String getComment15() {
		return comment15;
	}

	public void setComment15(String comment15) {
		this.comment15 = comment15;
	}

	public int getCountryID() {
		return countryID;
	}

	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}

	public String getFilledBy() {
		return filledBy;
	}

	public void setFilledBy(String filledBy) {
		this.filledBy = filledBy;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public int getLanguageID() {
		return languageID;
	}

	public int getCompanyID() {
		return companyID;
	}

	public int getChannelID() {
		return channelID;
	}

	public String getName() {
		return name;
	}

	public String getRefNo() {
		return refNo;
	}

	public int getRating() {
		return rating;
	}

	public int getFeedback() {
		return feedback;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getComments() {
		return comments;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public String getIpno() {
		return ipno;
	}

	public int getCritical() {
		return critical;
	}

	public String getDeptID() {
		return deptID;
	}

	public String getCacrars() {
		return cacrars;
	}

	public String getType() {
		return type;
	}


	public String getDoctor() {
		return doctor;
	}

	public int getCategory() {
		return category;
	}

	public String getEmail() {
		return email;
	}

	public String getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}


	public String getVisitReason() {
		return visitReason;
	}

	public String getStaff_Recommendation() {
		return Staff_Recommendation;
	}

	public String getStaff_dept() {
		return staff_dept;
	}

	public String getDoctor_Recommendation() {
		return doctor_Recommendation;
	}

	public int getIssueType() {
		return issueType;
	}

	public int getComplaintSource() {
		return complaintSource;
	}

	public String getFilePath() {
		return filePath;
	}

	public int getUploadID() {
		return uploadID;
	}

	public int getAudio() {
		return audio;
	}

	public String getBlockName() {
		return blockName;
	}

	public String getWingName() {
		return wingName;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public String getLocation() {
		return location;
	}

	public String getWardNo() {
		return wardNo;
	}

	public String getBedNo() {
		return bedNo;
	}

	public String getReason_comments() {
		return reason_comments;
	}

	public int getCreated_by() {
		return created_by;
	}

	public String getBilling_payment() {
		return billing_payment;
	}

	public String getAdmission_payment() {
		return admission_payment;
	}

	public String getSpecialist_clinic() {
		return specialist_clinic;
	}

	public String getImpression() {
		return impression;
	}

	public String getAbout_our_service() {
		return about_our_service;
	}

	public String getAddress() {
		return address;
	}

	public String getDepartment() {
		return department;
	}

	

	public String getAge_group() {
		return age_group;
	}

	public String getNot_impressed_department() {
		return not_impressed_department;
	}

	public String getNationality() {
		return nationality;
	}

	public String getCprno() {
		return cprno;
	}

	public String getStaff_Not_Recommendation() {
		return Staff_Not_Recommendation;
	}

	public String getStaff_dept_Not_Recommented() {
		return staff_dept_Not_Recommented;
	}

	public int getBranchID() {
		return branchID;
	}

	public String getTower() {
		return tower;
	}

	public String getStaff_dept1() {
		return staff_dept1;
	}

	public String getStaff_dept2() {
		return staff_dept2;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public void setIpno(String ipno) {
		this.ipno = ipno;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public void setCacrars(String cacrars) {
		this.cacrars = cacrars;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}


	public void setStaff_Recommendation(String staff_Recommendation) {
		Staff_Recommendation = staff_Recommendation;
	}

	public void setStaff_dept(String staff_dept) {
		this.staff_dept = staff_dept;
	}

	public void setDoctor_Recommendation(String doctor_Recommendation) {
		this.doctor_Recommendation = doctor_Recommendation;
	}

	public void setIssueType(int issueType) {
		this.issueType = issueType;
	}

	public void setComplaintSource(int complaintSource) {
		this.complaintSource = complaintSource;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setUploadID(int uploadID) {
		this.uploadID = uploadID;
	}

	public void setAudio(int audio) {
		this.audio = audio;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public void setWingName(String wingName) {
		this.wingName = wingName;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public void setReason_comments(String reason_comments) {
		this.reason_comments = reason_comments;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public void setBilling_payment(String billing_payment) {
		this.billing_payment = billing_payment;
	}

	public void setAdmission_payment(String admission_payment) {
		this.admission_payment = admission_payment;
	}

	public void setSpecialist_clinic(String specialist_clinic) {
		this.specialist_clinic = specialist_clinic;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public void setAbout_our_service(String about_our_service) {
		this.about_our_service = about_our_service;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	

	public void setAge_group(String age_group) {
		this.age_group = age_group;
	}

	public void setNot_impressed_department(String not_impressed_department) {
		this.not_impressed_department = not_impressed_department;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setCprno(String cprno) {
		this.cprno = cprno;
	}

	public void setStaff_Not_Recommendation(String staff_Not_Recommendation) {
		Staff_Not_Recommendation = staff_Not_Recommendation;
	}

	public void setStaff_dept_Not_Recommented(String staff_dept_Not_Recommented) {
		this.staff_dept_Not_Recommented = staff_dept_Not_Recommented;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public void setTower(String tower) {
		this.tower = tower;
	}

	public void setStaff_dept1(String staff_dept1) {
		this.staff_dept1 = staff_dept1;
	}

	public void setStaff_dept2(String staff_dept2) {
		this.staff_dept2 = staff_dept2;
	}

	public int get_1() {
		return _1;
	}

	public int get_2() {
		return _2;
	}

	public int get_3() {
		return _3;
	}

	public int get_4() {
		return _4;
	}

	public int get_5() {
		return _5;
	}

	public int get_6() {
		return _6;
	}

	public int get_7() {
		return _7;
	}

	public int get_8() {
		return _8;
	}

	public int get_9() {
		return _9;
	}

	public int get_10() {
		return _10;
	}

	public int get_11() {
		return _11;
	}

	public int get_12() {
		return _12;
	}

	public int get_13() {
		return _13;
	}

	public int get_14() {
		return _14;
	}

	public int get_15() {
		return _15;
	}

	public int get_16() {
		return _16;
	}

	public int get_17() {
		return _17;
	}

	public int get_18() {
		return _18;
	}

	public int get_19() {
		return _19;
	}

	public int get_20() {
		return _20;
	}

	public int get_21() {
		return _21;
	}

	public int get_22() {
		return _22;
	}

	public int get_23() {
		return _23;
	}

	public int get_24() {
		return _24;
	}

	public int get_25() {
		return _25;
	}

	public int get_26() {
		return _26;
	}

	public int get_27() {
		return _27;
	}

	public int get_28() {
		return _28;
	}

	public int get_29() {
		return _29;
	}

	public int get_30() {
		return _30;
	}

	public int get_31() {
		return _31;
	}

	public int get_32() {
		return _32;
	}

	public int get_33() {
		return _33;
	}

	public int get_34() {
		return _34;
	}

	public int get_35() {
		return _35;
	}

	public int get_36() {
		return _36;
	}

	public int get_37() {
		return _37;
	}

	public int get_38() {
		return _38;
	}

	public int get_39() {
		return _39;
	}

	public int get_40() {
		return _40;
	}

	public int get_41() {
		return _41;
	}

	public int get_42() {
		return _42;
	}

	public int get_43() {
		return _43;
	}

	public int get_44() {
		return _44;
	}

	public int get_45() {
		return _45;
	}

	public int get_46() {
		return _46;
	}

	public int get_47() {
		return _47;
	}

	public int get_48() {
		return _48;
	}

	public int get_49() {
		return _49;
	}

	public int get_50() {
		return _50;
	}

	public int get_51() {
		return _51;
	}

	public int get_52() {
		return _52;
	}

	public int get_53() {
		return _53;
	}

	public int get_54() {
		return _54;
	}

	public int get_55() {
		return _55;
	}

	public int get_56() {
		return _56;
	}

	public int get_57() {
		return _57;
	}

	public int get_58() {
		return _58;
	}

	public int get_59() {
		return _59;
	}

	public int get_60() {
		return _60;
	}

	public int get_61() {
		return _61;
	}

	public int get_62() {
		return _62;
	}

	public int get_63() {
		return _63;
	}

	public int get_64() {
		return _64;
	}

	public int get_65() {
		return _65;
	}

	public int get_66() {
		return _66;
	}

	public int get_67() {
		return _67;
	}

	public int get_68() {
		return _68;
	}

	public int get_69() {
		return _69;
	}

	public int get_70() {
		return _70;
	}

	public int get_71() {
		return _71;
	}

	public int get_72() {
		return _72;
	}

	public int get_73() {
		return _73;
	}

	public int get_74() {
		return _74;
	}

	public int get_75() {
		return _75;
	}

	public int get_76() {
		return _76;
	}

	public int get_77() {
		return _77;
	}

	public int get_78() {
		return _78;
	}

	public int get_79() {
		return _79;
	}

	public int get_80() {
		return _80;
	}

	public int get_81() {
		return _81;
	}

	public int get_82() {
		return _82;
	}

	public int get_83() {
		return _83;
	}

	public int get_84() {
		return _84;
	}

	public int get_85() {
		return _85;
	}

	public int get_86() {
		return _86;
	}

	public int get_87() {
		return _87;
	}

	public int get_88() {
		return _88;
	}

	public int get_89() {
		return _89;
	}

	public int get_90() {
		return _90;
	}

	public int get_91() {
		return _91;
	}

	public int get_92() {
		return _92;
	}

	public int get_93() {
		return _93;
	}

	public int get_94() {
		return _94;
	}

	public int get_95() {
		return _95;
	}

	public int get_96() {
		return _96;
	}

	public int get_97() {
		return _97;
	}

	public int get_98() {
		return _98;
	}

	public int get_99() {
		return _99;
	}

	public int get_100() {
		return _100;
	}

	public int get_101() {
		return _101;
	}

	public int get_102() {
		return _102;
	}

	public int get_103() {
		return _103;
	}

	public int get_104() {
		return _104;
	}

	public int get_105() {
		return _105;
	}

	public int get_106() {
		return _106;
	}

	public int get_107() {
		return _107;
	}

	public int get_108() {
		return _108;
	}

	public int get_109() {
		return _109;
	}

	public int get_110() {
		return _110;
	}

	public int get_111() {
		return _111;
	}

	public int get_112() {
		return _112;
	}

	public int get_113() {
		return _113;
	}

	public int get_114() {
		return _114;
	}

	public int get_115() {
		return _115;
	}

	public int get_116() {
		return _116;
	}

	public int get_117() {
		return _117;
	}

	public int get_118() {
		return _118;
	}

	public int get_119() {
		return _119;
	}

	public int get_120() {
		return _120;
	}

	public int get_121() {
		return _121;
	}

	public int get_122() {
		return _122;
	}

	public int get_123() {
		return _123;
	}

	public int get_124() {
		return _124;
	}

	public int get_125() {
		return _125;
	}

	public int get_126() {
		return _126;
	}

	public int get_127() {
		return _127;
	}

	public int get_128() {
		return _128;
	}

	public int get_129() {
		return _129;
	}

	public int get_130() {
		return _130;
	}

	public int get_131() {
		return _131;
	}

	public int get_132() {
		return _132;
	}

	public int get_133() {
		return _133;
	}

	public int get_134() {
		return _134;
	}

	public int get_135() {
		return _135;
	}

	public int get_136() {
		return _136;
	}

	public int get_137() {
		return _137;
	}

	public int get_138() {
		return _138;
	}

	public int get_139() {
		return _139;
	}

	public int get_140() {
		return _140;
	}

	public int get_141() {
		return _141;
	}

	public int get_142() {
		return _142;
	}

	public int get_143() {
		return _143;
	}

	public int get_144() {
		return _144;
	}

	public int get_145() {
		return _145;
	}

	public int get_146() {
		return _146;
	}

	public int get_147() {
		return _147;
	}

	public int get_148() {
		return _148;
	}

	public int get_149() {
		return _149;
	}

	public int get_150() {
		return _150;
	}

	public int get_151() {
		return _151;
	}

	public int get_152() {
		return _152;
	}

	public int get_153() {
		return _153;
	}

	public int get_154() {
		return _154;
	}

	public int get_155() {
		return _155;
	}

	public int get_156() {
		return _156;
	}

	public int get_157() {
		return _157;
	}

	public int get_158() {
		return _158;
	}

	public int get_159() {
		return _159;
	}

	public int get_160() {
		return _160;
	}

	public int get_161() {
		return _161;
	}

	public int get_162() {
		return _162;
	}

	public int get_163() {
		return _163;
	}

	public int get_164() {
		return _164;
	}

	public int get_165() {
		return _165;
	}

	public void set_1(int _1) {
		this._1 = _1;
	}
	
	public void set_2(int _2) {
		this._2 = _2;
	}

	public void set_3(int _3) {
		this._3 = _3;
	}

	public void set_4(int _4) {
		this._4 = _4;
	}

	public void set_5(int _5) {
		this._5 = _5;
	}

	public void set_6(int _6) {
		this._6 = _6;
	}

	public void set_7(int _7) {
		this._7 = _7;
	}

	public void set_8(int _8) {
		this._8 = _8;
	}

	public void set_9(int _9) {
		this._9 = _9;
	}

	public void set_10(int _10) {
		this._10 = _10;
	}

	public void set_11(int _11) {
		this._11 = _11;
	}

	public void set_12(int _12) {
		this._12 = _12;
	}

	public void set_13(int _13) {
		this._13 = _13;
	}

	public void set_14(int _14) {
		this._14 = _14;
	}

	public void set_15(int _15) {
		this._15 = _15;
	}

	public void set_16(int _16) {
		this._16 = _16;
	}

	public void set_17(int _17) {
		this._17 = _17;
	}

	public void set_18(int _18) {
		this._18 = _18;
	}

	public void set_19(int _19) {
		this._19 = _19;
	}

	public void set_20(int _20) {
		this._20 = _20;
	}

	public void set_21(int _21) {
		this._21 = _21;
	}

	public void set_22(int _22) {
		this._22 = _22;
	}

	public void set_23(int _23) {
		this._23 = _23;
	}

	public void set_24(int _24) {
		this._24 = _24;
	}

	public void set_25(int _25) {
		this._25 = _25;
	}

	public void set_26(int _26) {
		this._26 = _26;
	}

	public void set_27(int _27) {
		this._27 = _27;
	}

	public void set_28(int _28) {
		this._28 = _28;
	}

	public void set_29(int _29) {
		this._29 = _29;
	}

	public void set_30(int _30) {
		this._30 = _30;
	}

	public void set_31(int _31) {
		this._31 = _31;
	}

	public void set_32(int _32) {
		this._32 = _32;
	}

	public void set_33(int _33) {
		this._33 = _33;
	}

	public void set_34(int _34) {
		this._34 = _34;
	}

	public void set_35(int _35) {
		this._35 = _35;
	}

	public void set_36(int _36) {
		this._36 = _36;
	}

	public void set_37(int _37) {
		this._37 = _37;
	}

	public void set_38(int _38) {
		this._38 = _38;
	}

	public void set_39(int _39) {
		this._39 = _39;
	}

	public void set_40(int _40) {
		this._40 = _40;
	}

	public void set_41(int _41) {
		this._41 = _41;
	}

	public void set_42(int _42) {
		this._42 = _42;
	}

	public void set_43(int _43) {
		this._43 = _43;
	}

	public void set_44(int _44) {
		this._44 = _44;
	}

	public void set_45(int _45) {
		this._45 = _45;
	}

	public void set_46(int _46) {
		this._46 = _46;
	}

	public void set_47(int _47) {
		this._47 = _47;
	}

	public void set_48(int _48) {
		this._48 = _48;
	}

	public void set_49(int _49) {
		this._49 = _49;
	}

	public void set_50(int _50) {
		this._50 = _50;
	}

	public void set_51(int _51) {
		this._51 = _51;
	}

	public void set_52(int _52) {
		this._52 = _52;
	}

	public void set_53(int _53) {
		this._53 = _53;
	}

	public void set_54(int _54) {
		this._54 = _54;
	}

	public void set_55(int _55) {
		this._55 = _55;
	}

	public void set_56(int _56) {
		this._56 = _56;
	}

	public void set_57(int _57) {
		this._57 = _57;
	}

	public void set_58(int _58) {
		this._58 = _58;
	}

	public void set_59(int _59) {
		this._59 = _59;
	}

	public void set_60(int _60) {
		this._60 = _60;
	}

	public void set_61(int _61) {
		this._61 = _61;
	}

	public void set_62(int _62) {
		this._62 = _62;
	}

	public void set_63(int _63) {
		this._63 = _63;
	}

	public void set_64(int _64) {
		this._64 = _64;
	}

	public void set_65(int _65) {
		this._65 = _65;
	}

	public void set_66(int _66) {
		this._66 = _66;
	}

	public void set_67(int _67) {
		this._67 = _67;
	}

	public void set_68(int _68) {
		this._68 = _68;
	}

	public void set_69(int _69) {
		this._69 = _69;
	}

	public void set_70(int _70) {
		this._70 = _70;
	}

	public void set_71(int _71) {
		this._71 = _71;
	}

	public void set_72(int _72) {
		this._72 = _72;
	}

	public void set_73(int _73) {
		this._73 = _73;
	}

	public void set_74(int _74) {
		this._74 = _74;
	}

	public void set_75(int _75) {
		this._75 = _75;
	}

	public void set_76(int _76) {
		this._76 = _76;
	}

	public void set_77(int _77) {
		this._77 = _77;
	}

	public void set_78(int _78) {
		this._78 = _78;
	}

	public void set_79(int _79) {
		this._79 = _79;
	}

	public void set_80(int _80) {
		this._80 = _80;
	}

	public void set_81(int _81) {
		this._81 = _81;
	}

	public void set_82(int _82) {
		this._82 = _82;
	}

	public void set_83(int _83) {
		this._83 = _83;
	}

	public void set_84(int _84) {
		this._84 = _84;
	}

	public void set_85(int _85) {
		this._85 = _85;
	}

	public void set_86(int _86) {
		this._86 = _86;
	}

	public void set_87(int _87) {
		this._87 = _87;
	}

	public void set_88(int _88) {
		this._88 = _88;
	}

	public void set_89(int _89) {
		this._89 = _89;
	}

	public void set_90(int _90) {
		this._90 = _90;
	}

	public void set_91(int _91) {
		this._91 = _91;
	}

	public void set_92(int _92) {
		this._92 = _92;
	}

	public void set_93(int _93) {
		this._93 = _93;
	}

	public void set_94(int _94) {
		this._94 = _94;
	}

	public void set_95(int _95) {
		this._95 = _95;
	}

	public void set_96(int _96) {
		this._96 = _96;
	}

	public void set_97(int _97) {
		this._97 = _97;
	}

	public void set_98(int _98) {
		this._98 = _98;
	}

	public void set_99(int _99) {
		this._99 = _99;
	}

	public void set_100(int _100) {
		this._100 = _100;
	}

	public void set_101(int _101) {
		this._101 = _101;
	}

	public void set_102(int _102) {
		this._102 = _102;
	}

	public void set_103(int _103) {
		this._103 = _103;
	}

	public void set_104(int _104) {
		this._104 = _104;
	}

	public void set_105(int _105) {
		this._105 = _105;
	}

	public void set_106(int _106) {
		this._106 = _106;
	}

	public void set_107(int _107) {
		this._107 = _107;
	}

	public void set_108(int _108) {
		this._108 = _108;
	}

	public void set_109(int _109) {
		this._109 = _109;
	}

	public void set_110(int _110) {
		this._110 = _110;
	}

	public void set_111(int _111) {
		this._111 = _111;
	}

	public void set_112(int _112) {
		this._112 = _112;
	}

	public void set_113(int _113) {
		this._113 = _113;
	}

	public void set_114(int _114) {
		this._114 = _114;
	}

	public void set_115(int _115) {
		this._115 = _115;
	}

	public void set_116(int _116) {
		this._116 = _116;
	}

	public void set_117(int _117) {
		this._117 = _117;
	}

	public void set_118(int _118) {
		this._118 = _118;
	}

	public void set_119(int _119) {
		this._119 = _119;
	}

	public void set_120(int _120) {
		this._120 = _120;
	}

	public void set_121(int _121) {
		this._121 = _121;
	}

	public void set_122(int _122) {
		this._122 = _122;
	}

	public void set_123(int _123) {
		this._123 = _123;
	}

	public void set_124(int _124) {
		this._124 = _124;
	}

	public void set_125(int _125) {
		this._125 = _125;
	}

	public void set_126(int _126) {
		this._126 = _126;
	}

	public void set_127(int _127) {
		this._127 = _127;
	}

	public void set_128(int _128) {
		this._128 = _128;
	}

	public void set_129(int _129) {
		this._129 = _129;
	}

	public void set_130(int _130) {
		this._130 = _130;
	}

	public void set_131(int _131) {
		this._131 = _131;
	}

	public void set_132(int _132) {
		this._132 = _132;
	}

	public void set_133(int _133) {
		this._133 = _133;
	}

	public void set_134(int _134) {
		this._134 = _134;
	}

	public void set_135(int _135) {
		this._135 = _135;
	}

	public void set_136(int _136) {
		this._136 = _136;
	}

	public void set_137(int _137) {
		this._137 = _137;
	}

	public void set_138(int _138) {
		this._138 = _138;
	}

	public void set_139(int _139) {
		this._139 = _139;
	}

	public void set_140(int _140) {
		this._140 = _140;
	}

	public void set_141(int _141) {
		this._141 = _141;
	}

	public void set_142(int _142) {
		this._142 = _142;
	}

	public void set_143(int _143) {
		this._143 = _143;
	}

	public void set_144(int _144) {
		this._144 = _144;
	}

	public void set_145(int _145) {
		this._145 = _145;
	}

	public void set_146(int _146) {
		this._146 = _146;
	}

	public void set_147(int _147) {
		this._147 = _147;
	}

	public void set_148(int _148) {
		this._148 = _148;
	}

	public void set_149(int _149) {
		this._149 = _149;
	}

	public void set_150(int _150) {
		this._150 = _150;
	}

	public void set_151(int _151) {
		this._151 = _151;
	}

	public void set_152(int _152) {
		this._152 = _152;
	}

	public void set_153(int _153) {
		this._153 = _153;
	}

	public void set_154(int _154) {
		this._154 = _154;
	}

	public void set_155(int _155) {
		this._155 = _155;
	}

	public void set_156(int _156) {
		this._156 = _156;
	}

	public void set_157(int _157) {
		this._157 = _157;
	}

	public void set_158(int _158) {
		this._158 = _158;
	}

	public void set_159(int _159) {
		this._159 = _159;
	}

	public void set_160(int _160) {
		this._160 = _160;
	}

	public void set_161(int _161) {
		this._161 = _161;
	}

	public void set_162(int _162) {
		this._162 = _162;
	}

	public void set_163(int _163) {
		this._163 = _163;
	}

	public void set_164(int _164) {
		this._164 = _164;
	}

	public void set_165(int _165) {
		this._165 = _165;
	}

	public LocalDate getDoa() {
		return doa;
	}

	public LocalDate getDod() {
		return dod;
	}

	public LocalDate getDateofvisit() {
		return dateofvisit;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDoa(LocalDate doa) {
		this.doa = doa;
	}

	public void setDod(LocalDate dod) {
		this.dod = dod;
	}

	public void setDateofvisit(LocalDate dateofvisit) {
		this.dateofvisit = dateofvisit;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getRegLoc() {
		return regLoc;
	}

	public String getAdmittedLoc() {
		return admittedLoc;
	}

	public String getNoise() {
		return noise;
	}

	public String getAncillary() {
		return ancillary;
	}

	public String getPharmacy() {
		return pharmacy;
	}

	public String getNoiseComment() {
		return noiseComment;
	}

	public String getRef_comment() {
		return ref_comment;
	}

	public void setRegLoc(String regLoc) {
		this.regLoc = regLoc;
	}

	public void setAdmittedLoc(String admittedLoc) {
		this.admittedLoc = admittedLoc;
	}

	public void setNoise(String noise) {
		this.noise = noise;
	}

	public void setAncillary(String ancillary) {
		this.ancillary = ancillary;
	}

	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	public void setNoiseComment(String noiseComment) {
		this.noiseComment = noiseComment;
	}

	public void setRef_comment(String ref_comment) {
		this.ref_comment = ref_comment;
	}

	public String getStaff_dept3() {
		return staff_dept3;
	}

	public void setStaff_dept3(String staff_dept3) {
		this.staff_dept3 = staff_dept3;
	}

	public String getStaff_dept4() {
		return staff_dept4;
	}

	public void setStaff_dept4(String staff_dept4) {
		this.staff_dept4 = staff_dept4;
	}

	public String getStaff_dept5() {
		return staff_dept5;
	}

	public void setStaff_dept5(String staff_dept5) {
		this.staff_dept5 = staff_dept5;
	}

	public String getStaff_dept6() {
		return staff_dept6;
	}

	public void setStaff_dept6(String staff_dept6) {
		this.staff_dept6 = staff_dept6;
	}

	public String getStaff_dept7() {
		return staff_dept7;
	}

	public void setStaff_dept7(String staff_dept7) {
		this.staff_dept7 = staff_dept7;
	}

	public String getStaff_dept8() {
		return staff_dept8;
	}

	public void setStaff_dept8(String staff_dept8) {
		this.staff_dept8 = staff_dept8;
	}

	public String getStaff_dept9() {
		return staff_dept9;
	}

	public void setStaff_dept9(String staff_dept9) {
		this.staff_dept9 = staff_dept9;
	}

	public String getStaff_dept10() {
		return staff_dept10;
	}

	public void setStaff_dept10(String staff_dept10) {
		this.staff_dept10 = staff_dept10;
	}

	public String getStaff_dept11() {
		return staff_dept11;
	}

	public void setStaff_dept11(String staff_dept11) {
		this.staff_dept11 = staff_dept11;
	}

	public String getStaff_dept12() {
		return staff_dept12;
	}

	public void setStaff_dept12(String staff_dept12) {
		this.staff_dept12 = staff_dept12;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public double getPsiRating() {
		return psiRating;
	}

	public void setPsiRating(double psiRating) {
		this.psiRating = psiRating;
	}

	public String getStaffRecommendation1() {
		return staffRecommendation1;
	}

	public void setStaffRecommendation1(String staffRecommendation1) {
		this.staffRecommendation1 = staffRecommendation1;
	}

	public String getStaffRecommendation2() {
		return staffRecommendation2;
	}

	public void setStaffRecommendation2(String staffRecommendation2) {
		this.staffRecommendation2 = staffRecommendation2;
	}

	public String getStaffRecommendation3() {
		return staffRecommendation3;
	}

	public void setStaffRecommendation3(String staffRecommendation3) {
		this.staffRecommendation3 = staffRecommendation3;
	}

	public String getStaffRecommendation4() {
		return staffRecommendation4;
	}

	public void setStaffRecommendation4(String staffRecommendation4) {
		this.staffRecommendation4 = staffRecommendation4;
	}

	public String getStaffRecommendation5() {
		return staffRecommendation5;
	}

	public void setStaffRecommendation5(String staffRecommendation5) {
		this.staffRecommendation5 = staffRecommendation5;
	}

	public String getStaffRecommendation6() {
		return staffRecommendation6;
	}

	public void setStaffRecommendation6(String staffRecommendation6) {
		this.staffRecommendation6 = staffRecommendation6;
	}

	public String getStaffRecommendation7() {
		return staffRecommendation7;
	}

	public void setStaffRecommendation7(String staffRecommendation7) {
		this.staffRecommendation7 = staffRecommendation7;
	}

	public String getStaffRecommendation8() {
		return staffRecommendation8;
	}

	public void setStaffRecommendation8(String staffRecommendation8) {
		this.staffRecommendation8 = staffRecommendation8;
	}

	public String getStaffRecommendation9() {
		return staffRecommendation9;
	}

	public void setStaffRecommendation9(String staffRecommendation9) {
		this.staffRecommendation9 = staffRecommendation9;
	}

	public String getStaffRecommendation10() {
		return staffRecommendation10;
	}

	public void setStaffRecommendation10(String staffRecommendation10) {
		this.staffRecommendation10 = staffRecommendation10;
	}

	public String getStaffRecommendation11() {
		return staffRecommendation11;
	}

	public void setStaffRecommendation11(String staffRecommendation11) {
		this.staffRecommendation11 = staffRecommendation11;
	}

	public String getStaffRecommendation12() {
		return staffRecommendation12;
	}

	public void setStaffRecommendation12(String staffRecommendation12) {
		this.staffRecommendation12 = staffRecommendation12;
	}

	public int getReferralSource1() {
		return referralSource1;
	}

	public void setReferralSource1(int referralSource1) {
		this.referralSource1 = referralSource1;
	}

	public int getReferralSource2() {
		return referralSource2;
	}

	public void setReferralSource2(int referralSource2) {
		this.referralSource2 = referralSource2;
	}

	public int getReferralSource3() {
		return referralSource3;
	}

	public void setReferralSource3(int referralSource3) {
		this.referralSource3 = referralSource3;
	}

	public int getReferralSource4() {
		return referralSource4;
	}

	public void setReferralSource4(int referralSource4) {
		this.referralSource4 = referralSource4;
	}

	public int getReferralSource5() {
		return referralSource5;
	}

	public void setReferralSource5(int referralSource5) {
		this.referralSource5 = referralSource5;
	}

	public int getReferralSource6() {
		return referralSource6;
	}

	public void setReferralSource6(int referralSource6) {
		this.referralSource6 = referralSource6;
	}

	public int getReferralSource7() {
		return referralSource7;
	}

	public void setReferralSource7(int referralSource7) {
		this.referralSource7 = referralSource7;
	}

	public int getReferralSource8() {
		return referralSource8;
	}

	public void setReferralSource8(int referralSource8) {
		this.referralSource8 = referralSource8;
	}

	public int getReferralSource9() {
		return referralSource9;
	}

	public void setReferralSource9(int referralSource9) {
		this.referralSource9 = referralSource9;
	}

	public int getReferralSource10() {
		return referralSource10;
	}

	public void setReferralSource10(int referralSource10) {
		this.referralSource10 = referralSource10;
	}

	public int getReferralSource11() {
		return referralSource11;
	}

	public void setReferralSource11(int referralSource11) {
		this.referralSource11 = referralSource11;
	}

	public int getReferralSource12() {
		return referralSource12;
	}

	public void setReferralSource12(int referralSource12) {
		this.referralSource12 = referralSource12;
	}

	public int getReferralSource13() {
		return referralSource13;
	}

	public void setReferralSource13(int referralSource13) {
		this.referralSource13 = referralSource13;
	}

	public int getReferralSource14() {
		return referralSource14;
	}

	public void setReferralSource14(int referralSource14) {
		this.referralSource14 = referralSource14;
	}

	public int getReferralSource15() {
		return referralSource15;
	}

	public void setReferralSource15(int referralSource15) {
		this.referralSource15 = referralSource15;
	}

	public int getReferralSource16() {
		return referralSource16;
	}

	public void setReferralSource16(int referralSource16) {
		this.referralSource16 = referralSource16;
	}

	public int getReferralSource17() {
		return referralSource17;
	}

	public void setReferralSource17(int referralSource17) {
		this.referralSource17 = referralSource17;
	}

	public int getReferralSource18() {
		return referralSource18;
	}

	public void setReferralSource18(int referralSource18) {
		this.referralSource18 = referralSource18;
	}

	public int getReferralSource19() {
		return referralSource19;
	}

	public void setReferralSource19(int referralSource19) {
		this.referralSource19 = referralSource19;
	}

	public int getReferralSource20() {
		return referralSource20;
	}

	public void setReferralSource20(int referralSource20) {
		this.referralSource20 = referralSource20;
	}

	public String getHospital_Recommendation() {
		return hospital_Recommendation;
	}

	public void setHospital_Recommendation(String hospital_Recommendation) {
		this.hospital_Recommendation = hospital_Recommendation;
	}

	public String getWardtype() {
		return wardtype;
	}

	public void setWardtype(String wardtype) {
		this.wardtype = wardtype;
	}

	public String getRepeatPatient() {
		return repeatPatient;
	}

	public void setRepeatPatient(String repeatPatient) {
		this.repeatPatient = repeatPatient;
	}


	public String getReferredPersonName() {
		return referredPersonName;
	}

	public void setReferredPersonName(String referredPersonName) {
		this.referredPersonName = referredPersonName;
	}

	public String getReferredPersonPhNo() {
		return referredPersonPhNo;
	}

	public void setReferredPersonPhNo(String referredPersonPhNo) {
		this.referredPersonPhNo = referredPersonPhNo;
	}

	public int getReferralSource21() {
		return referralSource21;
	}

	public void setReferralSource21(int referralSource21) {
		this.referralSource21 = referralSource21;
	}

	public int getHiSid() {
		return HiSid;
	}

	public void setHiSid(int hiSid) {
		HiSid = hiSid;
	}
	
	

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getPsi() {
		return psi;
	}

	public void setPsi(int psi) {
		this.psi = psi;
	}

//	public boolean hasStaff1() {
//		return StringUtils.isNotBlank(this.staff_dept1);
//	}
//	
//	public boolean hasStaff2() {
//		return StringUtils.isNotBlank(this.staff_dept2);
//	}
//	
//	public boolean hasStaff3() {
//		return StringUtils.isNotBlank(this.staff_dept3);
//	}

	public String getStaffNotRecommendation1() {
		return staffNotRecommendation1;
	}

	public void setStaffNotRecommendation1(String staffNotRecommendation1) {
		this.staffNotRecommendation1 = staffNotRecommendation1;
	}



	public String getPsiIndicator() {
		return psiIndicator;
	}

	public void setPsiIndicator(String psiIndicator) {
		this.psiIndicator = psiIndicator;
	}



	public String getCes_comment() {
		return cesComment;
	}

	public void setCes_comment(String ces_comment) {
		this.cesComment = ces_comment;
	}

	public String getCes_contNo() {
		return cesContNo;
	}

	public void setCes_contNo(String ces_contNo) {
		this.cesContNo = ces_contNo;
	}

	public String getSubUnit() {
		return subUnit;
	}

	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}

	public String getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	public String getCesComment() {
		return cesComment;
	}

	public void setCesComment(String cesComment) {
		this.cesComment = cesComment;
	}

	public String getCesContNo() {
		return cesContNo;
	}

	public void setCesContNo(String cesContNo) {
		this.cesContNo = cesContNo;
	}

	public int getTei1() {
		return tei1;
	}

	public void setTei1(int tei1) {
		this.tei1 = tei1;
	}

	public int getTei2() {
		return tei2;
	}

	public void setTei2(int tei2) {
		this.tei2 = tei2;
	}

	public int getTei3() {
		return tei3;
	}

	public void setTei3(int tei3) {
		this.tei3 = tei3;
	}

	public int getTei4() {
		return tei4;
	}

	public void setTei4(int tei4) {
		this.tei4 = tei4;
	}

	public int getTei5() {
		return tei5;
	}

	public void setTei5(int tei5) {
		this.tei5 = tei5;
	}

	public int getTei6() {
		return tei6;
	}

	public void setTei6(int tei6) {
		this.tei6 = tei6;
	}
	public int getTei7() {
		return tei7;
	}

	public void setTei7(int tei7) {
		this.tei7 = tei7;
	}


	
}
