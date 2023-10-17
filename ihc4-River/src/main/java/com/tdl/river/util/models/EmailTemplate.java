package com.tdl.river.util.models;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.tdl.river.models.Branch;
import com.tdl.river.models.Company;
import com.tdl.river.models.FactorName;
import com.tdl.river.models.Feedback;
import com.tdl.river.models.FeedbackComments;
import com.tdl.river.models.SupportRequest;
import com.tdl.river.models.Ticket;
import com.tdl.river.models.Users;
import com.tdl.river.oauth.AESencrp;

public class EmailTemplate {
	public String prepareSubFactorComment(FeedbackComments Fbcomments, int subfactorId) {
		String comment ="";
		if(FactorList!=null) {
			for(int i=0;i<FactorList.size();i++) {
				FactorName sub=FactorList.get(i);
				if(sub.getId()==subfactorId){
					int sequence=sub.getColQue();
					Class<?> classObj = Fbcomments.getClass();
			        try {
			        	 Method printMessage = classObj.getDeclaredMethod("getComment"+sequence);
			            Object cmtobj= printMessage.invoke(Fbcomments); 
			            comment=(String)cmtobj;
			        }
			        catch (InvocationTargetException e) 
			        {
			            System.out.println(e.getCause());
			        } catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	
		
		return comment;
	}
	public  String ticketBody(Feedback fb,Ticket t, Users user, String[] ccEmailList, Company comData, FeedbackComments comments, FactorName factorTicket) {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String date = t.getCreatedDate().format(formatters);
		String subServiceDetail="";
		if(fb.getCompanyID()==125 && fb.getType().equalsIgnoreCase("IP")) {
			subServiceDetail="(Poor rating is for "+t.getFactorName()+")";
		}else 
			 subServiceDetail="(Poor rating is for "+t.getFactorName()+" -> ";
			
		if(fb.getCompanyID()==125 && fb.getType().equalsIgnoreCase("OP")) {
			
			if(FactorList!=null) {
				for(int i=0;i<FactorList.size();i++) {
					FactorName sub=FactorList.get(i);
					String subName=sub.getFactor_name();
					String subComt="";
					if(t.getFeedbackComments().contains(subName)){
					int seq=sub.getColQue();
					Class<?> classObj = comments.getClass();
					  
			        // get method object for "printMessage" function by
			        // name
			        try {
			        	 Method printMessage = classObj.getDeclaredMethod("getComment"+seq);
			            // invoke the function using this class obj
			            // pass in the class object
			            Object cmtobj= printMessage.invoke(comments); 
			            if(cmtobj!=null)
			            subComt=(String)cmtobj;
			            
			        }
			        
			        catch (InvocationTargetException e) 
			        {
			            System.out.println(e.getCause());
			        } catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					subServiceDetail+= " "+sub.getFactor_name()+" :- "+subComt+" ,";
					}
						
				}
				subServiceDetail+=")";
			}
		}
		String branch="";
		if(comments==null) {
			comments = new FeedbackComments();
		}
		System.out.println("Branch Id "+ fb.getBranchID());
		if(fb.getCompanyID()==127) {
			if(fb.getBranchID()==32)
				branch="GM";
			else if(fb.getBranchID()==33)
				branch="NEP";
			else if(fb.getBranchID()==34)
				branch="CAR";
			else if(fb.getBranchID()==35)
				branch="GAS";
			else if(fb.getBranchID()==36)
				branch="ICU";
			else if(fb.getBranchID()==37)
				branch="GEN";
			else if(fb.getBranchID()==38)
				branch="NEURO";
			else if(fb.getBranchID()==39)
				branch="URO";
			else if(fb.getBranchID()==40)
				branch="CTVT";
			else if(fb.getBranchID()==41)
				branch="ORTHO";
			else if(fb.getBranchID()==42)
				branch="OBS";
			else if(fb.getBranchID()==43)
				branch="PAED";
			else if(fb.getBranchID()==44)
				branch="ENT";
			else if(fb.getBranchID()==45)
				branch="ORTHAL";
			else if(fb.getBranchID()==46)
				branch="CA";
			else if(fb.getBranchID()==47)
				branch="DERM";
			else if(fb.getBranchID()==48)
				branch="PSY";
			else if(fb.getBranchID()==49)
				branch="DEN";
		}else if(fb.getCompanyID()==131) {
			if(fb.getBranchID()==51)
				branch="GGHC";
			else if(fb.getBranchID()==52)
				branch="BGS";
			else if(fb.getBranchID()==53)
				branch="CDKD";
			else if(fb.getBranchID()==54)
				branch="LKP";
			else if(fb.getBranchID()==55)
				branch="LBN";
			else if(fb.getBranchID()==56)
				branch="GGHCS";
			else if(fb.getBranchID()==57)
				branch="BGSS";
		}if(fb.getCompanyID()==133) {
			if(fb.getBranchID()==60)
				branch="SHH";
			else if(fb.getBranchID()==61)
				branch="AH";
			else if(fb.getBranchID()==62)
				branch="SE";
			else if(fb.getBranchID()==63)
				branch="MMC";
			else if(fb.getBranchID()==64)
				branch="DDH";
			else if(fb.getBranchID()==65)
				branch="CSMC";
			else if(fb.getBranchID()==66)
				branch="RMC";
			else if(fb.getBranchID()==67)
				branch="OLOLH";
			else if(fb.getBranchID()==68)
				branch="DLSMC";
			else if(fb.getBranchID()==69)
				branch="CLDH";
			else if(fb.getBranchID()==70)
				branch="WMMC";
			else if(fb.getBranchID()==71)
				branch="HHMH";
			else if(fb.getBranchID()==72)
				branch="MVMC";
			else if(fb.getBranchID()==73)
				branch="DJSH";
			else if(fb.getBranchID()==74)
				branch="MJSH";
			else if(fb.getBranchID()==75)
				branch="LBDH";
			else if(fb.getBranchID()==76)
				branch="RCH";
			else if(fb.getBranchID()==77)
				branch="CMC";
			else if(fb.getBranchID()==78)
				branch="CCHAMC";
		}
		else {
		if(fb.getBranchID()==4)  
			branch="IR";
		 else if(fb.getBranchID()==5) 
			branch="YESH";
		else if(fb.getBranchID()==6) 
			branch="MRN";
		else if(fb.getBranchID()==7) 
			branch="HC";
		else if(fb.getBranchID()==27)
			branch="BOG";
		else if(fb.getBranchID()==28)
			branch="HYD";
		else if(fb.getBranchID()==29)
			branch="OP CL";
		else if(fb.getBranchID()==30)
			branch="SH";
		else if(fb.getBranchID()==31)
			branch="MIY";
		else if(fb.getBranchID()==51)
			branch="BEL";
		else 
			branch="";
		}
		String type = fb.getType();
		if(fb.getCompanyID()==120) {//for BV
			if(fb.getType().equals("IPC"))
				type = "Complaint";
		}
		
		//String login ="https://cempia.com/"+domain+"/l2t?url=p&p="+ticketDetails[5];
		String login = "https://cempia.com/"+comData.getPathName();
		String bodyOfMail = "<BR>";
		bodyOfMail +="<html><body> <head> <meta charset='UTF-8'> <div style='width:100%;' align='center'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='center' valign='top' style='background-color:#fffff;' bgcolor='#fffff;'><br><br>"
				+ "<table width='583' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td width='75%'></td><td height='50' valign='middle' > </td>"
				+ "<td width='30%' valign='right'  style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b> &nbsp;&nbsp;&nbsp;</b></td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#FFFFFF' style='background-color:#FFFFFF; border-style: solid;    border-width: 0px 2px 0px 2px; border-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35' align='left' valign='top'>&nbsp;</td><td align='left' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td align='center' valign='top'><div style='color:#245da5; font-family:Times New Roman, Times, serif; font-size:20px;'>";
		
				bodyOfMail +="Dear "+user.getUsername()+",<br>The following ticket is for your kind action"+"</b></i><br>";
				bodyOfMail +="</div></td></tr><tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'><br><br><table width='100%' border='0' cellspacing='5' cellpadding='0'><tr ><td width='100%' height='30' align='center'  bgcolor='#86BBED' colspan=2 style='font-size:16px; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; background-color:#86BBED; font-weight: bold;'><u>Ticket Details</u></td></tr><tr >";
				if (fb.getCompanyID() == 117) {
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Name </td>";
					bodyOfMail += "<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "
							+ AESencrp.decrypt(fb.getName()) + " </td>";

					bodyOfMail += "</tr><tr >";
					String mrn = "UHID";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>"
							+ mrn + " </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "
							+ AESencrp.decrypt(fb.getRefNo()) + "</td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Mobile Number </td>";

					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "
							+ AESencrp.decrypt(fb.getContactNo()) + " </td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Type </td>";

					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "
							+ type + " </td>";
					bodyOfMail += "</tr>";

					String val1 = "";
					String val2 = "";
					if (fb.getType().equals("IP") || fb.getType().equals("OP")) {// sparsh
						if (fb.getType().equals("IP")) {
							val1 = "Room Number";
							val2 = fb.getRoomNo();
							if (fb.getRoomNo() == null)
								val2 = "";
						}
						if (fb.getType().equals("OP")) {
							val1 = "Speciality";
							val2 = fb.getDepartment();
							if (fb.getDepartment() == null)
								val2 = "";

						}
						bodyOfMail += "<tr>";
						bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>"
								+ val1 + " </td>";

						bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "
								+ val2 + " </td>";
						bodyOfMail += "</tr>";
					}
					bodyOfMail += "<tr ><td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Number  </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:"
							+ branch + "  " + t.getTicketNumber() + " </td>";

					bodyOfMail += "</tr><tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Generated Date & Time </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "
							+ date + " </td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Reason for Ticket  </td>";
					bodyOfMail += "<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
							+ t.getFeedbackComments() + "</td></tr>";
					bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Message  </td>";
					bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
							+ ((fb.getComments() == null || fb.getComments().trim().length() == 0) ? " - "
									: fb.getComments())
							+ " </td>";
					bodyOfMail += "</tr>";
				} else {

					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Number  </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
							+ ((branch!=null)?(branch + " - "):"") + t.getTicketNumber() + " </td>";
                    
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Name </td>";
					bodyOfMail += "<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "
							+ AESencrp.decrypt(fb.getName()) + " </td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Mobile Number </td>";
					
					if(fb.getCompanyID() == 121)
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "
							+"******"+ AESencrp.decrypt(fb.getContactNo()).substring(AESencrp.decrypt(fb.getContactNo()).length()-4) + " </td>";
					else
						bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "
								+ AESencrp.decrypt(fb.getContactNo()) + " </td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Type </td>";

					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "
							+ type + " </td>";
					bodyOfMail += "</tr>";
					
					String bed;
					String doctor_name;
					if (fb.getCompanyID() == 120) {
					if(fb.getBedNo()!=null && !fb.getBedNo().equals("")) {
						bed = fb.getBedNo();
					}else
						bed = "NA";
					if(fb.getDoctor()!=null && !fb.getDoctor().equals("")) {
						doctor_name = fb.getDoctor();

					}else
						doctor_name = "NA";

					bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Bed No </td>";

					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "
							+ bed + " </td>";
					bodyOfMail += "</tr><tr >";
					 
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Consultant Name </td>";

					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "
							+ doctor_name + " </td>";
					bodyOfMail += "</tr>";
					}
					
					
					
					String mrn = "MRN";
					if (fb.getCompanyID() == 116)
						mrn = "UHID";
					else if (fb.getCompanyID() == 115)
						mrn = "IP/OP Number";
					else if (fb.getCompanyID() == 118)
						mrn = "Patient ID";
					else if (fb.getCompanyID() == 119)
						mrn = "Hospital No";
					else if (fb.getCompanyID() == 120)
						mrn = "BHID";
					else if (fb.getCompanyID() == 122 || fb.getCompanyID() == 137)
						mrn = "I/C Number";
					else if (fb.getCompanyID() == 126)
						mrn = "File Number";
					
					bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>"
							+ mrn + " </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "
							+ AESencrp.decrypt(fb.getRefNo()) + "</td>";
					bodyOfMail += "</tr>";
					bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Generated Date & Time </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "
							+ date + " </td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Reason for Ticket  </td>";
					if(fb.getCompanyID()==125) {
//						bodyOfMail += "<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
//								+ subServiceDetail + "</td></tr>";
						bodyOfMail += "<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
								+ t.getFeedbackComments() + "</td></tr>";
					}
					else {
					bodyOfMail += "<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
							+ t.getFeedbackComments() + "</td></tr>";
					}
					if(fb.getCompanyID() == 115 && t.getFactorName().equals("OVERALL_EXPERIENCE") ) {
						bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Message  </td>";
						bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
								+ ((fb.getComments() == null || fb.getComments().trim().length() == 0) ? " - "
										: fb.getComments())
								+ " </td>";
						bodyOfMail += "</tr>";
					}else if(fb.getCompanyID() != 115){
						bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Message  </td>";
						bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
								+ ((fb.getComments() == null || fb.getComments().trim().length() == 0) ? " - "
										: fb.getComments())
								+ " </td>";
						bodyOfMail += "</tr>";
						if(fb.getCompanyID() == 122 || fb.getCompanyID() == 137){
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Service Comments  </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((feedbackComment(fb.getId(),factorTicket.getSequence(),comments) == null || feedbackComment(fb.getId(),factorTicket.getSequence(),comments).trim().length() == 0) ? " - "
											: feedbackComment(fb.getId(),factorTicket.getSequence(),comments))
									+ " </td>";
							bodyOfMail += "</tr>";
						}else if(fb.getCompanyID() == 125) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Service Comments  </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((t.getAudioComments() == null || t.getAudioComments().trim().length() == 0) ? " - "
											: t.getAudioComments())
									+
									" </td>";
							bodyOfMail += "</tr>";
						}
						if (fb.getType().equals("OP")) {
						if(fb.getCompanyID()==121 && t.getFactorName().equals("Appointment/Registration")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment6() == null || comments.getComment6().trim().length() == 0) ? " - "
											: comments.getComment6())
									+
									" </td>";
								
						}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Consultants")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment7() == null || comments.getComment7().trim().length() == 0) ? " - "
											: comments.getComment7())
									+
									" </td>";
								
						}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Radiology Services")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment8() == null || comments.getComment8().trim().length() == 0) ? " - "
											: comments.getComment8())
									+
									" </td>";
								
						}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Nursing Staff")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment9() == null || comments.getComment9().trim().length() == 0) ? " - "
											: comments.getComment9())
									+
									" </td>";
								
						}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Laboratory Services")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment10() == null || comments.getComment10().trim().length() == 0) ? " - "
											: comments.getComment10())
									+
									" </td>";
								
						}
						else if(fb.getCompanyID()==121 && t.getFactorName().equals("Hospital Ambience")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment11() == null || comments.getComment11().trim().length() == 0) ? " - "
											: comments.getComment11())
									+
									" </td>";
								
						}
						else if(fb.getCompanyID()==121 && t.getFactorName().equals("Pharmacy Services")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment12() == null || comments.getComment12().trim().length() == 0) ? " - "
											: comments.getComment12())
									+
									" </td>";
								
						}
						else if(fb.getCompanyID()==121 && t.getFactorName().equals("Housekeeping Services")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment13() == null || comments.getComment13().trim().length() == 0) ? " - "
											: comments.getComment13())
									+
									" </td>";
								
						}
						else if(fb.getCompanyID()==121 && t.getFactorName().equals("Patient Care Assistant")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment14() == null || comments.getComment14().trim().length() == 0) ? " - "
											: comments.getComment14())
									+
									" </td>";
								
						}
						else if(fb.getCompanyID()==121 && t.getFactorName().equals("Maintenance and Interiors")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment15() == null || comments.getComment15().trim().length() == 0) ? " - "
											: comments.getComment15())
									+
									" </td>";
								
						}
						else if(fb.getCompanyID()==121 && t.getFactorName().equals("Security Services")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment16() == null || comments.getComment16().trim().length() == 0) ? " - "
											: comments.getComment16())
									+
									" </td>";
								
						}
						else if(fb.getCompanyID()==121 && t.getFactorName().equals("Billing and Financial Counselling")) {
							bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
							bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
									+ ((comments.getComment17() == null || comments.getComment17().trim().length() == 0) ? " - "
											: comments.getComment17())
									+
									" </td>";
								
						}
					}// end for OP poor rate comment 
						
						if (fb.getType().equals("IP")) {
							if(fb.getCompanyID()==121 && t.getFactorName().equals("Admission Process")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment6() == null || comments.getComment6().trim().length() == 0) ? " - "
												: comments.getComment6())
										+
										" </td>";
									
							}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Consultants")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment7() == null || comments.getComment7().trim().length() == 0) ? " - "
												: comments.getComment7())
										+
										" </td>";
									
							}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Duty Medical Officers")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment8() == null || comments.getComment8().trim().length() == 0) ? " - "
												: comments.getComment8())
										+
										" </td>";
									
							}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Nursing Staff")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment9() == null || comments.getComment9().trim().length() == 0) ? " - "
												: comments.getComment9())
										+
										" </td>";
									
							}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Diagnostic Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment10() == null || comments.getComment10().trim().length() == 0) ? " - "
												: comments.getComment10())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Hospital Ambience")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment11() == null || comments.getComment11().trim().length() == 0) ? " - "
												: comments.getComment11())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Patient Relations Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment12() == null || comments.getComment12().trim().length() == 0) ? " - "
												: comments.getComment12())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Dietary Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment13() == null || comments.getComment13().trim().length() == 0) ? " - "
												: comments.getComment13())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Food and Beverages Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment14() == null || comments.getComment14().trim().length() == 0) ? " - "
												: comments.getComment14())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Housekeeping Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment15() == null || comments.getComment15().trim().length() == 0) ? " - "
												: comments.getComment15())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Patient Care Assistant")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment16() == null || comments.getComment16().trim().length() == 0) ? " - "
												: comments.getComment16())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Maintenance and Interiors")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment17() == null || comments.getComment17().trim().length() == 0) ? " - "
												: comments.getComment17())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Security Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment18() == null || comments.getComment18().trim().length() == 0) ? " - "
												: comments.getComment18())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Financial Counselling")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment19() == null || comments.getComment19().trim().length() == 0) ? " - "
												: comments.getComment19())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Discharge and Billing Process")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment20() == null || comments.getComment20().trim().length() == 0) ? " - "
												: comments.getComment20())
										+
										" </td>";
									
							}
						}// end for IP poor rate comment 
						

						if (fb.getType().equals("DC")) {
							if(fb.getCompanyID()==121 && t.getFactorName().equals("Appointment/Registration")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment6() == null || comments.getComment6().trim().length() == 0) ? " - "
												: comments.getComment6())
										+
										" </td>";
									
							}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Consultants")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment7() == null || comments.getComment7().trim().length() == 0) ? " - "
												: comments.getComment7())
										+
										" </td>";
									
							}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Radiation Therapy")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment8() == null || comments.getComment8().trim().length() == 0) ? " - "
												: comments.getComment8())
										+
										" </td>";
									
							}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Chemotherapy")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment9() == null || comments.getComment9().trim().length() == 0) ? " - "
												: comments.getComment9())
										+
										" </td>";
									
							}else if(fb.getCompanyID()==121 && t.getFactorName().equals("Ancillary / Diagnostic Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment10() == null || comments.getComment10().trim().length() == 0) ? " - "
												: comments.getComment10())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Hospital Ambience")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment11() == null || comments.getComment11().trim().length() == 0) ? " - "
												: comments.getComment11())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Patient Relations Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment12() == null || comments.getComment12().trim().length() == 0) ? " - "
												: comments.getComment12())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Nursing Staff")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment13() == null || comments.getComment13().trim().length() == 0) ? " - "
												: comments.getComment13())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Food and Beverages Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment14() == null || comments.getComment14().trim().length() == 0) ? " - "
												: comments.getComment14())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Housekeeping Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment15() == null || comments.getComment15().trim().length() == 0) ? " - "
												: comments.getComment15())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Patient Care Assistant")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment16() == null || comments.getComment16().trim().length() == 0) ? " - "
												: comments.getComment16())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Maintenance and Interiors")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment17() == null || comments.getComment17().trim().length() == 0) ? " - "
												: comments.getComment17())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Security Services")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment18() == null || comments.getComment18().trim().length() == 0) ? " - "
												: comments.getComment18())
										+
										" </td>";
									
							}
							else if(fb.getCompanyID()==121 && t.getFactorName().equals("Discharge and Billing Process")) {
								bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Comments for Poor rating </td>";
								bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
										+ ((comments.getComment19() == null || comments.getComment19().trim().length() == 0) ? " - "
												: comments.getComment19())
										+
										" </td>";
									
							}
						}// end for DC poor rate comment
					}
					

				}
		
		if(fb.getCompanyID()!=122 && fb.getCompanyID()!=137  ) { //this condition check is written to avoid two times comment for sunway and smcv
			if((fb.getCompanyID()==118 || comData.getServiceCmts()==1) && comments!=null && factorTicket!=null && factorTicket.getCmtCol()!=0 ) {// ruby hall service cmts
				int colVal = factorTicket.getCmtCol();
				String cmt="";
			//	(fb, "_" + index);
				if(colVal!=0)
					cmt = getFieldValue(comments,"comment"+colVal);
				bodyOfMail += "<tr > <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Service Comment </td>";
				bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+ cmt + "</td>";
				bodyOfMail += "</tr>";
				
			}
		}
		

		bodyOfMail +="</table></td></tr><tr>"
				+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b>Please login to CEMPIA platform to take action</b><br>";
		bodyOfMail += "<a href="+login+"><button>CEMPIA</button></a>";
		bodyOfMail +="</td><td width='35' > </td></tr></table></td></tr></table><br><br></td></tr>";
		bodyOfMail += "</table></div>";
		bodyOfMail += "<div><table>";
	/*	bodyOfMail +="<tr><td>Mail To</td><td>"+user.getEmail()+"</td></tr>";
		bodyOfMail +="<tr><td>CC To</td><td>"+Arrays.toString(ccEmailList)+"</td></tr>";*/
		bodyOfMail +="</table></div>";
		bodyOfMail += " </head></body></html>";
		bodyOfMail +="";
		bodyOfMail +="";
			//testing
		
		/*
		 * bodyOfMail +="<tr >"; bodyOfMail
		 * +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>TO Mail  </td>"
		 * ; bodyOfMail
		 * +="<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
		 * +ticketDetails[5]+"</td></tr><tr>"; bodyOfMail
		 * +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Escaltion Includes  </td>"
		 * ; bodyOfMail
		 * +="<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "
		 * +ticketDetails[6]+"</td>"; bodyOfMail +="</tr>";
		 */
		 
//		logger.info(bodyOfMail);
		
        return bodyOfMail;
		
	}
	private String feedbackComment(int feedbackId, int sequence,FeedbackComments comments) {
		 String serviceQuestion="";
		switch (sequence) {
	      case 1:
	    	  serviceQuestion=comments.getComment3();
	    	  break;
	      case 2:
	    	  serviceQuestion=comments.getComment4();
	    	  break;
	      case 3:
	    	  serviceQuestion=comments.getComment5();
	    	  break;
	      case 4:
	    	  serviceQuestion=comments.getComment1();
	    	  break;
	      case 5:
	    	  serviceQuestion=comments.getComment6();
	    	  break;
	      case 6:
	    	  serviceQuestion=comments.getComment7();
	    	  break;
	      case 7:
	    	  serviceQuestion=comments.getComment8();
	    	  break;
	    }
		// TODO Auto-generated method stub
		return serviceQuestion;
	}
	
	

	private static LocalDateTime getLocalTime(int countryID) {
		 LocalDateTime ldt = LocalDateTime.now().plusHours(5);
		 ldt = ldt.plusMinutes(30);//Local date time
		 String timeZone = "Asia/Calcutta";
			if(countryID==2)
				timeZone = "Asia/Kuala_Lumpur";//malaysia
			else if(countryID==3)
				timeZone = "Asia/Ho_Chi_Minh";//vitename
			else if(countryID==4)
				timeZone = "Asia/Jakarta";//indonesiya
			ZoneId zoneId = ZoneId.of(timeZone);
			ldt = ldt.now(zoneId);
		 return ldt;
	}

	
	public static String emailCredentails(Users u, String pathName) {
		String msg ="<h4 style='color:orange'> Dear "+u.getUsername()+",</h4>"
					+"<p>&nbsp;&nbsp;&nbsp;Please find CEMPIA platform credential for portal access</p>"
					+"<p>Trust this helps.</p><br>"
					+"<p>Login URL link https://cempia.com/"+pathName+" </p>"
					+"<p>User Login ID : "+u.getEmail()+"</p>"
					+"<p>User Password : "+AESencrp.decrypt(u.getPCIPHERPASSWORD())+"</p><br>"
					+"<p>Do feel free to reach the operations team for any clarification on the CEMPIA.</P><br>"
					+"<p>With Best Regards,</P>"
					+"<p>Team CEMPIA</P>";
					
					/*+"<p>Feel free to connect CEMPIA support team for further clarifications at colasia@thedecisionlabs.com</p>"*/
				
		return msg;
		}
	
	public static String resetLink(Users u, String pathName) {
		String msg ="<h4 style='color:orange'> Dear "+u.getUsername()+",</h4>"
					+"<p>&nbsp;&nbsp;&nbsp;Click on the following button to create a new password for your CEMPIA account</p>"
					+"<p><a href='https://cempia.com/"+pathName+"/resetLink?companyID="+u.getCompanyID()+"&_1="+AESencrp.encrypt(Integer.toString(u.getId()))+"'><button>CEMPIA Reset Password</button><a></p>"
					+"<p>Trust this helps.</p><br>"
					+"<p>Do feel free to reach the operations team for any clarification on the CEMPIA.</P><br>"
					+"<p>With Best Regards,</P>"
					+"<p>Team CEMPIA</P>";
					
					/*+"<p>Feel free to connect CEMPIA support team for further clarifications at colasia@thedecisionlabs.com</p>"*/
				
		return msg;
		}

	public static  String cempiaNewReqTemplate(SupportRequest reqData, Company company, Users user, Branch branch) {
		String msg ="<hr><h4 style='color:orange'> Hello  CEMPIA Team</h4>"
				+"<p>&nbsp;&nbsp;&nbsp; A new service request have been raised from <b>"+company.getCompany_name()+" - "+branch.getName()+"</b> by <b>"+user.getUsername()+"</b> following are the service request</p>"
				+"<table style='background-color:lightgray;width:100%'><tr style='background-color:#8aa5d2;height:100px;font-size:15px'>"
				+"<th >Request ID</th><th>Email</th><th>Request Type</th><th>Request Subject</th><th>Request Nature</th><th>Request Description</th></tr>"
				+"<tr style='font-size:15px;height:150px;'>"
				+"<td>"+branch.getBranch_code()+"-"+reqData.getReqNo()+"</td><td>"+user.getEmail()+"</td><td>"+reqData.getNature()+"</td><td>"+reqData.getSubject()+"</td><td>"+reqData.getReqType()+"</td><td>"+reqData.getDescription()+"</td>"
				+"</tr></table><br><br><hr><br><br>"
				+"<BR><BR><BR> Please login to CEMPIA platform to take action"
				+"<p>https://cempia.com/"+company.getPathName()+"/supportAdminLogin</p>";
			return msg;
	}

	public static String clientNewReqTemplate(SupportRequest reqData, Company company, Users user, Branch branch) {
		String msg ="<p style='text-align:right;font-size:20px'><b>Request Tracking</b></p>"
				+"<p style='text-align:right;font-size:18px'>Request ID :"+branch.getBranch_code()+"-"+reqData.getReqNo()+"</p><hr>"
				+"<h4 style='color:orange'> Hello "+user.getUsername()+"</h4>"
				+"<p>&nbsp;&nbsp;&nbsp; Thank You for submitting your request.We will get back to you soon. Following are your request details</p>"
				+"<table style='background-color:lightgray;'><tr style='background-color:#2874f0;height:10%;font-size:15px'>"
				+"<th >Request ID</th><th>EMAIL</th><th>REQUEST TYPE</th><th>REQUEST SUBJECT</th><th>REQUEST NATURE</th><th>REQUEST DESCRIPTION</th></tr>"
				+"<tr style='font-size:15px'>"
				+"<td>"+branch.getBranch_code()+"-"+reqData.getReqNo()+"</td><td>"+user.getEmail()+"</td><td>"+reqData.getNature()+"</td><td>"+reqData.getSubject()+"</td><td>"+reqData.getReqType()+"</td><td>"+reqData.getDescription()
				
				+"<tr></table>"
				+"<br><hr><p >Warm Regards<br> CEMPIA Team</p></div>";
			
	return msg;
	}

	public static String ClientStatusUpdate(SupportRequest supportReq, Company clientDetails, Users user,
			Branch branch) {
		String msg ="<p style='text-align:right;font-size:20px'><b>Request Tracking</b></p>"
				+"<p style='text-align:right;font-size:18px'>Request ID :"+branch.getBranch_code()+"-"+supportReq.getReqNo()+" Status:"+supportReq.getReqStatus()+"</p> <hr>"
				+"<h4 style='color:orange'> Hello "+user.getUsername()+"</h4>"
				+"<p>&nbsp;&nbsp;&nbsp;Your Request number <b>"+branch.getBranch_code()+"-"+supportReq.getReqNo()+"</b> for <b>"+supportReq.getSubject()+"</b>  has been updated by CEMPIA Team </p>"
				+"<p>CEMPIA Response: <b>"+supportReq.getResponseNote()+"</b></p><br>"
				/*+"<p>Feel free to connect CEMPIA support team for further clarifications at colasia@thedecisionlabs.com</p>"*/
				+"<br><hr><p >Warm Regards<br> CEMPIA Team</p></div>";
			
	return msg;
	}

	public static String CempiaTeamBody(SupportRequest s, Company company, Users user, Branch branch, Company clientDetails) {
		String msg ="<hr><h4 style='color:orange'> Hello  CEMPIA Team</h4>"
				+"<p>&nbsp;&nbsp;&nbsp; A new service request have been raised from <b>"+clientDetails.getCompany_name()+" - "+branch.getName()+"</b> and assigned to you following are the service request</p>"
				+"<table style='background-color:lightgray;'><tr style='background-color:#2874f0;height:10%;font-size:15px'>"
				+"<th >Request ID</th><th>SUBJECT</th><th>REQUEST TYPE</th><th>REQUEST NATURE</th><th>REQUEST DESCRIPTION</th>"
				+"<th >RESPONSE NOTE</th><th>MANAGEMENT NOTE</th><th>EFFORT</th><th >STATUS</th><th >DELIVERY DATE</th></tr>"
				+"<tr style='font-size:15px'>"
				+"<td>"+branch.getBranch_code()+"-"+s.getReqNo()+"</td><td>"+s.getSubject()+"</td><td>"+s.getReqType()+"</td><td>"+s.getNature()+"</td><td>"+s.getDescription()
				+"<td>"+s.getResponseNote()+"</td><td>"+s.getManagementNote()+"</td><td>"+s.getEffort()+"</td><td >"+s.getReqStatus()+"</td><td>"+s.getDeliveryDate()+"</td></tr>"
				+"</table><hr><br><br>"
				+"Please login to CEMPIA platform for more details <br>URL : http://cempia.com/"+clientDetails.getPathName()+"/supportAdminLogin";
		return msg;
	}

//	public static String DailyReportBranch(List<Summary> dailyReport, Summary total, List<String[]> complaintData) {
//		List<ScoreCard> ipService = dailyReport.get(0).getScoreCard();
//		List<ScoreCard> opService = dailyReport.get(1).getScoreCard();
//		String[] arr = {"IP","OP","Total"};
//		String body="";
//		body+="<div><b>Overview Summary</</div>";
//		body+="<table border='1'  width='100%;' ><tr style='background:#0470ab;color:white;align:center'><td>Type</td><td>Feedback Collected</td><td>High PSI</td><td>Medium PSI</td><td>Low PSI</td><td>Complaints</td><td>Resolved</td><td>Resolution %</td></tr>";
//		int i=0;
//		for (Iterator<Summary> iterator = dailyReport.iterator(); iterator.hasNext();) {
//			Summary summary = (Summary) iterator.next();
//			body+="<tr><td>"+arr[i]+"</td>";
//			body+="<td>"+summary.getFeedbackCount()+"</td>";
//			body+="<td>"+summary.getHighPsi()+"</td>";
//			body+="<td>"+summary.getMediumPsi()+"</td>";
//			body+="<td>"+summary.getLowPsi()+"</td>";
//			body+="<td>"+summary.getTotalTicket()+"</td>";
//			body+="<td>"+summary.getClosed()+"</td>";
//			body+="<td>"+summary.getClosedResolution()+"</td>";
//			body+="</tr>";
//			i++;
//			
//		}
//		body+="<tr><td>"+arr[i]+"</td>";
//		body+="<td>"+total.getFeedbackCount()+"</td>";
//		body+="<td>"+total.getHighPsi()+"</td>";
//		body+="<td>"+total.getMediumPsi()+"</td>";
//		body+="<td>"+total.getLowPsi()+"</td>";
//		body+="<td>"+total.getTotalTicket()+"</td>";
//		body+="<td>"+total.getClosed()+"</td>";
//		body+="<td>"+total.getClosedResolution()+"</td>";
//		body+="</tr>";
//		body+="</table>";
//		
//		body+="<br> <div><b>PSI Score</div>";
//		body+="<table>";
//		body+="<tr><td><table border='1' width='100%'>";
//		body+="<tr style='background:#0470ab;color:white;align:center'><td>IP</td><td>Score</td><tr>";
//		for (Iterator iterator = ipService.iterator(); iterator.hasNext();) {
//			ScoreCard scoreCard = (ScoreCard) iterator.next();
//			String val = scoreCard.getSubServiceScore();
//			if(val==null)
//				val="NA";
//			body+="<tr><td>"+scoreCard.getFactorName()+"</td><td>"+val+"</td><tr>";
//			
//		}
//		body+="</table></td>";
//		body+="<td><table border='1'>";
//		body+="<tr style='background:#0470ab;color:white;align:center'><td>OP</td><td>Score</td><tr>";
//		for (Iterator iterator = opService.iterator(); iterator.hasNext();) {
//			ScoreCard scoreCard = (ScoreCard) iterator.next();
//			String val = scoreCard.getServiceScore();
//			if(val==null)
//				val="NA";
//			body+="<tr><td>"+scoreCard.getFactorName()+"</td><td>"+val+"</td><tr>";
//			
//		}
//		body+="</table></td></tr></table>";
//		
//		body+="<br><div><b>Tickets & Complaints</b></div>";
//		body+="<table border='1' width='100%'>";
//		body+="<tr style='background:#0470ab;color:white;align:center'><td>Date And Time </td><td>Name</td><td>Contact No</td><td>Patient Type</td><td>Reason of Compaint</td><td>Overall Comments</td><td>PSI Score</td><td>Channel</td><td>Ticket Assigned To</td><td>Ticket Status</td><tr>";
//		
//		for (Iterator iterator = complaintData.iterator(); iterator.hasNext();) {
//			String[] cData = (String[]) iterator.next();
//			body+="<tr>";
//			for (int j = 0; j < cData.length; j++) {
//				if(j==1 || j==2)
//				body+="<td>"+AESencrp.decrypt(cData[j])+"</td>";
//				else {
//					if(cData[j]==null)
//					body+="<td> </td>";
//					else
//						body+="<td>"+cData[j]+"</td>";
//				}
//			}
//			body+="</tr>";
//			
//		}
//		body+="</table>";
//		return body;
//	}

//	public static String IncidentReportQualityTeam(IncidentReport report, Users user, Company emailDomain, String header,String branch) {
//		String bodyOfMail = "<BR>";
//		bodyOfMail +="<html><body> <head> <meta charset='UTF-8'> <div style='width:100%;' align='center'>"
//				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
//				+ "<tr><td align='center' valign='top' style='background-color:#fffff;' bgcolor='#fffff;'><br><br>"
//				+ "<table width='583' border='0' cellspacing='0' cellpadding='0'>"
//				+ "<tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'>"
//				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
//				+ "<tr><td width='75%'></td><td height='50' valign='middle' > </td>"
//				+ "<td width='30%' valign='right'  style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b> &nbsp;&nbsp;&nbsp;</b></td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#FFFFFF' style='background-color:#FFFFFF; border-style: solid;    border-width: 0px 2px 0px 2px; border-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35' align='left' valign='top'>&nbsp;</td><td align='left' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td align='center' valign='top'><div style='color:#245da5; font-family:Times New Roman, Times, serif; font-size:20px;'>";
//			bodyOfMail +=header;	
////	else if(report.getStatus()==2)
////		bodyOfMail +="Dear "+incidentDetails[11]+" ,<br>This is to inform that a new incident form assigned to you and it needs your action. Kindly login to CEMPIA portal to take action."+"</b></i><br>";	
//		
//		bodyOfMail +="</div></td></tr><tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'><table width='100%' border='0' cellspacing='5' cellpadding='0'><tr ><td width='100%' height='30' align='center'  bgcolor='#86BBED' colspan=2 style='font-size:16px; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; background-color:#86BBED; font-weight: bold;'><u>Incident Details</u></td></tr><tr >";
//		bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Report ID  </td>";
//		bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getReportID()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Name </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+report.getName()+"</td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Branch Name </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+branch+"</td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Identification No </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+report.getIdNo()+"</td>";
//			bodyOfMail +="</tr><tr >";
//		    bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Age </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "+report.getAge()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Gender </td>";
//			bodyOfMail +="<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getGender()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Consultant  </td>";
//			bodyOfMail +=" <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+report.getConsultant()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Location </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getLocation()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Harm Score </td>";
//			bodyOfMail +="<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getHarmSource()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Description  </td>";
//			bodyOfMail +="<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+report.getDescIncident()+"</td></tr>";
//			
//		bodyOfMail +="</table></td></tr><tr>"
//				+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b>Please login to CEMPIA platform to take action</b><br>";
//		bodyOfMail +="https://cempia.com/"+emailDomain.getPathName();
//		bodyOfMail +="</td><td width='35' > </td></tr></table></td></tr></table><br><br></td></tr>";
//		bodyOfMail += "</table></div> </head></body></html>";
//		bodyOfMail +="<br><br>Regards,<br>"+emailDomain.getCompany_name()+" Team.";
//		bodyOfMail +="";   //please remove to before deploye to prod
////		logger.info(bodyOfMail);
//        return bodyOfMail;
//	}

	public static String multipleTicketBody(Feedback fb, Ticket t, Users user, String pathName) {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String date = t.getCreatedDate().format(formatters);
		
		String login = "https://cempia.com/"+pathName;
		String bodyOfMail = "<BR>";
		bodyOfMail +="<html><body> <head> <meta charset='UTF-8'> <div style='width:100%;' align='center'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='center' valign='top' style='background-color:#fffff;' bgcolor='#fffff;'><br><br>"
				+ "<table width='583' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td width='75%'></td><td height='50' valign='middle' > </td>"
				+ "<td width='30%' valign='right'  style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b> &nbsp;&nbsp;&nbsp;</b></td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#FFFFFF' style='background-color:#FFFFFF; border-style: solid;    border-width: 0px 2px 0px 2px; border-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35' align='left' valign='top'>&nbsp;</td><td align='left' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td align='center' valign='top'><div style='color:#245da5; font-family:Times New Roman, Times, serif; font-size:20px;'>";
		
				bodyOfMail +="Dear "+user.getUsername()+",<br> for your information. The following ticket is part of multiple tickets."+"</b></i><br>";
				bodyOfMail +="</div></td></tr><tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'><br><br><table width='100%' border='0' cellspacing='5' cellpadding='0'><tr ><td width='100%' height='30' align='center'  bgcolor='#86BBED' colspan=2 style='font-size:16px; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; background-color:#86BBED; font-weight: bold;'><u>Ticket Details</u></td></tr><tr >";

					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Number  </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: " + t.getTicketNumber() + " </td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Phone Number </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "+ AESencrp.decrypt(fb.getContactNo()) + " </td>";
					bodyOfMail += "</tr><tr >";
					String mrn = "IP/OP Number";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>"+ mrn + " </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "	+ AESencrp.decrypt(fb.getRefNo()) + "</td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Name </td>";
					bodyOfMail += "<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+ AESencrp.decrypt(fb.getName()) + " </td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Message  </td>";
					bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+ ((fb.getComments() == null || fb.getComments().trim().length() == 0) ? " - "	: fb.getComments())	+ " </td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += " <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Generated Date & Time </td>";
					bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+ date + " </td>";
					bodyOfMail += "</tr><tr >";
					bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Reason for Ticket  </td>";
					bodyOfMail += "<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+ t.getFeedbackComments() + "</td></tr>";
					
		bodyOfMail +="</table></td></tr><tr>"
				+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b>Please login to CEMPIA platform to take action</b><br>";
		bodyOfMail += "<a href="+login+"><button>CEMPIA</button></a>";
		bodyOfMail +="</td><td width='35' > </td></tr></table></td></tr></table><br><br></td></tr>";
		bodyOfMail += "</table></div>";
		bodyOfMail += "<div><table>";
		
		bodyOfMail += " </head></body></html>";
		bodyOfMail +="";
		bodyOfMail +="";
			//testing
		
		
        return bodyOfMail;
	}

	public static String multipleTicketBodyDep(Feedback fb, String name, List<Ticket> ticketList, String pathName) {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String date = ticketList.get(0).getCreatedDate().format(formatters);
		
		String login = "https://cempia.com/"+pathName;
		String bodyOfMail = "<BR>";
		bodyOfMail +="<html><body> <head> <meta charset='UTF-8'> <div style='width:100%;' align='center'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='center' valign='top' style='background-color:#fffff;' bgcolor='#fffff;'><br><br>"
				+ "<table width='583' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td width='75%'></td><td height='50' valign='middle' > </td>"
				+ "<td width='30%' valign='right'  style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b> &nbsp;&nbsp;&nbsp;</b></td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#FFFFFF' style='background-color:#FFFFFF; border-style: solid;    border-width: 0px 2px 0px 2px; border-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35' align='left' valign='top'>&nbsp;</td><td align='left' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td align='center' valign='top'><div style='color:#245da5; font-family:Times New Roman, Times, serif; font-size:20px;'>";
		
				bodyOfMail +="Dear "+name+",<br> for your action. The following ticket is part of multiple tickets."+"</b></i><br>";
				bodyOfMail +="</div></td></tr><tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'><br><br><table width='100%' border='0' cellspacing='5' cellpadding='0'><tr ><td width='100%' height='30' align='center'  bgcolor='#86BBED' colspan=2 style='font-size:16px; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; background-color:#86BBED; font-weight: bold;'><u>Ticket Details</u></td></tr>";
					
				bodyOfMail += "<tr><td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Phone Number </td>";
				bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "+ AESencrp.decrypt(fb.getContactNo()) + " </td>";
				bodyOfMail += "</tr><tr >";
				String mrn = "IP/OP Number";
				bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>"+ mrn + " </td>";
				bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "	+ AESencrp.decrypt(fb.getRefNo()) + "</td>";
				bodyOfMail += "</tr><tr >";
				bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Name </td>";
				bodyOfMail += "<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+ AESencrp.decrypt(fb.getName()) + " </td>";
				bodyOfMail += "</tr><tr >";
				bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Message  </td>";
				bodyOfMail += " <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+ ((fb.getComments() == null || fb.getComments().trim().length() == 0) ? " - "	: fb.getComments())	+ " </td>";
				bodyOfMail += "</tr>";
				
				for (Ticket t : ticketList) {
					bodyOfMail += "<tr><td colspan='2'>";
					 bodyOfMail +="<hr></td></tr>";
						bodyOfMail += "<tr><td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Number  </td>";
						bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: " + t.getTicketNumber() + " </td>";
						bodyOfMail += "</tr><tr >";
						bodyOfMail += " <td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Generated Date & Time </td>";
						bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+ date + " </td>";
						bodyOfMail += "</tr><tr >";
						bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Reason for Ticket  </td>";
						bodyOfMail += "<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+ t.getFeedbackComments() + "</td></tr>";
				       
				}
					
					
		bodyOfMail +="</table></td></tr><tr>"
				+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b>Please login to CEMPIA platform to take action</b><br>";
		bodyOfMail += "<a href="+login+"><button>CEMPIA</button></a>";
		bodyOfMail +="</td><td width='35' > </td></tr></table></td></tr></table><br><br></td></tr>";
		bodyOfMail += "</table></div>";
		bodyOfMail += "<div><table>";
		
		bodyOfMail += " </head></body></html>";
		bodyOfMail +="";
		bodyOfMail +="";
			//testing
		
		
        return bodyOfMail;
	}
	
//	public static String medicationError(IncidentReport report, Users user, Company emailDomain, String header,String branch) {
//		String bodyOfMail = "<BR>";
//		bodyOfMail +="<html><body> <head> <meta charset='UTF-8'> <div style='width:100%;' align='center'>"
//				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
//				+ "<tr><td align='center' valign='top' style='background-color:#fffff;' bgcolor='#fffff;'><br><br>"
//				+ "<table width='583' border='0' cellspacing='0' cellpadding='0'>"
//				+ "<tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'>"
//				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
//				+ "<tr><td width='75%'></td><td height='50' valign='middle' > </td>"
//				+ "<td width='30%' valign='right'  style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b> &nbsp;&nbsp;&nbsp;</b></td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#FFFFFF' style='background-color:#FFFFFF; border-style: solid;    border-width: 0px 2px 0px 2px; border-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35' align='left' valign='top'>&nbsp;</td><td align='left' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td align='center' valign='top'><div style='color:#245da5; font-family:Times New Roman, Times, serif; font-size:20px;'>";
//			bodyOfMail +=header;	
////	else if(report.getStatus()==2)
////		bodyOfMail +="Dear "+incidentDetails[11]+" ,<br>This is to inform that a new incident form assigned to you and it needs your action. Kindly login to CEMPIA portal to take action."+"</b></i><br>";	
//		
//		bodyOfMail +="</div></td></tr><tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'><table width='100%' border='0' cellspacing='5' cellpadding='0'><tr ><td width='100%' height='30' align='center'  bgcolor='#86BBED' colspan=2 style='font-size:16px; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; background-color:#86BBED; font-weight: bold;'><u>Medication Error Details</u></td></tr><tr >";
//		bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Report ID  </td>";
//		bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getReportID()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Name </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+report.getName()+"</td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Branch Name </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+branch+"</td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Identification No </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+report.getIdNo()+"</td>";
//			bodyOfMail +="</tr><tr >";
//		    bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Age </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "+report.getAge()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Gender </td>";
//			bodyOfMail +="<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getGender()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Consultant  </td>";
//			bodyOfMail +=" <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+report.getConsultant()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> Was the error </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getErrorName()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Drug Name </td>";
//			bodyOfMail +="<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getDrugName()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Description of the event  </td>";
//			bodyOfMail +="<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+report.getDescIncident()+"</td></tr>";
//			
//		bodyOfMail +="</table></td></tr><tr>"
//				+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b>Please login to CEMPIA platform to take action</b><br>";
//		bodyOfMail +="https://cempia.com/"+emailDomain.getPathName();
//		bodyOfMail +="</td><td width='35' > </td></tr></table></td></tr></table><br><br></td></tr>";
//		bodyOfMail += "</table></div> </head></body></html>";
//		bodyOfMail +="<br><br>Regards,<br>"+emailDomain.getCompany_name()+" Team.";
//		bodyOfMail +="";
////		logger.info(bodyOfMail);
//        return bodyOfMail;
//	}
	
	
//	public static String adrMail(IncidentReport report, Users user, Company emailDomain, String header,String branch) {
//		String bodyOfMail = "<BR>";
//		bodyOfMail +="<html><body> <head> <meta charset='UTF-8'> <div style='width:100%;' align='center'>"
//				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
//				+ "<tr><td align='center' valign='top' style='background-color:#fffff;' bgcolor='#fffff;'><br><br>"
//				+ "<table width='583' border='0' cellspacing='0' cellpadding='0'>"
//				+ "<tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'>"
//				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
//				+ "<tr><td width='75%'></td><td height='50' valign='middle' > </td>"
//				+ "<td width='30%' valign='right'  style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b> &nbsp;&nbsp;&nbsp;</b></td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#FFFFFF' style='background-color:#FFFFFF; border-style: solid;    border-width: 0px 2px 0px 2px; border-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35' align='left' valign='top'>&nbsp;</td><td align='left' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td align='center' valign='top'><div style='color:#245da5; font-family:Times New Roman, Times, serif; font-size:20px;'>";
//			bodyOfMail +=header;	
////	else if(report.getStatus()==2)
////		bodyOfMail +="Dear "+incidentDetails[11]+" ,<br>This is to inform that a new incident form assigned to you and it needs your action. Kindly login to CEMPIA portal to take action."+"</b></i><br>";	
//		
//		bodyOfMail +="</div></td></tr><tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'><table width='100%' border='0' cellspacing='5' cellpadding='0'><tr ><td width='100%' height='30' align='center'  bgcolor='#86BBED' colspan=2 style='font-size:16px; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; background-color:#86BBED; font-weight: bold;'><u>ADR Details</u></td></tr><tr >";
//		bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Report ID  </td>";
//		bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getReportID()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Name </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+report.getName()+"</td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Branch Name </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+branch+"</td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Identification No </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+report.getIdNo()+"</td>";
//			bodyOfMail +="</tr><tr >";
//		    bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Age </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "+report.getAge()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Gender </td>";
//			bodyOfMail +="<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getGender()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Consultant  </td>";
//			bodyOfMail +=" <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+report.getConsultant()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Location </td>";
//			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+report.getLocation()+" </td>";
//			bodyOfMail +="</tr><tr >";
//			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Description  </td>";
//			bodyOfMail +="<td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+report.getDescIncident()+"</td></tr>";
//			
//		bodyOfMail +="</table></td></tr><tr>"
//				+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b>Please login to CEMPIA platform to take action</b><br>";
//		bodyOfMail +="https://cempia.com/"+emailDomain.getPathName();
//		bodyOfMail +="</td><td width='35' > </td></tr></table></td></tr></table><br><br></td></tr>";
//		bodyOfMail += "</table></div> </head></body></html>";
//		bodyOfMail +="<br><br>Regards,<br>"+emailDomain.getCompany_name()+" Team.";
//		bodyOfMail +="";
////		logger.info(bodyOfMail);
//        return bodyOfMail;
//	}
//	
	public static String getFieldValue(Object clazz ,String filedName) {
		try {
		Field field = clazz.getClass().getField(filedName);
	    Class clazzType = field.getType();
	     return (String) field.get (clazz);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String officerCommentNotification(Feedback fb, Company emailDomain, String staffDept, String staffName, String officerName, String[] mailTo, String[] ccList) {
		String login = "https://cempia.com/"+emailDomain.getPathName();
		String bodyOfMail = "<BR>";
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String date = fb.getCreated_date().format(formatters);
		bodyOfMail +="<html><body> <head> <meta charset='UTF-8'> <div style='width:100%;' align='center'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='center' valign='top' style='background-color:#fffff;' bgcolor='#fffff;'><br><br>"
				+ "<table width='583' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td width='75%'></td><td height='50' valign='middle' > </td>"
				+ "<td width='30%' valign='right'  style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b> &nbsp;&nbsp;&nbsp;</b></td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#FFFFFF' style='background-color:#FFFFFF; border-style: solid;    border-width: 0px 2px 0px 2px; border-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35' align='left' valign='top'>&nbsp;</td><td align='left' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td align='center' valign='top'><div style='color:#245da5; font-family:Times New Roman, Times, serif; font-size:20px;'>";
		
				bodyOfMail +="Dear "+officerName+" ,<br> "+"</b></i>Great Job !  Your department has received an appreciation from "+fb.getName()+"\r\n" + 
						"Please find the details below ";
				bodyOfMail +="</div></td></tr><tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'><br><br><table width='100%' border='0' cellspacing='5' cellpadding='0' style='margin-left:15%'>";
					
				bodyOfMail += "<tr><td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> Patient Name </td>";
				bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'> :  "+ fb.getName() + " </td>";
				bodyOfMail += "</tr><tr >";
				bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> Contact No.</td>";
				bodyOfMail += "<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+  AESencrp.decrypt(fb.getContactNo()) + " </td>";
				bodyOfMail += "</tr><tr >";
				bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> Feedback Generated Date  </td>";
				bodyOfMail += "<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "	+ date + "</td>";
				bodyOfMail += "</tr><tr >";
				bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> Department	 </td>";
				bodyOfMail += "<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+ staffDept + " </td>";
				bodyOfMail += "</tr><tr >";
				bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> Staff Name	 </td>";
				bodyOfMail += "<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+ staffName + " </td>";
				bodyOfMail += "</tr><tr >";
				bodyOfMail += "<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> Comments</td>";
				bodyOfMail += "<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+ fb.getComment2()+ " </td>";
				bodyOfMail += "</tr>";
				

				bodyOfMail +="</table></td></tr><tr>"
						+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b>Please login to CEMPIA platform to take action</b><br>";
				bodyOfMail += "<a href="+login+"><button>CEMPIA</button></a>";
						
			    bodyOfMail +="</table><br><h3 style='text-align:center'>Keep up the good work !<h3></td></tr><tr>"
				+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'>";		
//		bodyOfMail +="</table><br><h3 style='text-align:center'>Keep up the good work !<h3></td></tr><tr>"
//				+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'>";
//				
		bodyOfMail +="</td><td width='35' > </td></tr></table></td></tr></table><br><br></td></tr>";
		bodyOfMail += "</table></div>";
		bodyOfMail += "<div><table>";
		
		/*bodyOfMail+="<table><tr><td> Mail To : </td><td>"+Arrays.toString(mailTo)+"</td></tr>";
		bodyOfMail+="<tr><td>CC List :</td><td>"+Arrays.toString(ccList)+"</td></tr></table><br>";*/
		
		bodyOfMail += "<br><b>Sunway Med Team <br>" + 
				"( triggered by CEMPIA system)</b> </head></body></html>";
		bodyOfMail +="";
		bodyOfMail +="";
			//testing
		
		
        return bodyOfMail;
	}

	public static String autoEscalationMail(Users user, Company emailDomain, String[] data) {
		String bodyOfMail = "<BR>";
		bodyOfMail +="<html><body> <head> <meta charset='UTF-8'> <div style='width:100%;' align='center'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='center' valign='top' style='background-color:#fffff;' bgcolor='#fffff;'><br><br>"
				+ "<table width='583' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'>"
				+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td width='75%'></td><td height='50' valign='middle' > </td>"
				+ "<td width='30%' valign='right'  style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b> &nbsp;&nbsp;&nbsp;</b></td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#FFFFFF' style='background-color:#FFFFFF; border-style: solid;    border-width: 0px 2px 0px 2px; border-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35' align='left' valign='top'>&nbsp;</td><td align='left' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td align='center' valign='top'><div style='color:#245da5; font-family:Times New Roman, Times, serif; font-size:20px;'>";
		bodyOfMail +="Dear "+user.getUsername()+",<br>The following ticket is for your kind action"+"</b></i><br>";
		
		bodyOfMail +="</div></td></tr><tr><td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'><table width='100%' border='0' cellspacing='5' cellpadding='0'><tr ><td width='100%' height='30' align='center'  bgcolor='#86BBED' colspan=2 style='font-size:16px; color:#FFFFFF; font-family:Arial, Helvetica, sans-serif; background-color:#86BBED; font-weight: bold;'><u>Ticket Details</u></td></tr><tr >";
		bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Number </td>";
		bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+data[12]+"-"+data[1]+" </td>";
			bodyOfMail +="</tr><tr >";
			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Phone Number </td>";
			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+AESencrp.decrypt(data[8])+"</td>";
			bodyOfMail +="</tr><tr >";
			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Name </td>";
			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'> :  "+data[7]+"</td>";
			bodyOfMail +="</tr><tr >";
		    bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Patient Message </td>";
			bodyOfMail +="<td width='65%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif; font-weight: bold'>:  "+data[13]+" </td>";
			bodyOfMail +="</tr><tr >";
			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Ticket Generated Date </td>";
			bodyOfMail +="<td width='70%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>:  "+data[6]+" </td>";
			bodyOfMail +="</tr><tr >";
			bodyOfMail +="<td width='30%'  style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>Reason for Ticket   </td>";
			bodyOfMail +=" <td width='65%' style='font-size:13px; color:#525252; font-family:Arial, Helvetica, sans-serif;font-weight: bold'>: "+data[5]+" </td>";
			bodyOfMail +="</tr>";
			
		bodyOfMail +="</table></td></tr><tr>"
				+ "<td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;'>&nbsp;</td></tr></table></td><td width='35' align='left' valign='top'>&nbsp;</td></tr></table></td></tr><tr><td align='left' valign='top' bgcolor='#86BBED' style='background-color:#86BBED;'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='35'>&nbsp;</td><td height='50' valign='middle' style='color:#FFFFFF; font-size:11px; font-family:Arial, Helvetica, sans-serif;'><b>Please login to CEMPIA platform to take action</b><br>";
		bodyOfMail +="https://cempia.com/"+emailDomain.getPathName();
		bodyOfMail +="</td><td width='35' > </td></tr></table></td></tr></table><br><br></td></tr>";
		bodyOfMail += "</table></div> </head></body></html>";
		bodyOfMail +="<br><br>Regards,<br>"+emailDomain.getCompany_name()+" Team.";
		bodyOfMail +="";
		
//		logger.info(bodyOfMail);
        return bodyOfMail;
	}
	List<FactorName> FactorList=null;
	public void setFactorList(List<FactorName> fact) {
		this.FactorList=fact;
		// TODO Auto-generated method stub
		
	}
}
